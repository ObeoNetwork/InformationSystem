package org.obeonetwork.dsl.database.liquibasegen;

import java.util.Objects;

public record ConnectionInformation(String url, String username, String password) {
	public ConnectionInformation {
		Objects.requireNonNull(url);
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
	}

	/**
	 * Returns connection details with the password masked to avoid exposing it in logs.
	 */
	@Override
	public String toString() {
		return "ConnectionInformation[url=" + url + ", username=" + username + ", password=***]";
	}

}
