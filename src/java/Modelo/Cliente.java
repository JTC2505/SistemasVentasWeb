package Modelo;

public class Cliente {
    int id;
    String dni;
    String nomb;
    String dir;
    String estado;

    public Cliente() {
    }

    public Cliente(int id, String dni, String nomb, String dir, String estado) {
        this.id = id;
        this.dni = dni;
        this.nomb = nomb;
        this.dir = dir;
        this.estado = estado;
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

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
