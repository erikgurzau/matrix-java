package it.matrix;
import it.matrix.exception.MatrixException;
import java.util.*;
/**
 * Classe che gestisce una matrice
 * @author Erik Gurzau
 * @version 1.0.0
 * @see <a href="www.linkedin.com/in/erikgurzau">Linkedin</a>
 * @see <a mailto="gurzau10@gmail.com">Email</a>
 */
public class Matrix {
    /**
     * Matrice
     */
    private double[][] matrix;
    /**
     * Valore minimo degli elementi generati in modo randomico
     */
    public static final int MIN_RAND_VALUE = 0;
    /**
     * Valore massimo degli elementi generati in modo randomico
     */
    public static final int MAX_RAND_VALUE = 4;

    /**
     * Costruttore di una matrice generata randomicamente con una dimensione determinata
     * @param rows Numero di righe
     * @param columns Numero di colonne
     * @param random {@code true} Se e solo se, la matrice deve essere riempita con
     *               elementi generati randomicamente in un range di default;
     *               Altrimenti {@code false} per generare una matrice vuota.
     */
    public Matrix(int rows, int columns, boolean random) {
        if (random) matrix = Matrix.random(rows, columns);
        else matrix = new double[rows][columns];
    }

    /**
     * Costruttore di una matrice vuota con una dimesione determinata
     * @param rows Numero di righe
     * @param columns Numero di colonne
     */
    public Matrix(int rows, int columns) {
        matrix = new double[rows][columns];
    }

    /**
     * Costruttore di una matrice contenente gli elementi di una specifica collezione
     * @param matrix Matrice
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Costruttore copia
     * @param m Matrice da copiare
     */
    private Matrix(Matrix m) {
        this.matrix = m.getMatrix();
    }


    /**
     * Controlla se gli indici della riga e della colonna sono fuori dal range (index < 0 || index > N - 1)
     * @param m      Matrice
     * @param row    Indice della riga
     * @param column Indice della colonna
     * @return {@code true} Se e solo se, gli indice della riga e colonna
     *         sono dentro al range (index < 0 || index > N - 1);
     *         Altrimenti {@code false}.
     */
    public boolean outOfMatrixBounds(Matrix m, int row, int column) {
        return outOfRange(row, m.getNumRows()) || outOfRange(column, m.getNumColumns());
    }

    /**
     * Controlla se l'indice è fuori dal range (index < 0 || index > N - 1)
     * @param index Indice
     * @param N Lunghezza massima
     * @return {@code true} Se e solo se, l'indice è nell'intervallo (index < 0 || index > N - 1)
     *         Altrimenti {@code false}.
     */
    public boolean outOfRange(int index, int N){
        return index < 0 || index > N - 1;
    }

    /**
     * Ritorna il numero di righe della matrice
     * @return Il numero di righe della matrice
     */
    public int getNumRows() {
        return matrix.length;
    }

    /**
     * Ritorna il numero di colonne della matrice
     * @return Il numero di colonne della matrice
     */
    public int getNumColumns() {
        return matrix[0].length;
    }

    /**
     * Ritorna la matrice
     * @return La matrice
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * Rimpiazza un elemento in una posizione specifica della matrice con un altro elemento
     * @param value Elemento da inserire nella matrice
     * @param row Indice della riga dell'elemento da rimpiazzare
     * @param column Indice della colonna dell'elemento da rimpiazzare
     */
    public void set(double value, int row, int column) {
        if (outOfRange(row, getNumRows()))
            throw new RuntimeException("Illegal row index: " + row + "out of bounds 0 - " + getNumRows());
        if (outOfRange(column, getNumRows()))
            throw new RuntimeException("Illegal column index: " + column + "out of bounds 0 - " + getNumColumns());
        matrix[row][column] = value;
    }

    /**
     * Ritorna un elemento in una posizione specifica della matrice
     * @param row Indice della riga
     * @param column Indice della colonna
     * @return L'elemento nella posizione specificata
     */
    public double get(int row, int column) {
        if (outOfRange(row, getNumRows()))
            throw new RuntimeException("Illegal row index: " + row + "out of bounds 0 - " + getNumRows());
        if (outOfRange(column, getNumRows()))
            throw new RuntimeException("Illegal column index: " + column + "out of bounds 0 - " + getNumColumns());
        return matrix[row][column];
    }

