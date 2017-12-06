package com.javarush.task.task23.task2304;

import java.util.List;
import java.util.Map;

/*
Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого — обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого — обновить поле names.
*/
public class Solution {

    private List<Task> tasks;

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    private class TaskDataProvider{

    }
    private class NameDataProvider{

    }
    public static void main(String[] args) {

    }
}
