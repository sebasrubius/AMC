
package pkg18.pkg06.pkg13.alumnosdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ConsultasSQL {
    
    String Nombre="", Direccion="";
    int Telefono=0;
    
    static DefaultComboBoxModel modelocbCarreras=new DefaultComboBoxModel();
            
    //Constructor
    public ConsultasSQL () {
        
    }
        
    //Metodo
    public void InsertarAlumno (String Nombre, String Direccion, int Telefono) {
        
        try {
        //Consulta de insertar datos
        String sqlInsertarAsignatura = "insert into Alumnos (Nombre,Direccion,Telefono) values (?,?,?)";
        //String sqlInsertarAsignatura = "insert into Alumnos (Nombre,Direccion,Telefono) values (?,?,?); insert into Carreras (NombreCarrera) value (?)";
        
        //Dos pasos para la conexion
        ConexionSQL objetoConexionDeClase = new ConexionSQL();
        Connection cadenaConexionDeClase =objetoConexionDeClase.Conectar2();
        
        PreparedStatement Objetops = cadenaConexionDeClase.prepareStatement(sqlInsertarAsignatura);
        
        Objetops.setString(1, Nombre);
        Objetops.setString(2, Direccion);
        Objetops.setInt(3, Telefono);
        //Objetops.setString(4, Carrera);
        
        //Ejecutamos la consulta
        Objetops.executeUpdate();
        JOptionPane.showMessageDialog(null, "Insertó correctamente los datos");
        
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de clase no encontrada "+ex);
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de SQL Exception"+ex);
        }
    }

    public static void LeerCarreras () {
        
        try {
        //Consulta de leer datos    
            
        //Dos pasos para la conexion
        ConexionSQL objetoConexionDeClase = new ConexionSQL();
        Connection cadenaConexionDeClase =objetoConexionDeClase.Conectar2();
        
        Statement st = (Statement) ConexionSQL.conectar.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select * from Carreras");
        
        //modelocbCarreras.addElement("NombreCarrera");
        
        while (rs.next()) {
            modelocbCarreras.addElement(rs.getObject("NombreCarrera"));
        }
        
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de clase no encontrada "+ex);
                       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de SQL Exception"+ex);
        }
        
    }

}
