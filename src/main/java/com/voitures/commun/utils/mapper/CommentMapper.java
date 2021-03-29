package com.voitures.commun.utils.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.voitures.data.dto.comment.CommentDTO;
import com.voitures.data.entity.Comment;

/**
 *
 * @author e.livaniaina
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, VehicleMapper.class})
public interface CommentMapper {

	CommentDTO commentToDto(Comment comment);

	Comment dtoToComment(CommentDTO comment);

	List<CommentDTO> commentsToDtos(List<Comment> comments);
	
}
