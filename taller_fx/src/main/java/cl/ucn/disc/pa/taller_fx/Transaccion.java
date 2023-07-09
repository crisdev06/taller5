package cl.ucn.disc.pa.taller_fx;

import java.util.Date;

public class Transaccion {
    private String usuario;
    private String accion;
    private Date fechaHora;

    public Transaccion(String usuario, String accion, Date fechaHora) {
        this.usuario = usuario;
        this.accion = accion;
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "[" + fechaHora.toString() + "] Usuario: " + usuario + ", Acción: " + accion;
    }
}
