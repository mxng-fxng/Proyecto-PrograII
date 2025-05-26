package hl;

public class Casilla {
    private int color; // atributo privado tipo entero
    private int x;
    private int y;

    Casilla (int x, int y, int color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    Casilla (int x, int y){
        this(x,y,0);
    }

    Casilla(){
        this(0,0,0);
    }

    /** Cambiar el color de ‘esta‘ casilla
    *
    * Alternando entre el blanco y el negro, codificados respectivamente por 0 y 1.
    */
    public void cambiarColor (){
        if(this.color == 0) this.color = 1;
        else if(this.color == 1) this.color = 0;
        else throw new IllegalArgumentException("El color debe ser 0 o 1");
    }


    /** El color de ‘esta‘ casilla
    *
    * @return el numero de color de la casilla 0 para blanco, 1 para negro
    */
    public int color(){
        return this.color;
    }
}
