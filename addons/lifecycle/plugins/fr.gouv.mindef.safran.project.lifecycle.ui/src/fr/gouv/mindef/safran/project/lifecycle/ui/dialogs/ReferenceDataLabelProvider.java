package fr.gouv.mindef.safran.project.lifecycle.ui.dialogs;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import fr.gouv.mindef.safran.project.lifecycle.ReferenceData;

public class ReferenceDataLabelProvider extends LabelProvider implements ITableLabelProvider {
	
	private AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if (element instanceof ReferenceData) {
			ReferenceData referenceData = (ReferenceData)element;
			switch (columnIndex) {
			case 0:
				return labelProvider.getImage(referenceData.getReferencingElement());
			case 1:
				return null;
			case 2:
				return labelProvider.getImage(referenceData.getReferencedElement());
			}
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof ReferenceData) {
			ReferenceData referenceData = (ReferenceData)element;
			switch (columnIndex) {
			case 0:
				return labelProvider.getText(referenceData.getReferencingElement());
			case 1:
				return referenceData.getReferencingFeature().getName();
			case 2:
				return labelProvider.getText(referenceData.getReferencedElement());
			}
		}
		return null;
	}

}
