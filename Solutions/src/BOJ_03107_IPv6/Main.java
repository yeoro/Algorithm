package BOJ_03107_IPv6;

import java.io.*;
import java.util.*;

class Main {
	
	static String[] address;
	static StringBuilder og;
	static boolean check;
	static int zero, num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		address = br.readLine().split(":", -1);
		
		System.out.println(Arrays.toString(address));
		
		for(String s : address) {
			if(s.equals("")) {
				zero++;
			} else {
				num++;
			}
		}

		og = new StringBuilder();
		
		if(num == 0) { // 모두 0인 경우
			bw.write("0000:0000:0000:0000:0000:0000:0000:0000\n");
		} else {
			setString();
			
			if(og.charAt(og.length()-1) == ':') {
				og.deleteCharAt(og.length()-1);
						
			}
			
			bw.write(og.toString() + "\n");
		}
		
		bw.flush();
		br.close();
	}
	
	private static void setString() {
		for(int i = 0; i < address.length; i++) {
			StringBuilder sb = new StringBuilder(address[i]);
			
			if(!address[i].equals("")) {
				// 축약된 경우
				while(sb.length() < 4) {
					sb.insert(0, "0");
				}
				
				og.append(sb).append(":");
				
			} else {
				// 0 그룹이 축약된 경우
				if(check) {
					continue;
				}
				
				int expect = 8-i;
				int current = address.length-i;
				int add = expect-current+zero;
				
				System.out.println(expect + " " + current + " " + add);
				
				for(int j = 0; j < add; j++) {
					sb.append("0000:");
				}
				
				og.append(sb);
				
				check = true;
			}
		}
	}
}

