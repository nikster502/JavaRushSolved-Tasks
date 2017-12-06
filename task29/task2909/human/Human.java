package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
   private static int nextId = 0;
   protected  Size size;
    private int id;
    protected int age;
    protected String name;

    private List<Human> children = new ArrayList<>();

public class Size{
    public int height , weight;
}

    private  BloodGroup bloodGroup;

    public String getPosition(){
        return "Человек";
    }
    public void printData() {
        System.out.println(getPosition()+": " + name);
    }
    public List<Human> getChildren() {
        return  Collections.unmodifiableList(children);
    }

    public void addChild(Human human){
        children.add(human);
    }
    public void removeChild(Human human){
        for (int i=0;i<children.size();i++){
            if (children.get(i).equals(human)){
                children.remove(i);
            }
        }

    }

    public Human(String name,int age) {
        this.age = age;
        this.name = name;
        this.id = nextId;
        nextId++;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " +size.height + " Вес: " + size.weight);
    }

    @Override
    public void live() {

    }
}