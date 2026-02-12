package org.obeonetwork.dsl.database.liquibasegen;

import java.util.Objects;

public record ConnectionInformation(String url, String username, String password) {
	public ConnectionInformation {
		Objects.requireNonNull(url);
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
	}

}
