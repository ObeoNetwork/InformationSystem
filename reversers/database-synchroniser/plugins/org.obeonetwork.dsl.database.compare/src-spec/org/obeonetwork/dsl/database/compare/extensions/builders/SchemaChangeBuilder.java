/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.extensions.builders;

import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.ReferenceChange;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.dbevolution.AddSchema;
import org.obeonetwork.dsl.database.dbevolution.AlterSchema;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionFactory;
import org.obeonetwork.dsl.database.dbevolution.RemoveSchema;
import org.obeonetwork.dsl.database.dbevolution.RenameSchemaChange;
import org.obeonetwork.dsl.database.dbevolution.UpdateSchemaCommentChange;

public class SchemaChangeBuilder extends ChangeBuilder {

	public SchemaChangeBuilder() {
		super(DatabasePackage.eINSTANCE.getSchema());
	}

	@Override
	protected Diff handleAddChange(ReferenceChange change) {
		AddSchema addSchema = DbevolutionFactory.eINSTANCE.createAddSchema();
		Schema schema = (Schema) change.getValue();
		addSchema.setSchema(schema);
		
		fillDBDiff(addSchema, change);
		
		return addSchema;
	}

	@Override
	protected Diff handleRemoveChange(ReferenceChange change) {
		RemoveSchema removeSchema = DbevolutionFactory.eINSTANCE.createRemoveSchema();
		Schema schema = (Schema) change.getValue();
		removeSchema.setSchema(schema);
		
		fillDBDiff(removeSchema, change);
		
		return removeSchema;
	}

	@Override	
	protected Diff handleAlterChange(Match change) {
		AlterSchema alterSchema = DbevolutionFactory.eINSTANCE.createAlterSchema();
		alterSchema.setSchema((Schema)change.getRight());
		
		fillDBDiff(alterSchema, change);
		
		return alterSchema;
	}

	@Override
	protected Diff handleAlterChange(AttributeChange change) {
		if (DatabasePackage.eINSTANCE.getNamedElement_Name().equals(change.getAttribute())) {
			// Rename schema
			return createRenameSchemaChange(change);
		}
		if (DatabasePackage.eINSTANCE.getDatabaseElement_Comments().equals(change.getAttribute())) {
			// Update schema comments
			return createUpdateSchemaCommentChange(change);
		}
		return null;
	}

	protected RenameSchemaChange createRenameSchemaChange(AttributeChange change) {
		RenameSchemaChange renameSchemaChange = DbevolutionFactory.eINSTANCE.createRenameSchemaChange();
		renameSchemaChange.setSchema((Schema)change.getMatch().getRight());
		renameSchemaChange.setNewSchema((Schema)change.getMatch().getLeft());
		renameSchemaChange.setTarget(renameSchemaChange.getSchema());
		return renameSchemaChange;
	}
	
	protected UpdateSchemaCommentChange createUpdateSchemaCommentChange(AttributeChange change) {
		UpdateSchemaCommentChange updateSchemaCommentChange = DbevolutionFactory.eINSTANCE.createUpdateSchemaCommentChange();		
		updateSchemaCommentChange.setSchema((Schema) change.getMatch().getRight());
		updateSchemaCommentChange.setNewSchema((Schema) change.getMatch().getLeft());
		updateSchemaCommentChange.setTarget(updateSchemaCommentChange.getSchema());
		return updateSchemaCommentChange;
	}
	
	@Override
	protected Diff handleAlterChange(ReferenceChange change) {
		return null;
	}
}
