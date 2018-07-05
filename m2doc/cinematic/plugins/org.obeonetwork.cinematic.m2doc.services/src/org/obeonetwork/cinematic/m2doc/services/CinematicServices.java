package org.obeonetwork.cinematic.m2doc.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.acceleo.annotations.api.documentation.Documentation;
import org.eclipse.acceleo.annotations.api.documentation.Param;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.design.services.CinematicBindingServices;
import org.obeonetwork.dsl.cinematic.design.services.CinematicLabelServices;
import org.obeonetwork.dsl.cinematic.flow.ActionState;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.FlowAction;
import org.obeonetwork.dsl.cinematic.flow.FlowEvent;
import org.obeonetwork.dsl.cinematic.flow.FlowState;
import org.obeonetwork.dsl.cinematic.flow.provider.FlowItemProviderAdapterFactory;
import org.obeonetwork.dsl.cinematic.provider.CinematicItemProviderAdapterFactory;
import org.obeonetwork.dsl.cinematic.toolkits.provider.ToolkitsItemProviderAdapterFactory;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.cinematic.view.ViewElement;
import org.obeonetwork.dsl.cinematic.view.provider.ViewItemProviderAdapterFactory;
import org.obeonetwork.dsl.environment.Action;
import org.obeonetwork.dsl.environment.Annotation;
import org.obeonetwork.dsl.environment.MetaData;
import org.obeonetwork.dsl.environment.MetaDataContainer;
import org.obeonetwork.dsl.environment.ObeoDSMObject;
import org.obeonetwork.m2doc.element.MImage;
import org.obeonetwork.m2doc.element.impl.MImageImpl;

public class CinematicServices {

	private CinematicLabelServices labelService = new CinematicLabelServices();
	private CinematicBindingServices bindingService = new CinematicBindingServices ();


	public boolean isCinematicObject(EObject obj) {
		EPackage pack = obj.eClass().getEPackage();
		return pack.getName().contains("cinematic");
	}

	/**
	 * Return the list of metadata annotations from a flowEvent
	 * 
	 * @param flowEvent
	 *            source flow event
	 * @return list of annotations from the flowEvent
	 */
	
	// @formatter:off
	@Documentation(
		    value = "Return the list of metadata annotations from a flowEvent",
		    params = {
		        @Param(name = "flowEvent", value = "a flow event"),
		    },
		    result = "the list of metadata annotations"

		)
		// @formatter:on	
	public List<Annotation> getAnnotations(FlowEvent flowEvent) {
		MetaDataContainer metadatas = flowEvent.getMetadatas();
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
		    value = "get a label for a cinematic element, regarding how it is displayed in the ISModeler",
		    params = {
		        @Param(name = "obj", value = "a cinematic element"),
		    },
		    result = "the label"

		)
		// @formatter:on	
	public String cinematicLabel(EObject obj) {
		return labelService.getCinematicLabel(obj);
	}

	// @formatter:off
	@Documentation(
		    value = "get a label for a cinematic element, regarding how it is displayed in the ISModeler",
		    params = {
		        @Param(name = "obj", value = "a cinematic element"),
		    },
		    result = "the label"

		)
		// @formatter:on	
	public MImage cinematicIcon (EObject obj) {
		CinematicItemProviderAdapterFactory cinematicFactory = new CinematicItemProviderAdapterFactory();
		ViewItemProviderAdapterFactory viewFactory = new ViewItemProviderAdapterFactory();
		FlowItemProviderAdapterFactory flowFactory = new FlowItemProviderAdapterFactory();
		ToolkitsItemProviderAdapterFactory toolkitsFactory = new ToolkitsItemProviderAdapterFactory();
		
		String prefix = obj.eClass().getEPackage().getName();
		ComposeableAdapterFactory factory = null;
		if (prefix.equals("cinematic")) factory = cinematicFactory;
		else if (prefix.equals("view")) factory = viewFactory;
		else if (prefix.equals("toolkits")) factory = toolkitsFactory;
		else if (prefix.equals("flow")) factory = flowFactory;
		else throw new RuntimeException("No IS item provider for " + obj.toString());				
				
		
       if(factory.isFactoryForType(IItemLabelProvider.class)){
		IItemLabelProvider labelProvider = (IItemLabelProvider) factory.adapt(obj, IItemLabelProvider.class);
			if(labelProvider != null){ 
				Object image = labelProvider.getImage(obj);
				if (image instanceof URL) {
					URL imageUrl = (URL) image;
					org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(imageUrl.toString());
					
					return new MImageImpl(uri);
					
				}
				
				
			}
		}
		return null;
	}

	// @formatter:off
	@Documentation(
		    value = "Returns tis a vieweElement is required, as String.",
		    params = {
		        @Param(name = "viewElement", value = "the view Element"),
		    },
		    result = "\"Oui\" si l'element est requis, \"Non\" dans le cas contraire"

		)
		// @formatter:on

	public String isRequired(ViewElement viewElement) {
		if (viewElement.isRequired())
			return "Oui";
		else
			return "Non";
	}
	
	// @formatter:off
	@Documentation(
		    value = "Returns the list of sub elements of the package, as seen in the cinematic tree.",
		    params = {
		        @Param(name = "pack", value = "the package"),
		    },
		    result = "the list of sub elements of the package"

		)
		// @formatter:on
	public List<EObject> subElements (AbstractPackage pack){
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
		    value = "Returns the list of sub elements of the view container, as seen in the cinematic tree.",
		    params = {
		        @Param(name = "viewContainer", value = "the view container"),
		    },
		    result = "the list of sub elements of the view container"

		)
		// @formatter:on
	public List<EObject> subElements (ViewContainer viewContainer) {
		List<EObject>  result = new ArrayList<> ();
		result.addAll(viewContainer.getViewContainers());
		result.addAll(viewContainer.getViewElements());
		result.addAll(viewContainer.getViewContainerReferences());
		result.addAll(viewContainer.getEvents());
		result.addAll(viewContainer.getActions());
		result.addAll(bindingService.getCinematicBindingInfos(viewContainer));
		
		return result;
	}
	
	public List<Annotation> getAllLinkedDocuments (CinematicRoot cinematicRoot) {
		TreeIterator<EObject> iterator = cinematicRoot.eAllContents();
		List<Annotation> result = new ArrayList<Annotation>();
		while (iterator.hasNext()) {
			EObject obj = iterator.next();
			if (isCinematicObject(obj) && obj instanceof ObeoDSMObject) {
				ObeoDSMObject dsmObject = (ObeoDSMObject) obj;
				MetaDataContainer mdContainer = dsmObject.getMetadatas();
				if (mdContainer != null) {
					for (MetaData md: mdContainer.getMetadatas()) {
						if (md instanceof Annotation) {
							result.add((Annotation) md);
							
						}
					}
				}
			}
		}
		return result;
	}
	
	// @formatter:off
	@Documentation(
		    value = "Returns the list of actions states with at least an operation.",
		    params = {
		        @Param(name = "cinematicRoot", value = "the cinematic root"),
		    },
		    result = "the list of actions states with at least an operation"

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
	    value = "Returns the list of operation  for boolean true.",
	    params = {
	        @Param(name = "actionState", value = "the ActionState"),
	    },
	    result = "the list of operations from the action state"

	)
	// @formatter:on
	public List<Action> getOperations (ActionState actionState){
		List<Action> result = new ArrayList<>();
		for (FlowAction flowAction : actionState.getActions()) {
			result.addAll(flowAction.getOperations());
		}
		return result;
	}

	
}
