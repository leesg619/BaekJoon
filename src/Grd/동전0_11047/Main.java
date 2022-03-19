package Grd.동전0_11047;

import java.util.*;
public class Main {

    public int solution(int n, int k , int[] coins) {
        int answer = 0;

        int tmp = k;
        int i = n-1;
        while(true) {
            if(tmp == 0) break;
            if(coins[i] <= tmp) {
                tmp-=coins[i];
                answer++;
            }
            else i--;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = kb.nextInt();
        System.out.println(T.solution(n, k ,coins));

    }
}