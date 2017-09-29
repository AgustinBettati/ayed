package main.studentManagmentBinaryFiles;

import struct.impl.lists.DynamicList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class StudentFile {
    private File file;
    private RandomAccessFile randomAccessFile;
    private int registerSize;


    public StudentFile(String fileName) throws Exception {
        registerSize = 47;
        file = new File(fileName);
        randomAccessFile = new RandomAccessFile(file, "rw");

    }

    public void writeNewStudent(Student student) throws IOException {

        randomAccessFile.seek(lengthOfFile());
        writeStudent(student);

    }

    private void writeStudent(Student student) throws IOException {
        randomAccessFile.writeInt(student.getDni());
        randomAccessFile.writeUTF(student.getSurname());
        randomAccessFile.writeUTF(student.getName());
        randomAccessFile.writeDouble(student.getAverage());
        randomAccessFile.writeBoolean(student.isActive());

    }

    public long lengthOfFile() throws IOException {

        return randomAccessFile.length();
    }

    public int amountOfStudents() throws IOException {
        return (int) ((randomAccessFile.length()) / registerSize);
    }

    public Student find(int dni) throws IOException {

        randomAccessFile.seek(0);
        Student student;

        for (int i = 0; i < randomAccessFile.length(); i++) {

            student = read();
            if (student.getDni() == dni && student.isActive()) {
                return student;
            }
        }
        throw new StudentNotFoundException("The student was not found.");
    }

    public Student read() throws IOException {
        return new Student(randomAccessFile.readInt(), randomAccessFile.readUTF(), randomAccessFile.readUTF(), randomAccessFile.readDouble(),
                randomAccessFile.readBoolean());
    }

    public boolean deleteStudent(int dni) throws IOException {
        try {
            Student student = find(dni);
            randomAccessFile.seek(randomAccessFile.getFilePointer() - registerSize);
            student.setActive(false);
            writeStudent(student);
            return true;
        } catch (StudentNotFoundException e) {
            return false;
        }

    }

    public boolean changeAverageOfStudent(int dni, double newAverage) throws IOException {
        try {
            Student student = find(dni);
            randomAccessFile.seek(randomAccessFile.getFilePointer() - registerSize);
            student.setAverage(newAverage);
            writeStudent(student);
            return true;
        } catch (StudentNotFoundException e) {
            return false;
        }

    }

    public DynamicList<Student> studentsList() throws IOException {
        DynamicList<Student> students = new DynamicList<>();
        randomAccessFile.seek(0);
        Student student;
        for (int i = 0; i < amountOfStudents(); i++) {
            student = read();
            if (student.isActive()) {
                students.insertNext(student);
            }
        }
        return students;
    }

    public DynamicList<Student> listOfStudentsAbove(double minAverage) throws IOException {
        DynamicList<Student> studentsAboveAverage = new DynamicList<>();
        randomAccessFile.seek(0);
        Student student;
        for (int i = 0; i < amountOfStudents(); i++) {
            student = read();
            if (student.isActive() && student.getAverage()>=minAverage) {
                studentsAboveAverage.insertNext(student);
            }
        }
        return studentsAboveAverage;
    }

    public void generateIndexFile(){
        try {
            FileWriter fw = new FileWriter("indexFile.txt");
            randomAccessFile.seek(0);
            Student student;
            for (int i = 0; i < amountOfStudents(); i++) {
                int positionInFile = (int)randomAccessFile.getFilePointer();
                student = read();
                if (student.isActive()) {
                    fw.write("DNI: " + student.getDni()+ " --> position: " + positionInFile + "\n");
                }
            }
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void close() throws IOException {
        randomAccessFile.close();
    }
}
