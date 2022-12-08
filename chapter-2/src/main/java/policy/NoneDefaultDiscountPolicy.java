package policy;

import vo.Money;
import vo.Screening;

public class NoneDefaultDiscountPolicy implements DiscountPolicy {

    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
