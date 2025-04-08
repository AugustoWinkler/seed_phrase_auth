package seed_phrase_generator.seedgen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import seed_phrase_generator.seedgen.dto.SeedPhraseDTO;
import seed_phrase_generator.seedgen.exception.customexceptions.InvalidSeedException;
import seed_phrase_generator.seedgen.service.SeedPhraseService;

@RestController
@RequestMapping("/seed")
public class SeedPhraseController {

	@Autowired
	SeedPhraseService service;

	@PostMapping
	public ResponseEntity<String> saveSeedPhrase(@RequestParam @NotNull @Min(1) Long userId) {
		if (userId == null || userId <= 0) {
			return ResponseEntity.badRequest().body("Invalid userId");
		}
		return ResponseEntity.ok(new SeedPhraseDTO(service.createSeed(userId, 12)).getSeed());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<String> authSeed(@PathVariable Long userId, @RequestParam String seed) {
		if (userId == null || userId <= 0) {
			return ResponseEntity.badRequest().body("Invalid userId");
		}
		if (seed == null || seed.isEmpty()) {
			return ResponseEntity.badRequest().body("Seed cannot be empty");
		}
		try {
			service.autenticateUserSeed(userId, seed);
			return ResponseEntity.ok("User Auth Sucess");
		} catch (InvalidSeedException e) {
			return ResponseEntity.badRequest().body("User Auth Fail");
		}

	}

}
