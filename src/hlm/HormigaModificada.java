package hlm;

import hl.ICuadricula;
import hl.IHormiga.Giro;

package hl;

public class HormigaModificada extends Hormiga {
    
    // Atributo para mantener la orientación (ya que no podemos acceder a la de la clase base)
    protected Orientacion orientacion;
    
    // Constructor por defecto
    public HormigaModificada() {
        super();
        this.orientacion = Orientacion.IZQUIERDA; // Misma inicialización que la clase base
    }
    
    // Constructor con parámetros
    public HormigaModificada(int x, int y, Orientacion orientacion) {
        super(x, y, orientacion);
        this.orientacion = orientacion;
    }
    
    /** 'Esta' hormiga gira su orientacion segun el color de la casilla que ocupa
     *
     * Segun las reglas del juego gira en un sentido u otro dependiendo del
     * color de la casilla,
     * @param cuadricula la cuadricula donde se encuentra la hormiga y que
     * se utiliza para obtener la casilla.
     * @throws IllegalStateException si el color de la casilla no es
     * uno de los que la hormiga reconoce en sus instrucciones de actuacion.
     */
    @Override
    public Giro girar(ICuadricula cuadricula) {
        // Obtener las coordenadas actuales de la hormiga
        int[] coords = coordenadas();
        int x = coords[0];
        int y = coords[1];
        
        // Obtener la casilla actual
        Casilla casilla = cuadricula.casilla(x, y);
        int color = casilla.color();
        
        // Aplicar las reglas según el color:
        // - Color 0 (blanco): gira 90° a la izquierda
        // - Color 1 (negro): gira 90° a la derecha  
        // - Color 2 (rojo): gira 180° (media vuelta)
        
        switch (color) {
            case 0: // Blanco - girar a la izquierda
                this.orientacion = this.orientacion.girarIzquierda();
                return IHormiga.Giro.IZQUIERDA;
                
            case 1: // Negro - girar a la derecha
                this.orientacion = this.orientacion.girarDerecha();
                return IHormiga.Giro.DERECHA;
                
            case 2: // Rojo - girar 180° (media vuelta)
                this.orientacion = this.orientacion.girarDerecha().girarDerecha();
                return IHormiga.Giro.MEDIA_VUELTA;
                
            default:
                throw new IllegalStateException("Color de casilla no reconocido: " + color);
        }
    }
    
    /** Sobrescribir avanzar para usar nuestra orientación */
    @Override
    public void avanzar() {
        // Usar nuestra orientación local en lugar de la de la clase base
        switch(this.orientacion) {
            case ARRIBA:
                mover(0, 1);  // y++
                break;
            case ABAJO:
                mover(0, -1); // y--
                break;
            case DERECHA:
                mover(1, 0);  // x++
                break;
            case IZQUIERDA:
                mover(-1, 0); // x--
                break;
        }
    }
    
    /** Sobrescribir getAnguloEnGrados para usar nuestra orientación */
    @Override
    public int getAnguloEnGrados() {
        return this.orientacion.getAnguloEnGrados();
    }
}