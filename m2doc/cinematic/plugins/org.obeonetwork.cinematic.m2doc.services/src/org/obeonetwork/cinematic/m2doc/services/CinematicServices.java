/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.cinematic.m2doc.services;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Example;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ui.tools.api.actions.export.SizeTooLargeException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.obeonetwork.cinematic.m2doc.extension.MList;
import org.obeonetwork.cinematic.m2doc.extension.MListImpl;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.Package;
import org.obeonetwork.dsl.cinematic.design.ICinematicViewpoint;
import org.obeonetwork.dsl.cinematic.design.services.CinematicBindingServices;
import org.obeonetwork.dsl.cinematic.design.services.CinematicLabelServices;
import org.obeonetwork.dsl.cinematic.flow.ActionState;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowAction;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.flow.ViewState;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.Layout;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewEvent;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.dsl.requirement.Requirement;
import org.obeonetwork.dsl.technicalid.Identifiable;
import org.obeonetwork.m2doc.element.MImage;
import org.obeonetwork.m2doc.element.MStyle;
import org.obeonetwork.m2doc.element.MTable;
import org.obeonetwork.m2doc.element.MTable.MCell;
import org.obeonetwork.m2doc.element.MTable.MRow;
import org.obeonetwork.m2doc.element.MText;
import org.obeonetwork.m2doc.element.impl.MImageImpl;
import org.obeonetwork.m2doc.element.impl.MStyleImpl;
import org.obeonetwork.m2doc.element.impl.MTableImpl;
import org.obeonetwork.m2doc.element.impl.MTableImpl.MCellImpl;
import org.obeonetwork.m2doc.element.impl.MTableImpl.MRowImpl;
import org.obeonetwork.m2doc.element.impl.MTextImpl;
import org.obeonetwork.m2doc.sirius.services.M2DocSiriusServices;
import org.obeonetwork.tools.doc.core.DocumentationLink;

public class CinematicServices {
	
	private static final String YES_TEXT = "Oui";
	private static final String NO_TEXT = "Non";
	private static final String NA_TEXT = "N/A";
	
	private static final Color viewContainerHeaderColor = new Color(253, 206, 137);
	private static final Color viewContainerLineColor = new Color(253, 230, 195);
	private static final MStyle defaultTextStyle = new MStyleImpl(null, 10, null, null, -1);
	private static final MStyle boldTextStyle = new MStyleImpl(null, 10, null, null, 1);
	
	private CinematicLabelServices labelService = new CinematicLabelServices();
	private CinematicBindingServices bindingService = new CinematicBindingServices ();


	// @formatter:off
	@Documentation(
			comment = "{m:obj.isCinematicObject()}",
		    value = "Returns if the target object is a Cinematic element.",
		    examples = {
		    		@Example(
		    				expression = "{m:obj.isCinematicObject()}", 
		    				result = "True if the target object is a Cinematic element, false otherwise.")
		    }
		)
	// @formatter:on	
	public boolean isCinematicObject(EObject obj) {
		EPackage pack = obj.eClass().getEPackage();
		while(pack.eContainer() instanceof EPackage) {
			pack = (EPackage) pack.eContainer();
		}
		return pack.getName().equals("cinematic");
	}

