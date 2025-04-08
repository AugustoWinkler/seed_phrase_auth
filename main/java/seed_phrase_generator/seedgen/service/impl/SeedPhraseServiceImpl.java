package seed_phrase_generator.seedgen.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seed_phrase_generator.seedgen.exception.customexceptions.InvalidSeedException;
import seed_phrase_generator.seedgen.exception.customexceptions.UserIdAlreadyExistsException;
import seed_phrase_generator.seedgen.factory.SeedPhraseFactory;
import seed_phrase_generator.seedgen.model.SeedPhrase;
import seed_phrase_generator.seedgen.repository.SeedPhraseRepository;
import seed_phrase_generator.seedgen.service.SeedPhraseService;

@Service
public class SeedPhraseServiceImpl implements SeedPhraseService {

	@Autowired
	SeedPhraseRepository repository;

	@Autowired
	SeedPhraseFactory factory;

	@Override
	public Boolean autenticateUserSeed(Long userId, String seed) throws InvalidSeedException {
		SeedPhrase phrase = repository.findByUserId(userId);
		String seedKey = this.seedEncoder(this.normalizeSeed(seed));
		if (phrase == null) {
			throw new InvalidSeedException("No seed phrase found for user.");
		}
		if (!phrase.getSeedHash().equals(seedKey)) {
			throw new InvalidSeedException("Wrong Seed Phrase.");
		}
		return true;
	}

	@Override
	public List<String> createSeed(Long userId, int size) {
		if (repository.existsByUserId(userId)) {
			throw new UserIdAlreadyExistsException("This User ID Already have a Seed Phrase.");
		}
		List<String> seed = generatePhrase(size);
		String seedHash = this.seedEncoder(seed);
		SeedPhrase phrase = new SeedPhrase(seedHash, userId);
		repository.save(phrase);

		return seed;
	}

	private String phraseToString(List<String> seed) {
		return seed.stream().map(String::toLowerCase).map(String::trim).collect(Collectors.joining());
	}

	private List<String> generatePhrase(int size) {
		List<String> seed;
		while (true) {
			seed = factory.generatePhrase(size);
			if (!repository.existsBySeedHash(this.seedEncoder(seed))) {
				break;
			}
		}
		return seed;
	}

	private String normalizeSeed(String seed) {
		return seed.toLowerCase().replaceAll("[^a-z]", "");
	}

	private String seedEncoder(String seed) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(seed.getBytes());

			StringBuilder hexString = new StringBuilder();
			for (byte b : hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Erro ao gerar hash SHA-256", e);
		}
	}

	private String seedEncoder(List<String> seedList) {
		String seed = this.normalizeSeed(this.phraseToString(seedList));
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(seed.getBytes());

			StringBuilder hexString = new StringBuilder();
			for (byte b : hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Erro ao gerar hash SHA-256", e);
		}
	}

}
