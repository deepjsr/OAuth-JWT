package com.DAKR.web.JWT_Auth_DAKR_SOLUTION.models;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String jwtToken;
    private String username;
}
