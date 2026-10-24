package support.exceptions

/**
 * Exception thrown when an element cannot be found in the UI
 */
class ElementNotFoundException extends TestActionException {
	/**
	 * Constructs a new exception with the element path
	 * @param objectPath path to the element in object repository
	 */
	ElementNotFoundException(String objectPath) {
		super("Element not found: ${objectPath}")
	}
}
