package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
Разреши клонировать класс А
Запрети клонировать класс B
Разреши клонировать класс C
Не забудь о методах equals и hashCode!
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (i != a.i) return false;
            return j == a.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        protected A clone() throws CloneNotSupportedException {
           A a =  (A)super.clone();
            return a;
        }
        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;
        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            B b = (B) o;

            return name != null ? name.equals(b.name) : b.name == null;

        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        @Override
        protected C clone() throws CloneNotSupportedException {
            C c = new C(getI(),getJ(),getName());

            return c;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
C c = new C(1,1,"nikita");
        C clone = c.clone();
        System.out.println(c);
        System.out.println(clone);
    }
}
