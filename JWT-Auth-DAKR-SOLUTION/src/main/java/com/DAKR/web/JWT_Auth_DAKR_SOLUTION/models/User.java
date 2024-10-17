package com.DAKR.web.JWT_Auth_DAKR_SOLUTION.models;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String id;
    private String name;
    private String email;


}
