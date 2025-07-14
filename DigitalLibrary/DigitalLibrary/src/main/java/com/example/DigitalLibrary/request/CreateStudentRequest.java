package com.example.DigitalLibrary.request;

import com.example.DigitalLibrary.model.StudentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateStudentRequest
{
    String studentId;
    String name;
    String email;
    String phoneNo;
    StudentType studentType;
}
