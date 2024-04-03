/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.tests.eef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import org.eclipse.eef.core.api.EEFPage;
import org.eclipse.eef.ide.ui.properties.api.EEFTabDescriptor;
import org.eclipse.eef.properties.ui.api.EEFTabbedPropertySheetPage;
import org.junit.Test;
import org.obeonetwork.utils.common.IntrospectionUtils;

/**
 * This class tests that the EEF API we use by reflection in {@link DatabaseEEFPropertiesServices.forceRefresh(EOBject)} is not changed.
 */
public class EefTests {
	
	/**
	 * This test checks that the class {@link EEFTabbedPropertySheetPage} has an attribute 'descriptorToTab' and that the class {@ link EEFTabDescriptor} has an attribute 'eefPage'.
	 */
	@Test
	public void testApi() {
		
		Field fieldDescriptorToTab = IntrospectionUtils.getField(EEFTabbedPropertySheetPage.class, "descriptorToTab");
		assertNotNull(fieldDescriptorToTab);
		assertEquals("java.util.Map<org.eclipse.eef.properties.ui.api.IEEFTabDescriptor, org.eclipse.eef.properties.ui.api.EEFTabContents>", fieldDescriptorToTab.getGenericType().getTypeName());
		
		Field fieldEefPage = IntrospectionUtils.getField(EEFTabDescriptor.class, "eefPage");
		assertNotNull(fieldEefPage);
		assertEquals(EEFPage.class, fieldEefPage.getType());
		
	}

}
