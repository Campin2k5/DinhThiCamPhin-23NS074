package test;

import java.util.Scanner;

import controller.StudentController;
import view.StudentView;

public class Main {
	public static void main(String[] args) {      
		    Scanner scanner = new Scanner(System.in);
		    StudentView view = new StudentView();
	        StudentController controller = new StudentController(view);

	        int choice;
	        do {
	            System.out.println("----- MENU -----");
	            System.out.println("1. Thêm sinh viên");
	            System.out.println("2. Hiển thị danh sách sinh viên");
	            System.out.println("3. Sửa sinh viên");
	            System.out.println("4. Xóa sinh viên");
	            System.out.println("5. Xem file lưu sinh viên");
	            System.out.println("0. Thoát");
	            System.out.print("Nhập lựa chọn: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                	scanner.nextLine(); // Đọc dòng trống sau khi đọc số nguyên
	                    System.out.print("Nhập mã sinh viên: ");
	                    String id = scanner.nextLine();
	                    System.out.print("Nhập tên sinh viên: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Nhập tuổi sinh viên: ");
	                    int age = scanner.nextInt();
	                    controller.addStudent(id, name, age);
	                    break;
	                case 2:
	                	controller.displayAllStudents();
	                    break;
	                case 3:
	                    scanner.nextLine(); // Đọc dòng trống sau khi đọc số nguyên
	                    System.out.print("Nhập mã sinh viên cần sửa: ");
	                    String editId = scanner.nextLine();
	                    System.out.print("Nhập tên mới: ");
	                    String newName = scanner.nextLine();
	                    System.out.print("Nhập tuổi mới: ");
	                    int newAge = scanner.nextInt();
	                    controller.updateStudent(editId, newName, newAge);
	                    break;
	                case 4:
	                    scanner.nextLine(); // Đọc dòng trống sau khi đọc số nguyên
	                    System.out.print("Nhập mã sinh viên cần xóa: ");
	                    String deleteId = scanner.nextLine();
	                    controller.deleteStudent(deleteId);
	                    break;
	                case 5:
	                	System.out.println("Xem file lưu ở đâu.");
	        	        controller.saveStudentsToFile("students.dat");
	        	        controller.loadStudentsFromFile("students.dat");
	                case 0:
	                    System.out.println("Thoát chương trình.");
	                    break;
	                default:
	                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
	                    break;
	            }
	            System.out.println();
	        } while (choice != 0);
	        scanner.close();
            
	}
	
	
}
