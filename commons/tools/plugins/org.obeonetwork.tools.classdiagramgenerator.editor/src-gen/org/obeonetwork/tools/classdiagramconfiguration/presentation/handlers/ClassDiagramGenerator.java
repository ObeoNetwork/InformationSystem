package org.obeonetwork.tools.classdiagramconfiguration.presentation.handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.tools.classdiagramconfiguration.BooleanValue;
import org.obeonetwork.tools.classdiagramconfiguration.ColorInfo;
import org.obeonetwork.tools.classdiagramconfiguration.Configuration;
import org.obeonetwork.tools.classdiagramconfiguration.ConfigurationElement;
import org.obeonetwork.tools.classdiagramconfiguration.DiagramConf;
import org.obeonetwork.tools.classdiagramconfiguration.StringValue;
import org.obeonetwork.tools.classdiagramconfiguration.presentation.ClassDiagramConfigurationEditorPlugin;

import fr.obeo.dsl.viewpoint.description.DescriptionFactory;
import fr.obeo.dsl.viewpoint.description.DescriptionPackage;
import fr.obeo.dsl.viewpoint.description.Group;
import fr.obeo.dsl.viewpoint.description.JavaExtension;
import fr.obeo.dsl.viewpoint.description.RepresentationDescription;
import fr.obeo.dsl.viewpoint.description.UserColor;
import fr.obeo.dsl.viewpoint.description.UserColorsPalette;
import fr.obeo.dsl.viewpoint.description.UserFixedColor;
import fr.obeo.dsl.viewpoint.description.Viewpoint;

public class ClassDiagramGenerator {
	private static final String GENERATOR_OPTIONAL_NODE = "generatorOptionalNode";

	public final String VSM_TEMPLATE_PATH = "platform:/plugin/" + ClassDiagramConfigurationEditorPlugin.PLUGIN_ID + "/description/StructuredTypesDiagramTemplate.odesign";
	
	private Configuration configuration;
	private EditingDomain editingDomain;
	private Viewpoint viewpointFromTemplate;

	public ClassDiagramGenerator(Configuration configuration, EditingDomain editingDomain) {
		this.configuration = configuration;
		this.editingDomain = editingDomain;
	}
	
	public Collection<RepresentationDescription> generate() {
		if (configuration.getViewpoint() == null || configuration.getViewpoint().eIsProxy()) {
			MessageDialog.openError(Display.getDefault().getActiveShell(), "VSM generation", "No viewpoint associated to the Configuration root element !");
			return null;
		}
		
		Collection<GenerationInfo> generationInfos = getInformationsFromConfiguration(configuration);
		Collection<RepresentationDescription> descriptions = createNewRepresentationDescriptions(generationInfos);
		
		// Add java extensions
		addJavaExtensions(configuration, viewpointFromTemplate);
		
		// Add palette
		addPalette(configuration, viewpointFromTemplate);
		
		return descriptions;
	}
	
	private Collection<GenerationInfo> getInformationsFromConfiguration(Configuration configuration) {
		Collection<GenerationInfo> generationInfos = new ArrayList<GenerationInfo>();
		
		for (DiagramConf diagramConf : configuration.getDiagrams()) {
			if (diagramConf.getDescriptionId() == null || diagramConf.getDescriptionId().trim().isEmpty()) {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "VSM generation", "No description id provided for a DiagramConf instance !");
				return null;
			}
			GenerationInfo generationInfo = new GenerationInfo(diagramConf.getDescriptionId());
			
			collectInformations(diagramConf, generationInfo);
			TreeIterator<EObject> eAllContents = diagramConf.eAllContents();
			while (eAllContents.hasNext()) {
				EObject object = eAllContents.next();
				if (object instanceof ConfigurationElement) {
					ConfigurationElement element = (ConfigurationElement) object;
					collectInformations(element, generationInfo);
				}
			}
			generationInfos.add(generationInfo);
		}
		
