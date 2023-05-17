import java.util.Arrays;

public class Board {
    //attributes
    protected Tile[][] board;
    protected final int row;
    protected final int col;
    protected final String emptySpace = "_";
    private final int[][] target_board;
    protected int[] location_of_empty_tile;
    protected String board_as_a_String = "";


    protected int[][] getTarget_board() {
        return target_board;
    }
    protected Tile getTile(int row, int col) {
        return board[row][col];
    }

    protected static boolean isSolvable(Board board) {
        int n = board.row * board.col;
        int[] flat_board = new int[n];
        int index = 0;
        for(int i = 0; i < board.row; i++) {
            for(int j = 0; j < board.col; j++) {
                int tileNum = board.getTile(board.row,board.col).getTileNum();
                if(tileNum != (int)'_') {
                    flat_board[index++] = board.getTile(board.row,board.col).getTileNum();
                }
            }
        }
        int inversions = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(flat_board[i] > flat_board[j]) {
                    inversions++;
                }
            }
        }
        return (inversions % 2 == 0);
    }

    //requested constructor
    public Board(String string) {
        Tile[][] board;
        board_as_a_String = string;
        this.row = getRowNum(string);
        this.col = getColNum(string);
        board = new Tile[row][col];
        fillBoard(string,this.row,this.col);
        location_of_empty_tile = new int [2]; //?
        target_board = new int[row][col];
        createTargetBoard();

    }

    protected void createTargetBoard() {
        int num = 1;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == row - 1  && j == col - 1) {
                    target_board[i][j] = (int)('_');
                    break;
                }
                target_board[i][j] = num;
                num++;
            }
        }
    }


    //getter
    protected Tile[][] getBoard() {
        return this.board;
    }

    //helping functions to set up the board
    protected int getColNum(String string) {
        int col = 0, i = 0;
        while (i < string.length() && string.charAt(i) != '|') {
            col++;
            i++;
        }
        return col;
    }

    protected int getRowNum(String string) {
        int row = 1;
        int i = 0;
        while(i < string.length()) {
            if(string.charAt(i) == '|') {
                row += 1;
            }
            i++;
        }
        return row;
    }

    //switch loops order
    private void fillBoard(String string,int rows, int col) {
        int str_index = 0;
        int row = 0 , cols = 0,row_of_empty_tile = 0, col_of_empty_tile = 0;
        while(str_index < string.length()) {
            while(string.charAt(str_index)!= '|') {
                if(string.charAt(str_index) == '_') {
                    this.board[row][col] = new Tile(95);
                    this.location_of_empty_tile[0] = row;
                    this.location_of_empty_tile[1] = col;
                }
                else {
                    this.board[row][col] = new Tile(string.charAt(str_index));

                }
                str_index += 1;
            }
            row += 1;
            col = 0;
        }
    }

    public void printBoard() {
        for (int row = 0; row < this.row; row++) {
            System.out.println();
            for (int col = 0; col < this.col; col++) {
                System.out.print(board[row][col] + " ");
            }
        }
    }

    //given code
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(this.board, board.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    public int[] getLocation_of_empty_tile (){
        return location_of_empty_tile;
    }
}
