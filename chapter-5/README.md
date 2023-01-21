## 협력 객체 선정 기준
- `DiscountCondtion`과의 협력 후보 - `Screening`, `Movie` 
    - `Screening`
      - 예매 진행을 책임으로 갖고 있음
      - 이에 영화 요금 계산까지 책임으로 가질 경우 변경될 이유를 또 갖게 됨
      - 결과적으로 응집도가 낮아짐
    - `Movie`
        - 이미 `DiscountCondition` 목록을 속성으로 포함하고 있음
        - 이미 결합되어 있으므로 `DiscountCondtion`과의 협력이 설계 전체적인 결합도를 증가시키지는 않음
---
## 할인 조건 클래스 개선

```java
public boolean isSatisfiedBy(Screening screening) {
    if (type == DiscountConditionType.PERIOD) {
        return isSatisfiedByPeriod(screening);
    }

    return isSatisfiedBySequence(screening);
}
```

- 새로운 할인 조건이 추가될 경우
    - `if-else` 구문을 수정해야 함
    - 새로운 데이터를 요구할 경우, 마찬가지로 속성 추가가 필요
- 순번 조건, 기간 조건 판단 로직이 변경될 경우
    - 메서드 내부 구현 수정, 속성 변경 필요

---

## 클래스의 응집도 판단
> **변경의 이유에 따라 클래스를 분리하기**
- `isSatisfiedBySequence`, `isSatisfiedByPeriod` 메서드는 서로 다른 이유로 변경됨
- 서로 다른 이유로 변경되므로, 클래스의 응집도가 낮아짐

> **함께 초기화되는 속성을 기준으로 코드를 분리하기**
- 인스턴스 변수가 초기화되는 시점 확인
- 응집도가 높은 클래스는 인스턴스 생성 시 모든 속성을 함께 초기화 함
- `DiscountCondition`이 순번 조건을 표현하는 경우 `sequence`만 초기화됨
- `DiscountCondition`이 기간 조건을 표현하는 경우 `dayOfWeek`, `startTime`, `endTime`만 초기화됨
- 

> **속성 그룹과 해당 그룹에 접근하는 메서드 그룹을 기준으로 코드 분리하기**
- 메서드들이 인스턴스 변수를 사용하는 방식 확인
- 모든 메서드가 객체의 모든 속성을 사용한다면 클래스의 응집도가 높은 것
- `isSatisfiedBySequence`는 `sequence`만 사용
- `isSatisfiedByPeriod`는 `dayOfWeek`, `startTime`, `endTime`만 사용
