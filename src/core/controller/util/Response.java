package core.controller.util;

public class Response<T> {

    private int codigo;
    private String mensaje;
    private T dato;

    public Response(int codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public Response(int codigo, String mensaje, T dato) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.dato = dato;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
}
