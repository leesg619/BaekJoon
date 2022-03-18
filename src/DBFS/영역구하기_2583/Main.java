package DBFS.영역구하기_2583;

import java.util.*;
public class Main {
    static int num=0;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[][] ch;
    static int tmp = 0;
    static int m, n;
    static Rec[] recs;
    public static boolean contains(int a, int b ) {
        boolean v = false; /// 0.2    0.2 0.3  1.2 1.3  // 0,2 4,4
        for(Rec rec: recs) {
            if ((rec.x1 <= a) && (rec.y1 <= b) && (rec.y2 >= b + 1) && (rec.x2 >= a + 1)) {
                v = true;
                break;
            }
        }
        return v;
    }

    public void dfs(int x, int y) {
        if(x>=m || x<0 || y>=n || y<0) return;
        if (ch[x][y] == 1 || contains(x,y)) return;
        else {
            tmp++;
            ch[x][y] = 1;

            dfs(x+1, y);
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x, y+1);

        }
    }

    public void solution() {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(ch[i][j]==1) continue;

                if(!contains(i, j)) { // fresh 한 영역 들어올때마다 num+=1 및 dfs 진행, 끝나면 tmp 다시 0으로
                    dfs(i, j);

                    num++;
                    answer.add(tmp);
                    tmp = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();;
        m=kb.nextInt();;
        int k=kb.nextInt();;
        recs = new Rec[k];
        ch = new int[m+1][n+1];
        for (int i = 0; i < k; i++) {
            int x1= kb.nextInt();;
            int y1= kb.nextInt();;
            int x2= kb.nextInt();;
            int y2= kb.nextInt();;
            recs[i] = new Rec(x1,y1,x2,y2);
        }

        T.solution();
        Collections.sort(answer);

        System.out.println(num);
        for (int i=0; i<answer.size();i++) {
            System.out.print(answer.get(i));
            if(i != answer.size()-1) System.out.print(" ");
        }

    }
}

class Rec {
    int x1; int y1;
    int x2; int y2;

    public Rec(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
// for (int i = 0; i < n; i++) arr[i] = kb.nextInt();