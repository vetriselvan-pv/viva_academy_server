package com.viva.academy.students.dto.request;

import com.viva.academy.students.enums.Gender;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record StudentsRequestDto(
        @NotNull(message = "Name cannot be empty")
        String studentName,

        @NotNull(message = "Gender cannot be empty")
        Gender gender,

        @NotNull(message = "Mobile cannot be empty")
        String mobile,

        @NotNull(message = "DOB cannot be empty")
        LocalDate dob,

        @NotNull(message = "Email cannot be empty")
        String email
) {
}
