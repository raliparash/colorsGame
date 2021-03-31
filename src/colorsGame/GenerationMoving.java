package colorsGame;

public interface GenerationMoving {

    public int moveFirstDiagonal(int [][] generationZero, int row, int col);

    public int moveSecondDiagonal(int[][] generationZero, int row, int col);

    public int moveThirdDiagonal(int[][] generationZero, int row, int col);

    public int moveFourthDiagonal(int[][] generationZero, int row, int col);

    public int moveUp(int[][] generationZero, int row, int col);

    public int moveDown(int[][] generationZero, int row, int col);

    public int moveRight(int[][] generationZero, int row, int col);

    public int moveLeft(int[][] generationZero, int row, int col);

}
