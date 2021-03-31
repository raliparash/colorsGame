package colorsGame;

public class Rules {


    public Rules() {

    }

    public int getStateByGreenCell(int greenCount) {

        int state = -1;
        if (greenCount == 2 || greenCount == 3 || greenCount == 6) {
            state = 1;


        } else if (greenCount == 0 || greenCount == 1
                || greenCount == 4 || greenCount == 5 || greenCount == 7 || greenCount == 8) {
           state = 0;
        }
        return state;
    }

    public int getStateByRedCell(int greenCount) {
        int state = -1;
        if (greenCount == 3 || greenCount == 6) {
            state = 1;
        } else if (greenCount == 0 || greenCount == 1 || greenCount == 2
                || greenCount == 4 || greenCount == 5
                || greenCount == 7 || greenCount == 8) {
           state = 0;
        }
        return state;
    }
}
