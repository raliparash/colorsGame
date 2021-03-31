package colorsGame;

import java.util.Scanner;

public class GenerationZero extends Coordinates implements GenerationMoving {


    private int [][] generationZero;
    private Scanner scanner;


    public GenerationZero(int x, int y) {
        super(x, y);
        this.generationZero = new int[x][y];
        this.scanner = new Scanner(System.in);
        fillTheGenerationZeroWithData(scanner);



    }

    public void fillTheGenerationZeroWithData(Scanner scanner) {

        for (int i = 0; i < generationZero.length; i++) {
            String values = scanner.nextLine();
            for (int j = 0; j < generationZero[i].length; j++) {
                int value = Integer.parseInt(String.valueOf(values.charAt(j)));
                generationZero[i][j] = value;
            }
        }

    }

    public int[][] getGenerationZero() {
        return generationZero;
    }

    public void setGenerationZero(int[][] generationZero) {
        this.generationZero = generationZero;
    }
    public void setCellState(int row, int col, int state) {
        generationZero[row][col] = state;
    }

    public void copyGeneration(GenerationZero nextGeneration) {
        int height = generationZero.length;
        int width = generationZero[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                generationZero[i][j] = nextGeneration.getCellState(i, j);
        }
    }

    private int getCellState(int row, int col) {
        if (row == generationZero.length || row < 0) {
            return -1;
        }
        if (col == generationZero[0].length || col < 0) {
                return -1;
            }
        return generationZero[row][col];
        }


    public int greenCount(int givenRow, int givenCol, int [][] generationZero) {


        int count = 0;

                count = moveFirstDiagonal(this.generationZero, givenRow, givenCol)
                        + moveSecondDiagonal(this.generationZero, givenRow, givenCol)
                        + moveThirdDiagonal(this.generationZero, givenRow, givenCol)
                        + moveFourthDiagonal(this.generationZero, givenRow, givenCol)
                        + moveUp(this.generationZero, givenRow, givenCol)
                        + moveDown(this.generationZero, givenRow, givenCol)
                        + moveRight(this.generationZero, givenRow, givenCol)
                        + moveLeft(this.generationZero,givenRow, givenCol);


        return count;
    }



    @Override
    public int moveFirstDiagonal(int[][] generationZero, int rowPlace, int colPlace) {
        int greenCount = 0;


        int row = rowPlace + 1;
        int col = colPlace + 1;
        if (row >= this.generationZero.length || col >= this.generationZero.length) {
            return 0;
        }

        if (this.getGenerationZero()[row][col] == 1) {
            greenCount++;
        }

        return greenCount;

    }

    @Override
    public int moveSecondDiagonal(int[][] generationZero, int givenRow, int givenCol) {
        int greenCount = 0;
        int row = givenRow- 1;
        int col = givenCol - 1;
        if (row < 0 || col < 0) {
            return 0;
        }

        if (this.generationZero[row][col] == 1) {
            greenCount++;
        }

        return greenCount;
    }

    @Override
    public int moveThirdDiagonal(int[][] generationZero, int givenRow, int givenCol) {
        int greenCount = 0;

        int row = givenRow - 1;
        int col = givenCol + 1;
        if (row < 0 || col >= generationZero.length) {
            return 0;
        }
        if (this.generationZero[row][col] == 1) {
           greenCount++;
        }

      return greenCount;
    }

    @Override
    public int moveFourthDiagonal(int[][] generationZero, int givenRow, int givenCol) {
        int greenCount = 0;

        int row = givenRow + 1;
        int col = givenCol - 1;
        if (row >= generationZero.length || col < 0) {
            return 0;
        }
        if (this.generationZero[row][col] == 1) {
            greenCount++;
        }

        return greenCount;
    }

    @Override
    public int moveUp(int[][] generationZero, int givenRow, int givenCol) {
        int greenCount = 0;
        int row = givenRow - 1;


        if (row < 0) {
            return 0;
        }

        if (this.generationZero[row][givenCol] == 1) {
            greenCount++;
        }

        return greenCount;
    }

    @Override
    public int moveDown(int[][] generationZero, int givenRow, int givenCol) {
        int greenCount = 0;
        int row = givenRow + 1;

        if (row >= generationZero.length) {
            return 0;
        }

        if (this.generationZero[row][givenCol] == 1) {
            greenCount++;
        }

        return greenCount;
    }

    @Override
    public int moveRight(int[][] generationZero,  int givenRow, int givenCol) {

        int greenCount = 0;
        int col = givenCol + 1;

        if (col >=  generationZero.length) {

            return 0;
        }
        if (this.generationZero[givenRow][col] == 1) {
            greenCount++;
        }

        return greenCount;
    }

    @Override
    public int moveLeft(int[][] generationZero, int givenRow, int givenCol) {
        int greenCount = 0;
        int col = givenCol - 1;

        if (col < 0) {

            return 0;
        }
        if (this.generationZero[givenRow][col] == 1) {
            greenCount++;
        }

        return greenCount;
    }

    public void setGenerationCellState(int row, int col, int state) {
       generationZero[row][col] = state;
    }

}
