package models;

public class Empleado {

    private int idEmpleado;
    private String apellido;
    private String oficio;
    private int salario;
    private int idDepartamento;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String apellido, String oficio, int salario, int idDepartamento) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.oficio = oficio;
        this.salario = salario;
        this.idDepartamento = idDepartamento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
