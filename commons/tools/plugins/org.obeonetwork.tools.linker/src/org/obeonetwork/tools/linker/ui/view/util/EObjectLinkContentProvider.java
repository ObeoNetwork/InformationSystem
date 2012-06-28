/**
 * 
 */
package org.obeonetwork.tools.linker.ui.view.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.EObjectLinker;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EObjectLinkContentProvider implements IStructuredContentProvider {

	protected EObjectLinker linker;
	private boolean childrenVisibility;
	
	/**
	 * 
	 */
	public EObjectLinkContentProvider() {
		childrenVisibility = false;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof EObject && (((EObject) newInput).eResource() != null) && ((EObject)newInput).eResource().getResourceSet() != null) {
			ResourceSet resourceSet = ((EObject)newInput).eResource().getResourceSet();
			if (linker == null || !linker.getResourceSet().equals(resourceSet)) {
				linker = EObjectLinker.getLinker((EObject)newInput);		
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof EObject) {
			List<EObjectLink> links = linker.getLinks((EObject) inputElement);
			if (childrenVisibility) {
				List<EObjectLink> result = new ArrayList<EObjectLink>();
				result.addAll(links);
				result.addAll(getChildrenEntries((EObject) inputElement));
				return result.toArray();
			} else {
				return links.toArray();
			}
		}
		return null;
	}
	
	/**
	 * @param inputElement
	 * @return
	 */
	private List<EObjectLink> getChildrenEntries(EObject inputElement) {
		List<EObjectLink> result = new ArrayList<EObjectLink>();
		for (Iterator<EObject> iter = inputElement.eAllContents(); iter.hasNext(); ) {
			EObject next = iter.next();
			result.addAll(linker.getLinks(next));
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {	}

	/**
	 * Switch the children visibility in the viewer
	 */
	public void switchVisibility() {
		childrenVisibility = !childrenVisibility;
	}

}
