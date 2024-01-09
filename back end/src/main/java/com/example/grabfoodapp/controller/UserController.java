package com.example.grabfoodapp.controller;

import com.example.grabfoodapp.dto.UserDto;
import com.example.grabfoodapp.entity.User;
import com.example.grabfoodapp.form.UserCreateForm;
import com.example.grabfoodapp.form.UserUpdateForm;
import com.example.grabfoodapp.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
@Validated
@CrossOrigin("http://127.0.0.1:5500/")
public class UserController {
    private final UserService userService;

    @GetMapping("/api/v1/users")
    public Page<UserDto> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/api/v1/user/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/api/v1/user")
    public UserDto create(@RequestBody UserCreateForm form) {
        return userService.create(form);
    }

    @PutMapping("/api/v1/user/{id}")
    public UserDto update(@RequestBody @Valid UserUpdateForm form, @PathVariable("id") Long id) {
        return userService.update(form, id);
    }

    @DeleteMapping("/api/v1/user/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("api/v1/login")
    public ResponseEntity<?> login(Principal principal) {
        String username = principal.getName();
        // Tim account tương ứng dựa vào username
        User userLogin = userService.findUserByUsername(username);
        UserDto userDTO = new UserDto();
        userDTO.setId(userLogin.getId());
        userDTO.setUsername(userLogin.getUsername());
        userDTO.setEmail(userLogin.getEmail());
        userDTO.setName(userLogin.getName());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}