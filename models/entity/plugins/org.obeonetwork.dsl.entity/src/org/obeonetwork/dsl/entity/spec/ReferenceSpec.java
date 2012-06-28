package org.obeonetwork.dsl.entity.spec;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.entity.Reference;
import org.obeonetwork.dsl.entity.impl.ReferenceImpl;

public class ReferenceSpec extends ReferenceImpl {

	
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
				&& (newOppositeOf.getOppositeOf() == null || !newOppositeOf.getOppositeOf().equals(this))) {
			newOppositeOf.setOppositeOf(this);
		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.REFERENCE__OPPOSITE_OF, oldOppositeOf, newOppositeOf));
	}
	
	@Override
	public void setType(Entity newType) {
		Entity oldType = getType();
		super.setType(newType);
		
		// We check if the oppositeOf is still consistent
		if (getOppositeOf() != null
			&& (newType == null
				|| getOppositeOf().getEntity() == null
				|| !getOppositeOf().getEntity().isSubtypeOf(newType))){
			setOppositeOf(null);
		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.REFERENCE__TYPE, oldType, newType));
	}
	
	@Override
	public void setEntity(Entity newEntity) {
		// TODO : check this code
		if (newEntity != eInternalContainer() || (eContainerFeatureID() != EntityPackage.REFERENCE__ENTITY && newEntity != null)) {
			if (EcoreUtil.isAncestor(this, newEntity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEntity != null)
				msgs = ((InternalEObject)newEntity).eInverseAdd(this, EntityPackage.ENTITY__OWNED_REFERENCES, Entity.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newEntity, EntityPackage.REFERENCE__ENTITY, msgs);
			if (msgs != null) {
				msgs.dispatch();
			} else {
				// We check if the oppositeOf is still consistent
				if (getOppositeOf() != null
						&& !newEntity.isSubtypeOf(getOppositeOf().getType())) {
					setOppositeOf(null);
				}
			}
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntityPackage.REFERENCE__ENTITY, newEntity, newEntity));
	}
}
