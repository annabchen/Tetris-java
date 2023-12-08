import java.util.List;

public interface Piece {
    public Point position();
    public Point[] getBlocks();
    public void rotate();
    public void moveLeft();
    public void moveRight();
    public void moveDown();
    public int colorId();

}
