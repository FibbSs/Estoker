/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author FibbS
 */
public class Conexao {
    
     public Connection getConnection() {
        try {
                return DriverManager.getConnection("jdbc:mysql://localhost/estoque","root","123");
            }         
	catch(SQLException excecao) {
		throw new RuntimeException(excecao);
	}
    }
}
