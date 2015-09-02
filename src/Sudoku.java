import com.sun.org.apache.xml.internal.security.Init;

import java.util.jar.JarEntry;

/**
 * 数独-使用跳舞链数据结构
 * Created by zyw on 2015/8/31.
 */
public class Sudoku {
    /**
     * @param board
     * ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
    ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
    ["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]
     */
    public void solveSudoku() {

    }

    class DancingLink {
        DancingLink left;
        DancingLink right;
        DancingLink up;
        DancingLink down;
        int col=0;
        int row=0;
        char val = '.';
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public DancingLink[][] getDancingLinks() {
        return dancingLinks;
    }

    public void setDancingLinks(DancingLink[][] dancingLinks) {
        this.dancingLinks = dancingLinks;
    }

    char[][]board;
    public void init() {
        board[0] = "..9748...".toCharArray();
        board[1] = "7........".toCharArray();
        board[2] = ".2.1.9...".toCharArray();
        board[3] = "..7...24.".toCharArray();
        board[4] = ".64.1.59.".toCharArray();
        board[5] = ".98...3..".toCharArray();
        board[6] = "...8.3.2.".toCharArray();
        board[7] ="........6".toCharArray();
        board[8] = "...2759..".toCharArray();

        DancingLink head = new DancingLink();
        DancingLink c1 = new DancingLink();
        DancingLink c2 = new DancingLink();
        DancingLink c3 = new DancingLink();
        DancingLink c4 = new DancingLink();
        DancingLink c5 = new DancingLink();
        DancingLink c6 = new DancingLink();
        DancingLink c7 = new DancingLink();
        DancingLink c8 = new DancingLink();
        DancingLink c9 = new DancingLink();
        head.right=c1;
        c1.right=c2;
        c2.right=c3;
        c3.right=c4;
        c4.right=c5;
        c5.right=c6;
        c6.right=c7;
        c7.right=c8;
        c8.right=c9;
        c9.right=head;

    }
    DancingLink[][] dancingLinks = new DancingLink[9][9];
    public void initboard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                dancingLinks[i][j].val = board[i][j];
                //连接左侧
                for (int k = 1; k < 10; k++) {
                    if (board[i][(j - k + 10) / 10] != '.') {
                        dancingLinks[i][j].left=dancingLinks[i][(j - k + 10) / 10];
                        break;
                    }
                }
                //连接右侧
                for (int k = 1; k < 10; k++) {
                    if (board[i][(j + k + 10) / 10] != '.') {
                        dancingLinks[i][j].right=dancingLinks[i][(j + k + 10) / 10];
                        break;
                    }
                }

                //连接上侧
                for (int k = 1; k < 10; k++) {
                    if (board[(i-k+10)/10][j] != '.') {
                        dancingLinks[i][j].up=dancingLinks[(i-k+10)/10][j];
                        break;
                    }
                }
                //连接下侧
                for (int k = 1; k < 10; k++) {
                    if (board[(i+k+10)/10][j] != '.') {
                        dancingLinks[i][j].down=dancingLinks[(i+k+10)/10][j];
                        break;
                    }
                }
            }
        }
    }

}
