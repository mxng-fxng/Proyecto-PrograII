
package hl;

import java.awt.Color;

public class Graficos {
  
  private Graficos() {}

  private static final Color[] colores = { Color.WHITE, Color.LIGHT_GRAY, Color.RED };

  // Dibuja todas las casillas de cuadricula
  public static void dibujar (ICuadricula cuadricula) {
    for (int i = 0; i < Cuadricula.DIM; ++i) {
      for (int j = 0; j < Cuadricula.DIM; ++j) {
        StdDraw.setPenColor(colores[cuadricula.casilla(i,j).color()]);
        StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.square(i + 0.5, j + 0.5, 0.5);
      }
    }
  } 

  // Dibuja una hormiga, `h`
  public static void dibujar (IHormiga h) {
    int[] coord = h.coordenadas();
    StdDraw.picture(coord[0] + 0.5, coord[1] + 0.5, h.rutaDeLaImagen(), h.getAnguloEnGrados());
  } 

}
