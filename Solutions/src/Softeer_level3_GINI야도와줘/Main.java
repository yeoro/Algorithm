package Softeer_level3_GINIæﬂµµøÕ¡‡;

import java.util.*;
import java.io.*;


public class Main
{
	static class Node {
        int x, y, dis;
        
        public Node(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
        
        public String toString(){
            return "(" + x + ", " + y + ") - " + dis;
        }
    }
    static Queue<Node> tq = new LinkedList<>();
    static Queue<Node> rq = new LinkedList<>();
    static char[][] map;
    static boolean[][] v;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int R, C, min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        v = new boolean[R][C];
        
        for(int i = 0; i < R; i++){
            String input = br.readLine();
            
            for(int j = 0; j < C; j++){
                map[i][j] = input.charAt(j);
                
                if(map[i][j] == 'W'){
                    tq.add(new Node(i, j, 0));
                } else if(map[i][j] == '*'){
                    rq.add(new Node(i, j, 0));
                }
            }
        }

        solve();
        
        if(min == Integer.MAX_VALUE){
            System.out.println("FAIL");
        } else {
            System.out.println(min);
        }
    }
    
    static void solve(){
        while(!tq.isEmpty()){
            for(int i = 0, size = rq.size(); i < size; i++){
                Node cur = rq.poll();
                
                for(int j = 0; j < 4; j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(isIn(nx, ny) && map[nx][ny] == '.'){
                        map[nx][ny] = '*';
                        rq.offer(new Node(nx, ny, 0));
                    }
                }
            }
            
            for(int i = 0, size = tq.size(); i < size; i++){
                Node cur = tq.poll();
                
                for(int j = 0; j < 4; j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    
                    if(isIn(nx, ny) && !v[nx][ny]){
                        if(map[nx][ny] == 'H'){
                            min = Math.min(min, cur.dis+1);
                            return;
                        }
                        
                        if(map[nx][ny] == '.'){
                            v[nx][ny] = true;
                            tq.offer(new Node(nx, ny, cur.dis+1));
                        }
                    }
                }
            }
        }
    }
    
    static boolean isIn(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}