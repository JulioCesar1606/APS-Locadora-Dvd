/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import MODEL.Dvd;
import java.sql.*;

/**
 *
 * @author juccm
 */
public class DvdDAO {
    
    private Connection conecta;
    
    public DvdDAO(){
        this.conecta = new DAO().conecta();
    }
    
    public void adicionarDvd(Dvd dvd){
        
        String sql = "insert into tb_dvd (nomeDvd, diretor, ano, sinopse, status)"
                + "values(?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, dvd.getNome());
            stmt.setString(2, dvd.getDiretor());
            stmt.setInt(3, dvd.getAno());
            stmt.setString(4, dvd.getSinopse());
            stmt.setBoolean(5, true);
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void alterarDvd(Dvd dvd){
        
        String sql = "update tb_dvd set nomeDvd=?, diretor=?, ano=?, sinopse=?"
                + "where id=?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, dvd.getNome());
            stmt.setString(2, dvd.getDiretor());
            stmt.setInt(3, dvd.getAno());
            stmt.setInt(4, dvd.getId());
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void dvdAlugar(Dvd dvd){
        
        String sql = "update tb_dvd set status=?"
                + "where id=?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setBoolean(1, false);
            stmt.setInt(2, dvd.getId());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void dvdDevolver(Dvd dvd){
        
        String sql = "update tb_dvd set status=?"
                + "where id=?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setBoolean(1, true);
            stmt.setInt(2, dvd.getId());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
