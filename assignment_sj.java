import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class assignment_sj {
    public static void main(String[] args) {
//        - 컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759
        Set<Integer> randomNumber = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int[] userNumInt = new int[3];
        int strike = 0;
        int ball = 0;
        int attempt = 0;

        while (randomNumber.size() < 3) {
            int num = (int) (Math.random() * 10);
            randomNumber.add(num);
        }
        Integer[] numberArray = randomNumber.toArray(new Integer[0]); // 컴퓨터가 만든 숫자 배열

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞혀보세요!");
//                - 사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.

        while (true) {
            attempt++;
            System.out.print(attempt + "번째 시도:");
            String userNumber = sc.nextLine();

            for (int i = 0; i < 3; i++) {
                userNumInt[i] = userNumber.charAt(i) - '0'; // user가 입력한 숫자 배열
            }

            for (int k = 0; k < 3; k++) {
                if (numberArray[k] == userNumInt[k]) {
                    strike++;
                } else {
                    for (int l = 0; l < 3; l++) {
                        if (numberArray[k] == userNumInt[l]) {
                            ball++;
                            break;
                        }
                    }
                }
            }

            if (strike == 3) {
                System.out.printf("3S\n" + attempt + "번만에 맞히셨습니다.\n" + "게임을 종료합니다.\n");
                break;
            } else {
                System.out.println(ball + "B" + strike + "S");
            }
        }
    }
}