package policy;

import vo.Money;
import vo.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
