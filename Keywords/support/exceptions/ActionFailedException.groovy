package support.exceptions

/**
 * Exception thrown when an action fails to execute on an element
 */
class ActionFailedException extends TestActionException {
	/**
	 * Constructs a new exception with action details
	 * @param action the action that failed
	 * @param objectPath path to the element in object repository
	 * @param cause the underlying cause of the failure
	 */
	ActionFailedException(String action, String objectPath = "", Throwable cause) {
		super("Failed to perform ${action} on element: ${objectPath}", cause)
	}
}
