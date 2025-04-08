package seed_phrase_generator.seedgen.model.PhrasesEnum;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

public enum Phrases {
	JAVA, PYTHON, JAVASCRIPT, TYPESCRIPT, KOTLIN, SWIFT, DART, GO, RUST, RUBY, C, CPP, CSHARP, FSHARP, PERL, PHP, LUA,
	R, SQL, SCALA, HASKELL, ELIXIR, CLOJURE, ERLANG, SCHEME, LISP, OCAML, NIM, VALA, ZIG, FORTRAN, COBOL, BASIC,
	VISUALBASIC, PASCAL, DELPHI, ASSEMBLY, PROLOG, SCRATCH, SMALLTALK, GROOVY, JULIA, CRYSTAL, REASON, ELM, SOLIDITY, V,
	RED, ADA, MATLAB, POWERSHELL, SHELL, BASH, ZSH, AWK, SED, MAKE, NIMROD, TCL, ACTIONSCRIPT;

	@Autowired
	private static final Random RANDOM = new Random();

	public static Phrases getRandomWord() {
		Phrases[] values = Phrases.values();
		return values[RANDOM.nextInt(values.length)];
	}
}
