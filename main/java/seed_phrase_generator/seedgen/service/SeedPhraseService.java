package seed_phrase_generator.seedgen.service;

import java.util.List;



public interface SeedPhraseService {

	List<String> createSeed(Long userId, int size);
	
	Boolean autenticateUserSeed(Long userId, String seed);

}
