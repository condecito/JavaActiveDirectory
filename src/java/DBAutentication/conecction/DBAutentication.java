/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAutentication.conecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin
 */
public class DBAutentication {

    private String direccionIP;//direccion ip del servidor
    private String puerto;//puerto del servido
    private String instancia;//indica el nombre de la base de datos
    private String usuario;
    private String clave;
    private boolean conectado = false;
    private static Connection Conexion;

    public static Connection getConexion() {
        return Conexion;
    }

    public boolean isConectado() {
        return conectado;
    }

    public String getdireccionIP() {
        return direccionIP;
    }

    public void setdireccionIP(String servidor) {
        this.direccionIP = servidor;
        
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void conectar() throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://"+this.getdireccionIP()+":"+this.getPuerto()+"/"+getInstancia(), getUsuario(), getClave());
        } catch (Exception ex) {
            throw  ex;
        }

    }
    public void  cerraConeccion() throws SQLException{
        try {
            Conexion.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

}
