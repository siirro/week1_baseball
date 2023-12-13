import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // 1. 랜덤숫자 생성(3자리, 자리수 겹치지 않기)
        // 리스트에 0~9 숫자 하나씩 넣어주기
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(i);
        }

        // 리스트에 들어있는 0~9 숫자를 랜덤순으로 섞기
        Collections.shuffle(numberList);

        // 섞인 리스트에서 숫자 3개 뽑기.
        int num1 = numberList.get(0);
        if(num1==0) {        // 세자리수의 가장 앞자리가 0이면 안되기 때문에 0이 나왔을 시 다른 숫자를 넣어준다.
            num1 = numberList.get(3);
        }
        int num2 = numberList.get(1);
        int num3 = numberList.get(2);
        // 뽑은 3개의 숫자로 세 자리 수 생성!
        int number = num1*100 + num2*10 + num3;
//        System.out.println(number);

        System.out.println("컴퓨터가 숫자를 뽑았습니다! 답을 맞춰보세요!!");

        // 각 자리수마다 비교하기 위해 숫자를 숫자 리스트로 만들어줌 2) 정답숫자
        List<Character> numberAr = String.valueOf(number).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());


        // 2. 스캐너와 기본 변수 설정!
        Scanner sc = new Scanner(System.in);
        int tryNum = 0;
        int i=1;
        int B=0;
        int S=0;


        // 3. 반복문으로 tryNum(맞추기 시도)과 number(정답 숫자) 판단하기!
        while (true) {
            System.out.print(i+"번째 시도 : ");
            tryNum = sc.nextInt();

            if(String.valueOf(tryNum).length()==3) {

                B = 0;
                S = 0;



                // 각 자리수마다 비교하기 위해 숫자를 숫자 리스트로 만들어줌 1) 시도숫자
                List<Character> tryAr = String.valueOf(tryNum).chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList());

                // 서로 같은 자리의 수를 의미하는, 두 숫자의 같은 리스트 번호를 계속 비교한다.
                // 같은 자리에 같은 숫자가 있으면 S를 하나 올리고, 같은 자리에는 같은 숫자가 들어있지않지만, 전체 숫자에 지금의 리스트 번호의 숫자가 들어있으면 B가 1씩 올라간다.
                for (int j = 0; j < 3; j++) {
                    if (numberAr.get(j) == tryAr.get(j)) {
                        S++;
                    } else if (numberAr.get(j) != tryAr.get(j) && String.valueOf(number).contains(String.valueOf(tryAr.get(j)))) {
                        B++;
                    }
                }

                // 시도한 숫자의 결과 출력
                String result = B + "B" + S + "S";
                System.out.println(result);

                if(result.equals("0B3S")) {
                    System.out.println(i + "번의 시도만에 맞췄습니다!");
                    System.out.println("게임을 종료합니다.");
                    break;
                }

                // 다 맞췄을 경우
//                if (tryNum == number) {
//                    System.out.println(i + "번의 시도만에 맞췄습니다!");
//                    System.out.println("게임을 종료합니다.");
//                    break;
//                }

                i++;

            } else {
                System.out.println("3자리 수를 입력해주세요.");
            }
        }
    }
}

