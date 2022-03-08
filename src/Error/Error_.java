package Error;

/**
 *
 * @author Squery
 */
public class Error_ {

    private String mensaje;
    private String tipo;
    private long fila;
    private long columna;

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

    public long getFila() {
        return this.fila;
    }

    public void setFila(long fila) {
        this.fila = fila;
    }

    public long getColumna() {
        return this.columna;
    }

    public void setColumna(long columna) {
        this.columna = columna;
    }

    public Error_(String mensaje, String tipo, long fila, long columna) {
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }
}
