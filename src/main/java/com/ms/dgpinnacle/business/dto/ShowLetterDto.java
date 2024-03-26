package com.ms.dgpinnacle.business.dto;

import java.util.ArrayList;
import java.util.List;

import com.ms.dgpinnacle.business.entity.LetterConfig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShowLetterDto {
	
	private List<String> clientsName = new ArrayList<String>();
	
	private LetterConfig letter;

}
