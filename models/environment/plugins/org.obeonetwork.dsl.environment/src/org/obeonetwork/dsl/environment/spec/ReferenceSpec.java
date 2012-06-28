package org.obeonetwork.dsl.environment.spec;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.impl.ReferenceImpl;

public class ReferenceSpec extends ReferenceImpl {
	@Override
	public void setType(DTO newType) {
		DTO oldType = getType();
		super.setType(newType);

		// We check if the oppositeOf is still consistent
		if (getOppositeOf() != null
				&& (newType == null || getOppositeOf().getDto() == null || !getOppositeOf()
						.getDto().isSubtypeOf(newType))) {
			setOppositeOf(null);
		}

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					EnvironmentPackage.REFERENCE__TYPE, oldType, getType()));
	}

	
	@Override
	public void setOppositeOf(Reference newOppositeOf) {		
			Reference oldOppositeOf = getOppositeOf();
			super.setOppositeOf(newOppositeOf);

			// If an opposite was specified, we have to unset it
			if (oldOppositeOf != null && !oldOppositeOf.equals(newOppositeOf)) {
				oldOppositeOf.setOppositeOf(null);
			}

			// If a new opposite is specified, we have to ensure consistency
			if (newOppositeOf != null
					&& (newOppositeOf.getOppositeOf() == null || !newOppositeOf
							.getOppositeOf().equals(this))) {
				newOppositeOf.setOppositeOf(this);
			}

			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						EnvironmentPackage.REFERENCE__OPPOSITE_OF, oldOppositeOf,
						getOppositeOf()));
		
	}
}