    /**
     * Ritorna l'elemento in una posizione specifica della matrice
     * @param row    Indice della riga
     * @param column Indice della colonna
     * @return L'elemento in una posizione specifica
     */
    public double at(int row, int column) {
        if (outOfRange(row, getNumRows()))
            throw new RuntimeException("Illegal row index: " + row + "out of bounds 0 - " + getNumRows());
        if (outOfRange(column, getNumRows()))
            throw new RuntimeException("Illegal column index: " + column + "out of bounds 0 - " + getNumColumns());
        return get(row, column);
    }

    /**
     * Ritorna la riga della matrice in una posizione specifica
     * @param row Indice della riga
     * @return La collezione degli elementi della riga specificata nella matrice
     */
    public double[] getRow(int row) {
        if (outOfRange(row, getNumRows()))
            throw new RuntimeException("Illegal row index: " + row + "out of bounds 0 - " + getNumRows());
        return matrix[row];
    }

    /**
     * Sostituisce gli elementi, in una riga specifica della matrice, con nuovi elementi
     * @param elements Collezione di elementi da inserire
     * @param row Indice della riga
     */
    public void setRow(double[] elements, int row) {
        if (outOfRange(row, getNumRows()))
            throw new RuntimeException("Illegal row index: " + row + "out of bounds 0 - " + getNumRows());
        matrix[row] = elements;
    }

    /**
     * Calcolo del determinante di questa matrice
     * @return Il valore del determinante
     */
    public double determinant() throws MatrixException {
        return determinant(this);
    }

    /**
     * Calcolo del determinante di una matrice
     * @param m Matrice su cui calcolare il determinante
     * @return Il valore del determinante
     * @throws MatrixException Se la matrice non è quadrata
     */
    private double determinant(Matrix m) throws MatrixException {
        int det = 0;
        if (!m.isSquare())
            throw new MatrixException("Illegal matrix type: must be a square matrix");

        if (m.getNumRows() == 1) return m.at(0,0);
        else if (m.getNumRows() == 2) return m.at(0,0) * m.at(1,1) - m.at(1,0) * m.at(0,1);
        else if (m.getNumRows() == 3) return sarrus(m); //Sarrus method
        else {
            //Laplace method
            for (int i = 0; i < m.getNumRows();i++)
                det += Math.pow(-1, 2 + i) * m.at(0,i) * determinant(submatrix(m, 0, i));
            return det;
        }
    }

    /**
     * Calcolo del determinante attraverso il metodo di sarrus per matrici 3x3
     * @param m Matrice su cui bisogna calcolare il determinanate
     * @return Il valore del determinante
     * @throws MatrixException Se la matrice non è quadrata oppure la matrice non è 3x3
     */
    private double sarrus(Matrix m) throws MatrixException {
        if (!m.isSquare()) throw new MatrixException("Illegal matrix type: must be a square matrix");
        if (m.getNumRows() != 3) throw new MatrixException("Illegal Sarrus method: the matrix must be 3x3");
        return (m.at(0,0) * m.at(1,1) * m.at(2,2) + m.at(0,1) * m.at(1,2) * m.at(2,0) + m.at(0,2) * m.at(1,0) * m.at(2,1))
                - (m.at(0,2) * m.at(1,1) * m.at(2,0) + m.at(0,0) * m.at(1,2) * m.at(2,1) + m.at(0,1) * m.at(1,0) * m.at(2,2));
    }

    /**
     * Ottiene una sottomatrice (N-1)x(N-1) a partire da una matrice NxN, eliminando la prima riga e la prima colonna
     * @param m Matrice di partenza da cui ricavare la sottomatrice
     * @return Oggetto matrice corrispondete alla sottomatrice
     */
    public Matrix submatrix(Matrix m){
        return submatrix(m,0,0);
    }

