package com.ms.dgpinnacle.old.dto;

import com.ms.dgpinnacle.entity.LetterConfig;

public class letteverify {

	private String uniqueKey;
	
	private LetterConfig letter;

	public letteverify(String uniqueKey, LetterConfig letter) {
		super();
		this.uniqueKey = uniqueKey;
		this.letter = letter;
	}

	public letteverify() {
		super();
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public LetterConfig getLetter() {
		return letter;
	}

	public void setLetter(LetterConfig letter) {
		this.letter = letter;
	}

	
	
	
}
