package org.obeonetwork.dsl.database.compare;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.merge.AbstractMerger;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;

public class DbMerger extends AbstractMerger {

	public DbMerger() {
		super();
	}

	@Override
	public boolean isMergerFor(Diff target) {
		return target instanceof DBDiff;
	}

}
