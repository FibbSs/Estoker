


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elias Neto
 */
public class Usuario {
    private String login;
    private String senha;
    private String cpf;
    private boolean adm; // True se a pessoa tiver privilégios administrativo.
    
    public Usuario(String login, String senha, String cpf, Boolean adm){
    this.login = login;
    this.senha = senha;
    this.cpf = cpf;
    this.adm = adm;
    }

    public Usuario() {
    }
    
    //Getters e setters :
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
}
