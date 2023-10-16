package StudentManagerment;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentManager st = new StudentManager();
        //st.add();
        st.show();
    }
    public void add() {
        Student addStudent = new Student();

        System.out.println("________ADD STUDENT_________");
        System.out.print("Nhap ID: ");
        addStudent.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nhap Name: ");
        addStudent.setName(scanner.nextLine());

        System.out.print("Nhap Age: ");
        addStudent.setAge(scanner.nextInt());
        scanner.nextLine();
        
        System.out.print("Nhap Address: ");
        addStudent.setAddress(scanner.nextLine());

        System.out.print("Nhap GPA: ");
        addStudent.setGpa(scanner.nextDouble());


        StudentDao studentDao = new StudentDao();
        //add
        try {
            studentDao.write(addStudent);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void show() {
        StudentDao studentDao = new StudentDao();
        List<Student> list = studentDao.read();
        for (Student student : list) {
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%5d | ", student.getAge());
            System.out.format("%20s | ", student.getAddress());
            System.out.format("%10.1f%n", student.getGpa());
        }
    }
    private void deleteStudent(int id){
        StudentDao studentDao = new StudentDao();
        List<Student> list = studentDao.read();
        boolean status = false;
        for (Student student : list) {
            if(student.getId() == id) {
                status = true;
                list.remove(student);
            }
        }
    }
}
