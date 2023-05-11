public class State {
    protected Board board;
    protected Board target;
    public State(int rows, int columns) {
        this.board = board;
        this.target = new Board(board.get)
    }

    public Board getState() {
        return board;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof State)) {
            return false;
        }
        State otherState = (State) other;
        return board.equals(otherState.board);
    }
    public boolean isGoal() {
        int counter = 1;
        for(int i = 0; i < this.board.getNumR(); i++ ) {
            for(int j = 0; j < this.board.getNumC(); j++) {
                target[i][j] = new Tile(counter);
            }
        }
        return board.equals(target);

    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }
}
