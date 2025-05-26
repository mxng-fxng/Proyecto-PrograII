package hlm;

import hl.Casilla;
import hl.Hormiga;
import hl.ICuadricula;
import hl.IHormiga.Giro;

public class CuadriculaTresColores implements ICuadricula {
    // Tamanho de la matriz que guarda las casillas, DIMxDIM
    public static final int DIM = 11;
    
    // Array bidimensional de tamanho DIMxDIM que guarda las casillas
    protected CasillaTresColores[][] casillas;
    
    /** Construye e inicializa una nueva cuadricula */
    public CuadriculaTresColores() {
        casillas = new CasillaTresColores[DIM][DIM];
        
        // Inicializar todas las casillas
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                casillas[i][j] = new CasillaTresColores();
            }
        }
    }
    
    /** Devuelve la casilla de 'esta' cuadricula en los indices de fila y columna dados por i y j.
     * 
     * Se supone que los indices son las coordenadas (x, y) de la casilla en un plano 2D.
     * @throws IndexOutOfBoundsException cuando i o j no estan en el rango [0,Dim) 
     */
    @Override
    public Casilla casilla(int i, int j) {
        // Verificar que los índices estén en el rango válido
        if (i < 0 || i >= DIM || j < 0 || j >= DIM) {
            throw new IndexOutOfBoundsException(
                String.format("Índices fuera de rango: (%d, %d). Rango válido: [0, %d)", i, j, DIM)
            );
        }
        
        return casillas[i][j];
    }
}