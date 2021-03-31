package colorsGame;

public class NextGeneration {


    private final GenerationZero generationZero;
    private final GenerationZero nextGeneration;
    private Rules rules;
    private int realCount;

    public NextGeneration(GenerationZero generation) {
        this.generationZero = generation;
        this.nextGeneration = new GenerationZero(generationZero.getGenerationZero().length, generationZero.getGenerationZero()[0].length);
        this.realCount = 0;
    }

    public GenerationZero getGenerationZero() {
        return generationZero;
    }

    public int getRealCount() {
        return realCount;
    }

    public void getNextGenerationAfterApplyingFourthRules(int cycle, int rolPlace, int colPlace, GenerationZero generationZero) {
        while (cycle-- > 0) {


            Rules rules = new Rules();
            int row = generationZero.getGenerationZero().length;
            int col = generationZero.getGenerationZero()[0].length;
            int state = -1;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    int value = generationZero.getGenerationZero()[i][j];

                    int greenCount = 0;

                    if (i == rolPlace && j == colPlace) {
                        if (value == 0) {

                            greenCount = countGreenCellAroundCell(i, j, generationZero.getGenerationZero());
                            state = rules.getStateByRedCell(greenCount);

                            // state = getStateByRedCell(state, greenCount);
                            if (state == 1) {
                                this.realCount++;
                            }


                        } else if (value == 1) {
                            greenCount = countGreenCellAroundCell(i, j, generationZero.getGenerationZero());

                            state = rules.getStateByGreenCell(greenCount);
                            if (state == 1) {
                                this.realCount++;
                            }
                        }
                    } else {
                        if (value == 0) {

                            greenCount = countGreenCellAroundCell(i, j, generationZero.getGenerationZero());


                            state = rules.getStateByRedCell(greenCount);

                        } else if (value == 1) {
                            greenCount += countGreenCellAroundCell(i, j, generationZero.getGenerationZero());
                            ;


                            state = rules.getStateByGreenCell(greenCount);
                        }
                    }
                    nextGeneration.setCellState(i, j, state);
                }
            }

            generationZero.copyGeneration(nextGeneration);

        }
    }



    private int countGreenCellAroundCell(int i, int j, int[][] generationZero) {

        int greenCount = 0;

        greenCount = this.generationZero.moveFirstDiagonal(generationZero, i, j)
                + this.generationZero.moveSecondDiagonal(generationZero, i, j)
                + this.generationZero.moveThirdDiagonal(generationZero, i, j)
                + this.generationZero.moveFourthDiagonal(generationZero, i, j)
                + this.generationZero.moveUp(generationZero, i, j)
                + this.generationZero.moveDown(generationZero, i, j)
                + this.generationZero.moveRight(generationZero, i, j)
                + this.generationZero.moveLeft(generationZero, i, j);

        return greenCount;
    }
}

