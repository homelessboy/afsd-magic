package afsd.me.magic;

import java.util.Map;

/**
 * User: XuHui
 * Date: 2016/3/9
 * Time: 9:57
 */
public class Magic {
    String[][][] magic = new String[6][3][3];
    P[][] circle = new P[][]{
            {new P(4, 0, 2), new P(4, 0, 1), new P(4, 0, 0), new P(1, 2, 2), new P(1, 1, 2), new P(1, 0, 2), new P(5, 2, 0), new P(5, 2, 1), new P(5, 2, 2), new P(3, 0, 0), new P(3, 1, 0), new P(3, 2, 0)},
            {new P(4, 0, 0), new P(4, 1, 0), new P(4, 2, 0), new P(2, 2, 2), new P(2, 1, 2), new P(2, 0, 2), new P(5, 0, 0), new P(5, 1, 0), new P(5, 2, 0), new P(0, 0, 0), new P(0, 1, 0), new P(0, 2, 0)},
            {new P(4, 2, 0), new P(4, 2, 1), new P(4, 2, 2), new P(3, 2, 2), new P(3, 1, 2), new P(3, 0, 2), new P(5, 0, 2), new P(5, 0, 1), new P(5, 0, 0), new P(1, 0, 0), new P(1, 1, 0), new P(1, 2, 0)},
            {new P(4, 2, 2), new P(4, 1, 2), new P(4, 0, 2), new P(0, 2, 2), new P(0, 1, 2), new P(0, 0, 2), new P(5, 2, 2), new P(5, 1, 2), new P(5, 0, 2), new P(2, 0, 0), new P(2, 1, 0), new P(2, 2, 0)},
            {new P(3, 2, 0), new P(3, 2, 1), new P(3, 2, 2), new P(2, 2, 0), new P(2, 2, 1), new P(2, 2, 2), new P(1, 2, 0), new P(1, 2, 1), new P(1, 2, 2), new P(0, 2, 0), new P(0, 2, 1), new P(0, 2, 2)},
            {new P(0, 0, 2), new P(0, 0, 1), new P(0, 0, 0), new P(1, 0, 2), new P(1, 0, 1), new P(1, 0, 0), new P(2, 0, 2), new P(2, 0, 1), new P(2, 0, 0), new P(3, 0, 2), new P(3, 0, 1), new P(3, 0, 0)}
    };

    public Magic() {
        fileUp(magic[0], "蓝");
        fileUp(magic[1], "红");
        fileUp(magic[2], "绿");
        fileUp(magic[3], "橙");
        fileUp(magic[4], "黄");
        fileUp(magic[5], "白");
    }

    public Magic rotationSurface(int surface, Boolean cw, int step) {
        for (int i = 0; i < step; i++) {
            String[][] ans = new String[3][3];
            String[][] now = magic[surface];
            ans[1][1] = now[1][1];
            if (cw) {
                ans[0][0] = now[0][1];
                ans[0][1] = now[0][2];
                ans[0][2] = now[1][2];
                ans[1][2] = now[2][2];
                ans[2][2] = now[2][1];
                ans[2][1] = now[2][0];
                ans[2][0] = now[1][0];
                ans[1][0] = now[0][0];
            } else {
                ans[0][1] = now[0][0];
                ans[0][2] = now[0][1];
                ans[1][2] = now[0][2];
                ans[2][2] = now[1][2];
                ans[2][1] = now[2][2];
                ans[2][0] = now[2][1];
                ans[1][0] = now[2][0];
                ans[0][0] = now[1][0];
            }
            magic[surface] = ans;
        }
        return this;
    }

    public Magic rotationSide(int surface, Boolean cw, int step) {
        rotationCircle(surface, cw, step);
        return this;
    }

    private void rotationCircle(int surface, boolean cw, int step) {
        rotationP(surface, cw, step);
    }

    public void rotationP(int surface, Boolean cw, int step) {
        while (step-- > 0) {
            P p = circle[surface][0];
            P next;
            String tmp = magic[p.f][p.x][p.y];
            for (int i = 1; i < circle[surface].length; i++) {
                next =!cw? circle[surface][i]:circle[surface][circle[surface].length-i];
                System.out.println(p.x + ";" + p.y + ";;;;" + next.x + ";" + next.y);
                magic[p.f][p.x][p.y] = magic[next.f][next.x][next.y];
                p = next;
            }
            magic[p.f][p.x][p.y] = tmp;
        }
    }

    public static void fileUp(String[][] can, String str) {
        for (int i = 0; i < can.length; i++)
            for (int j = 0; j < can[i].length; j++)
                can[i][j] = str;
    }

    public void outPrint() {
        int k = 4;
        int i ;
        int j ;
        for (i = 2; i >= 0; i--) {
            for (j = 2; j >= 0; j--) {
                System.out.print(magic[k][i][j] + "\t");
            }
            System.out.println();
        }
        for (i = 2; i >= 0; i--) {
            for (k = 0; k < 4; k++) {
                for (j = 2; j >= 0; j--) {
                    System.out.print(magic[k][i][j] + "\t");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
        k = 5;
        for (i = 2; i >= 0; i--) {
            for (j = 2; j >= 0; j--) {
                System.out.print(magic[k][i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void outPrintSite() {
        int k ;
        int i ;
        int j ;
        for (i = 2; i >= 0; i--) {
            for (j = 2; j >= 0; j--) {
                System.out.print("[" + i + "][" + j + "]\t");
            }
            System.out.println();
        }
        for (i = 2; i >= 0; i--) {
            for (k = 0; k < 4; k++) {
                for (j = 2; j >= 0; j--) {
                    System.out.print("[" + i + "][" + j + "]\t");
                }
                System.out.print("\t");
            }
            System.out.println();
        }

        for (i = 2; i >= 0; i--) {
            for (j = 2; j >= 0; j--) {
                System.out.print("[" + i + "][" + j + "]\t");
            }
            System.out.println();
        }
    }

    class P {
        int f;
        int x;
        int y;
        public P(int f, int x, int y) {
            this.f = f;
            this.x = x;
            this.y = y;
        }
    }
}
