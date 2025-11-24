package core.model;

import core.model.interfaces.IPerson;


public abstract class Person implements IPerson {

    protected long id;
    protected String nombres;
    protected String apellidos;

    public Person(long id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

   
    public abstract IPerson copiar();
}
