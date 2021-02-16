package BOJ_02331_�ݺ�����;

import java.util.*;

public class BOJ_02331_�ݺ����� {
	
	static LinkedList<Integer> list = new LinkedList<Integer>();
	static int A, P;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		P = sc.nextInt();
		
		solve(A);
		
		sc.close();
	}
	
	private static void solve(int num) {
		if(list.contains(num)) {
//			System.out.println("���� ��: " + num + " �ߺ� �ε���: " + list.indexOf(num));
			System.out.println(list.indexOf(num));
			return;
		}
		
		list.add(num);
		
		String s = Integer.toString(num);
		int temp = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int n = Integer.parseInt(s.charAt(i)+"");
			
			temp += Math.pow(n, P);
		}
		
		solve(temp);
	}
}
