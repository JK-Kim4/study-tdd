package hanghae.study.studytdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@SpringBootTest
public class LottoTest {

    @Autowired
    Lotto lotto;

    @DisplayName("1-45 범위에 있는 임의의 정수를 생성한다")
    @Test
    public void testA() {
        int randomNumber = lotto.generateNumber();

        Assertions.assertTrue(randomNumber < 46 && randomNumber > 0);
    }

    @DisplayName("중복되지 않은 6개의 숫자를 뽑는다.")
    @Test
    public void testB(){
        lotto.generateWinningNumbers();

        Assertions.assertEquals(6, lotto.getWinningNumbers().size());
    }

    @DisplayName("중복되지 않은 숫자 6개로 로또가 완성되면 보너스 번호 1개를 뽑는다.")
    @Test
    public void testC(){
        lotto.generateBonusNumber();

        Assertions.assertTrue(lotto.getBonusNumber() != null
                && lotto.getBonusNumber() > 0 && lotto.getBonusNumber() < 46);

        Assertions.assertFalse(lotto.getWinningNumbers().contains(lotto.getBonusNumber()));
    }

    @DisplayName("일치하는 번호의 숫자로 등수를 결정한다.")
    @Test
    public void testD(){
        int count = 6;
        Rank result = lotto.getRank(count);

        Assertions.assertEquals(Rank.FIRST, result);
    }

    @DisplayName("로또 등수를 계산한다.")
    @Test
    public void testE(){

        //TODO doLotto 메소드를 실행하면 항상 다른 Rank 결과값을 반환
        Lotto customerLotto = new Lotto();
        Set<Integer> customerNumbers = customerLotto.getWinningNumbers();
        Rank rankResult = lotto.doLotto(customerNumbers);

        Assertions.assertNotNull(rankResult);
    }

}