    /**
     * Ottiene una sottomatrice (N-1)x(N-1) a partire da una matrice NxN, eliminando una riga e una colonna
     * @param m Matrice di partenza da cui ricavare la sottomatrice
     * @param rowFix Indice della riga da rimuovere
     * @param columnFix Indice della colonna da rimuovere
     * @return Sottomatrice (N-1)x(N-1)
     */
    public Matrix submatrix(Matrix m, int rowFix, int columnFix){
        if (outOfRange(rowFix, getNumRows()))
            throw new RuntimeException("Illegal row index: " + rowFix + "out of bounds 0 - " + getNumRows());
        if (outOfRange(columnFix, getNumRows()))
            throw new RuntimeException("Illegal column index: " + columnFix + "out of bounds 0 - " + getNumColumns());
        if (m.getNumRows() < 2 && m.getNumColumns() < 2)
            throw new RuntimeException("Illegal submatrix: you cannot extract a submatrix from a 1x1 matrix");


        int k = 0, max = Math.min(m.getNumRows(), m.getNumColumns());
        double[] array = new double[(int) Math.pow(max - 1, 2)];
        for (int i = 0; i < m.getNumRows(); i++) {
            for (int j = 0; j < m.getNumColumns(); j++) {
                if (i != rowFix && j != columnFix) {
                    array[k] = m.at(i,j);
                    k++;
                }
            }
        }
        return toMatrix(array);
    }

    /**
     * Crea una matrice copia di una matrice
     * @param m Matrice da copiare
     * @return Nuova matrice copiata
     */
    public Matrix copy(Matrix m){
        double[][] matrix = new double[m.getNumRows()][m.getNumColumns()];
        for (int i = 0; i < m.getNumRows(); i++){
            for (int j = 0; j < m.getNumColumns(); j++){
                matrix[i][j] = m.at(i,j);
            }
        }
        return new Matrix(matrix);
    }

    /**
     * Controlla se questa e un'altra matrice hanno lo stesso numero di righe
     * @param other Matrice da confrontare
     * @return {@code true} Se e solo se le due matrici hanno lo stesso numero di righe;
     *        Altrimenti {@code false}.
     */
    public boolean hasEqualsRows(Matrix other){
        return this.getNumRows() == other.getNumRows();
    }

    /**
     * Controlla se questa e un'altra matrice hanno lo stesso numero di colonne
     * @param other Matrice da confrontare
     * @return {@code true} Se e solo se le due matrici hanno lo stesso numero di colonne;
     *        Altrimenti {@code false}.
     */
    public boolean hasEqualsColumns(Matrix other){
        return this.getNumColumns() == other.getNumColumns();
    }

    /**
     * Controlla se questa eun'altra matrice sono dello stesso ordine,
     * ovvero hanno lo stesso numero di righe e colonne
     * @param other Matrice da confrontare
     * @return {@code true} Se e solo se le due matrici hanno lo stesso numero di righe e colonne;
     *         Altrimenti {@code false}.
     */
    public boolean hasEqualsOrder(Matrix other){
        return hasEqualsRows(other) && hasEqualsColumns(other);
    }


    /**
     * Conta i pivot in questa matrice. Un pivot è un'elemento della matrice
     * ed è definito tale se nella riga i-esima è il primo elemento non nullo
     * @return Il numero totale di pivot
     */
    private int countPivots(){
        int count = 0;
        for (int i = 0; i < getNumRows(); i++)
            for (int j = 0; j < getNumColumns(); j++)
                if (at(i,j) != 0){
                    count++;
                    break;
                }
        return count;
    }


    /**
     * Metodo per calcolare il rango di questa matrice attraverso
     * l'algoritmo di eliminazione gaussiana
     * @return Il rango della matrice
     */
    public int rank(){
        if (isNull()) return 0;
        return scale().countPivots();
    }



    /**
     * Riduce a scala questa matrice attraverso l'utilizzo del metodo di eliminazione di Gauss
     * @return La matrice in forma scala
     */
    public Matrix scale(){
        return scale(copy(this));
    }

    /**
     * Riduce a scala una matrice attraverso l'utilizzo del metodo di eliminazione di Gauss
     * @param m Matrice da risolvere
     * @return La matrice in forma scala
     */
    private Matrix scale(Matrix m){
        double[] a, b, ris;
        int pivotColumn, rowstart = 0;

        m.ordPivots();
        while (!m.isScale()) {
            for (int i = rowstart; i < m.getNumRows() - 1; i++){
                m.ordPivots();

                pivotColumn = m.getPivotColum(i);

                //Se pivotColumn == m.getNumColumns() allora riga nulla senza pivot
                if (pivotColumn < m.getNumColumns()){
                    for (int k = i + 1; k < m.getNumRows(); k++) {
                        if (m.at(k, pivotColumn) != 0) {
                            a = m.getRow(k);
                            b = Matrix.multiply(m.getRow(i), m.at(k, pivotColumn) / m.at(i, pivotColumn));
                            ris = Matrix.minus(a, b);
                            m.setRow(ris, k);
                        }
                    }
                }
            }
            rowstart++;
        }
        return m;
    }

