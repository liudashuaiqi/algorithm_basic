package class04比较器与堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//比较器的写法
public class Code01_Comparator {
    public static class Student{
        public String name;
        public int id;
        public int age;
        public Student(String name,int id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id-o2.id;
        }
    }
    public static class AgeShengIdSheng implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age!=o2.age?(o1.age-o2.age):(o1.id-o2.id);
        }
    }
    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }
    public static void main(String[] args){
        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 1, 22);

        Student[] stu = new Student[]{student1,student2,student3};
        Arrays.sort(stu,new IdAscendingComparator());
        printStudents(stu);
        System.out.println("===========================");

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
        heap.add(student1);
        heap.add(student2);
        heap.add(student3);
        while(!heap.isEmpty()){
            System.out.println(heap.poll().id);
        }
    }
}
