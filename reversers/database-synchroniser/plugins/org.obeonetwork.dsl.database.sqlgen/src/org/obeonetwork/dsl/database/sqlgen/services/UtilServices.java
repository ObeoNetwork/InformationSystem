package org.obeonetwork.dsl.database.sqlgen.services;

import java.util.List;

import org.eclipse.emf.compare.Diff;
import org.obeonetwork.dsl.database.compare.extensions.services.DiffContentService;

public class UtilServices {

	private DiffContentService diffContentService = null;
	
	public List<Diff> getSubDiffs(Diff diff) {
		List<Diff> subDiffs = getDiffContentService().getSubDiffs(diff);
		return subDiffs;
	}
	
	public Diff getRelatedDiff(Diff diff) {
		if (!diff.getRefinedBy().isEmpty()) {
			Diff refiningDiff = diff.getRefinedBy().get(0);
			if (!refiningDiff.getRequiredBy().isEmpty()) {
				Diff otherDiff = refiningDiff.getRequiredBy().get(0);
				if (!otherDiff.getRefines().isEmpty()) {
					return otherDiff.getRefines().get(0);
				}
			}
		}
		return null;
	}
	
	private DiffContentService getDiffContentService() {
		if (diffContentService == null) {
			diffContentService = new DiffContentService();
		}
		return diffContentService;
	}
}
