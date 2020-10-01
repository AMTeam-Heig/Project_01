package ch.heigvd.amt.stackovergoat.model;

import lombok.Getter;

@Getter
public class User {
    private int id;
    private String firstname;
    private String name;
    private String userName;
    private String email;
    private String password;

    public User(int id, String firstname, String name, String userName, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
