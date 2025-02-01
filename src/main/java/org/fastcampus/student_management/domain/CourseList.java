package org.fastcampus.student_management.domain;

import java.util.List;

public class CourseList {

  /*
  1급 콜렉션 사용시 장점
  * 로직을 한눈에 파악하기 쉽다
  * 재사용이 가능하다.
  * 중요!!! 테스트가 쉬워진다.
  * */
  private final List<Course> courses;

  public CourseList(List<Course> courses) {
    this.courses = courses;
  }

  public void changeAllCoursesFee(int fee) {
    for(Course course: courses) {
      if(course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
        course.changeFee((int) (fee * 1.5));
      }
      course.changeFee(fee);
    }
  }

}
