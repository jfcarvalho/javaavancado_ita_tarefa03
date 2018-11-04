
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nessk
 */
public class UsuarioDAOImpl implements UsuarioDAO {
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Usuario> ranking()
    {
        List<Usuario> todos = new ArrayList<>();
        try
        {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/cousera", "root", "root");
        } catch(SQLException e) {
         //TODO Autopgenerated catch block
         throw new RuntimeException("Não foi possível executar o acesso", e); 
         
        }
        return todos;
    }

    @Override
    public void inserir(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario recuperar(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionarPontos(String login, int pontos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
