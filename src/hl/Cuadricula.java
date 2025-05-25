package hl;

public class Cuadricula implements ICuadricula {
    // Tamanho de la matriz que guarda las casillas, DIMxDIM
    public static final int DIM = 11;

    // Array bidimensional de tamanho DIMxDIM que guarda las casillas
    private Casilla[][] casillas;
    
    /** Construye e inicializa una nueva cuadricula
    */
    public Cuadricula() {
        casillas = new Casilla[DIM][DIM];
        
        // Inicializar cada casilla
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }
    
    /** Devuelve la casilla de 'esta' cuadricula en los indices de fila y columna dados por i y j.
    * Se supone que los indices son las coordenadas (x, y) de la casilla en un plano 2D.
    * @throws IndexOutOfBoundsException cuando i o j no estan en el rango [0,Dim) */
    @Override
    public Casilla casilla(int i, int j) {
        // Verificar que los índices estén en el rango válido
        if (i < 0 || i >= DIM) {
            throw new IndexOutOfBoundsException("Índice i fuera de rango: " + i + ". Debe estar en [0, " + DIM + ")");
        }
        if (j < 0 || j >= DIM) {
            throw new IndexOutOfBoundsException("Índice j fuera de rango: " + j + ". Debe estar en [0, " + DIM + ")");
        }
        
        return casillas[i][j];
    }
}