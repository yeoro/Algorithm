package PG_2021KAKAO_메뉴리뉴얼;

import java.util.*;
import java.util.Map.Entry;

public class PG_2021KAKAO_메뉴리뉴얼 {
	
	static String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
	static int[] course = {2, 3, 5};

	static char[] order;
	static boolean[] v;
	static HashMap<String, Integer> orderHm = new HashMap<String, Integer>(); // 메뉴 구성과 주문 횟수 관리
	static ArrayList<Character> orderComb; // 메뉴 구성 관리
	static ArrayList<String> courseResult = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		// 메뉴들의 조합 생성
		for(int i = 0; i < orders.length; i++) {
			orderComb = new ArrayList<Character>();
			order = orders[i].toCharArray();
			v = new boolean[order.length];
			
			makeCourse(0);
		}
		
		for(int i = 0; i < course.length; i++) {
			ArrayList<Entry<String, Integer>> courseList = new ArrayList<Entry<String, Integer>>(); 
			
			// 코스 종류에 따라 최소 2명 이상의 손님이 주문한 코스 저장  
			for(Map.Entry<String, Integer> elem : orderHm.entrySet()) {
				if(elem.getKey().length() == course[i] && elem.getValue() >= 2) {
					courseList.add(elem);
				}
			}

			// 주문 횟수를 기준으로 내림차순으로 정렬
			Collections.sort(courseList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

			// 조건에 만족하는 코스요리가 있을 경우
			if(courseList.size() > 0) {
				// 최대 주문 횟수를 가진 값이 여러 개일 수 있기 때문에 최대값의 기준을 잡음
				int max = courseList.get(0).getValue();
				
				// value가 최대 주문 횟수와 같으면 최종 후보로 저장
				for(Map.Entry<String, Integer> elem : courseList) {
					if(elem.getValue() == max) {
						courseResult.add(elem.getKey());
					}
				}
			}
		}

		// 최종 후보 코스들의 이름을 사전 순으로 오름차순 정렬
		Collections.sort(courseResult, (o1, o2) -> o1.compareTo(o2));
		
		String[] answer = courseResult.toArray(new String[courseResult.size()]);
		
		System.out.println(Arrays.toString(answer));
	}
	
	private static void makeCourse(int depth) {
		if(depth > order.length) {
			return;
		}
		
		if(orderComb.size() >= 2) {
			// 'AB'와 'BA'를 같은 코스요리로 처리하기 위해 문자 배열에 메뉴를 담고 사전 순으로 오름차순하여 정렬한 후 코스요리 후보에 저장
			char[] sbToArr = new char[orderComb.size()];
			
			for(int i = 0; i < orderComb.size(); i++) {
				sbToArr[i] = orderComb.get(i);
			}
			
			Arrays.sort(sbToArr);
			
			String course = "";
			
			for(int i = 0; i < sbToArr.length; i++) {
				course += sbToArr[i];
			}
			
			if(!orderHm.containsKey(course)) {
				orderHm.put(course, 1);
			} else {
				orderHm.replace(course, orderHm.get(course)+1);
			}

		}
		
		for(int i = depth; i < v.length; i++) {
			if(!v[i]) {
				v[i] = true;
				orderComb.add(order[i]);	
				makeCourse(i+1);
				v[i] = false;
				orderComb.remove(orderComb.size()-1);
			}
		}
	}
}

