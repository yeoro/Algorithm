package Softeer_level3_사물인식최소면적산출프로그램;

import java.util.*;
import java.io.*;


public class Main
{
	static class Point implements Comparable<Point>{
        int x, y, k;

        public Point(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x - o.x == 0){
                return this.y - o.y;
            }
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + ", k=" + k + "]";
        }
    }
    static List<Point> points = new ArrayList<>();
    static List<Point> temp = new ArrayList<>();
    static boolean[] v, kV;
    static int N, K, start, min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
           
            points.add(new Point(x, y, k));
        }
        
        Collections.sort(points, (o1, o2) -> o1.k - o2.k);
        start = points.get(0).k;
        v = new boolean[points.size()];
        kV = new boolean[K+1];

        solve(0, points.get(0).k);
        
        System.out.println(min);
    }
    
    static void solve(int cur, int no){
        if(temp.size() == 1 && no > 1){
            return;
        }

        if(temp.size() == K){
            Collections.sort(temp);
            cal();
            Collections.sort(temp, (o1, o2) -> o1.k - o2.k);
        }
        
        for(int i = cur; i < points.size(); i++){
            Point p = points.get(i);
            
            if(!v[i] && !kV[p.k]){
                v[i] = true; 
                kV[p.k] = true;
                temp.add(p);

                solve(i+1, p.k);
                
                v[i] = false;
                kV[p.k] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
    
    static void cal(){
        Point p1 = temp.get(0);
        Point p2 = temp.get(temp.size()-1);
        
        int area = Math.abs(p1.x - p2.x) * Math.abs(p1.y - p2.y); 
        
        min = Math.min(min, area);
    }
}