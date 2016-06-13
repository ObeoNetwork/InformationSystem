package org.obeonetwork.tools.linker.ui.view;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;
import org.obeonetwork.tools.linker.EObjectLink;
import org.obeonetwork.tools.linker.ObeoLinkerPlugin;
import org.obeonetwork.tools.linker.ui.view.util.EObjectLinkContentProvider;
import org.obeonetwork.tools.linker.ui.view.util.ViewpointSelectionListener;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EObjectLinksView extends ViewPart {

	protected AdapterFactory adapterFactory;
	
	private TableViewer viewer;
	private Label eobjectLabel;

	private EObjectLinkContentProvider contentProvider;

	protected Action doubleClickAction;
	private Action switchChildrenVisibilityAction;

	private List<ViewListener> listeners;

	private ViewpointSelectionListener listener;
	

	/**
	 * The constructor.
	 */
	public EObjectLinksView() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		listeners = new ArrayList<EObjectLinksView.ViewListener>();
	}

	/**
	 * Add a new listener to the view.
	 * @param listener to add.
	 */
	public void addListener(ViewListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		Composite viewContainer = new Composite(parent, SWT.NONE);
		viewContainer.setLayout(new GridLayout());
		eobjectLabel = new Label(viewContainer, SWT.NONE);
		eobjectLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Composite tableContainer = new Composite(viewContainer, SWT.NONE);
		tableContainer.setLayoutData(new GridData(GridData.FILL_BOTH));
		TableColumnLayout layout = new TableColumnLayout();
		tableContainer.setLayout(layout);
		viewer = new TableViewer(tableContainer, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		addColumns();

		contentProvider = createContentProvider();
		viewer.setContentProvider(contentProvider);
		List<ViewerFilter> filters = createFilters();
		if (filters.size() > 0) {
			for (ViewerFilter viewerFilter : filters) {
				viewer.addFilter(viewerFilter);
			}
		}
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				for (ViewListener listener : listeners) {
					listener.fireSelectionChanged(getSelectedEntries());
				}
			}
		});
		ColumnViewerToolTipSupport.enableFor(viewer,ToolTip.NO_RECREATE);
		listener = new ViewpointSelectionListener() {

			/**
			 * {@inheritDoc}
			 * @see org.obeonetwork.tools.linker.ui.view.util.ViewpointSelectionListener#eObjectSelected(org.eclipse.emf.ecore.EObject)
			 */
			@Override
			protected void eObjectSelected(EObject selectedEObject) {
				update(selectedEObject);
			}
		};
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(listener);
		makeActions();
		fillLocalActionBar();
		fillLocalPullDown();
		hookDoubleClickAction();
	}

	/**
	 * Add columns to the tableviewer. 
	 */
	protected void addColumns() {
		addColumn(ObeoLinkerPlugin.getInstance().getString("EObjectLinksView_ColumnValue_title"), 100); //$NON-NLS-1$
	}

	/**
	 * Add one column to the viewer with the given name and ratio.
	 * @param columnName name to the column
	 * @param ratio weight of the column.
	 */
	protected void addColumn(String columnName, int ratio) {
		final TableViewerColumn colName = new TableViewerColumn(viewer, SWT.NONE);
		colName.getColumn().setText(columnName);
		CellLabelProvider columnNameLabelProvider = createLabelProvider();
		colName.setLabelProvider(columnNameLabelProvider);
		((TableColumnLayout)viewer.getControl().getParent().getLayout()).setColumnData(colName.getColumn(), new ColumnWeightData(ratio, true));
	}

	/**
	 * @return contentProvider to use for the viewer cells.
	 */
	protected EObjectLinkContentProvider createContentProvider() {
		return new EObjectLinkContentProvider();
	}
	
	/**
	 * @return labelProvider to use for the viewer cells.
	 */
	protected CellLabelProvider createLabelProvider() {
		return new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				cell.setText(cell.getElement().toString());
				
			}
		};
	}

	/**
	 * @return list of filters to add to the viewer.
	 */
	protected List<ViewerFilter> createFilters() {
		return Collections.emptyList();
	}

	/**
	 * @return the active selection
	 */
	public EObject getInput() {
		return (EObject) viewer.getInput();
	}
	
	@SuppressWarnings("unchecked")
	public List<EObjectLink> getSelectedEntries() {
		return viewer.getSelection() instanceof StructuredSelection?(List<EObjectLink>)((StructuredSelection)viewer.getSelection()).toList():Collections.EMPTY_LIST;
	}
	
	/**
	 * @return the adapterFactory
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * @param selectedEObject
	 */
	private void update(EObject selectedEObject) {
		viewer.setInput(selectedEObject);
		refresh();
	}
	/**
	 * Refresh the view.
	 */
	public void refresh() {
		viewer.refresh();
		if (!(viewer.getInput() instanceof EObject)) {
			eobjectLabel.setText(""); //$NON-NLS-1$
		} else {
			AdapterFactoryItemDelegator delegator = new AdapterFactoryItemDelegator(adapterFactory);
			eobjectLabel.setText(ObeoLinkerPlugin.getInstance().getString("EObjectLinksView_LabelSelection_prefix") + delegator.getText(viewer.getInput())); //$NON-NLS-1$
		}
		for (ViewListener listener : listeners) {
			listener.fireInputChanged(getInput());
		}
	}
	
	/**
	 * Switch the visibility of the children.
	 */
	public void switchVisibility() {
		contentProvider.switchVisibility();
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(listener);
		super.dispose();
	}

	protected void makeActions() {
		switchChildrenVisibilityAction = new Action(getShowChildrenActionTitle(), IAction.AS_CHECK_BOX) { //$NON-NLS-1$
			public void run() {
				switchVisibility();
				viewer.refresh();
			}
		};
		switchChildrenVisibilityAction.setText(getShowChildrenActionTitle()); //$NON-NLS-1$
		switchChildrenVisibilityAction.setToolTipText(getShowChildrenActionDescription()); //$NON-NLS-1$
	}
	
	protected String getShowChildrenActionTitle() {
		return ObeoLinkerPlugin.getInstance().getString("EObjectLinksView_ShowChildrenAction_title");
	}
	
	protected String getShowChildrenActionDescription() {
		return ObeoLinkerPlugin.getInstance().getString("EObjectLinksView_ShowChildrenAction_description");
	}

	/**
	 * To override
	 */
	protected void fillLocalActionBar() { }
	
	private void fillLocalPullDown() {
		getViewSite().getActionBars().getMenuManager().add(switchChildrenVisibilityAction);
	}
	
	private void hookDoubleClickAction() {
		doubleClickAction = createDoubleClickAction();
		if (doubleClickAction != null) {
			viewer.addDoubleClickListener(new IDoubleClickListener() {
				
				public void doubleClick(DoubleClickEvent event) {
					doubleClickAction.run();
				}
			});
		}
	}
	
	/**
	 * @return
	 */
	protected Action createDoubleClickAction() {
		return null;
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	
	/**
	 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
	 *
	 */
	public interface ViewListener {
		
		/**
		 * @param newInput of the view
		 */
		void fireInputChanged(EObject newInput);
		
		/**
		 * @param newSelection new selected entries
		 */
		void fireSelectionChanged(List<EObjectLink> newSelection);
		
	}

}