/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.Registro;
import java.sql.*;
/**
 *
 * @author juccm
 */
public class RegistroDAO {
    
    private Connection conecta;
    
    public RegistroDAO(){
        this.conecta = new DAO().conecta();
    }
    
    public void adicionarRegistro(Registro registro){
        
        String sql = "insert into tb_registro (data_locacao, cpf, dvd_locado)"
                + "values(?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, registro.getDataLocacao());
            stmt.setString(2, registro.getCpf());
            stmt.setString(3, registro.getDvd());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
