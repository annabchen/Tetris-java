import java.awt.*;
public class Display {
    public static final double DISPLAY_WIDTH = 300;
    public static final double DISPLAY_HEIGHT = 600;

    public Display() {
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 600);
        StdDraw.setYscale(0, DISPLAY_HEIGHT);
        //StdDraw.setScale(0,400);
        //StdDraw.setPenColor(Color.BLACK);

        //StdDraw.pause(2000);
    }

    public void render(int[][] window) {
        double blockSize = DISPLAY_WIDTH / Window.WIDTH;
        double halfSize = blockSize / 2;
        StdDraw.clear();
        for (int r = 0; r < window.length; r++) {
            for (int c = 0; c < window[r].length; c++) {
                if (window[r][c] != 0) {
                    if (window[r][c] == 7) {
                        StdDraw.setPenColor(Color.cyan);
                    } else if (window[r][c] == 1) {
                        StdDraw.setPenColor(Color.BLUE);
                    } else if (window[r][c] == 2) {
                        StdDraw.setPenColor(Color.ORANGE);
                    } else if (window[r][c] == 3) {
                        StdDraw.setPenColor(Color.yellow);
                    } else if (window[r][c] == 4) {
                        StdDraw.setPenColor(Color.GREEN);
                    } else if (window[r][c] == 5) {
                        StdDraw.setPenColor(165, 25, 255);
                    } else {
                        StdDraw.setPenColor(Color.RED);
                    }
                    StdDraw.filledSquare(c * blockSize + halfSize, (window.length - r) * blockSize - halfSize, halfSize);
                }
            }
        }
    }

    public void frame() {
        StdDraw.setPenColor(Color.black);
        StdDraw.rectangle(150, 300, (double) 300 / 2, (double) 600 / 2);
    }

    public void openScreen() {
        StdDraw.setPenColor(Color.black);
        StdDraw.text(300, 300, "Hello! Welcome to my Tetris :D");
        StdDraw.show(2000);
        StdDraw.clear();
        StdDraw.text(300, 300, "The game is controlled with the up, left, and right arrows keys.");
        StdDraw.show(3000);
        StdDraw.clear();
        StdDraw.text(300, 300, "Have fun!");
        StdDraw.show(2000);
        StdDraw.clear();
    }

    public void endingScreen() {
        StdDraw.setPenColor(Color.black);
        StdDraw.text(300, 300, "Game over! Thanks for playing!");
        StdDraw.show(2000);
        StdDraw.clear();
    }

    public synchronized void score(int currentScore) {
        StdDraw.setPenColor(Color.black);
        StdDraw.text(450, 520, "Score:");
        StdDraw.text(450, 500, String.valueOf(currentScore));

    }

    public void nextPiece(int[][] window) {
        StdDraw.setPenColor(Color.black);
        StdDraw.text(450,450,"Next Piece:");
        double blockSize = DISPLAY_WIDTH / Window.WIDTH;
        double halfSize = blockSize / 2;
        for (int r = 0; r < window.length; r++) {
            for (int c = 0; c < window[r].length; c++) {
                if (window[r][c] != 0) {
                    if (window[r][c] == 7) {
                        StdDraw.setPenColor(Color.cyan);
                    } else if (window[r][c] == 1) {
                        StdDraw.setPenColor(Color.BLUE);
                    } else if (window[r][c] == 2) {
                        StdDraw.setPenColor(Color.ORANGE);
                    } else if (window[r][c] == 3) {
                        StdDraw.setPenColor(Color.yellow);
                    } else if (window[r][c] == 4) {
                        StdDraw.setPenColor(Color.GREEN);
                    } else if (window[r][c] == 5) {
                        StdDraw.setPenColor(165, 25, 255);
                    } else {
                        StdDraw.setPenColor(Color.RED);
                    }
                    StdDraw.filledSquare(c * blockSize +450, (window.length - r) * blockSize + 300, halfSize);
                }
            }
        }
    }
}
