/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.LocalDvd;
import java.sql.*;

/**
 *
 * @author juccm
 */
public class LocalDvdDAO {
    
    private Connection conecta;
    
    public LocalDvdDAO(){
        this.conecta = new DAO().conecta();
    }
    
    public void adicionarLocalDvd(LocalDvd local){
        
        String sql = "insert into tb_localdvd (secçao, categoria)"
                + "values(?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setInt(1, local.getSeccao());
            stmt.setString(2, local.getCategoria());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
