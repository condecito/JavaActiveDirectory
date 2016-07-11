/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activeDirectory.security;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author Edwin
 * @param dni es de tipo dominio\\usuario
 */
public class seguridadActiveDirectory {

    static DirContext ActiveDirectory;
    private boolean atenticado = false;
    private String MensajeError = "";

    public void autenticarUsuario(String usuario, String clave, String servidor, String dn, String tipoAutenticacion) {
        if (!clave.equals("") && !usuario.equals("") && !servidor.equals("") && !dn.equals("") && !tipoAutenticacion.equals("")) {
            Hashtable parametros = new Hashtable();
            parametros.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            parametros.put(Context.PROVIDER_URL, servidor);
            parametros.put(Context.SECURITY_AUTHENTICATION, tipoAutenticacion);
            parametros.put(Context.SECURITY_PRINCIPAL, dn);
            parametros.put(Context.SECURITY_CREDENTIALS, clave);

            try {
                ActiveDirectory = new InitialDirContext(parametros);
                setAutenticado(true);
            } catch (Exception e) {
                setAutenticado(false);
                
                MensajeError = e.toString();
            }

        }
    }

    public boolean isAtenticado() {
        return atenticado;
    }

    public String getMensajeError() {
        return MensajeError;
    }

    private void setAutenticado(boolean autenticado) {
        this.atenticado = autenticado;
    }
    
   
    
}
