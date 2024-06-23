package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "StudentDto Model Information")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    int rollNo;

    @Schema(description = "Student First Name")
    @NotEmpty(message = "Student first name should not be null")
    private String firstName;

    @Schema(description = "Student Last Name")
    @NotEmpty(message = "Student last name should not be null")
    private String lastName;

    @Schema(description = "Student Email")
    @NotEmpty(message = "Student email should not be null")
    @Email(message = "Email should be valid")
    private String email;

}