	// @formatter:off
	@Documentation(
			comment = "{m:flowEvent.getAnnotations()}",
		    value = "Returns the list of metadata annotations of the target Flow Event.",
		    examples = {
		    		@Example(
		    				expression = "{m:flowEvent.getAnnotations().title->sep(',')}", 
		    				result = "A comma separated list of Flow Event's annotation titles.")
		    }
		)
	// @formatter:on	
	public List<Annotation> getAnnotations(ObeoDSMObject obj) {
		MetaDataContainer metadatas = obj.getMetadatas();
		if (metadatas != null) {
			List<Annotation> result = new ArrayList<Annotation>();
			for (MetaData md : metadatas.getMetadatas()) {
				if (md instanceof Annotation) {
					Annotation annotation = (Annotation) md;
					result.add(annotation);
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	// @formatter:off
	@Documentation(
			comment = "{m:viewContainer.getAllEvents()}",
		    value = "Returns the list of all events defined in this View Container or one of its sub View Containers.",
		    examples = {
		    		@Example(
		    				expression = "{m:viewContainer.getAllEvents()}", 
		    				result = "A list of View Events.")
		    }
		)
	// @formatter:on
	public List<ViewEvent> getAllEvents(ViewContainer viewContainer) {
		List<ViewEvent> allEvents = new ArrayList<>();
		
		collectAllEvents(allEvents, viewContainer);
		
		return allEvents;
	}

	private void collectAllEvents(List<ViewEvent> allEvents, ViewContainer viewContainer) {
		allEvents.addAll(viewContainer.getEvents());
		
		for(ViewElement subViewElement : viewContainer.getViewElements()) {
			allEvents.addAll(subViewElement.getEvents());
		}
		
		for(ViewContainer subViewContainer : viewContainer.getViewContainers()) {
			collectAllEvents(allEvents, subViewContainer);
		}
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:obj.cinematicLabel()}",
		    value = "Returns the presentation label of the target Cinematic element.",
		    examples = {
		    		@Example(
		    				expression = "{m:obj.getCinematicLabel()}", 
		    				result = "The label of the element.")
		    }
		)
	// @formatter:on	
	public String cinematicLabel(EObject obj) {
		if(obj != null) {
			return labelService.getCinematicLabel(obj);
		} else {
			return "";
		}
	}

	// @formatter:off
	@Documentation(
			comment = "{m:obj.cinematicIcon()}",
		    value = "Returns the presentation icon of the target Cinematic element.",
		    examples = {
		    		@Example(
		    				expression = "{m:obj.getCinematicIcon()}", 
		    				result = "The icon of the element.")
		    }
		)
	// @formatter:on	
	public MImage cinematicIcon(EObject obj) {
		
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		Image image = adapterFactoryLabelProvider.getImage(obj);
		
		ImageLoader imageLoader = new ImageLoader();
		imageLoader.data = new ImageData[] { image.getImageData() };
		if(obj instanceof Identifiable) {
			Identifiable identifiable = (Identifiable) obj;
			try {
				String tempFileNamePrefix = obj.eClass().getName() + "_" + identifiable.getTechnicalid();
				File tempFile = File.createTempFile(tempFileNamePrefix, ".png");
				tempFile.deleteOnExit();
				imageLoader.save(new FileOutputStream(tempFile), SWT.IMAGE_PNG);
				
				URIConverter uriConverter = URIConverter.INSTANCE;
				if (obj.eResource() != null && obj.eResource().getResourceSet() != null) {
					uriConverter = obj.eResource().getResourceSet().getURIConverter();
				}
				
				URL imageUrl = tempFile.toURI().toURL();
				URI uri = URI.createURI(imageUrl.toString());
				
				return new MImageImpl(uriConverter, uri);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can't get object image, unmanaged object type: " + obj.getClass().getName());
		}
		
		return null;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:viewElement.isRequired()}",
		    value = "Returns the string '" + YES_TEXT + "' if the target View Element is required, '" + NO_TEXT + "' otherwise."
		    		+ " Returns '" + NA_TEXT + "' if not applicable (case of a View Container or ViewContainerReference).",
		    examples = {
		    		@Example(
		    				expression = "{m:viewElement.isRequired()}", 
		    				result = "'" + YES_TEXT + "', '" + NO_TEXT + "' or '" + NA_TEXT + "'.")
		    }
		)
	// @formatter:on	
	public String isRequired(AbstractViewElement abstractViewElement) {
		if(abstractViewElement instanceof ViewElement) {
			ViewElement viewElement = (ViewElement) abstractViewElement;
			if (viewElement.isRequired())
				return YES_TEXT;
			else
				return NO_TEXT;
		}
		return NA_TEXT;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:viewElement.viewElementType()}",
		    value = "Returns the name of the view element's type if applicable."
		    		+ " Returns '" + NA_TEXT + "' if not applicable (case of a View Container or ViewContainerReference).",
		    examples = {
		    		@Example(
		    				expression = "{m:viewElement.viewElementType()}", 
		    				result = "'Type name' or '" + NA_TEXT + "'.")
		    }
		)
	// @formatter:on	
	public String viewElementType(AbstractViewElement abstractViewElement) {
		if(abstractViewElement instanceof ViewElement) {
			ViewElement viewElement = (ViewElement) abstractViewElement;
			if(viewElement.getType() != null) {
				return viewElement.getType().getName();
			}
			return "";
		}
		return NA_TEXT;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:package.uiStructure()}",
		    value = "Returns the list of the target package sub elements, as seen in the Cinematic tree.",
		    examples = {
		    		@Example(
		    				expression = "{m:package.uiStructure()}", 
		    				result = "The list of the sub elements.")
		    }
		)
	// @formatter:on	
	public List<EObject> uiStructure(AbstractPackage pack){
		List<EObject>  result = new ArrayList<> ();
		result.addAll (pack.getSubPackages());
		result.addAll (pack.getViewContainers());
		if (pack instanceof CinematicRoot) {
			CinematicRoot root = (CinematicRoot) pack;
			result.addAll(root.getToolkits());
		}
		return result;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:package.uiStructureAsTable()}",
		    value = "Returns a table representing the target package and its sub elements, as seen in the Cinematic tree.",
		    examples = {
		    		@Example(
		    				expression = "{m:package.uiStructureAsTable()}", 
		    				result = "A table representing the package.")
		    }
		)
	// @formatter:on	
	public MTable uiStructureAsTable(AbstractPackage pack) {
		return treeAsTable(pack, p -> uiStructure((AbstractPackage) p));
	}

