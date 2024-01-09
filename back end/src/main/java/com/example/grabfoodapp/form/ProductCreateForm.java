package com.example.grabfoodapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ProductCreateForm {
    @NotBlank
    @Length(max = 50)
    private String name;

    @NotNull
    @Length(max = 500)
    private String img;

    @NotNull
    private Long price;
}
