//Miranda Dorosz
package pieces;
import board.*;

public class Rook extends Piece{
    
    int xt,yt;
    int tempx,tempy;
    public Rook(int x, int y, char c, String color) {
        super(x, y, c, color);
        c = 'R';
    }

    @Override
    public boolean canMoveTo(int x, int y, Board board) {
        if(x > this.x && y == this.y) { //move right            
            if (lowCh("right",xt, yt, x, y,board))
            {               
                return canTake(xt+1,yt,board);
            }else{
                return false;
            }            
        } else if (x < this.x && y == this.y) { //move left
            if(lowCh("left",xt, yt, x,y,board))
            {
                return canTake(xt,yt-1,board);
            }else{
                return false;
            }
        } else if(y > this.y && x == this.x) { //move down
            if (lowCh("down",xt, yt,x,y,board))
            {
                return canTake(xt-1,yt,board);
            }else{
                return false;
            }
        } else if(y < this.y && x == this.x) { //move up
            if (lowCh("up",xt,yt,x,y,board))
            {
            return canTake(xt,yt+1,board);
            }else{
                 return false;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public void setter(int a, int b)
    {
      xt = a;
      yt = b;
    }
    @Override
    public boolean lowCh(String Place, int x1, int y1, int x2, int y2, Board board)
    {
        switch (Place)
        {
            case "right":
            for (; x1<=x2; x1++)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (x1==x2-1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            case "left":
            for(; x1>=x2; x1--)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (x1==x2+1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            case "down":
            for(; y1==y2; y--)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (y1==y2+1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            case "up":
            for (; y1==y2; y1++)
            {
                if (board.getSquare(x1,y1).getPiece()==null)
                {
                    if (y1==y2-1)
                    {
                        return true;
                    }
                }else{
                    return false;
                }
            }
            default: return false;
        }
        
    }
    
    @Override
    public boolean canTake(int x, int y, Board board)
    {
        if (board.getSquare(x, y).getPiece() == null)
        {
            return true;
        }else{
        switch (Colour.toLowerCase())
        {
            case "white":  return "black".equals(board.getSquare(x,y).getPiece().Colour);
        
            case "black":  return "white".equals(board.getSquare(x,y).getPiece().Colour);
            
            default:  return false;                    
        }
      }
    }
    
    @Override
    public void Threaten(Board board)
    {
        switch (Colour.toLowerCase())
        {
            case "white":
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempy <= 7)
                    {
                        board.getSquare(tempx,tempy).wt = board.getSquare(tempx,tempy).wt +1; 
                        tempy = tempy +1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx <= 7)
                    {
                       board.getSquare(tempx,tempy).wt = board.getSquare(tempx,tempy).wt +1; 
                       tempx = tempx +1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempy >= 0)
                    {
                         board.getSquare(tempx,tempy).wt = board.getSquare(tempx,tempy).wt +1;
                         tempy = tempy -1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx >= 0)
                    {
                      board.getSquare(tempx,tempy).wt = board.getSquare(tempx,tempy).wt +1;
                      tempx = tempx -1;
                    }                   
            case "black":    
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempy <= 7)
                    {
                    board.getSquare(tempx,tempy).bt = board.getSquare(tempx,tempy).bt +1; 
                    tempy = tempy +1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx <=7)
                    {
                       board.getSquare(tempx,tempy).bt = board.getSquare(tempx,tempy).bt +1; 
                       tempx = tempx +1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempy >= 0)
                    {
                         board.getSquare(tempx,tempy).bt = board.getSquare(tempx,tempy).bt +1;
                         tempy = tempy -1;
                    }
                tempx = this.x;
                tempy = this.y;
                    while(board.getSquare(tempx,tempy).getPiece() == null && tempx >= 0)
                    {
                      board.getSquare(tempx,tempy).bt = board.getSquare(tempx,tempy).bt +1;  
                      tempx = tempx -1;
                    }    
        }
    }
    
    @Override
    public void moveTo(int x, int y,Board board) {
        if(canMoveTo(x, y, board)) {
            this.x = x;
            this.y = y;
        }
        else {
            System.out.println("Error: Cannot move to requested spot.");
        }
    }
    
    
    //useless code section i would like to figure out how to remove to improve efficeny if we have the time and are completly done    
    @Override
    public boolean Danger(Board board)
    {
        return false;
    }        
    
}

/*
    Can move as far as it wants but only forward, back, or to the sides
    (no diagonals).
*/