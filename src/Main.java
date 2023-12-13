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
        // 리스트에 0~9 숫자 넣어주기
        List<Integer> numberList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            numberList.add(i);
        }
        // 리스트에 들어있는 0~9 숫자 랜덤순으로 섞기
        Collections.shuffle(numberList);


        // 섞인 리스트에서 숫자 3개 뽑기.
        int num1 = numberList.get(0);
        if(num1==0) {
            num1 = numberList.get(3);
        }
        int num2 = numberList.get(1);
        int num3 = numberList.get(2);
        // 뽑은 3개의 숫자로 세 자리 수 생성!
        int number = num1*100 + num2*10 + num3;
//        System.out.println(number);



        System.out.println("컴퓨터가 숫자를 뽑았습니다! 답을 맞춰보세요!!");
        List<Character> numberAr = String.valueOf(number).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        // 2. 숫자 받아오기!
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int tryNum = 0;
        int i=0;
        int B=0;
        int S=0;

        while (flag) {
            tryNum = sc.nextInt();
            i++;
            B=0;
            S=0;

            // 다 맞췄을 경우 먼저.
            if (tryNum == number) {
                flag = false;
                System.out.println("3S!!");
                System.out.println(i+"번의 시도만에 맞췄습니다!");
            }

            // 각 자리수마다 비교하기 위해 숫자를 숫자 리스트로 만들어줌
            List<Character> tryAr = String.valueOf(tryNum).chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.toList());
            for (int j = 0; j <3 ; j++) {
                if(numberAr.get(j)==tryAr.get(j)) {
                    S++;
                } else if(String.valueOf(number).contains(String.valueOf(tryAr.get(j)))) {
                    B++;
                }
            }


            System.out.println(tryAr);

            System.out.println(B+"B"+S+"S");


        }
    }
}

