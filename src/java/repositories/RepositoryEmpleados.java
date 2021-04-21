package repositories;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Empleado;

public class RepositoryEmpleados {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new SQLServerDriver());
        //PODEIS ATACAR A ORACLE EN LOCAL, INSTALAR SQL SERVER EXPRESS
        String cadena
                = "jdbc:sqlserver://sqlserverjavapgs.database.windows.net:1433;databaseName=SQLAZURE";
        Connection cn
                = DriverManager.getConnection(cadena, "adminsql", "Admin123");
        return cn;
    }

    public List<Empleado> getEmpleados() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from emp";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMP_NO");
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("OFICIO");
            int salario = rs.getInt("SALARIO");
            int iddept = rs.getInt("DEPT_NO");
            Empleado empleado = new Empleado(id, apellido, oficio, salario, iddept);
            empleados.add(empleado);
        }
        rs.close();
        cn.close();
        return empleados;
    }

    public List<String> getOficios() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select distinct oficio from emp";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<String> oficios = new ArrayList<>();
        while (rs.next()) {
            String oficio = rs.getString("OFICIO");
            oficios.add(oficio);
        }
        rs.close();
        cn.close();
        return oficios;
    }

    public void incrementarSalarioOficio(String oficio, int incremento) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "update emp set salario=salario + ? "
                + " where upper(oficio)=upper(?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, incremento);
        pst.setString(2, oficio);
        pst.executeUpdate();
        cn.close();
    }
}
