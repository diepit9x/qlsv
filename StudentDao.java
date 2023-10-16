package StudentManagerment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static final String STUDENT_FILE_NAME = "student.txt";
    
    public List<Student> read() {
        List<Student> listStudent = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(STUDENT_FILE_NAME));
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                listStudent = (List<Student>) obj;
            }
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        } finally {
            closeStream(ois);
        }
        return listStudent;
    }

    public void write(Student student) throws IOException{
        if (student == null) {
            throw new IllegalArgumentException("Student object cannot be null");
        }
        List<Student> listStudent = new ArrayList<>(read());
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(STUDENT_FILE_NAME));
            listStudent.add(student);
            oos.writeObject(listStudent);
            System.out.println("Add Success...");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            closeStream(oos);
        }
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
