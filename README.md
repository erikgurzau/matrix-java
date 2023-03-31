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
```

È anche possibile inizializzare una matrice con valori predefiniti utilizzando il costruttore `Matrix` che accetta un array bidimensionale:

```java
double[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
Matrix matrix = new Matrix(values);
```

### Operazioni tra matrici

Per eseguire un'operazione tra matrici, è possibile utilizzare i metodi della classe `Matrix`. Ad esempio, per sommare due matrici:

```java
Matrix matrixA = new Matrix(2, 2);
Matrix matrixB = new Matrix(2, 2);
Matrix sum = matrixA.add(matrixB);
```

### Trasposizione di una matrice

Per ottenere la trasposta di una matrice, è possibile utilizzare il metodo `transpose`:

```java
Matrix matrix = new Matrix(2, 3);
Matrix transpose = matrix.transpose();
```

### Calcolo del determinante

Per calcolare il determinante di una matrice quadrata, è possibile utilizzare il metodo `determinant`:

```java
double[][] values = {{1, 2}, {3, 4}};
Matrix matrix = new Matrix(values);
double determinant = matrix.determinant();
```

### Riduzione a scala
Per ridurre a scala una matrice attraverso l'utilizzo del metodo di Eliminazione di Gauss, è possibile utilizzare il metodo `scale`:

```java
double[][] values = {{1, 2}, {3, 4}};
Matrix matrix = new Matrix(values);
Matrix matrixScalex = matrix.scale(matrix);
```

### Risoluzione di un sistema di equazioni lineari

Per risolvere un sistema di equazioni lineari rappresentato come una matrice, è possibile utilizzare il metodo `solve`:

```java
double[][] coefficients = {{2, 1}, {1, 1}};
double[] constants = {4, 3};
Matrix matrix = new Matrix(coefficients);
Matrix constantsMatrix = new Matrix(constants, 2);
Matrix solution = matrix.solve(constantsMatrix);
```

## Contribuire

Ogni contributi sotto forma di segnalazione di bug, correzione di bug, miglioramenti della documentazione o suggerimenti per nuove features sono ben accetti.

### Come fare?

Questo repository è aperto alle contribuzioni degli sviluppatori esterni. Se sei interessato a contribuire al progetto, segui le istruzioni riportate di seguito:

1. Forka il repository: Per contribuire a un repository GitHub, devi prima creare una copia del repository originale sul tuo account GitHub personale. Puoi fare ciò utilizzando il pulsante "Fork" presente nella pagina del repository.

2. Clona il repository: Dopo aver effettuato il fork del repository, devi clonare la tua copia del repository sul tuo computer. Puoi farlo utilizzando il comando `git clone` e l'URL del repository che hai appena creato.

3. Crea un nuovo branch: Prima di apportare modifiche al codice, è importante creare un nuovo branch per le tue modifiche. In questo modo, potrai lavorare sulle tue modifiche senza intaccare il codice originale. Puoi creare un nuovo branch utilizzando il comando `git checkout -b nome_del_nuovo_branch`.

4. Effettua le modifiche: Ora puoi apportare le modifiche al codice. Assicurati di seguire le linee guida del repository, inclusi i formati dei file, le convenzioni di denominazione, le regole di stile e le linee guida generali del progetto.

5. Fai il commit delle modifiche: Dopo aver apportato le modifiche al codice, è importante effettuare il commit delle modifiche al branch corrente. Puoi farlo utilizzando il comando `git add .` per aggiungere tutti i file modificati e il comando `git commit -m "messaggio del commit"` per effettuare il commit delle modifiche.

6. Pusha il branch modificato: Dopo aver effettuato il commit delle modifiche, puoi pushare il branch modificato sul tuo repository GitHub. Puoi farlo utilizzando il comando `git push origin nome_del_nuovo_branch`.

7. Crea una pull request: Dopo aver pushato il branch modificato sul tuo repository GitHub, puoi creare una pull request per richiedere l'integrazione delle tue modifiche nel repository originale. Puoi farlo utilizzando il pulsante "Create Pull Request" nella pagina del repository.

8. Attendi il feedback: Dopo aver creato la pull request, gli amministratori del repository originale valuteranno le tue modifiche e potranno richiedere eventuali modifiche o chiarimenti. Assicurati di monitorare la tua pull request e di rispondere prontamente alle eventuali richieste.


## Licenza

`matrix-java` è rilasciato sotto la licenza MIT. Leggere il file LICENSE per maggiori informazioni.


