package org.fastcampus.student_management.domain;

public class CourseFee {

  /* 객체를 따로 만듦으로써 재사용가능, 캡슐화, 눈에 확 보임 */
  private int fee;

  public CourseFee(int fee) {
    this.fee = fee;
  }

  public void changeFee(int fee) {
    this.fee = fee;
  }

  private void checkFee(int fee) {
    if(fee < 0) {
      throw new IllegalArgumentException("수강료는 0원 이상이어야 합니다.");
    }
  }

  public int getFee() {
    return fee;
  }

}
