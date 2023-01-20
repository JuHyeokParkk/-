## step 1
- `DiscountCondtion`과의 협력 후보 - `Screening`, `Movie` 
    - `Screening`
      - 예매 진행을 책임으로 갖고 있음
      - 이에 영화 요금 계산까지 책임으로 가질 경우 변경될 이유를 또 갖게 됨
      - 결과적으로 응집도가 낮아짐
    - `Movie`
        - 이미 `DiscountCondition` 목록을 속성으로 포함하고 있음
        - 이미 결합되어 있으므로 `DiscountCondtion`과의 협력이 설계 전체적인 결합도를 증가시키지는 않음