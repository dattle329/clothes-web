package com.example.grabfoodapp.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserCreateForm {
    @NotBlank
    @Length(max = 50)
    private String name;

    @NotBlank

    private String password;

    @NotBlank
    @Length(max = 50)
    @Email
    private String email;

    @NotBlank
    @Length(max = 50)
    private String username;
}
