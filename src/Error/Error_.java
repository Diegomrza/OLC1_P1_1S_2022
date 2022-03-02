package Error;

/**
 *
 * @author Squery
 */
public class Error_ {

    private String mensaje;
    private String tipo;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Error_(String mensaje, String tipo) {
        this.mensaje = mensaje;
        this.tipo = tipo;
    }
}
