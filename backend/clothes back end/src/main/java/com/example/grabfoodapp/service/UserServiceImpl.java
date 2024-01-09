package com.example.grabfoodapp.service;

import com.example.grabfoodapp.dto.UserDto;
import com.example.grabfoodapp.form.UserCreateForm;
import com.example.grabfoodapp.form.UserUpdateForm;
import com.example.grabfoodapp.map.UserMapper;
import com.example.grabfoodapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserMapper::map);
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id).map(UserMapper::map).get();
    }

    @Override
    public com.example.grabfoodapp.entity.User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.map(form);
        var endCodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(endCodedPassword);
        var savedUser = userRepository.save(user);
        return UserMapper.map(savedUser);
    }

    @Override
    public UserDto update(UserUpdateForm form, Long id) {
        var user = UserMapper.map(form, id);
        var savedUser = userRepository.save(user);
        return UserMapper.map(savedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }
        return new User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.NO_AUTHORITIES
        );
    }
}
