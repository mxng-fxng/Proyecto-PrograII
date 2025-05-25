package hl;

public class Principal {
  
  public static final int PAUSA = 1200;

  public static void main (String[] args) {
    StdDraw.setCanvasSize(768, 768); // Para el que lo quiera ver mas grande puede aumentar aqui el tamanno
    StdDraw.setScale(-2.0, Cuadricula.DIM + 2.0);
    StdDraw.enableDoubleBuffering();
    ICuadricula cuadricula = new Cuadricula();
    IHormiga h1 = new Hormiga();
    h1.mover(9, 9); // Posicion inicial
    int iteraciones = 3*200;
    StdDraw.clear();
    Graficos.dibujar(cuadricula);
    Graficos.dibujar(h1);
    StdDraw.show(); // Se muestra la posicion inicial
    while ( ! StdDraw.mousePressed() ); // Se pausa hasta que haga click en la pantalla
    StdDraw.pause(PAUSA);
    while (iteraciones > 0) {
      h1.tick(cuadricula); // Se hace un paso en la simulacion de la hormiga
      StdDraw.clear();
      Graficos.dibujar(cuadricula);
      Graficos.dibujar(h1);
      StdDraw.show(); // Y se muestra
      StdDraw.pause(PAUSA); // Y se detiene para que se pueda observar el cambio
      --iteraciones;
    }
  }
}
