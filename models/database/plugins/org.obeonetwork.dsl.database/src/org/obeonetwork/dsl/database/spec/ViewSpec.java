package org.obeonetwork.dsl.database.spec;


import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.ViewElement;
import org.obeonetwork.dsl.database.impl.ViewImpl;
import org.obeonetwork.dsl.database.view.parser.ColObject;
import org.obeonetwork.dsl.database.view.parser.ViewContentProvider;

public class ViewSpec extends ViewImpl{
	private Adapter viewContentAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getFeature() == DatabasePackage.Literals.VIEW__QUERY) {
				View view = (View) notification.getNotifier();
				if (notification.getNewValue()!= null
						&& !notification.getNewValue().equals(notification.getOldValue())){
					String query = view.getQuery();
					// Clear existing reference in view
					view.getColumns().clear();
					view.getTables().clear();

					// Parse new query
					ViewContentProvider viewContentProvider = new ViewContentProvider();
					viewContentProvider.parseViewQuery(query);
					List<ColObject> listOfColumns = viewContentProvider.getColumns();
					if (listOfColumns!=null){
						for ( ColObject column : listOfColumns){
							ViewElement col = DatabaseFactory.eINSTANCE.createViewElement();
							col.setName(column.getName());
							col.setAlias(column.getAlias());
							view.getColumns().add(col);
						}
					}
					List<String> listOfTables = viewContentProvider.getTables();
					if (listOfTables!=null){
						for ( String table : listOfTables){
							ViewElement viewtableElement = DatabaseFactory.eINSTANCE.createViewElement();
							viewtableElement.setName(table);
							view.getTables().add(viewtableElement);
						}
					}
				}else if (notification.getNewValue() == null){
					view.getColumns().clear();
					view.getTables().clear();
				}
			}
		}
	};

	public ViewSpec(){
		super();
		eAdapters().add(viewContentAdapter);
	}
}