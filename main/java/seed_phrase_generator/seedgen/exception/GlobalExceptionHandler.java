package seed_phrase_generator.seedgen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import seed_phrase_generator.seedgen.exception.customexceptions.InvalidSeedException;
import seed_phrase_generator.seedgen.exception.customexceptions.SeedAlreadyExistsException;
import seed_phrase_generator.seedgen.exception.customexceptions.UserIdAlreadyExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(SeedAlreadyExistsException.class)
	public ResponseEntity<String> handleSeedAlreadyExists(SeedAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}

	@ExceptionHandler
	public ResponseEntity<String> handleUserIdAlreadyExists(UserIdAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}
			
	public ResponseEntity<String> handleInvalidSeed(InvalidSeedException ex) {
		return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body(ex.getMessage());
	}
}