		return generationInfos;
	}
	
	private void collectInformations(ConfigurationElement element, GenerationInfo generationInfo) {
		// Specific case for DiagramConf elements
		if (element instanceof DiagramConf) {
			DiagramConf diagramConf = (DiagramConf)element;
			generationInfo.getPlaceholders().put(diagramConf.getFullQualifiedId() + ".id", diagramConf.getDescriptionId());
			for (String metamodel : diagramConf.getMetamodels()) {
				generationInfo.getMetamodelsURIs().add(metamodel);
			}
		}
		
		for (StringValue stringValue : element.getStringValues()) {
			String placeholderId = stringValue.getFullQualifiedId();
			if (generationInfo.getPlaceholders().containsKey(placeholderId)) {
				log(IStatus.WARNING, "Placeholder with ID '" + placeholderId + "' already exists (previous value = '" + generationInfo.getPlaceholders().get(placeholderId) + "').", null);
			}
			generationInfo.getPlaceholders().put(placeholderId, stringValue.getValue());
		}
		
		for (BooleanValue booleanValue : element.getBooleanValues()) {
			String placeholderId = booleanValue.getFullQualifiedId();
			if (generationInfo.getBooleanInfos().containsKey(placeholderId)) {
				log(IStatus.WARNING, "Placeholder with ID '" + placeholderId + "' already exists (previous value = '" + generationInfo.getPlaceholders().get(placeholderId) + "').", null);
			}
			generationInfo.getBooleanInfos().put(placeholderId, booleanValue.isValue());
		}
	}
	
	private Collection<RepresentationDescription> createNewRepresentationDescriptions(Collection<GenerationInfo> generationInfos) {
		String vsmContents = getVsmContents(generationInfos);
		
		Resource vsmFromTemplate = getVsmFromTemplate(vsmContents);
		removeOptionalElements(generationInfos, vsmFromTemplate);
		
		viewpointFromTemplate = getViewpointFromTemplate(vsmFromTemplate);
		
		return createDescriptionsInTargetVSM(generationInfos, viewpointFromTemplate, configuration.getViewpoint());
	}
	
	private String getVsmContents(Collection<GenerationInfo> generationInfos) {
		// First copy the template and replace all placeholders and boolean infos
		String vsmContents = getFileContents(VSM_TEMPLATE_PATH);

		for (GenerationInfo generationInfo : generationInfos) {
			for (Entry<String, String> placeholder : generationInfo.getPlaceholders().entrySet()) {
				String key = placeholder.getKey();
				key = key.replaceAll("\\.", "\\\\.");
				// Some values are used within URI, we have to escape them
				vsmContents = vsmContents.replaceAll("='\\{" + key + "\\}'", "='" + placeholder.getValue().replaceAll(" ", "%20") + "'");
				vsmContents = vsmContents.replaceAll("\\{" + key + "\\}", placeholder.getValue());
			}
		}
		return vsmContents;
	}
	
	private Resource getVsmFromTemplate(String vsmContents) {
		File temp = null;
		try {
			temp = File.createTempFile("Class_Diagram_Tmp_", ".odesign");
			temp.deleteOnExit();
			
			BufferedWriter out = new BufferedWriter(new FileWriter(temp));
			out.write(vsmContents);
			out.close();
			
		} catch (IOException e) {
			log(IStatus.ERROR, "Unable to create temporary file for new VSM", e);
		}
		
		// Then load the new resource
		URI tempFileUri = URI.createFileURI(temp.getAbsolutePath());
		
		ResourceSet set = new ResourceSetImpl();
		return set.getResource(tempFileUri, true);
	}
	
	private void removeOptionalElements(Collection<GenerationInfo> generationInfos, Resource vsmFromTemplate) {
		// Remove optional elements
		if (vsmFromTemplate instanceof XMLResource) {
			Map<EObject, AnyType> eObjectToExtensionMap = ((XMLResource)vsmFromTemplate).getEObjectToExtensionMap();
			Map<String, Collection<EObject>> optionalNodes = getOptionalNodes(eObjectToExtensionMap);
			
			for (Entry<String, Collection<EObject>> optionalNodeEntry : optionalNodes.entrySet()) {
				String optionalNodeId = optionalNodeEntry.getKey();
				
				// Check if we have informations on this node
				for (GenerationInfo generationInfo : generationInfos) {
					Boolean optionalNodeActivated = generationInfo.getBooleanInfos().get(optionalNodeId);
					if (optionalNodeActivated == null || optionalNodeActivated == Boolean.FALSE) {
						// Remove the node
						for (EObject object : optionalNodeEntry.getValue()) {
							EcoreUtil.delete(object);						
						}
					}
				}
			}
		}
	}
	
	private Viewpoint getViewpointFromTemplate(Resource vsmFromTemplate) {
		for (EObject root : vsmFromTemplate.getContents()) {
			if (root instanceof Group) {
				Group group = (Group)root;
				if (group.getOwnedViewpoints().isEmpty() == false) {
					return group.getOwnedViewpoints().get(0);
				}
			}
		}
		return null;
	}
	
	private Collection<RepresentationDescription> createDescriptionsInTargetVSM(Collection<GenerationInfo> generationInfos, Viewpoint viewpointFromTemplate, Viewpoint viewpointFromTargetVSM) {
		Collection<RepresentationDescription> descriptions = new ArrayList<RepresentationDescription>();
		
		if (viewpointFromTemplate != null) {
			
			for (GenerationInfo generationInfo : generationInfos) {
				RepresentationDescription desc = getDescriptionFromId(viewpointFromTemplate, generationInfo.getDescriptionId());
				if (desc != null) {
					descriptions.add(desc);
					
					// Add metamodels
					if (!generationInfo.getMetamodelsURIs().isEmpty()) {
						for (String metamodelUri : generationInfo.getMetamodelsURIs()) {
							Object ePackage = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
							if (ePackage instanceof EPackage) {
								desc.getMetamodel().add((EPackage)ePackage);						
							}
						}
					}
				}
			}
			
			if (descriptions.isEmpty() == false) {
				AddCommand addCommand = new AddCommand(editingDomain, viewpointFromTargetVSM, DescriptionPackage.Literals.VIEWPOINT__OWNED_REPRESENTATIONS, descriptions);
				editingDomain.getCommandStack().execute(addCommand);
			}
		}
		
		return descriptions;
	}
	
	private RepresentationDescription getDescriptionFromId(Viewpoint viewpoint, String id) {
		for (RepresentationDescription description : viewpoint.getOwnedRepresentations()) {
			if (id.equals(description.getName())) {
				return description;
			}
		}
		return null;
	}
	
	private void addJavaExtensions(Configuration configuration, Viewpoint viewpointFromTemplate) {
		Collection<String> javaExtensions = new LinkedHashSet<String>(configuration.getJavaExtensions());
		for (JavaExtension javaExtensionFromTemplate : viewpointFromTemplate.getOwnedJavaExtensions()) {
			javaExtensions.add(javaExtensionFromTemplate.getQualifiedClassName());
		}
		if (javaExtensions.isEmpty() == false) {
			for (String javaExtension : javaExtensions) {
				if (containsJavaExtension(configuration.getViewpoint().getOwnedJavaExtensions(), javaExtension) == false) {
					JavaExtension extension = DescriptionFactory.eINSTANCE.createJavaExtension();
					extension.setQualifiedClassName(javaExtension);
					AddCommand addCommand = new AddCommand(editingDomain, configuration.getViewpoint(), DescriptionPackage.Literals.VIEWPOINT__OWNED_JAVA_EXTENSIONS, extension);
					editingDomain.getCommandStack().execute(addCommand);
				}
			}
		}
	}
	
	private boolean containsJavaExtension(Collection<JavaExtension> extensions, String newExtension) {
		for (JavaExtension javaExtension : extensions) {
			if (newExtension.equals(javaExtension.getQualifiedClassName())) {
				return true;
			}
		}
		return false;
	}
	
	private void addPalette(Configuration configuration, Viewpoint viewpointFromTemplate) {
		if (configuration.getColors().isEmpty() == false) {
			// Get Group from template
			Group groupFromTemplate = null;
			if (viewpointFromTemplate.eContainer() instanceof Group) {
				groupFromTemplate = (Group)viewpointFromTemplate.eContainer();
			}
			
			// get group
			EObject eContainer = configuration.getViewpoint().eContainer();
			if (eContainer instanceof Group) {
				Group group = (Group)eContainer;
				UserColorsPalette palette = null;
				if (group.getUserColorsPalettes().isEmpty()) {
					// We have to create a user color palette
					palette = DescriptionFactory.eINSTANCE.createUserColorsPalette();
					palette.setName("Palette");
					AddCommand addCommand = new AddCommand(editingDomain, group, DescriptionPackage.Literals.GROUP__USER_COLORS_PALETTES, palette);
					editingDomain.getCommandStack().execute(addCommand);
				} else {
					// use the first palette
					palette = group.getUserColorsPalettes().get(0);
				}
				for (ColorInfo colorInfo : configuration.getColors()) {
					// Check if color exists
					UserFixedColor newColor = null;
					for (UserColor userColor : palette.getEntries()) {
						if (userColor instanceof UserFixedColor && userColor.getName().equals(colorInfo.getName())) {
							newColor = (UserFixedColor)userColor;
							break;
						}
					}
					if (newColor == null) {
						newColor = DescriptionFactory.eINSTANCE.createUserFixedColor();
						AddCommand addCommand = new AddCommand(editingDomain, palette, DescriptionPackage.Literals.USER_COLORS_PALETTE__ENTRIES, newColor);
						editingDomain.getCommandStack().execute(addCommand);
					}
					newColor.setName(colorInfo.getName());
					newColor.setRed(colorInfo.getRed());
					newColor.setGreen(colorInfo.getGreen());
					newColor.setBlue(colorInfo.getBlue());
				}
				
				// representation descriptions must reference the new palette
				if (palette != null) {
					replaceColorReferences(groupFromTemplate, group, configuration.getColors(), palette);
				}
			}
		}
	}
	
	private void replaceColorReferences(Group groupFromTemplate, Group newGroup, Collection<ColorInfo> generationColors, UserColorsPalette palette) {
		// Retrieve colors in the odesign templates
		Collection<UserColor> defaultUserColors = new ArrayList<UserColor>();
		for (ColorInfo generationColor : generationColors) {
			for (UserColorsPalette defaultPalette : groupFromTemplate.getUserColorsPalettes()) {
				for (UserColor defaultColor : defaultPalette.getEntries()) {
					if (defaultColor instanceof UserFixedColor && defaultColor.getName().equals(generationColor.getName())) {
						defaultUserColors.add(defaultColor);
					}
				}
			}
		}
		
		// we have to change references to these colors to the corresponding ones in the new palette
		Map<UserColor, UserColor> colorCorrespondances = new HashMap<UserColor, UserColor>();
		for (UserColor userColor : defaultUserColors) {
			for (UserColor newColor : palette.getEntries()) {
				if (newColor instanceof UserFixedColor && userColor.getName().equals(newColor.getName())) {
					colorCorrespondances.put(userColor, newColor);
				}
			}
		}
		
		// find references to the default color
		for (Entry<UserColor, UserColor> entry : colorCorrespondances.entrySet()) {
			Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find(entry.getKey(), newGroup.eResource().getResourceSet());
			for (Setting setting : settings) {
				EcoreUtil.replace(setting.getEObject(), setting.getEStructuralFeature(), entry.getKey(), entry.getValue());
			}
		}
	}
	
	private Map<String, Collection<EObject>> getOptionalNodes(Map<EObject, AnyType> eObjectToExtensionMap) {
		Map<String, Collection<EObject>> result = new HashMap<String, Collection<EObject>>();
		for (Entry<EObject, AnyType> entry : eObjectToExtensionMap.entrySet()) {
			AnyType anyType = entry.getValue();
			FeatureMap anyAttribute = anyType.getAnyAttribute();
			for (org.eclipse.emf.ecore.util.FeatureMap.Entry featureMapEntry : anyAttribute) {
				EStructuralFeature feature = featureMapEntry.getEStructuralFeature();
				if (GENERATOR_OPTIONAL_NODE.equals(feature.getName())) {
					String id = (String)featureMapEntry.getValue();
					// Put value into result map
					if (result.get(id) == null) {
						result.put(id, new ArrayList<EObject>());
					}
					result.get(id).add(entry.getKey());
				}
			}
		}
		return result;
	}
	
	private String getFileContents(String path) {
		String result = "";
		URL url;
		try {
			url = new URL(path);
			InputStream inputStream = url.openConnection().getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				result += inputLine;
				result += "\n";
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private void log(int severity, String message, Exception e) {
		ClassDiagramConfigurationEditorPlugin.getPlugin().getLog().log(new Status(severity, ClassDiagramConfigurationEditorPlugin.PLUGIN_ID, message, e));		
	}
}
