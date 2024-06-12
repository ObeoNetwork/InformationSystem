package org.obeonetwork.graal.design.ui.view.explorer.system;

import java.util.Comparator;

import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;

/**
 * @author obeo
 *
 */
public class SystemTreeContentViewerComparator extends org.eclipse.jface.viewers.ViewerComparator {

	public SystemTreeContentViewerComparator() {
	}

	/**
	 * @param comparator
	 */
	public SystemTreeContentViewerComparator(Comparator<? super String> comparator) {
		super(comparator);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int category(Object element) {
		if (element instanceof DRepresentationDescriptor) {
			return 0;
		}
		return 1;
	}

}
