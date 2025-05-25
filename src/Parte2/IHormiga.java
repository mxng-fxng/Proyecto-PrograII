/*Q*/
package hl;
/*q*/
public interface IHormiga {
  
  // Los posibles giros que puede hacer una hormiga.
  static enum Giro { IZQUIERDA, DERECHA, MEDIA_VUELTA, SIN_GIRO }
  
  /** Mueve `esta` hormiga el numero de casillas indicadas en los parametros.
   * 
   * @param incX, incY los incrementos de posicion de la hormiga, es decir,
   * la hormiga se desplaza esa cantidad de casillas en cada eje independientemente
   * de su orientacion. */
  public void mover (int incX, int incY);
  
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
  public Giro girar (ICuadricula cuadricula);

  /** `Esta` hormiga cambia el color de la casilla que ocupa
  *
  *  Se busca la casilla en la `cuadricula` y se cambia su color.
  *  @param cuadricula la cuadricula donde se encuentra la hormiga y que
  *  se utiliza para obtener la casilla.
  */
  public void cambiarColor (ICuadricula cuadricula);
  
  /** `Esta` hormiga avanza una casilla en el sentido de su orientacion
   * 
   *  Se utiliza la orientacion (sus vectores unitarios) para que la hormiga se 
   *  mueva una casilla.
   * */
  public void avanzar (); 
  
  /** Llama sucesivamente y recurrentemente a los metodos girar, cambiarColor y avanzar
  *
  *  La primera vez se llama a girar, la segunda a cambiarColor, la tercera a 
  *  avanzar y vuelta a empezar.
  *  @param cuadricula la cuadricula donde se encuentra la hormiga y que
  *  se utiliza para obtener la casilla.
  * */ 
 public void tick (ICuadricula cuadricula);
  
  /** 
   * Devuelve las coordenadas de la hormiga.  
   * @return como un array { x, y } siendo x e y las coordenadas de la hormiga en el plano 2D
   */
  int[] coordenadas ();  
  
  /** La ruta del archivo con la imagen de la hormiga.
   * Por ejemplo: "res/ant_1.png" 
   * @return la ruta relativa al archivo
   */
  String rutaDeLaImagen ();
  
  /** El angulo en grados de `esta` hormiga
   * que se debe girar en sentido anti-horario la imagen dada por el metodo anterior, 
   * para que, al dibujar el dibujo de la hormiga quede orientado correctamente
   * @return el angulo en grados de la orientacion de `esta` hormiga 
   */
  int getAnguloEnGrados ();
}
