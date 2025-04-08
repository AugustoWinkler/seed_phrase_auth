package seed_phrase_generator.seedgen.exception.customexceptions;

public class SeedAlreadyExistsException extends RuntimeException {
	public SeedAlreadyExistsException(String message) {
		super(message);
	}
}
