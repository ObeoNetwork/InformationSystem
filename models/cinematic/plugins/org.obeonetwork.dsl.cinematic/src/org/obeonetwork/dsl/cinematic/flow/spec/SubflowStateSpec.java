package org.obeonetwork.dsl.cinematic.flow.spec;

import org.obeonetwork.dsl.cinematic.flow.impl.SubflowStateImpl;

public class SubflowStateSpec extends SubflowStateImpl {
	@Override
	public String getName() {
		if (super.getSubflow() != null) {
			return super.getSubflow().getName();
		}
		return "<unnamed>";
	}
}
