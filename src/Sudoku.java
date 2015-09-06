import com.sun.org.apache.xml.internal.security.Init;
import sun.plugin2.message.HeartbeatMessage;

import java.util.jar.JarEntry;

/**
 * 数独-使用跳舞链数据结构
 * Created by zyw on 2015/8/31.
 */
public class Sudoku {
    public char[][] board = new char[10][9];
    public DancingLink[][] dancingLinks = new DancingLink[9][9];

    /**
     * board ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
     *              ["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
     *              ["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]
     */
    public void solveSudoku() {

    }

    /**
     * 标示元素C1，指的是标示C1、和C1所在列的所有元素、以及该元素所在行的元素，并从双向链中移除这些元素
     * @param c
     */
    public void mark(DancingLink c) {
        DancingLink tmp=null;
        while (tmp != c) {
            tmp=c.down;
            //移除行元素
            if (tmp != c) {

            }

        }


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

    public void initBoard() {
        board[0] = "aaaaaaaaa".toCharArray();
        board[1] = "..9748...".toCharArray();
        board[2] = "7........".toCharArray();
        board[3] = ".2.1.9...".toCharArray();
        board[4] = "..7...24.".toCharArray();
        board[5] = ".64.1.59.".toCharArray();
        board[6] = ".98...3..".toCharArray();
        board[7] = "...8.3.2.".toCharArray();
        board[8] = "........6".toCharArray();
        board[9] = "...2759..".toCharArray();


    }

    public void initDancingLinks() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                dancingLinks[i][j] = new DancingLink();
                dancingLinks[i][j].val = board[i][j];
                dancingLinks[i][j].col = dancingLinks[0][j];
                dancingLinks[i][j].row=i;
                //连接左侧
                for (int k = 1; k < 10; k++) {
                    if (board[i][(j - k + 10) / 10] != '.') {
                        dancingLinks[i][j].left = dancingLinks[i][(j - k + 10) / 10];
                        break;
                    }
                }
                //连接右侧
                for (int k = 1; k < 10; k++) {
                    if (board[i][(j + k + 10) / 10] != '.') {
                        dancingLinks[i][j].right = dancingLinks[i][(j + k + 10) / 10];
                        break;
                    }
                }

                //连接上侧
                for (int k = 1; k < 10; k++) {
                    if (board[(i - k + 10) / 10][j] != '.') {
                        dancingLinks[i][j].up = dancingLinks[(i - k + 10) / 10][j];
                        break;
                    }
                }
                //连接下侧
                for (int k = 1; k < 10; k++) {
                    if (board[(i + k + 10) / 10][j] != '.') {
                        dancingLinks[i][j].down = dancingLinks[(i + k + 10) / 10][j];
                        break;
                    }
                }
            }
        }
        DancingLink head = new DancingLink();
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                head.right = dancingLinks[0][0];
            } else if (i == 8) {
                dancingLinks[0][8].right = head;
            } else {
                dancingLinks[0][i].right = dancingLinks[0][i + 1];
            }
        }
    }


}
