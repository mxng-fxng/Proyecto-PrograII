package hlm;

import hl.ICuadricula;
import hl.IHormiga.Giro;
import tads.IQueue;
import tads.LinkedQueue;

public class HormigaReiterativa {
    private static enum Estatus { MOVIENDO, REITERANDO }
    private Estatus estatus;

    // Numero de movimientos en el estatus MOVIENDO
    private int movimientos = 0;
    
    // Numero de movimientos para alternar entre estatus
    // (para depurar se puede poner un valor mas bajo, por ejemplo: 3
    public static int vecesParaAlternar = 5;
    
    // La secuencia para guardar los giros
    private final IQueue<Giro> giros = new LinkedQueue<>(){

    }
    
    /** Construye la hormiga
    *
    * Inicializar el estatus a MOVIENDO.
    */
    public HormigaReiterativa () {

    }
    
    /** Comprueba si hay que cambiar el estatus y lo hace si fuese necesario.
    *
    * - Si el estatus es MOVIENDO y el numero de movimientos es ‘vecesParaAlternar‘
    * se cambia el estatus, se fija ‘movimientos‘ a 0 y se pasa el estatus a
    * REITERANDO.
    * - Si el estatus es REITERANDO y cola esta vacia se cambia el estatus
    * a MOVIENDO.
    */
    public void cambiarEstatus() {

    }
    
    /** Gira ‘esta‘ hormiga segun sus reglas.
    *
    * En este metodo lo primero es llamar a ‘cambiarEstatus‘.
    * Importante: La implementacion es mas simple si se usa girar de
    * la clase _base_ (HormigaModificada).
    *
    * @param cuadricula la cuadricula donde se encuentra la hormiga y que
    * se utiliza para obtener la casilla.
    * @throws IllegalStateException si el color de la casilla no es
    * uno de lo que la hormiga reconoce en sus instrucciones de actuacion.
    * Exactamente igual que en el caso de la HormigaModificada.
    */
    @Override
    public Giro girar (ICuadricula cuadricula) {

    }
    
    /** Ruta de la imagen a mostrar.
    * @return el archivo "res/ant_1.png" si ‘esta‘ se esta moviendo y "res/ant_2.png"
    * en caso contrario.
    */
    @Override
    public String rutaDeLaImagen () {

    }
    
    /* ATENCION: Es necesario dejar este metodo exactamente asi.
    * Este se utiliza en las pruebas para comprobar el estado interno
    * de la hormiga (inaccesible de otra manera).
    * Si no se mantiene tal cual algunas pruebas no podran evaluar
    * correctamente el codigo fuente propuesto */
    @Override
    public String toString() {
    return String.format("st: %d, mov: %d, seq: %s, alt: %d",
    estatus.ordinal(), movimientos, giros.toString(), vecesParaAlternar);
    }
}
