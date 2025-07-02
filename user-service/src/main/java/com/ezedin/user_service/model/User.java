package com.ezedin.user_service.model;

import lombok.*;
import jakarta.persistence.*;
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id; // Same as Keycloak "sub"

    private String username;
    private String email;
}
