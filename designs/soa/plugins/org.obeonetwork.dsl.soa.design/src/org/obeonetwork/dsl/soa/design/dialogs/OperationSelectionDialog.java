package org.obeonetwork.dsl.soa.design.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Flow;
import org.obeonetwork.dsl.soa.Operation;
import org.obeonetwork.dsl.soa.Parameter;

/**
 * {@link ListDialog} for selecting the {@link Parameter} objects for a {@link Flow} object.
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a> 
 */
public class OperationSelectionDialog extends ListDialog {

	public OperationSelectionDialog(Shell parent) {
		super(parent);
		setAddCancelButton(true);
		setBlockOnOpen(true);
		setTitle("Operation selection");
		setContentProvider(new IStructuredContentProvider() {
			
			@Override
			public Object[] getElements(Object inputElement) {
				Flow flow  = (Flow) inputElement;
				Component component = (Component) flow.eContainer().eContainer();
				Collection<Operation> parameters = new ArrayList<>();					
				component.eAllContents().forEachRemaining(eObject -> {
					if (eObject instanceof Operation) {
						parameters.add((Operation) eObject);
					}
				});
				return parameters.stream().toArray(Operation[]::new);
			}
		});
		
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
	}

}
