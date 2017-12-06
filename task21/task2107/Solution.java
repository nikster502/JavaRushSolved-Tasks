package com.javarush.task.task21.task2107;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты\
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.
*/
public class Solution implements Cloneable{

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        return users != null ? users.equals(solution.users) : solution.users == null;

    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);
            System.out.println(solution.users);
            System.out.println(clone.users);
for (String map : clone.users.keySet()){
    System.out.println(map.toString() + " " + clone.users.get(map));
}
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    protected Solution clone() throws CloneNotSupportedException {
            Solution solution = (Solution) super.clone();
            Map<String,User>cloneMap = new HashMap<>();
            String name;
            User user;
        if (this.users !=null){
            for (Map.Entry<String,User> map : this.users.entrySet()){
                name = map.getKey();
                user = map.getValue();
                cloneMap.put(name,user);
            }
            solution.users = cloneMap;
        }
        else solution.users = null;
        return solution;
    }

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        protected User clone() throws CloneNotSupportedException {
            User user = (User) super.clone();
            return user;

        }
    }
}