    /**
     * Cerca il pivot in una riga specifica della matrice, ritorna l'indice della colonna
     * del primo elemento non nullo, altrimenti se la riga è nulla (tutti gli elementi sono
     * pari a 0) ritorna il numero di colonne totali.
     * Ciò rappresenta la posizione o il "peso" della colonna del pivot nell'algoritmo di ordinamento
     * @param row Indice della riga in cui cercare il pivot
     * @return Ritorna l'indice della colonna del pivot nella riga specificata
     */
    private int getPivotColum(int row){
        for (int j = 0; j < getNumColumns(); j++)
            if (at(row, j) != 0) return j;
        return getNumColumns(); //riga nulla
    }

    /**
     * Controlla se ogni pivot nella riga i-esima, con i > 1, si trova nella colonna successiva al precedente;
     * @return {@code true} Se e solo se, ogni pivot nella riga i-esima, con i > 1,
     *         si trova nella colonna successiva al precedente;
     *         Altrimenti {@code false}.
     */
    private boolean pivotsAreScaled(){
        ArrayList<Integer> pivotsColumn = getAllPivotsColumn();
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < i; j++)
                if (pivotsColumn.get(i) >= pivotsColumn.get(j))
                    return false;
        }
        return true;
    }

    /**
     * Ritorna una lista contenente gli indici delle colonne di ciascun pivot della matrice
     * @return Ritorna una lista contenente lgli indici delle colonne di ciascun pivot della matrice
     */
    private ArrayList<Integer> getAllPivotsColumn(){
        ArrayList<Integer> pivotsColumn = new ArrayList<>();
        for (int i = 0; i < getNumRows(); i++)  pivotsColumn.add(getPivotColum(i));
        return pivotsColumn;
    }

    /**
     * Ordina la matrice in base alle colonne dei pivot, se P1(x,y), P2(z,h) e y >= h allora vengono scambiate le righe
     * @return Ordina la matrice in base alle colonne dei pivot
     */
    private Matrix ordPivots(){
        ArrayList<Integer> pivotsColumn = getAllPivotsColumn();
        int tmp;
        boolean sort;
        do {
            sort = true;
            for(int i = 0; i < getNumRows() - 1; i++)
                if(pivotsColumn.get(i) > pivotsColumn.get(i + 1)) {
                    tmp = pivotsColumn.get(i);
                    pivotsColumn.set(i, pivotsColumn.get(i + 1));
                    pivotsColumn.set(i + 1, tmp);
                    Matrix.swap(this, i, i + 1);
                    sort = false;
                }
        } while (!sort);
        return this;
    }


    /**
     * Somma questa matrice ad un'altra, se e solo se sono dello stesso ordine,
     * ovvero hanno lo stesso numero di righe e colonne
     * @param other Matrice da sommare a questa
     * @return Matrice somma
     */
    public Matrix sum(Matrix other){
        if (!hasEqualsOrder(other))
            throw new RuntimeException("Illegal matrices length: the matricies aren't the same type");

        double[][] matrix = new double[this.getNumRows()][this.getNumColumns()];
        for (int i = 0; i < this.getNumRows(); i++)
            for (int j = 0; j < this.getNumColumns(); j++)
                matrix[i][j] = this.at(i,j) + other.at(i,j);

        return new Matrix(matrix);
    }

    /**
     * Somma tutti gli elementi della matrice con uno scalare
     * @param scalar Lo scalare da sommare a tutti gli elementi della matrice
     * @return Matrice sommata allo scalare
     */
    public Matrix sum(double scalar){
        double[][] matrix = new double[getNumRows()][getNumColumns()];
        for (int i = 0; i < getNumRows(); i++)
            for (int j = 0; j < getNumColumns(); j++)
                matrix[i][j] = at(i,j) + scalar;

        return new Matrix(matrix);
    }

    /**
     * Esegue la sottrazione tra gli elementi di questa matrice con uno scalare
     * @param scalar Lo scalare da sottrarre agli elementi della matrice
     * @return Matrice differenza con lo scalare
     */
    public Matrix diff(double scalar){
        double[][] matrix = new double[getNumRows()][getNumColumns()];
        for (int i = 0; i < getNumRows(); i++)
            for (int j = 0; j < getNumColumns(); j++)
                matrix[i][j] = at(i,j) - scalar;

        return new Matrix(matrix);
    }

    /**
     * Esegue la sottrazione tra questa matrice ed un'altra, se e solo se sono dello stesso ordine,
     * ovvero hanno lo stesso numero di righe e colonne
     * @param other Matrice da sottrarre a questa
     * @return Matrice differenza
     */
    public Matrix diff(Matrix other){
        if (!hasEqualsOrder(other))
            throw new RuntimeException("Illegal matrices length: the matricies aren't the same type");
        double[][] matrix = new double[this.getNumRows()][this.getNumColumns()];
        for (int i = 0; i < this.getNumRows(); i++)
            for (int j = 0; j < this.getNumColumns(); j++)
                matrix[i][j] = this.at(i,j) - other.at(i,j);

        return new Matrix(matrix);
    }


    /**
     * Ritorna la matrice trasposta, le righe diventano le colonne e viceversa.
     * Elemento della matrice Aij viene trasposto in posizione Aji
     * @return Ritorna la matrice trasposta
     */
    public Matrix transposed(){
        double[][] matrix = new double[getNumRows()][getNumColumns()];
        for (int i = 0; i < getNumRows(); i++){
            for (int j = 0; j < getNumColumns(); j++){
                matrix[i][j] = at(j,i);
            }
        }
        return new Matrix(matrix);
    }

    /**
     * Calcola la matrice inversa di questa matrice se e solo se,
     * il suo determinante è diverso da 0
     * @return Matrice inversa di questa matrice
     * @throws MatrixException Se la matrice non è quadrata oppure ha determinate uguale a 0
     */
    public Matrix inverse() throws MatrixException {
        double det = determinant();
        if (!isSquare())
            throw new MatrixException("Illegal matrix type: must be a square matrix");
        if (det == 0)
            throw new MatrixException("Illegal determinant: must be not equals to 0");

        Matrix mCofactors = cofactors(transposed());
        double[][] matrix = new double [getNumRows()][getNumColumns()];
        for (int i = 0; i < getNumRows(); i++){
            for (int j = 0; j < getNumColumns(); j++){
                matrix[i][j] = mCofactors.at(j,i) / det;
            }
        }
        return new Matrix(matrix);
    }

    /**
     * Calcola la matrice dei complementi algebrici (o cofattori) degli elementi
     * di una matrice. Un cofattore è identificato dalla formula -(1)^i+j * det(Bij),
     * ovvero dal determinante della sottomatrice Bij e dal simbolo '+' se la somma
     * degli indici i e j è pari, '-' invece se è dispari.
     * Il calcolo dei complementi algebrici di una matrice serve per poter calcolare
     * la matrice inversa di una matrice quadrata con determinante diverso da 0
     * @param m Matrice di partenza
     * @return Matrice contenente i cofattori della matrice di partenza
     * @throws MatrixException Se la matrice non è quadrata
     */
    public Matrix cofactors(Matrix m) throws MatrixException {
        if (!m.isSquare())
            throw new MatrixException("Illegal matrix type: must be a square matrix");

        double[][] matrix = new double[m.getNumRows()][m.getNumColumns()];
        for (int i = 0; i < m.getNumRows(); i++){
            for (int j = 0; j < m.getNumColumns(); j++){
                matrix[j][i] = Math.pow(-1, (i+1) + (j+1)) * m.determinant(m.submatrix(m, i, j));
            }
        }
        return new Matrix(matrix);
    }

    /**
     * Prodotto righe per colonne : moliplica questa matrice MxN con un'altra,
     * se e solo se quest'ultima ha dimensione NxK.
     * Ogni elemento del prodotto è ottenuto mendiante Aik * Bkj
     * @param other Matrice NxK da moltipliacre a questa
     * @return La matrice risultante dal prodotto righe per colonne
     */
    public Matrix multiply(Matrix other){
        if(this.getNumColumns() != other.getNumRows())
            throw new RuntimeException("Illegal product rows by columns: the number of rows and columns are not equals " + this.getNumColumns() + " != " + other.getNumRows());

        double[][] matrix = new double[this.getNumRows()][other.getNumColumns()];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                for (int k = 0; k < matrix.length; k++) {
                    matrix[i][j] += this.at(i, k) * other.at(k, j);
                }
            }
        }
        return new Matrix(matrix);
    }

    /**
     * Controlla se la matrice è quadrata
     * @return {@code true} Se e solo se, la matrice ha
     *          il numero di righe uguale al numero di colonne;
     *          Altrimenti {@code false}.
     */
    public boolean isSquare(){
        return getNumRows() == getNumColumns();
    }

    /**
     * Controlla se la matrice è triangolare superiore o inferiore
     * @return {@code true} Se la matrice è triangolare superiore o inferiore;
     *          Altrimenti {@code false}.
     */
    public boolean isTriangular(){
        return isUpperTriangular() || isLowerTriangular();
    }

    /**
     * Controlla se la matrice è triangolare superiore
     * @return {@code true} Se e solo se, la matrice è quadrata ed l'elemento
     *      *          in posizione (i,j) della matrice è uguale a 0 ed i > j;
     *          Altrimenti {@code false}.
     */
    public boolean isUpperTriangular(){
        if (!isSquare()) return false;
        for (int i = 0; i < getNumRows(); i++)
            for (int j = 0; j < i; j++)
                if (at(i, j) != 0)
                    return false;
        return true;
    }

    /**
     * Controlla se la matrice è triangolare inferiore
     * @return {@code true} Se e solo se, la matrice è quadrata ed l'elemento
     *          in posizione (i,j) della matrice è uguale a 0 ed i < j;
     *          Altrimenti {@code false}.
     */
    public boolean isLowerTriangular(){
        if (!isSquare()) return false;
        for (int i = 0; i < getNumRows(); i++)
            for (int j = i + 1; j < getNumColumns(); j++)
                if (at(i, j) != 0)
                    return false;
        return true;
    }

    /**
     * Controlla se la matrice è diagonale
     * @return {@code true} Se e solo se, ogni elemento della diagonale
     *          principale, in posizione i = j, è diverso da 0, mentre
     *          dove i != j, è uguale a 0;
     *          Altrimenti {@code false}.
     */
    public boolean isDiagonal(){
        if (!isSquare()) return false;
        for (int i = 0; i < getNumRows(); i++)
            for (int j = 0; j < getNumColumns(); j++)
                if (i == j && at(i, j) == 0) return false;
                else if (i != j && at(i, j) != 0) return false;

        return true;
    }

    /**
     * Controlla se la matrice è nulla
     * @return {@code true} Se e solo se, ogni elemento della matrice è uguale a 0;
     *          Altrimenti {@code false}.
     */
    public boolean isNull(){
        for (double[] row: matrix)
            for (double element: row)
                if (element != 0) return false;
        return true;
    }

    /**
     * Controlla se la matrice è identità
     * @return {@code true} Se e solo se, ogni elemento della diagonale
     *          principale, in posizione i = j, è uguale a 1, mentre
     *          dove i != j, è uguale a 0;
     *          Altrimenti {@code false}.
     */
    public boolean isIdentity(){
        if (!isSquare()) return false;
        for (int i = 0; i < getNumRows(); i++)
            for (int j = 0; j < getNumColumns(); j++)
                if (i != j && at(i, j) != 0) return false;
                else if (i == j && at(i,j) != 1) return false;

        return true;
    }

    /**
     * Controlla se la matrice è ridotta a scala
     * @return {@code true} Se e solo se, tutti gli elementi sotto ogni pivot della matrice
     *          (primo elememto non nullo della riga i-esima) sono uguali a 0 e ogni pivot
     *          nella riga i-esima, con i > 1, si trova nella colonna successiva al precedente;
     *          Altrimenti {@code false}.
     */
    public boolean isScale(){
        return zerosUnderPivots() || pivotsAreScaled();
    }

    /**
     * Controlla se sotto ogni pivot ci sono solo zeri
     * @return {@code true} Se e solo se, identificato il pivot nella riga
     *          i-esima e colonna j-esima, a partire dall'elemento i+1j,
     *          tutti gli elementi nella stessa colonna sono pari a 0;
     *          Altrimenti {@code false} se c'è anche solo un numero diverso da 0.
     */
    private boolean zerosUnderPivots(){
        for (int i = 0; i < getNumRows(); i++){
            for (int j = 0; j < getNumColumns(); j++){
                if (at(i,j) != 0){
                    for (int k = i + 1; k < getNumRows(); k++)
                        if (at(k, j) != 0)
                            return false;
                    break;
                }
            }
        }
        return true;
    }

    /**
     * Ripopola la matrice con elementi identificabili nell'intervallo (MIN_RAND_VALUE =< x && x < MAX_RAND_VALUE)
     * @return Questa matrice ripopolata in modo randomico
     */
    public Matrix random(){
        matrix = Matrix.random(getNumRows(), getNumColumns());
        return this;
    }

    /**
     * Ritorna una stringa che rappresenta graficamente in una signola linea la matrice, contiene la rappresentazione String di ogni elemento
     * @return Rappresentazione String della matrice
     */
    public String toLineString(){
        String s = "";
        for (int i = 0; i < getNumRows(); i++){
            s += "{";
            for (int j = 0; j < getNumColumns(); j++) {
                s += Math.ceil(at(i,j)*100)/100 + "";
                if (j != getNumColumns() - 1) s += ",";
            }
            s += "}";
            if (i != getNumRows() - 1) s += ",";
        }
        return s;
    }

    /**
     * Ritorna una stringa che rappresenta graficamente in forma tabellare la matrice, contiene la rappresentazione String di ogni elemento
     * @return Rappresentazione String della matrice
     */
    public String toString(){
        String s = "\n";
        for (double[] array: matrix){
            for (double x: array) {
                s += Math.ceil(x*100)/100 + "  ";
            }
            s += "\n";
        }
        return s;
    }


    /**
     * Genera in modo randomico una matrice di NxM elementi con valori nell'intervallo (MIN_RAND_VALUE =< x && x < MAX_RAND_VALUE)
     * @param N Numero di righe
     * @param M Numero di colonne
     * @return Matrice di double generata randomicamente
     */
    public static double[][] random(int N, int M){
        Random rand = new Random();
        double[][] matrix = new double[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                matrix[i][j] = rand.nextInt(MAX_RAND_VALUE - MIN_RAND_VALUE) + MIN_RAND_VALUE;
        return matrix;
    }

    /**
     * Genera in modo randomico un oggetto Matrice di NxM elementi con valori nell'intervallo (MIN_RAND_VALUE =< x && x < MAX_RAND_VALUE)
     * @param N Numero di righe
     * @param M Numero di colonne
     * @return Oggetto Matrix generato in modo randomico
     */
    public static Matrix randMatrix(int N, int M){
        return new Matrix(random(N, M));
    }

    /**
     * Trasforma un vettore di lunghezza N, in una matrice √N x √N
     * @param array Vettore da convertire in matrice
     * @return Matrice corrispondente alla conversione del vettore
     */
    public static Matrix toMatrix(double[] array){
        int n = (int) Math.sqrt(array.length), k = 0;
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                matrix[i][j] = array[k];
                k++;
            }
        }
        return new Matrix(matrix);
    }

    /**
     * Moltiplica un ogni elemento di un vettore con uno scalare
     * @param row Vettore
     * @param c Scalara
     * @return Il vettore moltiplicato allo scalare
     */
    public static double[] multiply(double[] row, double c){
        double[] array = new double[row.length];
        for (int i = 0; i < row.length; i++) array[i] = row[i] * c;
        return array;
    }

    /**
     * Esegue la sottrazione tra due vettori se e solo se hanno la stessa lunghezza
     * @param elements1 Vettore minuendo dell'operazione
     * @param elements2 Vettore sottraendo dell'operazione
     * @return Il vettore differenza
     */
    public static double[] minus(double[] elements1, double[] elements2){
        if (elements1.length != elements2.length)
            throw new RuntimeException("Illegal array length: the two lengths must be equals");
        double[] array = new double[elements1.length];
        for (int i = 0; i < array.length; i++) array[i] = elements1[i] - elements2[i];
        return array;
    }

    /**
     * Scambia due righe di una matrice
     * @param m Matrice su cui scambiare le righe
     * @param a Primo indice
     * @param b Secondo indice
     * @return La matrice con le righe scambiate
     */
    public static Matrix swap(Matrix m, int a, int b){
        double[] tmp = m.getRow(a);
        m.setRow(m.getRow(b), a);
        m.setRow(tmp, b);
        return m;
    }
}
