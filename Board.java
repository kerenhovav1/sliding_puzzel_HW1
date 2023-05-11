import java.util.Arrays;

public class Board {
    protected Tile[][] tiles;

    public Board(int rows, int columns) {
        this.tiles = new Tile[rows][columns];
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }

    public int getNumR() {
        return tiles.length;
    }

    public int getNumC() {
        return tiles[0].length;
    }
}
