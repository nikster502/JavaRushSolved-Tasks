package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
   private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {

        return students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }




    public University(String name, int age) {
        this.name =name;
        this.age = age;

    }

    public Student getStudentWithAverageGrade( double averageGrade) {
for (Student student : students){
if (student.getAverageGrade() == averageGrade){
    return student;
}
}
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        int max=0;
        for (int i =0;i<students.size();i++){
            if (students.get(i).getAverageGrade()> students.get(max).getAverageGrade() ){
              max =i;
            }
        }
        return students.size() == 0 ? null : students.get(max);
    }

    public Student getStudentWithMinAverageGrade() {
        int min=0;
        for (int i =0;i<students.size();i++){
            if (students.get(i).getAverageGrade()< students.get(min).getAverageGrade() ){
                min =i;
            }
        }
        return students.size() == 0 ? null : students.get(min);
    }
    public void expel(Student student){
        for (int i=0;i<students.size();i++){
            if (students.get(i).equals(student)){
                students.remove(i);
            }
        }
    }
}