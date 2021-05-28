/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;
 import java.sql.SQLException;
 import java.sql.Connection;
 import DAO.DAO;
 import VIEW.JFrameMenu;
/**
 *
 * @author juccm
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        
        Connection conecta = new DAO().conecta();
        System.out.println("Conectado");
        conecta.close();
        
        JFrameMenu menu = new JFrameMenu();
        menu.setVisible(true);
    }
}
