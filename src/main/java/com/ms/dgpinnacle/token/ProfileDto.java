package com.ms.dgpinnacle.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

	private Long id;
	private String code;
	private String name;
}
