package afsd.me.magic;

import java.util.Map;

/**
 * User: XuHui
 * Date: 2016/3/9
 * Time: 9:57
 */
public class Magic {
    String[][][] magic = new String[6][3][3];

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
        for (int i = 0; i < step; i++) {
            rotationCircle(surface, cw);
        }

        return this;
    }

    private void rotationCircle(int surface, boolean cw) {
        switch (surface) {
            case 0: {
                if (cw) {

                } else {
                    String tmp = magic[4][0][2];
                    magic[4][0][2] = magic[4][0][1];
                    magic[4][0][1] = magic[4][0][0];
                    magic[4][0][0] = magic[1][2][2];
                    magic[1][2][2] = magic[1][1][2];
                    magic[1][1][2] = magic[1][0][2];
                    magic[1][0][2] = magic[5][2][0];
                    magic[5][2][0] = magic[5][2][1];
                    magic[5][2][1] = magic[5][2][2];
                    magic[5][2][2] = magic[3][0][0];
                    magic[3][0][0] = magic[3][1][0];
                    magic[3][1][0] = magic[3][2][0];
                    magic[3][2][0] = tmp;
                }
                break;
            }
//            case 1: {
//                circle[0] = magic[4][0][2];
//                circle[1] = magic[4][1][2];
//                circle[2] = magic[4][2][2];
//                circle[3] = magic[2][2][0];
//                circle[4] = magic[2][1][0];
//                circle[5] = magic[2][0][0];
//                circle[6] = magic[5][0][2];
//                circle[7] = magic[5][1][2];
//                circle[8] = magic[5][2][2];
//                circle[9] = magic[0][0][2];
//                circle[10] = magic[0][1][2];
//                circle[11] = magic[0][2][2];
//                break;
//            }
//            case 2: {
//                circle[0] = magic[4][2][2];
//                circle[1] = magic[4][2][1];
//                circle[2] = magic[4][2][0];
//                circle[3] = magic[3][2][0];
//                circle[4] = magic[3][1][0];
//                circle[5] = magic[3][0][0];
//                circle[6] = magic[5][0][0];
//                circle[7] = magic[5][0][1];
//                circle[8] = magic[5][0][2];
//                circle[9] = magic[1][0][2];
//                circle[10] = magic[1][1][2];
//                circle[11] = magic[1][2][2];
//                break;
//            }
//            case 3: {
//                circle[0] = magic[4][2][0];
//                circle[1] = magic[4][1][0];
//                circle[2] = magic[4][0][0];
//                circle[3] = magic[0][2][0];
//                circle[4] = magic[0][1][0];
//                circle[5] = magic[0][0][0];
//                circle[6] = magic[5][2][0];
//                circle[7] = magic[5][1][0];
//                circle[8] = magic[5][0][0];
//                circle[9] = magic[2][0][2];
//                circle[10] = magic[2][1][2];
//                circle[11] = magic[2][2][2];
//                break;
//            }
//            case 4: {
//                circle[0] = magic[3][2][2];
//                circle[1] = magic[3][2][1];
//                circle[2] = magic[3][2][0];
//                circle[3] = magic[2][2][2];
//                circle[4] = magic[2][2][1];
//                circle[5] = magic[2][2][0];
//                circle[6] = magic[1][2][2];
//                circle[7] = magic[1][2][1];
//                circle[8] = magic[1][2][0];
//                circle[9] = magic[0][2][2];
//                circle[10] = magic[0][2][1];
//                circle[11] = magic[0][1][0];
//                break;
//            }
//            case 5: {
//                circle[0] = magic[0][0][0];
//                circle[1] = magic[0][0][1];
//                circle[2] = magic[0][0][2];
//                circle[3] = magic[1][0][0];
//                circle[4] = magic[1][0][1];
//                circle[5] = magic[1][0][2];
//                circle[6] = magic[2][0][0];
//                circle[7] = magic[2][0][1];
//                circle[8] = magic[2][0][2];
//                circle[9] = magic[3][0][0];
//                circle[10] = magic[3][0][1];
//                circle[11] = magic[3][0][2];
//                break;
//            }
        }
    }

    public static void fileUp(String[][] can, String str) {
        for (int i = 0; i < can.length; i++)
            for (int j = 0; j < can[i].length; j++)
                can[i][j] = str;
    }

    public void outPrint() {
        int k = 4;
        int i = 0;
        int j = 0;
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
        int k = 4;
        int i = 0;
        int j = 0;
        for (i = 2; i >= 0; i--) {
            for (j = 2; j >= 0; j--) {
//                System.out.print(magic[k][i][j] + "\t");
                System.out.print("[" + i + "][" + j + "]\t");
            }
            System.out.println();
        }
        for (i = 2; i >= 0; i--) {
            for (k = 0; k < 4; k++) {
                for (j = 2; j >= 0; j--) {
//                    System.out.print(magic[k][i][j] + "\t");
                    System.out.print("[" + i + "][" + j + "]\t");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
        k = 5;
        for (i = 2; i >= 0; i--) {
            for (j = 2; j >= 0; j--) {
//                System.out.print(magic[k][i][j] + "\t");
                System.out.print("[" + i + "][" + j + "]\t");
            }
            System.out.println();
        }
    }
}
