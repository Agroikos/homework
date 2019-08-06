package hackerrank.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

class Student implements Comparable <Student>, Comparator<Student> {
    private int id;
    private String fname;
    private double cgpa;

    @Override
    public int compareTo(Student o) {
        if (this == o) return 0;

        if (o.cgpa == this.cgpa) {
            if (o.fname.equals(this.fname)) return this.id - o.id;
            else return this.fname.compareTo(o.fname);
        }
        else if (o.cgpa-this.cgpa < 0) return -1;
        else return 1;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == o2) return 0;

        if (o1.cgpa == o2.cgpa) {
            if (o1.fname.equals(o2.fname)) return o1.id-o2.id;
            else return o1.fname.compareTo(o2.fname);
        }
        else return (int) Math.round(o1.cgpa-o2.cgpa);

    }

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
public class SortExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        //List<Student> newStudentList =
        //Collections.sort(studentList);

        //studentList.stream().forEach( st -> System.out.print(st.getFname() + "(" + st.getCgpa() + ") "));
        //System.out.println();

        //studentList.stream().sorted().forEach( st -> System.out.print(st.getFname() + "(" + st.getCgpa() + ") "));
        studentList.stream().sorted().forEach( st -> System.out.println(st.getFname()));

    }
}



