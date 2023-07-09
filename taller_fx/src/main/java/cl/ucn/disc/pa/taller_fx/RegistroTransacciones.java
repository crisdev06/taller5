package cl.ucn.disc.pa.taller_fx;

import java.util.ArrayList;
import java.util.List;

public class RegistroTransacciones {
    private List<Transaccion> transacciones;

    public RegistroTransacciones() {
        this.transacciones = new ArrayList<>();
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }
}
