package Softeer_level3_택배마스터광우;

import java.util.*;
import java.io.*;


public class Main
{

    static List<Integer> rails = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    static int N, M, K, min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            rails.add(Integer.parseInt(st.nextToken()));
        }
        
        solve(0);
        
        System.out.println(min);
    }
    
    static void solve(int depth){
        if(depth == N){
            work();
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(!temp.contains(rails.get(i))){
                temp.add(rails.get(i));
                solve(depth+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    static void work(){
        Deque<Integer> dq = new LinkedList<>();
        int totalWeight = 0;
        
        for(int i : temp){
            dq.add(i);
        }
        
        for(int i = 0; i < K; i++){
            int weight = 0;
            while(true){
                int cur = dq.poll();
                
                if(weight + cur > M){
                    dq.addFirst(cur);
                    break;
                }
                
                weight += cur;
                dq.add(cur);
            }
            
            totalWeight += weight;
        }
        
        min = Math.min(totalWeight, min);
    }
}