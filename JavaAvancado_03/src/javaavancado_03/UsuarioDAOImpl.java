package javaavancado_03;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
            String sql = "SELECT * FROM usuario ORDER BY pontos DESC;";
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                todos.add(u);
            }
        } catch(SQLException e) {
         //TODO Autopgenerated catch block
         throw new RuntimeException("Não foi possível executar o acesso", e); 
         
        }
        return todos;
    }

    @Override
    public void inserir(Usuario u) {
        try
       {
              Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
              String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?);";
              PreparedStatement stm = c.prepareStatement(sql);
              stm.setString(1, u.getLogin());
              stm.setString(2, u.getEmail());
              stm.setString(3, u.getNome());
              stm.setString(4, u.getSenha());
              stm.setInt(5, u.getPontos());
              stm.executeUpdate();
       }
       catch(SQLException e){
           //TODO Autopgenerated catch block
           throw new RuntimeException("Não foi possível executar o acesso", e);
       }
    }

    @Override
    public Usuario recuperar(String login) {
       Usuario user = new Usuario();
       try
       {
              Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
              String sql = "SELECT * FROM usuario WHERE login = ?;";
              PreparedStatement stm = c.prepareStatement(sql);
              stm.setString(1, login);
              ResultSet rs = stm.executeQuery();
              while(rs.next()) {
                user.setNome(rs.getString("nome"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setPontos(rs.getInt("pontos"));
              }
       }
       catch(SQLException e){
           //TODO Autopgenerated catch block
           throw new RuntimeException("Não foi possível executar o acesso", e);
       }
       
       return user;
    }

    @Override
    public void adicionarPontos(String login, int pontos) {
        try{
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/coursera", "root", "root");
            String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, pontos);
            stm.setString(2, login);
            stm.executeUpdate();
             
       }catch(SQLException e){
           //TODO Autopgenerated catch block
           throw new RuntimeException("Não foi possível executar o acesso", e);
       }
      }
    
}
