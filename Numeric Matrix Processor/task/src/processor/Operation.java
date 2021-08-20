package processor;

public class Operation {

    public static double[][] add(double[][] matrixA, double[][] matrixB) throws Error {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            throw new Error("The operation cannot be performed.");
        } else {
            double[][] sumMatrix = new double[matrixA.length][matrixA[0].length];

            for (int i = 0; i < matrixA.length ; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            return sumMatrix;
        }
    }

    public static void multiplyByScalar(double[][] matrix, double constant) {
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] *= constant;
            }
        }
        System.out.println("The result is:");
    }

    public static double[][] multiplyMatrices(double[][] matrixA, double[][] matrixB) throws Error {
        if (matrixA[0].length != matrixB.length) {
            throw new Error("The operation cannot be performed.");
        }

        double[][] answer = new double[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    answer[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return answer;
    }


    public static double[][] mainDiagonal(double[][] matrix) {
        double answer[][] = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer[j][i] = matrix[i][j];
            }
        }
        return answer;
    }

    public static double[][] sideDiagonal(double[][] matrix) {
        double answer[][] = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer[j][i] = matrix[matrix.length - 1 - i][matrix[0].length - 1 - j];
            }
        }
        return answer;
    }

    public static double[][] verticalLine(double[][] matrix) {
        double answer[][] = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer[i][j] = matrix[i][matrix[i].length - 1 - j];
            }
        }
        return answer;
    }

    public static double[][] horizontalLine(double[][] matrix) {
        double answer[][] = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer[i][j] = matrix[matrix[i].length - 1 - i][j];
            }
        }
        return answer;
    }

    public static double calculateDeterminant(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //MATRIX 1 element
        if (rows == 1 && cols == 1) {
            return matrix[0][0];
        }

        //MATRIX 2X2
        if (rows == 2 && cols == 2) {
            return determinantOf2X2(matrix);
        }

        return laplaceExpand(matrix);
    }


    private static double determinantOf2X2(double[][] matrix) {
        return matrix[0][0] * matrix[1][1]
                - matrix[1][0] * matrix[0][1];
    }


    private static double laplaceExpand(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double det = 0;

        if (rows == 3 && cols == 3) {
            return (matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[2][1] * matrix[1][2])
                    + ( -1 * matrix[0][1]) * (matrix[1][0] * matrix[2][2] - matrix[2][0] * matrix[1][2]))
                    + (matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[2][0] * matrix[1][1]));
        } else {
            for (int i = 0; i < rows; i++) {
                det += Math.pow(-1, i) * matrix[0][i] * laplaceExpand(minor(matrix, i));
            }
        }
        return det;
    }

    private static double[][] minor(double[][] matrix, int skip) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] expandMatrix = new double[rows - 1][cols - 1];
        int ii = 0;
            for (int i = 1; i < rows; i++, ii++) {
                int jj = 0;
                for (int j = 0; j < cols; j++) {
                    if(j != skip) {
                        expandMatrix[ii][jj] = matrix[i][j];
                        jj++;
                    }
                }
            }
        return expandMatrix;
    }

    public static double[][] inverseMatrix(double[][] matrixA) {

        return new double[][]{{0, 0}};
    }
}