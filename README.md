## [방법론] 3주차. 테스트 코드 작성

TDD, TEST 코드 작성 실습

#### 요구사항
(우테코 프리코스 백엔드 과제 - lotto의 요구사항입니다.)
```text
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

 - src/main/java/hanghae/study/studytdd/Lotto.class: 로또 기능이 포함된 코어
 - src/test/java/hanghae/study/studytdd/LottoTest.class: Lotto.class TEST 코드
 - src/main/java/hanghae/study/studytdd/Rank.enum: 로또 등수 저장 enum type
 