/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voitures.commun.utils.mapper;

import org.mapstruct.Mapper;

import com.voitures.data.dto.user.UserDTO;
import com.voitures.data.entity.User;

/**
 *
 * @author e.livaniaina
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDTO userToDto(User user);
}
