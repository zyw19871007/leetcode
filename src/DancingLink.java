/**
 * Created by Administrator on 2015/9/6.
 */
public class DancingLink {
    DancingLink left;
    DancingLink right;
    DancingLink up;
    DancingLink down;
    DancingLink col;
    int row = 0;
    char val = '.';

    public void remove() {
        DancingLink tmp = new DancingLink();
        tmp = left.right;
        left.right=right.left;
        right.left=tmp;
        tmp = up.down;
        up.down = down.up;
        down.up = tmp;
    }
    public  void recover() {
        left.right = this;
        right.left = this;
        up.down = this;
        down.up = this;
    }
}
