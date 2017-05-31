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
package org.obeonetwork.dsl.database.compare.extensions.processor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.compare.extensions.builders.ChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.ColumnChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.ConstraintChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.ForeignKeyChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.ForeignKeyElementChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.IndexChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.IndexElementChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.PrimaryKeyChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.SchemaChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.SequenceChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.TableChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.TypeInstanceChangeBuilder;
import org.obeonetwork.dsl.database.compare.extensions.builders.ViewChangeBuilder;

public class DatabaseDiffExtension {

	public class Visitor {
		
		private List<ChangeBuilder> builders;
		
		public Visitor(List<ChangeBuilder> builders) {
			this.builders = builders;
		}
		
		public void visit(EObject object) {
			Iterator<EObject> it = object.eAllContents();
			while(it.hasNext()) {
				handleElement(it.next());
			}
		}
		
		protected Diff handleElement(EObject comparisonElement) {
			Diff result = null;
			for (ChangeBuilder builder : builders) {
				if (builder.canHandle(comparisonElement)) {
					result = builder.handle(comparisonElement);	
					//handled = true;
					break;
				}
			}
//			if (!handled) {
//				traceNotHandledElement(diffElement);	
//			}
			return result;
		}
		
//		private void traceNotHandledElement(Diff diff) {
//		Object target = null;
//		if (diff instanceof ReferenceChange) {
//			target = ((ReferenceChange) diff).getValue();
//		} else if (diff instanceof AttributeChange) {
//			target = ((AttributeChange) diff).getValue();
//		} else {
//			Activator.getDefault().logWarning("[DatabaseComparison] Type non traite : " + diff.eClass().getName());
//		}
//		if (target != null && !DatabasePackage.eINSTANCE.getDataBase().isInstance(target)) {
//			String msg = "[DatabaseComparison] Type non traite : " + diff.eClass().getName() + " => " + target;
//			Activator.getDefault().logWarning(msg);
//		}
//		}

	}
		
	private List<ChangeBuilder> changeBuilders;
	
	private Visitor visitor;

	public DatabaseDiffExtension() {
		changeBuilders = new ArrayList<ChangeBuilder>();
		changeBuilders.add(new TableChangeBuilder());
		changeBuilders.add(new ColumnChangeBuilder());
		changeBuilders.add(new SchemaChangeBuilder());
		changeBuilders.add(new PrimaryKeyChangeBuilder());
		changeBuilders.add(new ForeignKeyChangeBuilder());
		changeBuilders.add(new IndexChangeBuilder());
		changeBuilders.add(new ConstraintChangeBuilder());
		changeBuilders.add(new SequenceChangeBuilder());
		changeBuilders.add(new TypeInstanceChangeBuilder());
		changeBuilders.add(new ForeignKeyElementChangeBuilder());
		changeBuilders.add(new IndexElementChangeBuilder());
		changeBuilders.add(new ViewChangeBuilder());
		
		visitor = new Visitor(changeBuilders);
	}
	
	public void visit(Comparison comparison) {	
		visitor.visit(comparison);
	}

}

