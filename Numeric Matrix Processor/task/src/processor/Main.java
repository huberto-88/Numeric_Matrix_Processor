package processor;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double[][] matrixA;
        double[][] matrixB;

        //MENU:
        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("0. Exit");
            System.out.println("Your choice: ");

            String choice = scanner.nextLine();
            int rows;
            int cols;

            switch (choice) {
                case "1": {
                    System.out.println("Enter size of first matrix: ");
                    rows = scanner.nextInt();
                    cols = scanner.nextInt();
                    System.out.println("Enter first matrix: ");
                    matrixA = readInputMatrix(rows, cols);

                    System.out.println("Enter size of second matrix: ");
                    rows = scanner.nextInt();
                    cols = scanner.nextInt();
                    System.out.println("Enter second matrix: ");
                    matrixB = readInputMatrix(rows, cols);

                    try {
                        displayMatrix(Operation.add(matrixA, matrixB));
                    } catch (Error error) {
                        System.out.println(error.getMessage());
                    }
                }
                break;
                case "2": {
                    System.out.println("Enter size of matrix: ");
                    rows = scanner.nextInt();
                    cols = scanner.nextInt();
                    System.out.println("Enter constant: ");
                    matrixA = readInputMatrix(rows, cols);
                    int scalar = scanner.nextInt();
                    System.out.println("Enter matrix: ");
                    Operation.multiplyByScalar(matrixA, scalar);
                    displayMatrix(matrixA);
                }
                break;
                case "3": {
                    System.out.println("Enter size of first matrix: ");
                    rows = scanner.nextInt();
                    cols = scanner.nextInt();
                    System.out.println("Enter first matrix: ");
                    matrixA = readInputMatrix(rows, cols);

                    System.out.println("Enter size of second matrix: ");
                    rows = scanner.nextInt();
                    cols = scanner.nextInt();
                    System.out.println("Enter second matrix: ");
                    matrixB = readInputMatrix(rows, cols);

                    try {
                        displayMatrix(Operation.multiplyMatrices(matrixA, matrixB));
                    } catch (Error error) {
                        System.out.println(error.getMessage());
                    }
                }
                break;
                case "4": {
                    {
                        try {
                            displayMatrix(transposeMatrix());
                        } catch (Error error) {
                            System.out.println(error.getMessage());
                        }
                    }
                }
                break;
                case "5": {
                    System.out.println("Enter size of first matrix: ");
                    rows = scanner.nextInt();
                    cols = scanner.nextInt();
                    System.out.println("Enter first matrix: ");
                    matrixA = readInputMatrix(rows, cols);

                    System.out.println("The result is:");
                    System.out.println(Operation.calculateDeterminant(matrixA));
                    System.out.println("The result is:");
                    displayMatrix(Operation.inverseMatrix(matrixA));
                }
                break;
                case "6": {
                    System.out.println("6. Inverse matrix");
                    rows = scanner.nextInt();
                    cols = scanner.nextInt();
                    System.out.println("Enter first matrix: ");
                    matrixA = readInputMatrix(rows, cols);


                }
                break;
                case "0": {
                    System.exit(0);
                }
                break;
            }
        }
    }


    public static double[][] transposeMatrix() throws Error {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");

        System.out.println("Your choice:");
        String choice = new Scanner(System.in).next();

        System.out.println("Enter matrix size: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        double[][] matrix = readInputMatrix(rows, cols);

        switch (choice) {
            case "1":
                return Operation.mainDiagonal(matrix);
            case "2":
                return Operation.sideDiagonal(matrix);
            case "3":
                return Operation.verticalLine(matrix);
            case "4":
                return Operation.horizontalLine(matrix);
        }
        throw new Error("jakis blad");
    }

    private static void displayMatrix(double[][] matrix) {
        System.out.println("The result is:");
        for (double[] mm : matrix) {
            for (double m : mm) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }

    private static double[][] readInputMatrix(int rows, int columns) {
        scanner.nextLine();     // necessary to consume new line sign because Scanner is shit

        double[][] matrix = new double[rows][columns];

        for(int i = 0; i < rows; i++) {
            String[] items = scanner.nextLine().split("\\s+");
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = Double.parseDouble(items[j]);
            }
        }
        return matrix;
    }

}