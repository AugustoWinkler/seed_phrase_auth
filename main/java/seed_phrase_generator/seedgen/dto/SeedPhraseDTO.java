package seed_phrase_generator.seedgen.dto;

import java.util.List;

public class SeedPhraseDTO {
	private String seed = "";

	public SeedPhraseDTO(List<String> seed) {
		for (String word : seed) {
			this.seed += word + " ";
		}
	}

	public String getSeed() {
		return seed;
	}

}
