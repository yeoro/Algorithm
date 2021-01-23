package BOJ_01406_������;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_01406_������ {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String s = br.readLine();
		List<String> list = new LinkedList<String>();
		
		for(int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i) + "");
		}
		
		int M = Integer.parseInt(br.readLine());

		ListIterator<String> it = list.listIterator();
		while(it.hasNext()) {
			it.next();
		}
		
		for(int i = 0; i < M; i++) {
			String order = br.readLine();
			st = new StringTokenizer(order);
			
			switch(st.nextToken()) {
				case "L":
					// Ŀ���� �������� �� ĭ �ű� (�� ���̸� ����)
					if(it.hasPrevious()) {
						it.previous();
					}
					break;
				case "D":
					// Ŀ���� ���������� �� ĭ �ű� (�� �������̸� ����)
					if(it.hasNext()) {
						it.next();
					}
					break;
				case "B":
					// Ŀ�� ������ ���� ����
					if(it.hasPrevious()) {
						it.previous();
						it.remove();
					}
					break;
				case "P":
					// Ŀ�� ���ʿ� ���� �߰�
					it.add(st.nextToken());
					break;
				default:
					break;
			}
		}
		
		for(String temp : list) {
			bw.write(temp);
		}
		
		br.close();
		bw.flush();
	}
	
}
