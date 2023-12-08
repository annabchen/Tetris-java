public class J implements Piece{
    private Point point;
    private int numRotations;
    public J(int x, int y){
        this.point = new Point(x,y);
    }
    @Override
    public Point position() {
        return point;
    }

    @Override
    public Point[] getBlocks() {
        // x, y is middle block
        if (numRotations%4==0) {
            return new Point[]{new Point(point.x, point.y), new Point(point.x - 1, point.y), new Point(point.x - 1, point.y + 1)
                    , new Point(point.x + 1, point.y)};
        }
        else if (numRotations%4==1){
            return new Point[]{new Point(point.x, point.y), new Point(point.x, point.y+1), new Point(point.x, point.y + 2)
                    , new Point(point.x + 1, point.y+1)};
        }
        else if (numRotations%4==2){
            return new Point[]{new Point(point.x, point.y), new Point(point.x - 1, point.y), new Point(point.x +1, point.y)
                    , new Point(point.x + 1, point.y-1)};
        }
        else {
            return new Point[]{new Point(point.x, point.y), new Point(point.x - 1, point.y-1), new Point(point.x, point.y - 1)
                    , new Point(point.x, point.y+1)};
        }
    }

    @Override
    public void rotate() {
        numRotations++;
    }

    @Override
    public void moveLeft() {
        point.x -= 1;
    }

    @Override
    public void moveRight() {
        point.x+=1;
    }

    @Override
    public void moveDown() {
        point.y+=1;
    }

    @Override
    public int colorId() {
        return 0;
    }
}
