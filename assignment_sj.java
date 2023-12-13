import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class assignment_sj {
    public class test {
        public static void main(String[] args) {
//        - 컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759
            Set<Integer> randomNumber = new HashSet<>();
            Scanner sc = new Scanner(System.in);
            int[] userNumInt = new int[3];

            while (randomNumber.size()<3){
                int num = (int)(Math.random()*10);
                randomNumber.add(num);
            }

            System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞혀보세요!");
//                - 사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.
            for(int i=1; i<2; i++){
                System.out.print(i+"번째 시도:");
                String userNumber = sc.nextLine();

                for(int j = 0; j<3 ; j++){
                    userNumInt[j] = userNumber.charAt(j)-'0';
//                System.out.println(userNumInt[0]);
                    HashSet.contains(userNumInt[j]) -> B개수 -> 위치 파악 불가 2
                    Hash -> Array
                    arry[k] userNumInt[k] -> S개수 1
                    B-S: S개수
                    if (s 3개)
                }
            }

//        - 컴퓨터는 사용자가 입력한 세자리 숫자에 대해서, 아래의 규칙대로 스트라이크(S)와 볼(B)를 알려줍니다.

//        - 숫자의 값과 위치가 모두 일치하면 S
//                - 숫자의 값은 일치하지만 위치가 틀렸으면 B
//                - 기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록됩니다.
//        - 숫자 3개를 모두 맞춘 경우, 게임을 종료합니다.

        }

    }

}
