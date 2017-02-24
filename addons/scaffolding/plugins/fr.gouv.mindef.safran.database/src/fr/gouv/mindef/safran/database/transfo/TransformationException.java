package fr.gouv.mindef.safran.database.transfo;

public class TransformationException extends RuntimeException{

	private static final long serialVersionUID = 2738495468184012606L;

	public TransformationException() {
		super();
	}

	public TransformationException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransformationException(String message) {
		super(message);
	}

	public TransformationException(Throwable cause) {
		super(cause);
	}

	
}
