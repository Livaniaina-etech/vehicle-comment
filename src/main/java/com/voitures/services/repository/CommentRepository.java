/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voitures.services.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.voitures.data.entity.Comment;
import com.voitures.data.entity.Vehicle;

/**
 *
 * @author e.livaniaina
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("select c from Comment c WHERE c.vehicle = :vehicle")
	Page<Comment> findCommentByVehicle(Vehicle vehicle, Pageable pageable);
}
