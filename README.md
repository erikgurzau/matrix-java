# Matrix Java

`matrix-java` is a Java library for manipulating matrices.

## Features

The library offers the following features:

- Creation of empty or initialised matrices with predefined values
- Mathematical operations between matrices, such as addition and multiplication
- Transposition of matrices
- Calculating the determinant of square matrices
- Solving systems of linear equations represented as matrices

## Utilisation

### Creating a matrix

To create a matrix, you can use the `Matrix` constructor and pass the dimensions of the matrix as parameters:

```java
Matrix matrix = new Matrix(3, 3);
```

You can also initialise a matrix with predefined values using the `Matrix` constructor, which accepts a two-dimensional array:

```java
double[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
Matrix matrix = new Matrix(values);
```

### Operations between matrices

To perform an operation between matrices, you can use the methods of the `Matrix` class. For example, to sum two matrices:

```java
Matrix matrixA = new Matrix(2, 2);
Matrix matrixB = new Matrix(2, 2);
Matrix sum = matrixA.add(matrixB);
```

### Transposing a matrix

To obtain the transpose of a matrix, you can use the `transpose` method:

```java
Matrix matrix = new Matrix(2, 3);
Matrix transpose = matrix.transpose();
```

### Calculating the determinant

To calculate the determinant of a square matrix, you can use the `determinant` method:

```java
double[][] values = {{1, 2}, {3, 4}};
Matrix matrix = new Matrix(values);
double determinant = matrix.determinant();
```

### Scaling
To reduce a matrix to scale using the Gauss elimination method, the `scale` method can be used:

```java
double[][] values = {{1, 2}, {3, 4}};
Matrix matrix = new Matrix(values);
Matrix matrixScalex = matrix.scale(matrix);
```

### Solving a system of linear equations

To solve a system of linear equations represented as a matrix, you can use the ``solve`` method:

```java
double[][] coefficients = {{2, 1}, {1, 1}};
double[] constants = {4, 3};
Matrix matrix = new Matrix(coefficients);
Matrix constantsMatrix = new Matrix(constants, 2);
Matrix solution = matrix.solve(constantsMatrix);
```

## Contribute

Any contributions in the form of bug reports, bug fixes, documentation improvements or suggestions for new features are welcome.

### How?

This repository is open for contributions from external developers. If you are interested in contributing to the project, please follow the instructions below:

1. Fork the repository: To contribute to a GitHub repository, you must first create a copy of the original repository on your personal GitHub account. You can do this by using the 'Fork' button on the repository page.

2. Clone the repository: After you fork the repository, you need to clone your copy of the repository on your computer. You can do this using the `git clone` command and the URL of the repository you just created.

3. Create a new branch: Before making changes to your code, it is important to create a new branch for your changes. This way, you can work on your changes without affecting the original code. You can create a new branch using the command `git checkout -b new_branch_name`.

4. Make changes: You can now make changes to the code. Make sure you follow the guidelines of the repository, including file formats, naming conventions, style rules and general project guidelines.

5. Commit changes: After making changes to the code, it is important to commit the changes to the current branch. You can do this by using the command `git add .` to add all the changed files and the command `git commit -m "commit message"` to commit the changes.

6. Pusha the modified branch: After committing the changes, you can push the modified branch to your GitHub repository. You can do this by using the command `git push origin_name_of_the_new_branch`.

7. Create a pull request: After pushing the modified branch to your GitHub repository, you can create a pull request to request the integration of your changes into the original repository. You can do this by using the 'Create Pull Request' button on the repository page.

8. Wait for feedback: After you have created the pull request, the administrators of the original repository will evaluate your changes and may request changes or clarifications. Be sure to monitor your pull request and respond promptly to any requests.


## Licence

`matrix-java` is released under the MIT licence. Please read the LICENSE file for more information.
