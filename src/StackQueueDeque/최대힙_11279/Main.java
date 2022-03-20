package StackQueueDeque.최대힙_11279;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            pQ.offer(tmp);
            if (tmp == 0) System.out.println(pQ.poll());
        }

    }
}