package org.obeonetwork.dsl.database.reverse.utils;

public interface ProgressListener {

	void start(int numberOfSteps);
	
	void progressTo(int step, String message);
	
	void end(String message);

}
