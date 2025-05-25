package hlm;

import java.util.Random;

public class CasillaTresColores {
    // Consulta: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
    static final Random r = new Random(31416);
    /** Construye una casilla de color aleatorio:
    *
    * Se obtiene un numero aleatorio entre 0 y 99 (ambos inclusives) usando
    * el objeto ‘r‘ y su metodo nextInt si aleatorio es menor estrictamente
    * que 20 el color de la casilla sera el 1, si esta entre 20 y 39 (ambos inclusives)
    * sera 2 y sera 0 en cualquier otro caso.
    */
    public CasillaTresColores () {

    }
    /** Cambia el color de ‘esta‘ casilla.
    *
    * Si es 0 pasa a 1, si es 1 a 2 y si es 2 a 3.
    * Atencion: NO hace falta utilizar if para resolver esto.
    */
    @Override
    public void cambiarColor() {

    }

}
