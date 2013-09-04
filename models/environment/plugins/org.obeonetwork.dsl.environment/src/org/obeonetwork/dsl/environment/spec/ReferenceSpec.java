package org.obeonetwork.dsl.environment.spec;

import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.impl.ReferenceImpl;

public class ReferenceSpec extends ReferenceImpl {
	@Override
	public void setType(DTO newType) {
		super.setType(newType);

		// We check if the oppositeOf is still consistent
		if (getOppositeOf() != null && !newType.eIsProxy()
				&& (newType == null || getOppositeOf().getDto() == null || !getOppositeOf()
						.getDto().isSubtypeOf(newType))) {
			setOppositeOf(null);
		}
	}

	
	@Override
	public void setOppositeOf(Reference newOppositeOf) {		
			Reference oldOppositeOf = getOppositeOf();
			super.setOppositeOf(newOppositeOf);

			// If an opposite was specified, we have to unset it
			if (oldOppositeOf != null && (newOppositeOf == null || !newOppositeOf.eIsProxy()) && !oldOppositeOf.equals(newOppositeOf)) {
				oldOppositeOf.setOppositeOf(null);
			}

			// If a new opposite is specified, we have to ensure consistency
			if (newOppositeOf != null && !newOppositeOf.eIsProxy()
					&& (newOppositeOf.getOppositeOf() == null || !newOppositeOf
							.getOppositeOf().equals(this))) {
				newOppositeOf.setOppositeOf(this);
			}
	}
}
