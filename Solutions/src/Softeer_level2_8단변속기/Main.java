package Softeer_level2_8단변속기;

import java.util.*;
import java.io.*;


public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		boolean a = false;
		boolean d = false;

		int pre = Integer.parseInt(st.nextToken());

		while(st.hasMoreTokens()) {
			int cur = Integer.parseInt(st.nextToken());

			if(pre < cur) {
				a = true;
			} else {
				d = true;
			}

			pre = cur;
		}

		if(a && d) {
			System.out.println("mixed");
		} else if(a) {
			System.out.println("ascending");
		} else if(d) {
			System.out.println("descending");
		}

		br.close();
	}
}