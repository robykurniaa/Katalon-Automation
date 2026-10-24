package support.exceptions

/**
 * Base exception class for test automation actions
 */
class TestActionException extends Exception {
	/**
	 * Constructs a new exception with the specified detail message
	 * @param message the detail message
	 */
	TestActionException(String message) {
		super(message)
	}

	/**
	 * Constructs a new exception with the specified detail message and cause
	 * @param message the detail message
	 * @param cause the cause
	 */
	TestActionException(String message, Throwable cause) {
		super(message, cause)
	}
}
