import java.util.List;

public class L implements Piece{
    private Point point;
    private int numRotations;
    public L(int x, int y){
        this.point = new Point(x,y);
    }
    @Override
    public Point position() {
        return point;
    }

    @Override
    public Point[] getBlocks() {
        // x, y is middle block
        if(numRotations%4==0) {
            return new Point[]{new Point(point.x, point.y), new Point(point.x + 1, point.y),
                    new Point(point.x - 1, point.y), new Point(point.x + 1, point.y + 1)};
        }
        else if(numRotations%4==1){
            return new Point[]{new Point(point.x, point.y), new Point(point.x +1, point.y-1),
                    new Point(point.x, point.y + 1), new Point(point.x, point.y-1)};
        }
        else if(numRotations%4==2){
            return new Point[]{new Point(point.x, point.y), new Point(point.x - 1, point.y),
                    new Point(point.x - 1, point.y - 1), new Point(point.x + 1, point.y)};
        }
        else{
            return new Point[]{new Point(point.x, point.y), new Point(point.x - 1, point.y+1),
                    new Point(point.x, point.y + 1), new Point(point.x, point.y-1)};
        }
    }

    @Override
    public void rotate() {
        numRotations++;
    }

    @Override
    public void moveLeft() {
        for(Point p: getBlocks()) {
            if(p.x==0){
                return;
            }
        }
        point.x -= 1;

    }

    @Override
    public void moveRight() {
        for(Point p: getBlocks()) {
            if(p.x==9){
                return;
            }
        }
        point.x+=1;
    }

    @Override
    public void moveDown() {
        point.y+=1;
    }

    @Override
    public int colorId() {
        return 2;
    }
}
