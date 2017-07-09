package main.binaryFiles;

import struct.impl.lists.DynamicList;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Student apu= new Student(40269313,"Agustin","Bettati",8.8,true);
        Student mark= new Student(40649002,"Marcos","Khabie",7.5,true);

        StudentFile studentFile = new StudentFile("pija");

        studentFile.writeNewStudent(apu);
        studentFile.writeNewStudent(mark);

        System.out.println(studentFile.lengthOfFile());

        Student encontrado= studentFile.find(40649002);
        System.out.println(encontrado.getName());

        studentFile.deleteStudent(40269313);

        System.out.println("p");

        DynamicList<Student> s = studentFile.studentsList();
        for (int i = 0; i <s.size() ; i++) {
            s.goTo(i);
            System.out.println(s.getActual().getName());
        }

    }
}
