package math2P;

//문제
//        조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.
//
//
//
//        이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
//
//        조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.
//
//        한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.
//
//        출력
//        각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCase; i++) {
            String num = bf.readLine();

            num.split(" ");
            int x1 = Integer.parseInt(num.split(" ")[0]);
            int y1 = Integer.parseInt(num.split(" ")[1]);
            int r1 = Integer.parseInt(num.split(" ")[2]);
            int x2 = Integer.parseInt(num.split(" ")[3]);
            int y2 = Integer.parseInt(num.split(" ")[4]);
            int r2 = Integer.parseInt(num.split(" ")[5]);

            double pDis = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            double rDis = r1 + r2;

            if (pDis == 0 & r1 == r2) {
                System.out.println(-1);
            } else if (pDis > rDis) {
                System.out.println(0);
            } else if (pDis == rDis) {
                System.out.println(1);
            } else if (pDis < rDis) {
                if (pDis + Math.min(r1, r2) > Math.max(r1, r2)) {
                    System.out.println(2);
                } else if (pDis + Math.min(r1, r2) == Math.max(r1, r2)) {
                    System.out.println(1);
                } else if (pDis + Math.min(r1, r2) < Math.max(r1, r2)) {
                    System.out.println(0);
                }
            }
        }
    }
}

