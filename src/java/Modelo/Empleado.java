package Modelo;

public class Empleado {
    int id;
    String dni;
    String nomb;
    String tel;
    String estado;
    String user;

    public Empleado() {
    }

    public Empleado(int id, String dni, String nomb, String tel, String estado, String user) {
        this.id = id;
        this.dni = dni;
        this.nomb = nomb;
        this.tel = tel;
        this.estado = estado;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    
}
