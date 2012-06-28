package org.obeonetwork.tools.linker.ui.view.util;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.tools.linker.EObjectLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class EObjectLinkLabelProvider extends StyledCellLabelProvider implements ITableLabelProvider {

	private AdapterFactoryItemDelegator itemDelegator;
	private Font emphasicFont;

	/**
	 * @param adapterFactory to use
	 * @param emphasicFont to use to show the children documentation
	 */
	public EObjectLinkLabelProvider(AdapterFactory adapterFactory) {
		super();
		this.itemDelegator = new AdapterFactoryItemDelegator(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
	 */
	@Override
	public void update(final ViewerCell cell) {
		StyledString styledString = new StyledString(getColumnText(cell.getElement(), cell.getColumnIndex()), getStyle(cell));
		cell.setText(styledString.getString());
		cell.setStyleRanges(styledString.getStyleRanges());
	}

	private Styler getStyle(final ViewerCell cell) {

		if (!displaySelectedElementEntry(cell)) {
			return new Styler() {
				public void applyStyles(TextStyle textStyle) {
					textStyle.font = getEmphasicFont();
					textStyle.foreground = cell.getControl().getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY);
				}
			};
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipText(java.lang.Object)
	 */
	@Override
	public String getToolTipText(Object element) {
		if (element instanceof EObjectLink) {
			EObjectLink link = (EObjectLink)element;
			return itemDelegator.getText(link.getSource());
		}
		return super.getToolTipText(element);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipShift(java.lang.Object)
	 */
	@Override
	public Point getToolTipShift(Object object) {
		return new Point(5, 5);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipDisplayDelayTime(java.lang.Object)
	 */
	@Override
	public int getToolTipDisplayDelayTime(Object object) {
		return 50;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipTimeDisplayed(java.lang.Object)
	 */
	@Override
	public int getToolTipTimeDisplayed(Object object) {
		return 5000;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public abstract String getColumnText(Object element, int columnIndex);
	
	/**
	 * @param cell
	 * @return
	 */
	private boolean displaySelectedElementEntry(final ViewerCell cell) {
		return getCurrentElement() != null?getCurrentElement().equals(getCellElement(cell)):false;
	}

	/**
	 * @return the selected element (input of the TableViewer).
	 */
	private Object getCurrentElement() {
		return getViewer().getInput();
	}

	/**
	 * @param cell
	 * @return
	 */
	private EObject getCellElement(final ViewerCell cell) {
		if (cell.getElement() instanceof EObjectLink) {
			EObjectLink entry = (EObjectLink)cell.getElement();
			if (entry != null) {
				return entry.getSource();
			}
		} 
		return null;
	}


	private Font getEmphasicFont() {
		if (emphasicFont == null) {
			FontData[] originalData = getViewer().getControl().getFont().getFontData();
			FontData[] styleData = new FontData[originalData.length];
			for (int i = 0; i < styleData.length; i++) {
				FontData base = originalData[i];
				styleData[i] = new FontData(base.getName(), base.getHeight(), base.getStyle() | SWT.ITALIC);
			}

			emphasicFont = new Font(Display.getCurrent(), styleData);
		}
		return emphasicFont;

	}



}
