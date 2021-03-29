/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voitures.services.applicatif.comment;

import com.voitures.data.dto.comment.CommentDTO;
import com.voitures.data.dto.comment.VehicleCommentDTO;

/**
 *
 * @author e.livaniaina
 */
public interface CommentSA {
	public CommentDTO saveComment(CommentDTO dto);
	public VehicleCommentDTO getVehicleComment(Long vehicleID, Integer pageNo, Integer pageSize, String sortBy);
}
