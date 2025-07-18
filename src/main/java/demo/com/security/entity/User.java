package demo.com.security.entity;

import demo.com.security.dto.LoginRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @MongoId
    @Indexed(name = "user_id")
    private String userId;

    @Indexed(name = "email",  unique = true)
    private String email;

    @Indexed(name = "name")
    private String name;

    @Indexed(name = "password")
    private String password;

    @DBRef(lazy = true)
    @Indexed(name = "roles")
    private Set<Role> roles;

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.password(), this.password);
        // Verifica se a senha que chegou lá é igual a senha do usuário no banco de dados, após criptografar ambas.
    }
}
