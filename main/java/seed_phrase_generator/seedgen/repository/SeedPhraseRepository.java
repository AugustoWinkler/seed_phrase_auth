package seed_phrase_generator.seedgen.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import seed_phrase_generator.seedgen.model.SeedPhrase;

public interface SeedPhraseRepository extends JpaRepository<SeedPhrase, Long> {

	boolean existsBySeedHash(String seedHash);

	boolean existsByUserId(Long userId);
	
	SeedPhrase findByUserId(Long userId);
}
