package com.chornopyskyi.chemicallaboratory.persistence.entity.impl;

import com.chornopyskyi.chemicallaboratory.persistence.exception.EntityArgumentException;
import com.chornopyskyi.chemicallaboratory.persistence.entity.Entity;
import com.chornopyskyi.chemicallaboratory.persistence.entity.ErrorTemplates;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class User extends Entity {

    private final String password;
    private String email;
    private String username;

    public User(UUID id, String password, String email, String username) {
        super(id);
        this.password = validatedPassword(password);
        this.email = setEmail(email);
        setUsername(username);
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

    private String setEmail(String email) {
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
        var pattern = Pattern.compile("^[a-zA-Z0-9_]+$");
        if (pattern.matcher(username).matches()) {
            errors.add(ErrorTemplates.ONLY_LATIN.getTemplate().formatted(templateName, 24));
        }

        if (!this.errors.isEmpty()) {
            throw new EntityArgumentException(errors);
        }

        this.username = username;
    }

    private String validatedPassword(String password) {
        final String templateName = "паролю";

        if (password.isBlank()) {
            errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
        }
        if (password.length() < 8) {
            errors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 4));
        }
        if (password.length() > 32) {
            errors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 32));
        }
        var pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$");
        if (pattern.matcher(password).matches()) {
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
                ", id=" + id +
                '}';
    }
}
