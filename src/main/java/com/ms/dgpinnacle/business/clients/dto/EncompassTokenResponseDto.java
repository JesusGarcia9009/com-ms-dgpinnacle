package com.ms.dgpinnacle.business.clients.dto;

public class EncompassTokenResponseDto {

	private String access_token;
    private String token_type;
	public EncompassTokenResponseDto(String access_token, String token_type) {
		super();
		this.access_token = access_token;
		this.token_type = token_type;
	}
	public EncompassTokenResponseDto() {
		super();
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
    
    
}
