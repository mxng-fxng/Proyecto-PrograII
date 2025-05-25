package hl;

public class Casilla {
    private int color;
    /** Cambiar el color de ‘esta‘ casilla
    *
    * Alternando entre el blanco y el negro, codificados respectivamente por 0 y 1.
    */
    public void cambiarColor (){
        if (color == 0)
            color = 1;
        color = 0;
    }

    /** El color de ‘esta‘ casilla
    *
    * @return el numero de color de la casilla 0 para blanco, 1 para negro
    */
    public int color(){
        return color;
    }
}
