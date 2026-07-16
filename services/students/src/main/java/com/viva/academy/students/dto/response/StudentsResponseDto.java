package com.viva.academy.students.dto.response;

import com.viva.academy.students.enums.Gender;
import java.time.LocalDate;

public record StudentsResponseDto(
        String studentName,
        String StudentId,
        LocalDate dob,
        String mobile,
        String email,
        Gender gender
) {
}
