package com.example.grabfoodapp.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class OrderUpdateForm {
    @NotNull
    @Length(max = 100)
    private int quantity;

}
