package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider.extensionpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Manager of the contributions to the extension point:
 * boundableElementChildrenDefinitions.
 * 
 * @author Obeo
 *
 */
public class BoundableElementChildrenContributionsManager {
	private static final String BOUNDABLE_ELEMENT_CHILDREN_EXTENSION_ID = "org.obeonetwork.dsl.environment.binding.dialect.ui.boundableElementChildrenDefinitions";//$NON-NLS-1$
	private static final String BOUNDABLE_ELEMENT_CHILDREN_EXTENSION_DEFINITION_ATTRIBUTE = "definition";//$NON-NLS-1$

	private static List<IBoundableElementChildren> DEFINITIONS;

	/**
	 * 
	 * @return a list of extensions of the extension point with ID:
	 *         {@link BOUNDABLE_ELEMNT_CHILDREN_EXTENSION_ID}.
	 */
	private static List<IConfigurationElement> getProvidedBoundableElementChildrenExtensions() {
		IExtension[] extensions = Platform.getExtensionRegistry()
				.getExtensionPoint(BOUNDABLE_ELEMENT_CHILDREN_EXTENSION_ID).getExtensions();
		return Arrays.stream(extensions).map(IExtension::getConfigurationElements).flatMap(Arrays::stream)
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @return a list of executable {@link IBoundableElementChildren} provided by
	 *         contributions to the extension point with ID
	 *         {@link BOUNDABLE_ELEMNT_CHILDREN_EXTENSION_ID}.
	 */
	private static List<IBoundableElementChildren> getProvidedBoundableElementsChildren() {
		List<IBoundableElementChildren> providedDefintions = new ArrayList<>();
		List<IConfigurationElement> contributions = getProvidedBoundableElementChildrenExtensions();
		for (IConfigurationElement configurationElement : contributions) {
			try {
				final Object extension = configurationElement
						.createExecutableExtension(BOUNDABLE_ELEMENT_CHILDREN_EXTENSION_DEFINITION_ATTRIBUTE);
				if (extension instanceof IBoundableElementChildren) {
					providedDefintions.add((IBoundableElementChildren) extension);
				}
			} catch (CoreException ex) {
				ex.printStackTrace();
			}
		}
		return providedDefintions;
	}

	/**
	 * 
	 * @return a list of executable {@link IBoundableElementChildren} provided by
	 *         contributions to the extension point with ID
	 *         {@link BOUNDABLE_ELEMNT_CHILDREN_EXTENSION_ID}.
	 */
	private static List<IBoundableElementChildren> getDefinitions() {
		if (DEFINITIONS == null) {
			DEFINITIONS = getProvidedBoundableElementsChildren();
		}
		return DEFINITIONS;
	}

	/**
	 * 
	 * @param object
	 * @return children to be displayed for object if a match is found among
	 *         contributed extensions. A match is such that the EClass of object is
	 *         among {@link IBoundableElementChildren#getApplicableEClasses()} of a
	 *         contributed extension.
	 */
	public static EObject[] getChildren(EObject object) {
		EObject[] results = new EObject[] {};
		if (object == null) {
			return results;
		}
		List<IBoundableElementChildren> definitions = getDefinitions();
		for (IBoundableElementChildren definition : definitions) {
			List<EClass> eclasses = definition.getApplicableEClasses();
			if (eclasses != null && eclasses.stream().anyMatch(cla -> cla.isInstance(object))) {
				List<? extends EObject> children = definition.getChildren(object);
				if (children != null) {
					return children.toArray(new EObject[] {});
				}
			}
		}
		return results;
	}

	/**
	 * 
	 * @param object
	 * @return a label to be displayed if a match is found among contributed
	 *         extensions. A match is such that the EClass of object is among
	 *         {@link IBoundableElementChildren#getApplicableEClasses()} of a
	 *         contributed extension.
	 */
	public static String getLabel(EObject object) {
		List<IBoundableElementChildren> definitions = getDefinitions();
		for (IBoundableElementChildren definition : definitions) {
			List<EClass> eclasses = definition.getApplicableEClasses();
			if (eclasses != null && eclasses.stream().anyMatch(cla -> cla.isInstance(object))) {
				return definition.getLabel(object);
			}
		}
		return null;
	}
}
