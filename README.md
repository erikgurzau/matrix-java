# Matrix Java

`matrix-java` è una libreria Java per la manipolazione di matrici.

## Caratteristiche

La libreria offre le seguenti funzionalità:

- Creazione di matrici vuote o inizializzate con valori predefiniti
- Operazioni matematiche tra matrici, come l'addizione e la moltiplicazione
- Trasposizione di matrici
- Calcolo del determinante di matrici quadrate
- Risoluzione di sistemi di equazioni lineari rappresentati come matrici

## Utilizzo

### Creazione di una matrice

Per creare una matrice, è possibile utilizzare il costruttore `Matrix` e passare le dimensioni della matrice come parametri:

```java
Matrix matrix = new Matrix(3, 3);
'''

È anche possibile inizializzare una matrice con valori predefiniti utilizzando il costruttore `Matrix` che accetta un array bidimensionale:

```java
double[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
Matrix matrix = new Matrix(values);
'''

### Operazioni tra matrici

Per eseguire un'operazione tra matrici, è possibile utilizzare i metodi della classe `Matrix`. Ad esempio, per sommare due matrici:

```java
Matrix matrixA = new Matrix(2, 2);
Matrix matrixB = new Matrix(2, 2);
Matrix sum = matrixA.add(matrixB);
'''

### Trasposizione di una matrice

Per ottenere la trasposta di una matrice, è possibile utilizzare il metodo `transpose`:

```java
Matrix matrix = new Matrix(2, 3);
Matrix transpose = matrix.transpose();
'''

### Calcolo del determinante

Per calcolare il determinante di una matrice quadrata, è possibile utilizzare il metodo `determinant`:

```java
double[][] values = {{1, 2}, {3, 4}};
Matrix matrix = new Matrix(values);
double determinant = matrix.determinant();
'''

### Risoluzione di un sistema di equazioni lineari

Per risolvere un sistema di equazioni lineari rappresentato come una matrice, è possibile utilizzare il metodo `solve`:

```java
double[][] coefficients = {{2, 1}, {1, 1}};
double[] constants = {4, 3};
Matrix matrix = new Matrix(coefficients);
Matrix constantsMatrix = new Matrix(constants, 2);
Matrix solution = matrix.solve(constantsMatrix);
'''

## Contribuire

Ogni contributi sotto forma di segnalazione di bug, correzione di bug, miglioramenti della documentazione o suggerimenti per nuove features sono ben accetti. Esegui una fork ed inviare una pull request o aprire un issue per iniziare la discussione.

## Licenza

`matrix-java` è rilasciato sotto la licenza MIT. Leggere il file LICENSE per maggiori informazioni.


