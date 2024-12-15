package hust.soict.dsai.aims.exception;

public class LimitExceededException extends Exception {
	public LimitExceededException() {
	}

	public LimitExceededException(String message) {
		super(message);
	}

	public LimitExceededException(Throwable cause) {
		super(cause);
	}

	public LimitExceededException(String message, Throwable cause) {
		super(message, cause);
	}

	public LimitExceededException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
