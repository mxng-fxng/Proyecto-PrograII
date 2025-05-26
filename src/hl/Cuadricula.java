package hl;

public class Cuadricula implements ICuadricula {
    // Tamanho de la matriz que guarda las casillas, DIMxDIM
    public static final int DIM = 11;

    // Array bidimensional de tamanho DIMxDIM que guarda las casillas
    private Casilla[][] casillas;
    
    /** Construye e inicializa una nueva cuadricula
    */
    public Cuadricula() {
        casillas = new Casilla[DIM][DIM]; // crea la cuadricula, que es el conjunto de casillas
        
        // Inicializar cada casilla
        for (int i = 0; i < DIM; i++) { //recorre las i
            for (int j = 0; j < DIM; j++) { // recorre las j
                casillas[i][j] = new Casilla(i, j); //le da a cada casilla (elemento del array), un par de coordenadas
            }
        }
    }
    
    /** Devuelve la casilla de 'esta' cuadricula en los indices de fila y columna dados por i y j.
    * Se supone que los indices son las coordenadas (x, y) de la casilla en un plano 2D.
    * @throws IndexOutOfBoundsException cuando i o j no estan en el rango [0,Dim) */
    @Override
    public Casilla casilla(int i, int j) {
        if (i < 0 || i >= DIM) {
            throw new IndexOutOfBoundsException("Índice i fuera de rango: " + i + ". Debe estar en [0, " + DIM + ")");
        }
        else if (j < 0 || j >= DIM) {
            throw new IndexOutOfBoundsException("Índice j fuera de rango: " + j + ". Debe estar en [0, " + DIM + ")");
        }
        else {
        return casillas[i][j];
        }
    }
}