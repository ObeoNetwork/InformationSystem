package org.obeonetwork.utils.sirius.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.query.DRepresentationQuery;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationElement;

public class SiriusTablePropertyTester extends PropertyTester {

	private final static String PROP_TABLE_NAME = "tableName";
	
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {		
		
		DRepresentationElement tableElement = (DRepresentationElement) receiver; 
		DRepresentation dRepresentation = SiriusUtil.findRepresentation(tableElement);
		if (dRepresentation != null ) {
			DRepresentationQuery dRepresentationQuery = new DRepresentationQuery(dRepresentation);
			
			if (dRepresentationQuery.getRepresentationDescriptor() != null 
					&& dRepresentationQuery.getRepresentationDescriptor().getDescription() != null
					&& dRepresentationQuery.getRepresentationDescriptor().getDescription().getLabel() != null) {
				
				return dRepresentationQuery.getRepresentationDescriptor().getDescription().getLabel().equals(expectedValue);
			}
				
		}
		
		return false;
	}

}
