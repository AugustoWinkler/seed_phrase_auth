package seed_phrase_generator.seedgen.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import seed_phrase_generator.seedgen.model.PhrasesEnum.Phrases;

@Component
public class SeedPhraseFactory {

	public List<String> generatePhrase(int size) {
		List<String> phraseToSave = new ArrayList<>();
		while (size > 0) {
			String randomWord = Phrases.getRandomWord().toString();
			if (phraseToSave.add(randomWord)) {
				size--;
			}
		}
		return phraseToSave;
	}
}
