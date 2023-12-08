import java.awt.*;

public class Display {
    public static final double WIDTH = 300;
    public static final double HEIGHT = 600;
    public Display(){
        StdDraw.setCanvasSize((int)WIDTH, (int) HEIGHT);
        StdDraw.setXscale(0,WIDTH);
        StdDraw.setYscale(0,HEIGHT);
        //StdDraw.setScale(0,400);
        StdDraw.setPenColor(Color.BLACK);

        //StdDraw.pause(2000);
    }
    public void render(int[][] window){
        double blockSize = WIDTH/Window.WIDTH;
        double halfSize = blockSize/2;
        StdDraw.clear();
        for(int r=0; r<window.length; r++){
            for (int c = 0; c < window[r].length; c++) {
                if(window[r][c] != 0){
                    if (window[r][c]==2){
                        StdDraw.setPenColor(Color.MAGENTA);
                    }
                    StdDraw.filledSquare(c*blockSize+halfSize,(window.length-r)*blockSize-halfSize, halfSize);
                }
            }
        }
    }
}
