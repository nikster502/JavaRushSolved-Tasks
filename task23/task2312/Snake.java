package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 17.03.2017.
 */
public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;
    public Snake(int x, int y)
    {
        sections=new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x,y));
        isAlive=true;
    }
    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public Snake(SnakeSection snakeSection) {
        this.sections.add(snakeSection);
    }

    /**
     Змейка(15)
     Теперь осталось допилить змею.

     Вот что я предлагаю насчет движения змеи:
     Змея состоит из кусочков. Давай каждый ход просто добавлять один кусочек со стороны головы,
     а самый последний — удалять. Тогда получится, что змея ползет.

     Давай добавим два метода move, один без параметров, а другой с двумя параметрами типа int.

     В методе move без параметров необходимо:
     а) прекратить движение если змея умерла(isAlive == false)
     б) вызвать метод move(0, -1) если направление движения равно SnakeDirection.UP
     в) вызвать метод move(1, 0) если направление движения равно SnakeDirection.RIGHT
     г) вызвать метод move(0, 1) если направление движения равно SnakeDirection.DOWN
     д) вызвать метод move(-1, 0) если направление движения равно SnakeDirection.LEFT

     Метод move с параметрами int, int пока оставим пустым.
     */
    public void move(int x,int y){
    }
    public void move(){
        if (isAlive==false){
        }
        else if (SnakeDirection.UP== this.direction){
            move(0,-1);
        }
        else if (SnakeDirection.RIGHT==this.direction){
            move(1,0);
        }
        else if (SnakeDirection.DOWN==this.direction){
            move(0,1);
        }
        else if (SnakeDirection.LEFT==this.direction){
            move(-1,0);
        }

    }
    public void checkBorders(SnakeSection head){

            if (head.getX() >= Room.game.getHeight() || head.getY() >= Room.game.getWidth() || head.getX() < 0 || head.getY() < 0) {
                isAlive = false;

        }
    }

    public void checkBody(SnakeSection head){
        if (getSections().contains(head)){
        isAlive = false;
        }
    }
    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection()
    {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}

