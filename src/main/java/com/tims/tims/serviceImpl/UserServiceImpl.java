package com.tims.tims.serviceImpl;

import com.tims.tims.model.UserDtls;
import com.tims.tims.repository.UserRepository;
import com.tims.tims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDtls saveUser(UserDtls user) {
        user.setRole("ROLE_USER");
      String encodePassword=passwordEncoder.encode(user.getPassword());
      user.setPassword(encodePassword);
       UserDtls saveUser= userRepository.save(user);
        return saveUser;
    }

    @Override
    public List<UserDtls> getAllUser() {
        return List.of();
    }


}
