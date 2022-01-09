package com.example.test.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreate {
    private String username;
    private String password;
}
