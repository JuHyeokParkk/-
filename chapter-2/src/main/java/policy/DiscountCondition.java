package policy;

import vo.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
