package org.obeonetwork.dsl.cinematic.toolkits.spec;

import java.util.stream.Collectors;

import org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl;

public class WidgetSpec extends WidgetImpl {

	@Override
	public String getMetadataHelp() {
		return this.getMetadataDefinitions().stream()
				.map(m -> m.getHelp())
				.filter(v -> v != null)
				.collect(Collectors.joining("\n"));
	}

	
}
