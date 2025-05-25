package hl;

public class Orientacion {
    private int rumbo;
    /* Arriba Derecha Abajo Izquierda */
    private static final int[][] unitarios = { { 0, +1 }, { +1, 0 }, { 0, -1 }, { -1, 0 } };
    private Orientacion (int rumbo) ;
    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 180 grados
    public Orientacion girarMediaVuelta () ;
    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 90 grados a la izquierda
    public Orientacion girarIzquierda () ;
    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 90 grados a la derecha
    public Orientacion girarDerecha () ;
    // Mueve la hormiga, ‘h‘, con un incremento de posicion dado por el vector
    // unitario de ‘esta‘ orientacion.
    public void mover (IHormiga h) ;
    // Devuelve el angulo en grados de ‘esta‘ orientacion respecto del eje vertical. Por ejemplo,
    // arriba devuelve 0 grados mientras que izquierda devuelve 90 (o -270) y derecha son -90 (o 270).
    public int getAnguloEnGrados () ;
    public static final Orientacion IZQUIERDA = new Orientacion(3);
}
