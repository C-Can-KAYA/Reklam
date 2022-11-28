package com.lastSoftware.FirstProfessionalProject.Service.User;

import com.lastSoftware.FirstProfessionalProject.Entity.User;
import com.lastSoftware.FirstProfessionalProject.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else
            return null;
    }

    public void deleteById(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) { //user zaten yok, db'den empty result gelmiş
            System.out.println("User " + userId + " doesn't exist"); //istersek loglayabiliriz
        }
    }

    public void deleteAll() {
            userRepository.deleteAll();
    }

    public User getOneUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}

