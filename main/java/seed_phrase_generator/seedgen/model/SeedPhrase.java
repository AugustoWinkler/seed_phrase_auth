package seed_phrase_generator.seedgen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class SeedPhrase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seedId;
	@Column(nullable = false, unique = true)
	private String seedHash;
	@Column(nullable = false, unique = true)
	private Long userId;

	public SeedPhrase() {
		super();
	}

	public SeedPhrase(String seedPhrase, Long userId) {
		this.seedHash = seedPhrase;
		this.userId = userId;
	}

	public String getSeedHash() {
		return seedHash;
	}

}
