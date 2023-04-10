package zerobaseCT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1 {

	static int[] bullets;
	static Target[][] board;
	static int N;
	static int K;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result = 0;

	public static void main(String[] args) throws IOException {

		input();

		dfs(0, 0);

		System.out.println(result);
	}

	private static void dfs(int point, int bulletNumber) {
		if (bulletNumber >= K) { // k 번째 총알까지 다 쐈을 때
			result = Math.max(result, point);
			return;
		}

		for (int i = 0; i < N; i++) { // N 번째 행에서 쐇을 때
			for (int j = 0; j < N; j++) { // 타겟이 있는 곳까지 N 번째 열까지 탐색

				if (board[i][j].curLife > 0) { // i,j에 타겟이 있을 때

					if (board[i][j].curLife >= 10) { // 보너스 일 때
						int before = board[i][j].curLife;
						board[i][j].curLife = 0;
						dfs(point + board[i][j].initialLife, bulletNumber + 1);
						board[i][j].curLife = before;
						break;

					} else if (board[i][j].curLife <= bullets[bulletNumber]) { // 타겟이 총알에 맞고 터질 때
						Target[] isCreated = new Target[4]; // 사방에 생긴 새로운 타겟 위치
						int createTargetPoint = board[i][j].initialLife / 4;

						if (createTargetPoint >= 1) {
							for (int k = 0; k < 4; k++) {                    // 사방에 생길 수 있는 지 확인
								int createX = i + dx[k];
								int createY = j + dy[k];

								if (isPossible(createX, createY)) {
									isCreated[k] = board[createX][createY];
									board[createX][createY] = new Target(createTargetPoint);
								}
							}

							int before = board[i][j].curLife;
							board[i][j].curLife = 0;
							dfs(point + board[i][j].initialLife, bulletNumber + 1);
							board[i][j].curLife = before;
							for (int k = 0; k < 4; k++) {
								if (isCreated[k] != null) {
									board[i + dx[k]][j + dy[k]] = isCreated[k];
								}
							}
							break;

						} else {
							int before = board[i][j].curLife;
							board[i][j].curLife = 0;
							dfs(point + board[i][j].initialLife, bulletNumber + 1);
							board[i][j].curLife = before; // 롤백
							break;

						}

					} else {                                            // 총알 데미지가 모자랄 때
						board[i][j].curLife -= bullets[bulletNumber];
						dfs(point, bulletNumber + 1);
						board[i][j].curLife += bullets[bulletNumber];
						break;

					}
				}
			}
		}


	}

	private static boolean isPossible(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N && board[x][y].curLife == 0;
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		K = Integer.parseInt(bf.readLine());
		board = new Target[N][N];
		bullets = new int[K];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				int point = Integer.parseInt(st.nextToken());
				board[i][j] = new Target(point);
			}
		}

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < K; i++) {
			bullets[i] = Integer.parseInt(st.nextToken());
		}
	}


	private static class Target {

		int initialLife;
		int curLife;

		public Target(int initialLife) {
			this.initialLife = initialLife;
			this.curLife = initialLife;
		}
	}
}


