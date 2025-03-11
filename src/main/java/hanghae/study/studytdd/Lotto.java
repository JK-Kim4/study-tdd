package hanghae.study.studytdd;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Lotto {


    private Integer bonusNumber = Integer.MIN_VALUE;
    private final Set<Integer> winningNumbers = new HashSet<>();

    public Rank doLotto(Set<Integer> customerNumbers) {
        Integer count = 0;

        this.generateWinningNumbers();
        this.generateBonusNumber();

        for(Integer customerNumber : customerNumbers) {
            if(winningNumbers.contains(customerNumber)){
                count++;
            }
        }

        return getRank(count);
    }

    public int generateNumber() {
        return (int)(Math.random() * 45) + 1;
    }

    public void generateWinningNumbers(){
        while (this.winningNumbers.size() < 6){
            this.winningNumbers.add(this.generateNumber());
        }
    }

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

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    public Set<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

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
