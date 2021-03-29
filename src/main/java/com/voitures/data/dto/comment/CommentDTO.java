package com.voitures.data.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.voitures.data.dto.user.UserDTO;
import com.voitures.data.dto.vehicle.VehicleDTO;

import java.util.Date;

/**
 *
 * @author e.livaniaina
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CommentDTO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date dateComment;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String commentData;
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	UserDTO user;
	@JsonIgnore
	VehicleDTO vehicle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateComment() {
		return dateComment;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}

	public String getCommentData() {
		return commentData;
	}

	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
