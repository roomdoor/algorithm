package sort;

//문제
//        N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
//
//        출력
//        첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());

        int[] check = new int[10001];

        for (int i = 0; i < n; i++) {

            check[Integer.parseInt(bf.readLine())] += 1;

        }

        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < check[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}