	// @formatter:off
	@Documentation(
			comment = "{m:viewContainer.uiStructureAsTable()}",
		    value = "Returns a table representing the target ViewContainer and its sub elements, as seen in the Cinematic tree.",
		    examples = {
		    		@Example(
		    				expression = "{m:viewContainer.uiStructureAsTable()}", 
		    				result = "A table representing the ViewContainer.")
		    }
		)
	// @formatter:on	
	public MTable uiStructureAsTable(ViewContainer viewContainer) {
		return treeAsTable(viewContainer, vc -> uiStructure((ViewContainer) vc));
	}

	private MTable treeAsTable(EObject root, Function<EObject, List<EObject>> subElements){
		
		MTable table = new MTableImpl();
        table.setLabel(cinematicLabel(root));
		
        MRow headerRow = new MRowImpl();
        table.getRows().add(headerRow);
        
        MImage headerIcon = cinematicIcon(root);
        MText headerText = new MTextImpl(cinematicLabel(root), defaultTextStyle);
        
        MList headerList = new MListImpl();
        headerList.add(headerIcon);
        headerList.add(new MTextImpl("  ", defaultTextStyle));
        headerList.add(headerText);
        
        MCell headerCell = new MCellImpl(headerList, null);
        headerRow.getCells().add(headerCell);
        
        for(EObject element : subElements.apply(root)) {
            MRow row = new MRowImpl();
            table.getRows().add(row);
            
            MImage icon = cinematicIcon(element);
            MText text = new MTextImpl(cinematicLabel(element), defaultTextStyle);
            
            MList list = new MListImpl();
            list.add(new MTextImpl("  >   ", boldTextStyle));
            list.add(icon);
            list.add(new MTextImpl("  ", defaultTextStyle));
            list.add(text);
            
            MCell cell = new MCellImpl(list, null);
            row.getCells().add(cell);
        }
        
		return table;
	}

