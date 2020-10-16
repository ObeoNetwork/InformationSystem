package org.obeonetwork.utils.sirius.transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public abstract class RecordingCommandWithResult<T> extends RecordingCommand {

	private Throwable exception = null;
	
	private List<T> result = new ArrayList<T>();
	
	public RecordingCommandWithResult(TransactionalEditingDomain domain) {
		super(domain);
	}

	protected void addResult(T result) {
		this.result.add(result);
	}
	
	@Override
	public Collection<T> getResult() {
		return result;
	}
	
	public T getSingleResult() {
		return (result.isEmpty())? null : result.get(0);
	}

	@Override
	protected void doExecute() {
		try {
			T result = doExecuteWithResult();
			if(result != null) {
				addResult(result);
			}
		} catch (Throwable e) {
			this.exception = e;
		}
	}
	
	protected abstract T doExecuteWithResult();
	
	public Throwable getException() {
		return exception;
	}
	
}
