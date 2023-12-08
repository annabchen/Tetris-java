import java.util.Arrays;

import static java.awt.event.KeyEvent.*;

public class Project {
    public static void main(String[] args) {
        Window win1 = new Window();
        Display display = new Display();


         //while game is running,
        while(!win1.gameOver()) {
             //check if user moved the piece left or right
            if (StdDraw.isKeyPressed(VK_LEFT)){
                // move key left
                win1.movePieceLeft();
            }
            else if (StdDraw.isKeyPressed(VK_RIGHT)){
                win1.movePieceRight();
            }
            // check if the user rotated
            else if (StdDraw.isKeyPressed(VK_UP)){
                win1.rotatePiece();
            }
            win1.tick();
            //printArr(win1.positions());
            display.render(win1.positions());
            StdDraw.pause(100);
        }
    }
    public static void printArr (int[][] arr){
        System.out.println(Arrays.deepToString(arr));
    }
}
