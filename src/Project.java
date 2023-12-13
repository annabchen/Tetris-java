import java.awt.*;
import java.util.Arrays;

import static java.awt.event.KeyEvent.*;

public class Project {
    public static void main(String[] args) {
        Window win1 = new Window();
        Display display = new Display();
        display.openScreen();
        StdAudio.play("SFX_7_1_.wav");
        StdAudio.playInBackground("1_-_Music_1_1_.wav");
        //while game is running,
        while(!win1.gameOver()) {
            display.frame();
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
            display.score(win1.getScore());
            display.nextPiece(win1.initializeNPiece());
            StdDraw.show(100);
            win1.tick();

            display.render(win1.positions());
        }
        StdAudio.play("SFX_11_1_.wav");
        display.endingScreen();
    }
    public static void printArr (int[][] arr){
        System.out.println(Arrays.deepToString(arr));
    }

}
