package code;

public class AbstractClass {

    public static void main(String[] args) {

        ChessPiece king = new ChessPieceKing("white", 0, 0);
        ChessPiece rook = new ChessPieceRook("black", 0, 0);

        king.getMove();
        rook.getMove();

    }
}

abstract class ChessPiece {
    private String color;
    private int x, y;

    public ChessPiece(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void getMove() {
        System.out.println(color + ": " + move());
    }

    // abstract method, every subclass moves differently
    protected abstract String move();
}

class ChessPieceKing extends ChessPiece {

    public ChessPieceKing(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    protected String move() {
        return ("King moves one square in any direction");
    }
}

class ChessPieceRook extends ChessPiece {

    public ChessPieceRook(String color, int x, int y) {
        super(color, x, y);
    }

    @Override
    protected String move() {
        return ("Rook moves any number of squares in a horizontal or vertical direction");
    }
}