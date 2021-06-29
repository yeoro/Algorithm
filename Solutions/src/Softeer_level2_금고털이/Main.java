package Softeer_level2_±›∞Ì≈–¿Ã;
import java.util.*;
import java.io.*;


public class Main
{
	static class Jewel implements Comparable<Jewel>{
		int m, p;

		public Jewel(int m, int p) {
			this.m = m;
			this.p = p;
		}

		@Override
		public int compareTo(Jewel o) {
			return Integer.compare(o.p, this.p);
		}
	}

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Jewel[] j = new Jewel[N];
		int price = 0;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			j[i] = new Jewel(Integer.parseInt(st.nextToken()),  Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(j);

		for(Jewel e : j) {
			if(W >= e.m) {
				W -= e.m;
				price += (e.m*e.p);
			} else {
				price += (W%e.m)*e.p;
				break;
			}
		}

		System.out.println(price);

		br.close();
	}
}