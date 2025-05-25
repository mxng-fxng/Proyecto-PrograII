package hl;

public class Orientacion {
    private int rumbo;
    /* Arriba Derecha Abajo Izquierda */
    private static final int[][] unitarios = { { 0, +1 }, { +1, 0 }, { 0, -1 }, { -1, 0 } };

    private Orientacion (int rumbo) {
        this.rumbo = rumbo;
    }

    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 180 grados
    public Orientacion girarMediaVuelta () {
        int nuevaOrientacion = (this.rumbo + 2) % 4;
        return new Orientacion(nuevaOrientacion);
    }

    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 90 grados a la izquierda
    public Orientacion girarIzquierda () {
        int nuevaOrientacion = (this.rumbo + 3) % 4;  // +3 es equivalente a -1 en módulo 4
        return new Orientacion(nuevaOrientacion);
    }

    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 90 grados a la derecha
    public Orientacion girarDerecha () {
        int nuevaOrientacion = (this.rumbo + 1) % 4;
        return new Orientacion(nuevaOrientacion);
    }

    // Mueve la hormiga, ‘h‘, con un incremento de posicion dado por el vector
    // unitario de ‘esta‘ orientacion.
    public void mover (IHormiga h) {
        int dX = unitarios[this.rumbo][0];
        int dY = unitarios[this.rumbo][1];
        h.mover(dX, dY);
    }

    // Devuelve el angulo en grados de ‘esta‘ orientacion respecto del eje vertical. Por ejemplo,
    // arriba devuelve 0 grados mientras que izquierda devuelve 90 (o -270) y derecha son -90 (o 270).
    public int getAnguloEnGrados () {
        switch (this.rumbo) {
            case 0: // Arriba
                return 0;
            case 1: // Derecha
                return -90;  // o 270
            case 2: // Abajo
                return 180;  // o -180
            case 3: // Izquierda
                return 90;   // o -270
            default:
                throw new IllegalStateException("Rumbo inválido: " + this.rumbo);
        }
    }

    public static final Orientacion IZQUIERDA = new Orientacion(3);
}
