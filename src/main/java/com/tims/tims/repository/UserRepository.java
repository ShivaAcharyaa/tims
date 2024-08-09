package com.tims.tims.repository;

import com.tims.tims.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
public UserDtls findByEmail(@Param("email") String email);
 }
