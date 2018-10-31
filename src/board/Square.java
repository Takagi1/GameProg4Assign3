
package board;

import java.io.Serializable;
import pieces.Piece;

public class Square implements Serializable {
    int x;
    int y;
    Piece piece;

    //constructor?
    public Square(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        piece = null;
    }

    //used to remove the piece when it moves
    public Piece remove() {
        Piece Tpiece = this.piece;
        this.piece = null;
        return Tpiece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setSquare(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
    
    //method for setting when loading
    public void setSquare(Square square) {
        this.x = square.x;
        this.y = square.y;
        this.piece = square.piece;
    }
  
}