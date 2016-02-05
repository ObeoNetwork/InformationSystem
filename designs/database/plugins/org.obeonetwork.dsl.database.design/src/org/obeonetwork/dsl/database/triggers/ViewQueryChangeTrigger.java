package org.obeonetwork.dsl.database.triggers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.ViewElement;
import org.obeonetwork.dsl.database.view.parser.ColObject;
import org.obeonetwork.dsl.database.view.parser.ViewContentProvider;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

/**
 * Trigger to check if a query changed in order to update 
 * tables and columns references.
 * @author fbats
 *
 */
public class ViewQueryChangeTrigger implements ModelChangeTrigger{
/*
 * This trigger is a workaround to update tables and columns using commands.
 * 
 * A first implementation done using an adapter to recompute tables and columns
 * show some troubles for diagram refresh when user use undo/redo.
 * 
 */

	private View view;
	private String query;

	@Override
	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		Iterable<Notification> querySetNotification = Iterables.filter(notifications, IS_QUERY_SET);
		
		for(Notification notification: querySetNotification){
			view = (View) notification.getNotifier();
			query = view.getQuery();
			final Session session = SessionManager.INSTANCE.getSession(view);
			final TransactionalEditingDomain domain = session.getTransactionalEditingDomain();

			if (!Strings.isNullOrEmpty(query)){
				final Command result = new RecordingCommand(domain) {

					@Override
					protected void doExecute() {
						if (view.getColumns()!=null){
							view.getColumns().clear();
						}
						if (view.getTables()!=null){
							view.getTables().clear();
						}
						// Parse new query
						ViewContentProvider viewContentProvider = new ViewContentProvider();
						viewContentProvider.parseViewQuery(query);
						List<ColObject> listOfColumns = viewContentProvider.getColumns();

						if (listOfColumns!=null){
							for ( ColObject column : listOfColumns){
								ViewElement elem = DatabaseFactory.eINSTANCE.createViewElement();
								elem.setName(column.getName());
								elem.setAlias(column.getAlias());
								view.getColumns().add(elem);
							}
						}
						List<String> listOfTables = viewContentProvider.getTables();
						if (listOfTables!=null){
							for ( String table : listOfTables){
								ViewElement elem = DatabaseFactory.eINSTANCE.createViewElement();
								elem.setName(table);
								view.getTables().add(elem);
							}
						}
					}
				};
				return Options.newSome(result);
			}else if (Strings.isNullOrEmpty(query)){
				final Command result = new RecordingCommand(domain) {

					@Override
					protected void doExecute() {
						if (view.getColumns()!=null){
							view.getColumns().clear();
						}
						if (view.getTables()!=null){
							view.getTables().clear();
						}
					}
				};
				return Options.newSome(result);
			}
		}
		return Options.newNone();
	}

	@Override
	public int priority() {
		return 1;
	}


	/**
	 * Filter Query modification notifications.
	 */
	public static final Predicate<Notification> IS_QUERY_SET = new Predicate<Notification>() {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean apply(Notification input) {
			if (input.isTouch())
				return false;
			if (input.getEventType() == Notification.ADD || input.getEventType() == Notification.ADD_MANY || input.getEventType() == Notification.SET) {
				return input.getFeature() == DatabasePackage.Literals.VIEW__QUERY;
			}
			return false;
		}
	};
}