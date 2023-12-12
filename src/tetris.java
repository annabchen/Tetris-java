public class tetris {
    public static void main(String[] args) {
        // user input will be integrated through the movement of the pieces

        // 10 spaces wide, 20 spaces tall
        int[][] window = new int[20][10];
        setupStdDraw();

        randomPiece(window);
        drawRows(window);
        // while loop runs as long as the window is not full of pieces
        while(!isArrayFull(window)){
            // input the random piece, which starts off at the top middle of the window
            randomPiece(window);
            // let the user control its movement (left with left arrow or right with right arrow)

            // at the same time, move the piece down one row at a time

            // redraw the array after every change made

            // insert a method for clearing the rows that are full
        }
    }
    // sets up the StdDraw window
    public static void setupStdDraw(){
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(500, 1000);
        StdDraw.setScale(0,1000);
        //StdDraw.setPenColor(StdDraw.BLUE);
    }
    // methods for drawing the different blocks:
    public static void Lblock(int[][] window, int r, int c){
        window[r][c]=1;
        window[r-1][c]=1;
        window[r-2][c]=1;
        window[r-2][c+1]=1;
    }
    public static void Jblock(int[][] window, int r, int c){
        window[r][c] = 1;
        window[r-1][c]=1;
        window[r-2][c]=1;
        window[r-2][c-1]=1;
    }
    public static void Tblock(int[][] window, int r, int c){
        window[r][c]=1;
        window[r-1][c]=1;
        window[r-1][c-1]=1;
        window[r-1][c+1]=1;
    }
    public static void Oblock(int[][] window, int r, int c){
        window[r][c]=1;
        window[r][c+1]=1;
        window[r-1][c]=1;
        window[r-1][c+1]=1;
    }
    public static void Iblock(int[][] window, int r, int c){
        window[r][c]=1;
        window[r-1][c]=1;
        window[r-2][c]=1;
        window[r-3][c]=1;
    }
    public static void Zblock(int[][] window, int r, int c){
        window[r][c]=1;
        window[r][c-1]=1;
        window[r-1][c]=1;
        window[r-1][c+1]=1;
    }
    public static void Sblock(int[][] window, int r, int c){
        window[r][c]=1;
        window[r][c+1]=1;
        window[r-1][c]=1;
        window[r-1][c-1]=1;
    }
    // checks if there are elements in all the rows
    public static boolean isArrayFull(int[][] window){
        boolean isFull = true;
        for (int i = 0; i < 20; i++) {
            if (window[2][i] != 1){
                isFull = false;
            }
        }
        return isFull;
    }
    // method which places a random piece at the top of the window
    public static void randomPiece (int[][] window){
        int n = (int)(Math.random()*7);
        if (n==0){
            Lblock(window,19,5);
        }
        else if (n==1){
            Jblock(window,19,5);
        }
        else if (n==2){
            Tblock(window,19,5);
        }
        else if (n==3){
            Oblock(window,19,5);
        }
        else if (n==4){
            Iblock(window,19,5);
        }
        else if (n==5){
            Zblock(window,19,5);
        }
        else {
            Sblock(window, 19, 5);
        }
    }
    // method drawRows taken from Rule110
    public static void drawRows(int[][] window){
        int cellSizeX = 500 / 10 ;
        int cellSizeY = cellSizeX * 2;
        //StdDraw.setPenColor(StdDraw.BLUE);
        for (int r = 0; r < window.length; r++) {
            for (int c = 0; c < window[r].length; c++) {
                if(window[r][c] == 1){

                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledRectangle(c*cellSizeY, r*cellSizeX-cellSizeY, cellSizeY/2, cellSizeX/2);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.rectangle(c*cellSizeY, r*cellSizeX-cellSizeY, cellSizeY/2, cellSizeX/2);

                }
            }
        }
        StdDraw.show();
    }
    // method for moving the piece down the rows
    public static void movePieceDown(int[][] window){
        for (int y = window.length-1; y > 1; y--) {
            window[y-1]= window[y];
        }
    }
    // method for user input
    /*public static void leftRightMovement(int[][] window){
        while (StdDraw.isKeyPressed(37)){
            window[][-1] = window[][]; //??????
        }
        while (StdDraw.isKeyPressed(39)){
            window[][+1] = window[][]; // ?????????
        }
    }*/
}
