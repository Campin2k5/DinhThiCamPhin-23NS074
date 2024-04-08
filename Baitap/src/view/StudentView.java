package view;

import java.util.List;
import model.Student;

public class StudentView {
		public void printStundentDetails(Student student) {
			System.out.println("Student:");
			System.out.println("Id: "+student.getId());
			System.out.println("Name: "+student.getName());
			System.out.println("Age: "+student.getAge());
		}
		public void printStudentList(List<Student>students) {
			System.out.println("Thông tin sinh viên: ");
			for(Student student:students) {
				System.out.println("Mã sinh viên: "+student.getId());
				System.out.println("Tên sinh viên: "+student.getName());
				System.out.println("Tuổi sinh viên: "+student.getAge());
			}
		}

}
