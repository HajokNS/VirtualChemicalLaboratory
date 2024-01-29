package com.chornopyskyi.chemicallaboratory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;
@JsonPropertyOrder({"idUser", "username", "password", "email", "role", "errors", "valid"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends EntityErrors {

    private String idUser;
    private String password;
    private String email;
    private String username;
    private String role;

    public User(@JsonProperty("password") String password,  @JsonProperty("email") String email,
        @JsonProperty("username") String username, @JsonProperty("role") String role) {
        this.idUser = UUID.randomUUID().toString();
        this.password = setPassword(password);
        this.email = setEmail(email);
        setUsername(username);
        this.role = role;
    }

    public User() {
        // Пустий конструктор
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String setEmail(String email) {
      final String templateName = "електронної пошти";

        if (email.isBlank()) {
            errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
        }
        if (email.length() < 12) {
            errors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 12));
        }
        if (email.length() > 28) {
            errors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 28));
        }

        if (!(email.contains("@") && email.contains(".")))
        {
            errors.add(ErrorTemplates.EMAIL_CONTAINS.getTemplate().formatted(templateName));
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            errors.add(ErrorTemplates.EMAIL_MATCHES.getTemplate().formatted(templateName));
        }

        if (!errors.isEmpty()) {
            throw new EntityArgumentException(errors);
        }

        return email;
    }

    public void setUsername(String username) {
      final String templateName = "логіну";

        if (username.isBlank()) {
            errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
        }
        if (username.length() < 4) {
            errors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 4));
        }
        if (username.length() > 24) {
            errors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 24));
        }
        var pattern = Pattern.compile("^[A-Za-z0-9_.\\s]+$");
        if (!pattern.matcher(username).matches()) {
            errors.add(ErrorTemplates.ONLY_LATIN.getTemplate().formatted(templateName, 24));
        }

        if (!this.errors.isEmpty()) {
            throw new EntityArgumentException(errors);
        }

        this.username = username;
    }

    public String setPassword(String password) {
        final String templateName = "паролю";

        if (password.isBlank()) {
            errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
        }
        if (password.length() < 8) {
            errors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 8));
        }
        if (password.length() > 24) {
            errors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 24));
        }
        var pattern = Pattern.compile("^[A-Za-z0-9_.\\s]+$");
        if (!pattern.matcher(password).matches()) {
            errors.add(ErrorTemplates.PASSWORD.getTemplate().formatted(templateName, 24));
        }

        if (!this.errors.isEmpty()) {
            throw new EntityArgumentException(errors);
        }

        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", id=" + idUser +
                '}';
    }

    public void displayUserInfo() {
        System.out.println("User Information:");
        System.out.println("ID: " + idUser);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
    }

}
