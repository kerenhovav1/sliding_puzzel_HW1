import java.sql.SQLOutput;

public class Action {
    protected int tile;
    protected Board board;
    private int emptyRow;
    private int emptyCol;
    private String direction;

    //constructor
    public Action(int tile, int emptyRow, int emptyCol, Board board) {
        this.tile = tile;
        this.emptyRow = board.getLocation_of_empty_tile()[0];
        this.emptyCol = board.getLocation_of_empty_tile()[1];
        this.direction= //????
    }

    public enum Enum_Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public void move(Enum_Direction direction) {
        switch (direction) {
            case UP:
                if (emptyRow > 0) {
                    swap(emptyRow, emptyCol, emptyRow - 1, emptyCol);
                    ///direction ???
                }
                break;
            case DOWN:
                if (emptyRow < this.board.length - 1) {
                    swap(emptyRow, emptyCol, emptyRow + 1, emptyCol);
                }
                break;
            case RIGHT:
                if (emptyCol < this.board[0].length - 1) {
                    swap(emptyRow, emptyCol, emptyRow, emptyCol + 1);
                }
                break;
            case LEFT:
                if (emptyCol > 0) {
                    swap(emptyRow, emptyCol, emptyRow, emptyCol - 1);
                }
                break;
        }
    }

    private void swap(int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;

        emptyRow = row2;
        emptyCol = col2;
    }



 // ?????
    @Override
    public void toString(){
        System.out.println("Move");
    }
}
