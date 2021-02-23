public class FloydWarshall {

	public static void main(String[] args) {
		int N = 4; // 정점 갯수
		int INF = 987654321;
		int[][] arr = {
				{0, 5, INF, 8},
				{7, 0, 9, INF},
				{2, INF, 0, 4},
				{INF, INF, 3, 0}
		};
		int[][] result = new int[N][N];
		
		// 배열 초기화
		for(int i = 0; i < arr.length; i++) {
			System.arraycopy(arr[i], 0, result[i], 0, arr[i].length);
		}
		
		// 경유 정점
		for(int k = 0; k < N; k++) { 
			// 출발 정점
			for(int i = 0; i < N; i++) { 
				// 도착 정점
				for(int j = 0; j < N; j++) { 
					// 바로 가는 경로와 경유 정점을 거치는 경로 비교 후 가중치가 적은 경로 선택
					if(result[i][k] + result[k][j] < result[i][j]) {
						result[i][j] = result[i][k] + result[k][j];
					}
				}
			}
		}
		
		// 결과
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(Double.POSITIVE_INFINITY);
		System.out.println(10000*100 + 1);
		System.out.println(987654321);
	}

}
