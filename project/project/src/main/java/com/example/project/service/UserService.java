package com.example.project.service;

import com.example.project.entity.User;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	public User updateUser(Long id, User userDetails) {
	    return userRepository.findById(id).map(user -> {
	        user.setName(userDetails.getName());
	        user.setEmail(userDetails.getEmail());
	        return userRepository.save(user);
	    }).orElse(null);
	}


    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public User updateid(Long id, User userDetails) {
        if (userRepository.existsById(id)) {
            User obj = userRepository.findById(id).get();
            obj.setId(id);
            obj.setName(userDetails.getName());
            obj.setEmail(userDetails.getEmail());
            return userRepository.save(obj);
        }
        return null;  // Return null if ID not found
    }

}
