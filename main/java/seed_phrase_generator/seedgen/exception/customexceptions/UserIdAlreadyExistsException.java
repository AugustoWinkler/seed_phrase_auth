package seed_phrase_generator.seedgen.exception.customexceptions;

public class UserIdAlreadyExistsException extends RuntimeException {
	public UserIdAlreadyExistsException(String message) {
		super(message);
	}
}