	// @formatter:off
	@Documentation(
			comment = "{m:viewContainer.uiStructure()}",
		    value = "Returns the list of the target ViewContainer sub elements, as seen in the Cinematic tree.",
		    examples = {
		    		@Example(
		    				expression = "{m:viewContainer.uiStructure()}", 
		    				result = "The list of the sub elements.")
		    }
		)
	// @formatter:on	
	public List<EObject> uiStructure(ViewContainer viewContainer) {
		List<EObject>  result = new ArrayList<> ();
		result.addAll(viewContainer.getViewContainers());
		//result.addAll(viewContainer.getViewElements());
		result.addAll(viewContainer.getViewContainerReferences());

		
		return result;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:cinematicRoot.getAllLinkedDocuments()}",
		    value = "Returns the list of all documents attached to any of the elements "
		    		+ "contained in the target Cinematic Root.",
		    examples = {
		    		@Example(
		    				expression = "{m:cinematicRoot.getAllLinkedDocuments()}", 
		    				result = "The list of all of the documents.")
		    }
		)
	// @formatter:on	
	public List<Annotation> getAllLinkedDocuments(CinematicRoot cinematicRoot) {
		Iterator<EObject> iterator = cinematicRoot.eAllContents();
		List<Annotation> result = new ArrayList<Annotation>();
		while (iterator.hasNext()) {
			EObject obj = iterator.next();
			if (isCinematicObject(obj) && obj instanceof ObeoDSMObject) {
				ObeoDSMObject dsmObject = (ObeoDSMObject) obj;
				MetaDataContainer mdContainer = dsmObject.getMetadatas();
				if (mdContainer != null) {
					for (MetaData md: mdContainer.getMetadatas()) {
						if (md instanceof Annotation) {
							Annotation annotation = (Annotation) md;
							if (annotation.getTitle() != null && annotation.getTitle().startsWith(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE)) {
								result.add((Annotation) md);
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:doc.getDocumentTitle()}",
		    value = "Returns the title of the document.",
		    examples = {
		    		@Example(
		    				expression = "{m:doc.getDocumentTitle()}", 
		    				result = "The title of the document.")
		    }
		)
	// @formatter:on	
	public String getDocumentTitle(Annotation doc) {
		if(doc.getTitle() != null && doc.getTitle().length() >= DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE.length() + 3) {
			return doc.getTitle().substring(DocumentationLink.DOCUMENTATION_ANNOTATION_TITLE.length() + 3);
		}
		
		return "";
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:doc.getDocumentedObject()}",
		    value = "Returns the object this document is attached to.",
		    examples = {
		    		@Example(
		    				expression = "{m:doc.getDocumentedObject()}", 
		    				result = "The documented object.")
		    }
		)
	// @formatter:on	
	public EObject getDocumentedObject(Annotation doc) {
		if(doc.eContainer() != null) {
			return doc.eContainer().eContainer();
		}
		return null;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:cinematicRoot.getAllActionStatesWithOperations()}",
		    value = "Returns the list of all the Action States contained in the target Cinematic Root, having at least one Operation.",
		    examples = {
		    		@Example(
		    				expression = "{m:cinematicRoot.getAllActionStatesWithOperations()}", 
		    				result = "The list of all the Action States having at least one Operation.")
		    }
		)
	// @formatter:on	
	public List<ActionState> getAllActionStatesWithOperations (CinematicRoot cinematicRoot){
		List<ActionState>  result = new ArrayList<ActionState> ();
		for (Flow flow : cinematicRoot.getFlows()) {
			for (FlowState actionState : flow.getStates()) {
				if (actionState instanceof ActionState) {
					ActionState as = (ActionState) actionState;
					if (getOperations(as).size() > 0) {
						result.add(as);
					}
				}
			}
		}
		
		return result;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:actionState.getOperations()}",
		    value = "Returns the list of all the Operations attached to the target Action State (by way of Flow Actions).",
		    examples = {
		    		@Example(
		    				expression = "{m:actionState.getOperations()}", 
		    				result = "The list Operations attached to the target Action State.")
		    }
		)
	// @formatter:on	
	public List<Action> getOperations(ActionState actionState) {
		List<Action> result = new ArrayList<>();
		for (FlowAction flowAction : actionState.getActions()) {
			result.addAll(flowAction.getOperations());
		}
		return result;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:obj.getTypeName()}",
		    value = "Returns the name of the given object's type, formatted with white spaces.",
		    examples = {
		    		@Example(
		    				expression = "{m:obj.getTypeName()}", 
		    				result = "A string representation of the given object's type.")
		    }
		)
	// @formatter:on	
	public String getTypeName(EObject obj) {
		StringBuffer typeName = new StringBuffer();
		
		char[] className = obj.eClass().getName().toCharArray();
		for(int i = 0; i < className.length; i++) {
			char c = className[i];
			if(Character.isUpperCase(c) && i > 0) {
				typeName.append(" ");
			}
			typeName.append(c);
		}
		
		return typeName.toString();
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:obj.getName()}",
		    value = "Returns the name of the given object if it defines one. "
		    		+ "Returns an empty string in all other cases.",
		    examples = {
		    		@Example(
		    				expression = "{m:obj.getName()}", 
		    				result = "The object name.")
		    }
		)
	// @formatter:on	
	public String getName(EObject obj) {
		String name = "";
		
		if(obj != null) {
			EStructuralFeature nameFeature = obj.eClass().getEStructuralFeature("name");
			if(nameFeature != null) {
				Object nameValue = obj.eGet(nameFeature);
				if(nameValue instanceof String) {
					name = (String) nameValue;
				}
			}
		}
		
		return name;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:flowState.isNewInstance()}",
		    value = "If the target Flow State is a View State, returns the string '" + YES_TEXT + "' "
		    		+ "if it is a new instance and '" + NO_TEXT + "' if it is not. Returns '" + NA_TEXT + "' if "
		    		+ "the target Flow State is not a View State.",
		    examples = {
		    		@Example(
		    				expression = "{m:flowState.isNewInstance()}", 
		    				result = "'" + YES_TEXT + "' or '" + NO_TEXT + "' or '" + NA_TEXT + "'.")
		    }
		)
	// @formatter:on	
	public String isNewInstance(FlowState flowState) {
		if(flowState instanceof ViewState) {
			if (((ViewState) flowState).isNewInstance())
				return YES_TEXT;
			else
				return NO_TEXT;
		}
		return NA_TEXT;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:flowState.getViewContainers()}",
		    value = "If the target Flow State is a View State, returns the list "
		    		+ "of the referenced View Containers. Returns an empty list "
		    		+ "if the target Flow State is not a View State.",
		    examples = {
		    		@Example(
		    				expression = "{m:flowState.isNewInstance()}", 
		    				result = "The list of the referenced View Containers.")
		    }
		)
	// @formatter:on	
	public List<ViewContainer> getViewContainers(FlowState flowState) {
		if(flowState instanceof ViewState) {
			return ((ViewState) flowState).getViewContainers();
		}
		return Collections.emptyList();
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:flowState.isRefresh()}",
		    value = "If the target Flow State is a View State, returns the string '" + YES_TEXT + "' "
		    		+ "if it is set to refresh and '" + NO_TEXT + "' if it is not. Returns '" + NA_TEXT + "' if "
		    		+ "the target Flow State is not a View State.",
		    examples = {
		    		@Example(
		    				expression = "{m:flowState.isRefresh()}", 
		    				result = "'" + YES_TEXT + "' or '" + NO_TEXT + "' or '" + NA_TEXT + "'.")
		    }
		)
	// @formatter:on	
	public String isRefresh(FlowState flowState) {
		if(flowState instanceof ViewState) {
			if (((ViewState) flowState).isRefresh())
				return YES_TEXT;
			else
				return NO_TEXT;
		}
		return NA_TEXT;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:transition.isModal()}",
		    value = "Returns the string '" + YES_TEXT + "' if the target Transition is modal, '" + NO_TEXT + "' otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:transition.isModal()}", 
		    				result = "'" + YES_TEXT + "' or '" + NO_TEXT + "'.")
		    }
		)
	// @formatter:on	
	public String isModal(Transition transition) {
		if (transition.isModal())
			return YES_TEXT;
		else
			return NO_TEXT;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:transition.isModal()}",
		    value = "Returns the string '" + YES_TEXT + "' if the target Transition is modal, '" + NO_TEXT + "' otherwise.",
		    examples = {
		    		@Example(
		    				expression = "{m:transition.isModal()}", 
		    				result = "'" + YES_TEXT + "' or '" + NO_TEXT + "'.")
		    }
		)
	// @formatter:on	
	public List<EObject> getReferencedCinematicObjects(Requirement requirement) {
		List<EObject> referencedCinematicObjects = new ArrayList<>();
		for(EObject o : requirement.getReferencedObject()) {
			if(isCinematicObject(o)) {
				referencedCinematicObjects.add(o);
			}
		}
		
		return referencedCinematicObjects;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:package.getAllViewContainers()}",
		    value = "Returns all the ViewContainers contained in the given package and any of its sub packages and view containers.",
		    examples = {
		    		@Example(
		    				expression = "{m:package.getAllViewContainers()}", 
		    				result = "The list of all contained View Containers.")
		    }
		)
	// @formatter:on	
	public List<ViewContainer> getAllViewContainers(AbstractPackage abstractPackage) {
		List<ViewContainer> allViewContainers = new ArrayList<>();
		allViewContainers.addAll(abstractPackage.getViewContainers());
		
		for(ViewContainer vc : abstractPackage.getViewContainers()) {
			allViewContainers.addAll(getAllViewContainers(vc));
		}
		
		for(Package p : abstractPackage.getSubPackages()) {
			allViewContainers.addAll(getAllViewContainers(p));
		}
			
		return allViewContainers;
	}

	private List<ViewContainer> getAllViewContainers(ViewContainer viewContainer) {
		List<ViewContainer> allViewContainers = new ArrayList<>();
		allViewContainers.add(viewContainer);
		
		for(ViewContainer subViewContainer : viewContainer.getViewContainers()) {
			allViewContainers.addAll(getAllViewContainers(subViewContainer));
		}
		
		return allViewContainers;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:viewContainer.structureAsTable()}",
		    value = "Returns a table representing the target ViewContainer and its sub elements, as seen in the Package Diagram.",
		    examples = {
		    		@Example(
		    				expression = "{m:viewContainer.structureAsTable()}", 
		    				result = "A table representing the ViewContainer structure.")
		    }
		)
	// @formatter:on	
	public MTable structureAsTable(ViewContainer viewContainer) {
		
		MTable table = new MTableImpl();
        table.setLabel(cinematicLabel(viewContainer));
		
        MRow headerRow = new MRowImpl();
        table.getRows().add(headerRow);
        
        MImage headerIcon = cinematicIcon(viewContainer);
        MText headerText = new MTextImpl(cinematicLabel(viewContainer), defaultTextStyle);
        
        MList headerList = new MListImpl();
        headerList.add(headerIcon);
        headerList.add(new MTextImpl("  ", defaultTextStyle));
        headerList.add(headerText);
        
        MCell headerCell = new MCellImpl(headerList, viewContainerHeaderColor);
        headerRow.getCells().add(headerCell);
        
        for(AbstractViewElement viewElement : getSortedOwnedElements(viewContainer)) {
            MRow row = new MRowImpl();
            table.getRows().add(row);
            
            MImage icon = cinematicIcon(viewElement);
            MText text = new MTextImpl(cinematicLabel(viewElement), defaultTextStyle);
            
            MList list = new MListImpl();
            list.add(icon);
            list.add(new MTextImpl("  ", defaultTextStyle));
            list.add(text);
            
            MCell cell = new MCellImpl(list, viewContainerLineColor);
            row.getCells().add(cell);
        }
        
		return table;
	}
	
	private List<AbstractViewElement> getSortedOwnedElements(ViewContainer viewContainer) {
		List<AbstractViewElement> sortedOwnedElements = new ArrayList<>();
		sortedOwnedElements.addAll(viewContainer.getViewContainers());
		sortedOwnedElements.addAll(viewContainer.getViewElements());
		sortedOwnedElements.addAll(viewContainer.getViewContainerReferences());
		
		return sortedOwnedElements;
	}

	// asMockupImage
	
	// @formatter:off
	@Documentation(
			comment = "{m:viewContainer.asMockupImage()}",
		    value = "Returns a collection of images representing the target ViewContainer Mockup Diagrams.",
		    examples = {
		    		@Example(
		    				expression = "{m:viewContainer.asMockupImage()}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asMockupImage(ViewContainer viewContainer) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(viewContainer).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(viewContainer, ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_ID);
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:viewContainer.asMockupImage(width)}",
		    value = "Returns a collection of images representing the target ViewContainer Mockup Diagrams scaled to the given width keeping the initial image ratio.",
		    examples = {
		    		@Example(
		    				expression = "{m:viewContainer.asMockupImage(400)}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asMockupImage(ViewContainer viewContainer, int width) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(viewContainer).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(viewContainer, ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_ID);
		images.forEach(i -> i.conserveRatio());
		images.forEach(i -> i.setWidth(width));
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:viewContainer.asMockupImage(width, height)}",
		    value = "Returns a collection of images representing the target ViewContainer Mockup Diagrams scaled to the given width and heigth.",
		    examples = {
		    		@Example(
		    				expression = "{m:viewContainer.asMockupImage(400, 300)}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asMockupImage(ViewContainer viewContainer, int width, int height) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(viewContainer).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(viewContainer, ICinematicViewpoint.VIEW_CONTAINER_DIAGRAM_ID);
		images.forEach(i -> i.setHeight(height));
		images.forEach(i -> i.setWidth(width));
		
		return images;
	}
	
	// asFlowImage
	
	// @formatter:off
	@Documentation(
			comment = "{m:flow.asFlowImage()}",
		    value = "Returns a collection of images representing the target Flow Flow Diagrams.",
		    examples = {
		    		@Example(
		    				expression = "{m:flow.asFlowImage()}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asFlowImage(Flow flow) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(flow).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(flow, ICinematicViewpoint.FLOW_DIAGRAM_ID);
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:flow.asFlowImage(width)}",
		    value = "Returns a collection of images representing the target Flow Flow Diagrams scaled to the given width keeping the initial image ratio.",
		    examples = {
		    		@Example(
		    				expression = "{m:flow.asFlowImage(400)}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asFlowImage(Flow flow, int width) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(flow).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(flow, ICinematicViewpoint.FLOW_DIAGRAM_ID);
		images.forEach(i -> i.conserveRatio());
		images.forEach(i -> i.setWidth(width));
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:flow.asFlowImage(width, height)}",
		    value = "Returns a collection of images representing the target Flow Flow Diagrams scaled to the given width and heigth.",
		    examples = {
		    		@Example(
		    				expression = "{m:flow.asFlowImage(400, 300)}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asFlowImage(Flow flow, int width, int height) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(flow).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(flow, ICinematicViewpoint.FLOW_DIAGRAM_ID);
		images.forEach(i -> i.setHeight(height));
		images.forEach(i -> i.setWidth(width));
		
		return images;
	}
	
    // asPackageImage
	
	// @formatter:off
	@Documentation(
			comment = "{m:abstractPackage.asPackageImage()}",
		    value = "Returns a collection of images representing the target Package Package Diagrams.",
		    examples = {
		    		@Example(
		    				expression = "{m:abstractPackage.asPackageImage()}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asPackageImage(Package abstractPackage) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(abstractPackage).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(abstractPackage, ICinematicViewpoint.PACKAGE_DIAGRAM_ID);
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:abstractPackage.asPackageImage(width)}",
		    value = "Returns a collection of images representing the target Package Package Diagrams scaled to the given width keeping the initial image ratio.",
		    examples = {
		    		@Example(
		    				expression = "{m:abstractPackage.asPackageImage(400)}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asPackageImage(Package abstractPackage, int width) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(abstractPackage).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(abstractPackage, ICinematicViewpoint.PACKAGE_DIAGRAM_ID);
		images.forEach(i -> i.conserveRatio());
		images.forEach(i -> i.setWidth(width));
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:abstractPackage.asPackageImage(width, height)}",
		    value = "Returns a collection of images representing the target Package Package Diagrams scaled to the given width and heigth.",
		    examples = {
		    		@Example(
		    				expression = "{m:abstractPackage.asPackageImage(400, 300)}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asPackageImage(Package abstractPackage, int width, int height) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(abstractPackage).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(abstractPackage, ICinematicViewpoint.PACKAGE_DIAGRAM_ID);
		images.forEach(i -> i.setHeight(height));
		images.forEach(i -> i.setWidth(width));
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:layout.asLayoutImage()}",
		    value = "Returns a collection of images representing the target Layout Layout Diagrams.",
		    examples = {
		    		@Example(
		    				expression = "{m:layout.asLayoutImage()}", 
		    				result = "A sequence of images.")
		    }
		)
	
	// asLayoutImage
	
	// @formatter:on	
	public List<MImage> asLayoutImage(Layout layout) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(layout).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(layout, ICinematicViewpoint.LAYOUT_DIAGRAM_ID);
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:layout.asLayoutImage(width)}",
		    value = "Returns a collection of images representing the target Layout Layout Diagrams scaled to the given width keeping the initial image ratio.",
		    examples = {
		    		@Example(
		    				expression = "{m:layout.asLayoutImage(400)}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asLayoutImage(Layout layout, int width) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(layout).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(layout, ICinematicViewpoint.LAYOUT_DIAGRAM_ID);
		images.forEach(i -> i.conserveRatio());
		images.forEach(i -> i.setWidth(width));
		
		return images;
	}
	
	// @formatter:off
	@Documentation(
			comment = "{m:layout.asLayoutImage(width, height)}",
		    value = "Returns a collection of images representing the target Layout Layout Diagrams scaled to the given width and heigth.",
		    examples = {
		    		@Example(
		    				expression = "{m:layout.asLayoutImage(400, 300)}", 
		    				result = "A sequence of images.")
		    }
		)
	// @formatter:on	
	public List<MImage> asLayoutImage(Layout layout, int width, int height) throws SizeTooLargeException, IOException {
		Session session = new EObjectQuery(layout).getSession();
		List<MImage> images = new M2DocSiriusServices(session, true).asImageByRepresentationDescriptionName(layout, ICinematicViewpoint.LAYOUT_DIAGRAM_ID);
		images.forEach(i -> i.setHeight(height));
		images.forEach(i -> i.setWidth(width));
		
		return images;
	}
	
}
