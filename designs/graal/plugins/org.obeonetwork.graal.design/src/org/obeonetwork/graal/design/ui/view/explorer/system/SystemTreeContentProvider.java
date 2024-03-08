package org.obeonetwork.graal.design.ui.view.explorer.system;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.provider.NamespaceItemProvider;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.graal.provider.SystemItemProvider;
import org.obeonetwork.graal.provider.custom.SystemCustomContentItemProvider;

/**
 * @author Obeo
 *
 */
public class SystemTreeContentProvider implements ITreeContentProvider {
	@Override
	public Object[] getElements(Object inputElement) {
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof SystemCustomContentItemProvider) {
			SystemCustomContentItemProvider systemCustomContentItemProvider = (SystemCustomContentItemProvider) parentElement;
			return systemCustomContentItemProvider.getChildren(systemCustomContentItemProvider.getTarget()).toArray();
		} else if (parentElement instanceof EObject) {//Below SystemCustomContentItemProvider
			return ((EObject)parentElement).eContents().toArray();
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof SystemCustomContentItemProvider) {
			SystemCustomContentItemProvider systemCustomContentItemProvider = (SystemCustomContentItemProvider) element;
			return systemCustomContentItemProvider.getParent(systemCustomContentItemProvider.getTarget());
		}  else if(element instanceof EObject) {//Below SystemCustomContentItemProvider
			EObject parent = ((EObject)element).eContainer();
			if (parent instanceof org.obeonetwork.graal.System) {// $NON-NLS-N$
				final AdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
				Object systemElementItemProvider = composedAdapterFactory.adapt(element, IEditingDomainItemProvider.class);
				
				if(systemElementItemProvider instanceof NamespaceItemProvider) {
					//This is to avoid overriding getParent() in NamespaceItemProvider that would yield do circular dependencies
					Object system = ((IEditingDomainItemProvider) systemElementItemProvider).getParent(element);
					SystemItemProvider systemItemProvider =	(SystemItemProvider)composedAdapterFactory.adapt(system, IEditingDomainItemProvider.class);
					return systemItemProvider != null 
							? systemItemProvider.getSystemCustomContentItemProvider(EnvironmentPackage.eINSTANCE.getNamespacesContainer_OwnedNamespaces()) 
							: null;
				} else if(systemElementItemProvider!=null) {
					//Some getParent() have been overridden in ItemProvider to get the transient node instead of System
					return ((IEditingDomainItemProvider) systemElementItemProvider).getParent(element);
				}
			}
			return parent;
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
}
