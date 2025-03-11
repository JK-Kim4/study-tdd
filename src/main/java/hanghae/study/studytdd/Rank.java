package hanghae.study.studytdd;

public enum Rank {

    FIRST("2,000,000,000원"),
    SECOND("30,000,000원"),
    THIRD("1,500,000원"),
    FOURTH("50,000원"),
    FIFTH("5,000원"),
    FAIL("다음 기회에");

    private String price;

    public String getPrice() {
        return price;
    }
    Rank(String price) {
        this.price = price;
    }
}
