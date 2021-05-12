package org.obeonetwork.dsl.soa.design.adapters;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.design.dialogs.NewSecuritySchemeDialog;

/**
 * {@link SelectionAdapter} for changing the {@link SecuritySchemeType} of a {@link SecuritySchemeType}
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a>
 */
public class SecuritySchemeTypeAdapter extends SelectionAdapter {

	private NewSecuritySchemeDialog securitySchemeDialog;
	
	public SecuritySchemeTypeAdapter(NewSecuritySchemeDialog securitySchemeDialog) {
		super();
		this.securitySchemeDialog = securitySchemeDialog;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Combo combo = (Combo) e.widget;
		int selectionIndex = combo.getSelectionIndex();
		String item = combo.getItem(selectionIndex);
		SecuritySchemeType type = SecuritySchemeType.getByName(item);
		securitySchemeDialog.setSecuritySchemeType(type);
		securitySchemeDialog.displayComposite();
	}

}