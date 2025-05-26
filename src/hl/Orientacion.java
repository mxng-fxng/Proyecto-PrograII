package hl;

public class Orientacion {
   private int rumbo;
                                                /* Arriba Derecha Abajo Izquierda */
    private static final int[][] unitarios = { { 0, +1 }, { +1, 0 }, { 0, -1 }, { -1, 0 } };

    private Orientacion (int rumbo) {
        this.rumbo = rumbo;
    }

    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 180 grados
    public Orientacion girarMediaVuelta (){
        int rumboAux = this.rumbo;
        switch (rumboAux) {
            case 0: //Arriba -> abajo
                rumboAux = 2;
                break;
            case 1: //Derecha -> izquierda
                rumboAux = 3;
                break;
            case 2:// Abajo -> arriba
                rumboAux = 0;
                break;
            case 3://Izquierda -> derecha
                rumboAux = 1;
                break;
            default:
                throw new  IllegalArgumentException("Valor fuera de 0-3");    
        }
        return new Orientacion(rumboAux);
    }

    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 90 grados a la izquierda
    public Orientacion girarIzquierda (){
        int rumboAux = this.rumbo;
        switch (rumboAux) {
            case 0: //Arriba -> izquierda
                rumboAux = 3;
                break;
            case 1: //Derecha -> arriba
                rumboAux = 0;
                break;
            case 2:// Abajo -> derecha
                rumboAux = 1;
                break;
            case 3://Izquierda -> abajo
                rumboAux = 2;
                break;
            default:
                throw new  IllegalArgumentException("Valor fuera de 0-3");    
        }
        return new Orientacion(rumboAux);
    }

    // Devuelve una nueva orientacion que resulta de girar ‘esta‘ orientacion 90 grados a la derecha
    public Orientacion girarDerecha (){
        int rumboAux = this.rumbo;
        switch (rumboAux) {
            case 0: //Arriba -> derecha
                rumboAux = 1;
                break;
            case 1: //Derecha -> abajo
                rumboAux = 2;
                break;
            case 2:// Abajo -> izquierda
                rumboAux = 3;
                break;
            case 3://Izquierda -> arriba
                rumboAux = 0;
                break;
            default:
                throw new  IllegalArgumentException("Valor fuera de 0-3");    
        }
        return new Orientacion(rumboAux);
    }

    // Mueve la hormiga, ‘h‘, con un incremento de posicion dado por el vector
    // unitario de ‘esta‘ orientacion.
    public void mover (IHormiga h){
        int despX = unitarios[this.rumbo][0];
        int despY = unitarios[this.rumbo][1];
        h.mover(despX, despY);
    }

    // Devuelve el angulo en grados de ‘esta‘ orientacion respecto del eje vertical. Por ejemplo,
    // arriba devuelve 0 grados mientras que izquierda devuelve 90 (o -270) y derecha son -90 (o 270).
    public int getAnguloEnGrados (){
        int rumboAux = this.rumbo;
        int grados;
        switch (rumboAux) {
            case 0: //Arriba
                grados = 0;
                break;
            case 1: //Derecha 
                grados = 270;
                break;
            case 2:// Abajo 
                grados = 180;
                break;
            case 3://Izquierda
                grados = 90;
                break;
            default:
                throw new  IllegalArgumentException("Valor fuera de 0-3");    
        }
        return grados;
    }

    public static final Orientacion IZQUIERDA = new Orientacion(3);
}
