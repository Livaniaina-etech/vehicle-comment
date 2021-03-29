package com.voitures.data.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author e.livaniaina
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserDTO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
