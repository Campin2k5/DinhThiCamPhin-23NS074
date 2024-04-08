package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Student;
import view.StudentView;

public class StudentController {
	private List<Student>students;
	private StudentView view;
	
	public StudentController(StudentView view) {
		this.students=new ArrayList<>();
		this.view=view;
	}
	
	public void addStudent(String id,String name, int age) {
		Student student=new Student(id,name, age);
		students.add(student);
	}
	
	public void deleteStudent(String id) {
        students = students.stream().filter(student -> !student.getId().equals(id)).collect(Collectors.toList());
    }
	
	public void updateStudent(String id, String newName, int newAge) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setAge(newAge);
                break;
            }
        }
    }
	
	public void displayStudent(String id) {
		for(Student student:students) {
			if(student.getName().equals(id)){
				view.printStundentDetails(student);
				return;
			}
		}
		System.out.println("Student not found!");
	}
	
	public void displayAllStudents() {
		view.printStudentList(students);
	}
	
	public void saveStudentsToFile(String filename) {
		try {
			FileOutputStream fileOut=new FileOutputStream(filename);
			ObjectOutputStream objectOut=new ObjectOutputStream(fileOut);
			objectOut.writeObject(students);
			objectOut.close();
			fileOut.close();
			System.out.println("Student save to "+fileOut+" successfuly!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadStudentsFromFile(String filename) {
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			students = (List<Student>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Students loaded from " + filename + " successfully!");
		} catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
		}
	}
	public List<Student> getStudents() {
        return students;
    }
}
