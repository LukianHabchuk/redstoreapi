package com.example.redstoreapi.service;


import com.example.redstoreapi.dto.UserDTO;
import com.example.redstoreapi.entity.User;
import com.example.redstoreapi.enums.Role;
import com.example.redstoreapi.enums.Status;
import com.example.redstoreapi.exception.UserNotFoundException;
import com.example.redstoreapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.redstoreapi.constants.Constants.*;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User create(UserDTO userDTO) {
        return repository.save(convertUserDTO(userDTO));
    }

    public User update(User user) {
        repository.deleteById(user.getId());
        return repository.save(user);
    }

    public void remove(long id) {
        repository.deleteById(id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(String.format(WITH_WAS_NOT_FOUND, USER_ATTRIBUTE, "id", id)));
    }

    public User getByUserName(String userName) {
        return repository.findByUserName(userName)
                .orElseThrow(() ->
                        new UserNotFoundException(String.format(WITH_S_WAS_NOT_FOUND, USER_ATTRIBUTE, "username", userName)));
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(String.format(WITH_S_WAS_NOT_FOUND, USER_ATTRIBUTE, "email", email)));
    }

    public boolean isExists(String username, String email) {
        return repository.findByUserName(username).isPresent() || repository.findByEmail(email).isPresent();
    }

    private User convertUserDTO(UserDTO userDTO) {
        return new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword(), Role.USER, Status.ACTIVE);
    }
}
