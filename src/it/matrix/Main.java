package it.matrix;
import it.matrix.exception.MatrixException;

public class Main {
    public static void main(String[] args) {
        double[][] matrix = {{0.0,1.0,0.0,0.0},{0.0,1.0,1.0,1.0},{1.0,1.0,1.0,1.0},{0.0,1.0,0.0,0.0}};
        Matrix m = new Matrix(matrix);
        m = new Matrix(3,3, true);


        System.out.println();
        System.out.println("A                  \t: " + m.toLineString());
        System.out.println("A Scala            \t: " + m.scale().toLineString());
        try {
            System.out.println("A Inversa          \t: " + m.inverse().toLineString());
        } catch (MatrixException e) {
            System.out.println("A Inversa          \t: " + e.getMessage());
        }
        try {
            System.out.println("A Cofattori        \t: " + m.cofactors(m).toLineString());
        } catch (MatrixException e) {
            System.out.println("A Cofattori        \t: " + e.getMessage());
        }
        try {
            System.out.println("A * A Inversa      \t: " + m.multiply(m.inverse()).toLineString());
        } catch (MatrixException e) {
            System.out.println("A * A Inversa      \t: " + e.getMessage() );
        }
        try {
            System.out.println("Determinante       \t: " + m.determinant());
        } catch (MatrixException e) {
            System.out.println("Determinante       \t: " + e.getMessage());
        }

        System.out.println("Scala              \t: " + m.isScale());
        System.out.println("Diagonale          \t: " + m.isDiagonal());
        System.out.println("Identità           \t: " + m.isIdentity());
        System.out.println("Nulla              \t: " + m.isNull());
        System.out.println("Triang. Superiore  \t: " + m.isUpperTriangular());
        System.out.println("Triang. Inferiore  \t: " + m.isLowerTriangular());
    }
}
