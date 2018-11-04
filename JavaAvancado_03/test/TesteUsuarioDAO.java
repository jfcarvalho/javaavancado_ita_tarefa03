/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javaavancado_03.Usuario;
import javaavancado_03.UsuarioDAOImpl;
import org.junit.Test;
import static org.junit.Assert.*;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;


/**
 *
 * @author nessk
 */
public class TesteUsuarioDAO {
    
    JdbcDatabaseTester jdt;
    
    public TesteUsuarioDAO() {
    }

    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver","jdbc:mysql://localhost/coursera", "root", "root");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/inicio.xml"));
        jdt.onSetup();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    
    public void insere()
    {
        UsuarioDAOImpl ds = new UsuarioDAOImpl();
        Usuario u = new Usuario();
        u.setNome("Elionara Silva");
        u.setLogin("elionara.silva");
        u.setEmail("elionara.silva@solutis.com.br");
        u.setSenha("elionara");
        u.setPontos(100);
        ds.inserir(u);
        Usuario recuperado = new Usuario();
        recuperado = ds.recuperar("elionara.silva");
        assertEquals(u.getNome(), recuperado.getNome());
        
        
    }
    
     @Test
    
    public void recupera()
    {
        UsuarioDAOImpl ds = new UsuarioDAOImpl();
        Usuario u = new Usuario();
        u = ds.recuperar("gitirana");
        assertEquals("Alexandre Gitirana", u.getNome());
    }
  
    @Test
    public void ranking()
    {
        UsuarioDAOImpl ds = new UsuarioDAOImpl();
        List<Usuario> usuarios = ds.ranking();
        assertEquals("Alexandre Gitirana", usuarios.get(0).getNome());
    }
    
    @Test
    public void adicionarPontos()
    {
        UsuarioDAOImpl ds = new UsuarioDAOImpl();
        ds.adicionarPontos("jean.carvalho", 1000);
        Usuario us = new Usuario();
        us = ds.recuperar("jean.carvalho");
        assertEquals(1900, us.getPontos());
    }
  
    
}
