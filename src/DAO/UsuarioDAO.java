/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.Usuario;
import java.sql.*;
/**
 *
 * @author juccm
 */
public class UsuarioDAO {
    
    private Connection conecta;
    
    public UsuarioDAO(){
        this.conecta = new DAO().conecta();
    }
    
    public void adicionarUsuario(Usuario usuario){
        
        String sql = "insert into tb_usuario (nome, cpf, telefone)"
                + "values(?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void alterarUsuario(Usuario usuario){
        
        String sql = "update tb_usuario set nome=?, cpf=?, telefone=?"
                + "where id=?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getTelefone());
            stmt.setInt(4, usuario.getId());
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void deletarUsuario(Usuario usuario){
        
        String sql = "delete from tb_usuario where id=?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
