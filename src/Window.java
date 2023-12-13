import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Window {
    // keeps track of where pieces are, moves them, outputs states that could be used by drawing class

    // store 1d array of pieces
    // have method that constructs a boolean 2d array of which pieces are occupied
    // int[][] color by number?!!
    private int[][] window;
    private int[][] npiece;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;
    private ArrayList<Piece> pieces;
    private Piece activePiece;
    private Piece nextPiece;
    private long moveDownTimestamp;
    private int score = 0;
    public Window(){
        window = new int[20][10];
        npiece = new int[4][4];
        pieces = new ArrayList<>();
        moveDownTimestamp = System.nanoTime();
        activePiece = getRandomPiece();
        nextPiece = getRandomPiece();
    }
    public boolean gameOver(){
        // game is over when active piece cannot move down anymore but is still out of bounds
        if (activePiece!= null && !downSpace()){
            for(Point pt : activePiece.getBlocks()){
                if(pt.y==1){
                    return true;
                }
            }
        }
        return false;
    }
    public int[][] positions(boolean hasActivePiece){
        int[][] newWindow = new int[window.length][];
        for (int i = 0; i < window.length; i++) {
            newWindow[i] = Arrays.copyOf(window[i], window[i].length);
        }
        if(activePiece!=null && hasActivePiece) {
            for (Point pt : activePiece.getBlocks()) {
                newWindow[pt.y][pt.x] = activePiece.colorId();
            }
        }
        return newWindow;
    }
    public int[][] positions(){
        return positions(true);
    }
    public boolean downSpace(){
        int[][] positions = positions(false);
        for(Point pt: activePiece.getBlocks()){
            //System.out.println(pt.y);
            if( pt.y>HEIGHT-2 || positions[pt.y+1][pt.x]!=0){
                return false;
            }
        }
        return true;
    }
    public void movePieceLeft(){
        if(activePiece!= null){
            activePiece.moveLeft();
        }
    }
    public void movePieceRight(){
        if(activePiece!= null){
            activePiece.moveRight();
        }
    }
    public void rotatePiece(){
        if (activePiece!=null){
            activePiece.rotate();
        }
    }
    public int[][] initializeNPiece(){
        npiece = new int[4][4];
        for (int i=0; i<npiece.length;i++) {
            npiece[nextPiece.getYs()[i]][nextPiece.getXs()[i]] = nextPiece.colorId();
        }
        return npiece;
    }
    public void tick(){
        // if no active piece, it puts a new one at the top
        if (activePiece==null){
            activePiece = nextPiece;
            nextPiece = getRandomPiece();

        }
        // if enough time passed, we move down the active piece if there is room
        // if active piece is at the bottom, solidify it
        if(System.nanoTime()-moveDownTimestamp>1e9){
            //System.out.println(downSpace());
            if(downSpace()) {
                activePiece.moveDown();
            }
            else {
                solidify(activePiece);
                activePiece = null;
            }
            moveDownTimestamp = System.nanoTime();
        }
    }
    public Piece getRandomPiece(){
        int n = (int)(Math.random()*7);
        if (n==0){
            return new L(5,1);
        }
        else if (n==1){
            return new J(5,1);
        }
        else if (n==2){
            return new T(5,1);
        }
        else if (n==3){
            return new O(5,1);
        }
        else if (n==4){
            return new I(5,2);
        }
        else if (n==5){
            return new Z(5,1);
        }
        else {
            return new S(5,1);
        }
    }
    // solidifies pieces, deletes full rows (no 0s), returns the num rows deleted
    public int solidify(Piece p) {
        StdAudio.play("SFX_8_1_.wav");
        // Solidify the piece on the board
        for (Point pt : p.getBlocks()) {
            window[pt.y][pt.x] = activePiece.colorId();
        }
        boolean[] rowsToDelete = new boolean[20];
        int deletedRows = 0;
        // Identify full rows
        for (int i = 0; i < 20; i++) {
            boolean fullRow = true;
            for (int j = 0; j < 10; j++) {
                if (window[i][j] == 0) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                rowsToDelete[i] = true;
                deletedRows++;
                score += 100;
            }
        }
        // Shift rows down
        if (deletedRows > 0) {
            StdAudio.play("tetrisRowsCleared.wav");
            int newRow = 19;
            for (int oldRow = 19; oldRow >= 0; oldRow--) {
                if (!rowsToDelete[oldRow]) {
                    if (newRow != oldRow) {
                        window[newRow] = Arrays.copyOf(window[oldRow], 10);
                    }
                    newRow--;
                }
            }
            // Clear the top rows
            for (int i = 0; i <= newRow; i++) {
                window[i] = new int[10];
            }
        }
        return deletedRows;
    }
    public int getScore(){
        return score;
    }

}
