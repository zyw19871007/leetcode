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
    public void solveSudoku(char[][] board) {

    }

    class DancingLink {
        DancingLink left;
        DancingLink right;
        DancingLink up;
        DancingLink down;
        int col=0;
        int row=0;
    }

    public void init() {
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

    public void init(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //连接左侧

            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //初始化


    }
}
