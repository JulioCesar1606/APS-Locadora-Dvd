/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juccm
 */
public class ClienteDAO {
    
    private Connection conecta;
    
    public ClienteDAO(){
        this.conecta = new DAO().conecta();
    }
    
    public void adicionarCliente(Cliente cliente){
        
        String sql = "insert into tb_cliente (nome, cpf, telefone, endereco)"
                + "values(?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEndereco());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void atualizarCliente(Cliente cliente){
        
        String sql = "update tb_cliente set nome=?, telefone=?, endereco=?"
                + "where cpf=?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCpf());
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Cliente> listarClientes(){
        
        String sql = "select * from tb_cliente";
        ResultSet rs;
        List<Cliente> cliente = new ArrayList<>();
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cle = new Cliente();
                cle.setNome(rs.getString("nome"));
                cle.setCpf(rs.getString("cpf"));
                cle.setTelefone(rs.getString("telefone"));
                cle.setEndereco(rs.getString("endereco"));
                cliente.add(cle);  
            }
            rs.close();
            stmt.close();
            return cliente;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
