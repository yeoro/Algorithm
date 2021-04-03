package PG_2021데브매칭_다단계이익배분;

import java.io.*;
import java.util.*;

public class PG_2021데브매칭_다단계이익배분 {
	
	static LinkedList<String>[] adj;
	
	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		// 0: 민호
		adj = new LinkedList[enroll.length+1];
		
		for(int i = 0, size = enroll.length+1; i < size; i++) {
			adj[i] = new LinkedList<String>();
		}
		
		for(int i = 0, size = referral.length; i < size; i++) {
			
			if(!referral[i].equals("-")) {
				adj[i-1].add(referral[i]);
			} else {
				adj[0].add(enroll[i]);
			}
		}
		
		for(int i = 0; i < enroll.length+1; i++) {
			for(String s : adj[i]) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}

