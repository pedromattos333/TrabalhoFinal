package com.senac.pedro.gunregister.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
@DatabaseTable(tableName = "conta")
public class Conta implements Serializable {
    @DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
    private Long id;
    @DatabaseField(canBeNull = false, width = 45)
    private String login;
    @DatabaseField(canBeNull = false, width = 45)
    private String email;
    @DatabaseField(canBeNull = false, width = 45)
    private String senha;

    public Conta(String login, String email, String senha) {

        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    public Conta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login: " + getLogin() + " " + getEmail() + " Senha: " + getSenha();
    }
}
