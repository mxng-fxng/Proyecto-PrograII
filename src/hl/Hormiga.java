package hl;

public class Hormiga implements IHormiga {
    // Los posibles giros que puede hacer una hormiga.
    // Removido porque debe estar definido en IHormiga
    // static enum Giro { IZQUIERDA, DERECHA, MEDIA_VUELTA, SIN_GIRO }
    
    // Atributos de la hormiga
    private int x, y;  // Posición de la hormiga
    private Orientacion orientacion;  // Orientación actual
    private int contadorTick;  // Para controlar el ciclo de tick
    
    // Constructor por defecto (requerido por los tests)
    public Hormiga() {
        this.x = 0;
        this.y = 0;
        this.orientacion = Orientacion.IZQUIERDA; // Usar la constante estática disponible
        this.contadorTick = 0;
    }
    
    // Constructor con parámetros
    public Hormiga(int x, int y, Orientacion orientacion) {
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
        this.contadorTick = 0;
    }
    
    /** Mueve `esta` hormiga el numero de casillas indicadas en los parametros.
     * 
     * @param incX, incY los incrementos de posicion de la hormiga, es decir,
     * la hormiga se desplaza esa cantidad de casillas en cada eje independientemente
     * de su orientacion. */
    public void mover(int incX, int incY) {
        this.x += incX;
        this.y += incY;
    }
    
    /** `Esta` hormiga gira su orientacion segun el color de la casilla que ocupa
     *
     *  Segun las reglas del juego gira en un sentido u otro dependiendo del 
     *  color de la casilla,
     *  @param cuadricula la cuadricula donde se encuentra la hormiga y que
     *  se utiliza para obtener la casilla.
     *  @return eL giro que se ha realizado
     *  @throws IllegalStateException si el color de la casilla no es 
     *  uno de lo que la hormiga reconoce en sus instrucciones de actuacion.
     */
    public IHormiga.Giro girar(ICuadricula cuadricula) {
        // Obtener el color de la casilla actual usando el método de la interfaz
        Casilla casilla = cuadricula.casilla(this.x, this.y);
        
        // Asumir que Casilla tiene un método para obtener su estado/color
        // Implementación basada en reglas clásicas de Langton's Ant
        if (casilla.color() == 0) {
            // En casilla blanca: girar a la derecha
            this.orientacion = this.orientacion.girarDerecha();
            return IHormiga.Giro.DERECHA;
        } else {
            // En casilla negra/no blanca: girar a la izquierda
            this.orientacion = this.orientacion.girarIzquierda();
            return IHormiga.Giro.IZQUIERDA;
        }
    }

    /** `Esta` hormiga cambia el color de la casilla que ocupa
    *
    *  Se busca la casilla en la `cuadricula` y se cambia su color.
    *  @param cuadricula la cuadricula donde se encuentra la hormiga y que
    *  se utiliza para obtener la casilla.
    */
    public void cambiarColor(ICuadricula cuadricula) {
        // Obtener la casilla actual
        Casilla casilla = cuadricula.casilla(this.x, this.y);
        
        // Cambiar el estado de la casilla
        casilla.cambiarColor();
    }
    
    /** `Esta` hormiga avanza una casilla en el sentido de su orientacion
     * 
     *  Se utiliza la orientacion (sus vectores unitarios) para que la hormiga se 
     *  mueva una casilla.
     * */
    public void avanzar() {
        // Usar la orientación para mover la hormiga
        this.orientacion.mover(this);
    }
    
    /** Llama sucesivamente y recurrentemente a los metodos girar, cambiarColor y avanzar
    *
    *  La primera vez se llama a girar, la segunda a cambiarColor, la tercera a 
    *  avanzar y vuelta a empezar.
    *  @param cuadricula la cuadricula donde se encuentra la hormiga y que
    *  se utiliza para obtener la casilla.
    * */ 
    public void tick(ICuadricula cuadricula) {
        switch (this.contadorTick % 3) {
            case 0:
                // Primera fase: girar
                girar(cuadricula);
                break;
            case 1:
                // Segunda fase: cambiar color
                cambiarColor(cuadricula);
                break;
            case 2:
                // Tercera fase: avanzar
                avanzar();
                break;
        }
        this.contadorTick++;
    }
    
    /** 
     * Devuelve las coordenadas de la hormiga.  
     * @return como un array { x, y } siendo x e y las coordenadas de la hormiga en el plano 2D
     */
    public int[] coordenadas() {
        return new int[]{this.x, this.y};
    }
    
    /** La ruta del archivo con la imagen de la hormiga.
     * Por ejemplo: "res/ant_1.png" 
     * @return la ruta relativa al archivo
     */
    public String rutaDeLaImagen() {
        return "res/ant_1.png";
    }
    
    /** El angulo en grados de `esta` hormiga
     * que se debe girar en sentido anti-horario la imagen dada por el metodo anterior, 
     * para que, al dibujar el dibujo de la hormiga quede orientado correctamente
     * @return el angulo en grados de la orientacion de `esta` hormiga 
     */
    public int getAnguloEnGrados() {
        return this.orientacion.getAnguloEnGrados();
    }
    
    // Métodos adicionales útiles
    public Orientacion getOrientacion() {
        return this.orientacion;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        return "Hormiga[x=" + x + ", y=" + y + ", orientacion=" + orientacion + "]";
    }
}