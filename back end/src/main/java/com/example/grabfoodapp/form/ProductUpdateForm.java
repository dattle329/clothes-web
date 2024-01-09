package com.example.grabfoodapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ProductUpdateForm {
    @NotBlank
    @Length(max = 50)
    private String name;

    @NotNull
    @Length(max = 500)
    private String img;

    @NotNull
    @Length(max = 50)
    private Long price;
}
