package BOJ_11650_��ǥ�����ϱ�;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_11650_��ǥ�����ϱ� {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<coordinates> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(new coordinates(sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list);
		
		for(coordinates c : list) {
			System.out.println(c.x + " " + c.y);
		}
		
		sc.close();
	}
	
}

class coordinates implements Comparable<coordinates> {
	int x;
	int y;
	
	public coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(coordinates o) {
		if(this.x - o.x == 0) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
}

