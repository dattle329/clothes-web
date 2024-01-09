package com.example.grabfoodapp.service;

import com.example.grabfoodapp.dto.UserDto;
import com.example.grabfoodapp.entity.User;
import com.example.grabfoodapp.form.UserCreateForm;
import com.example.grabfoodapp.form.UserUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserDto> findAll(Pageable pageable);

    UserDto findById(Long id);

    User findUserByUsername(String username);
    UserDto create(UserCreateForm form);
    UserDto update(UserUpdateForm form, Long id);
    void delete(Long id);
}
