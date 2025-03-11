package hanghae.study.studytdd;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component  //JUnit test @Autowired 위해 Bean 등록
public class Lotto {

    private Integer bonusNumber = Integer.MIN_VALUE;
    private final Set<Integer> winningNumbers = new HashSet<>();

    //로또 실행, 사용자 입력을 받아 로또 순위를 리턴
    public Rank doLotto(Set<Integer> customerNumbers) {
        int count = 0;

        this.generateWinningNumbers();
        this.generateBonusNumber();

        for(Integer customerNumber : customerNumbers) {
            if(winningNumbers.contains(customerNumber)){
                count++;
            }
        }

        return getRank(count);
    }

    // 1이상 45이하의 임의의 숫자를 리턴
    public int generateNumber() {
        return (int)(Math.random() * 45) + 1;
    }

    // 중복되지 않은 6개의 (1이상 45이하의) 숫자를 생성하여 winningNumbers 저장
    public void generateWinningNumbers(){
        while (this.winningNumbers.size() < 6){
            this.winningNumbers.add(this.generateNumber());
        }
    }

    // winningNumbers가 조건을 만족(서로다른 숫자 6개)하는 경우 보너스 숫자 생성
    public void generateBonusNumber() {

        if(this.winningNumbers.size() < 6){
            System.out.println("winning number size is less than 6");
            this.generateWinningNumbers();
        }

        while (true){
            Integer bonusNumber = generateNumber();
            if(!this.winningNumbers.contains(bonusNumber)){
                this.bonusNumber = bonusNumber;
                break;
            }
            System.out.println("bonus number " + bonusNumber + " contains winning number");
        }
    }

    // getter
    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    // getter
    public Set<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    // 일치하는 숫자의 갯수로 등수 산출
    public Rank getRank(int count) {

        return switch (count) {
            case 6 -> Rank.FIRST;
            case 5 -> Rank.SECOND;
            case 4 -> Rank.THIRD;
            case 3 -> Rank.FOURTH;
            case 2 -> Rank.FIFTH;
            default -> Rank.FAIL;
        };

    }
}
