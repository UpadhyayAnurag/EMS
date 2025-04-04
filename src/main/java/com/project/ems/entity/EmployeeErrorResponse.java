package com.project.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private long timeStamp;
}
