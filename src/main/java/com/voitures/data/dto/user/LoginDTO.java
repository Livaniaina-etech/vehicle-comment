package com.voitures.data.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author e.livaniaina
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LoginDTO {

	public LoginDTO(String token) {
		this.token = token;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
