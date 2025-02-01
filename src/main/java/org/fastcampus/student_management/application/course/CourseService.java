package org.fastcampus.student_management.application.course;

import java.util.ArrayList;
import java.util.List;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.CourseList;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

public class CourseService {

  private final CourseRepository courseRepository;
  private final StudentService studentService;

  public CourseService(CourseRepository courseRepository, StudentService studentService) {
    this.courseRepository = courseRepository;
    this.studentService = studentService;
  }

  public void registerCourse(CourseInfoDto courseInfoDto) {
    Student student = studentService.getStudent(courseInfoDto.getStudentName());
    Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(),
        courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
    courseRepository.save(course);
  }

  public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
    // TODO: 과제 구현 부분
    List<Course> courses = courseRepository.getCourseDayOfWeek(dayOfWeek);
/*    List<CourseInfoDto> courseInfoDtoList = new ArrayList<>();
    for(Course c : courseList) {
      CourseInfoDto cid = new CourseInfoDto(c);
      courseInfoDtoList.add(cid);
    }
    return courseInfoDtoList;*/

    /* lamda식 -> for문을 안써도 되므로 간결함 */
    return courses.stream().map(CourseInfoDto::new).toList();
  }

  public void changeFee(String studentName, int fee) {
    // TODO: 과제 구현 부분
/*    List<Course> studentCourseList = courseRepository.getCourseListByStudent(studentName);
    List<Course> newStudentCourseList = new ArrayList<>();
    for(Course c : studentCourseList) {
      Course newCourse = new Course(c.getStudent(), c.getCourseName(), fee, c.getDayOfWeek(), c.getCourseTime());
      newStudentCourseList.add(newCourse);
    }

    courseRepository.saveCourses(newStudentCourseList);*/

    List<Course> courses = courseRepository.getCourseListByStudent(studentName);
    CourseList courseList = new CourseList(courses);
    courseList.changeAllCoursesFee(fee);
  }
}
