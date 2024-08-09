package com.tims.tims.service;

import com.tims.tims.model.Course;
import com.tims.tims.model.UserDtls;

import java.util.List;

public interface UserService {
   public UserDtls saveUser(UserDtls user);
   public List<UserDtls> getAllUser();
}
