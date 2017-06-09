/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import connection.Conexao ;
import model.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO { 
    private Connection connection;
     String nome;
     String login;
     String senha;
     String tipo;
     String cpf;   
     
    public UsuarioDAO(){ 
        this.connection = new Conexao().getConnection();
    } 
    
    public void adiciona(Usuario usuario){ 
        String sql = "INSERT INTO usuario(nome,login,senha,tipo,cpf) VALUES(?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTipo());
            stmt.setString(5, usuario.getCpf());
            stmt.execute();
            stmt.close();
        }catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
    }
    
    public boolean validarCpf(String cpf){
	String query = "SELECT cpf from usuario";
        Statement stmt = null;
        boolean status = false;
        Connection con = new Conexao().getConnection();
	try {
            stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
                while(resultado.next()){
                    if(resultado.getNString("cpf").equals(cpf)){
                        return true;
                    }else{
                        status = false;
                    }
		}
            stmt.close();
        }catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        return status;
    }
}   
