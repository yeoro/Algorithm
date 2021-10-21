package Softeer_level4_지우는소수를좋아해;

import java.util.*;
import java.io.*;


public class Main
{
	static class Gym implements Comparable<Gym> {
        int no, level;
        
        public Gym(int no, int level) {
            this.no = no;
            this.level = level;
        }
        
        @Override
        public int compareTo(Gym o){
            return this.level - o.level;
        }
    }
    static int[][] arr;
    static int[] dis;
    static boolean[] v;
    static int N, K, max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        dis = new int[N+1];
        v = new boolean[N+1];
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            arr[A][B] = Math.min(arr[A][B], C);
            arr[B][A] = Math.min(arr[B][A], C);
        }

        solve(1);
        
        if(isPrime(max)){
            System.out.println(max);
        } else {
            System.out.println(findPrime(max));
        }
    }
    
    static void solve(int start){
       PriorityQueue<Gym> pq = new PriorityQueue<>();
       pq.offer(new Gym(start, 0));
       dis[start] = 0;
       v[start] = true;
       
       for(int i = 1; i <= N; i++){
           if(!v[i] && arr[start][i] != Integer.MAX_VALUE){
               dis[i] = arr[start][i];
               pq.offer(new Gym(i, arr[start][i]));
           }
       }
       
       while(!pq.isEmpty()){
           Gym cur = pq.poll();
           int minIdx = cur.no;
           v[minIdx] = true;
       
           for(int i = 1; i <= N; i++){
               if(!v[i] && arr[minIdx][i] != Integer.MAX_VALUE){
                   if(arr[minIdx][i] < dis[i]){
                       dis[i] = Math.min(dis[i], arr[minIdx][i]);
                       max = Math.max(max, dis[i]);
                       pq.offer(new Gym(i, dis[i]));
                   }
               }
           }
       }
    }
    
    static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    static int findPrime(int n){
        for(int i = n+1; i <= 10000; i++){
            if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0){
                return i;
            }
        }
        return n;
    }
}