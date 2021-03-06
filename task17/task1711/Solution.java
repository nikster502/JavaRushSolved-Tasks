package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
CRUD 2
CrUD Batch — multiple Creation, Updates, Deletion

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-с — добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u — обновляет соответствующие данные людей с заданными id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке

Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997


Требования:
1. Класс Solution должен содержать public static volatile поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        Person person = null;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    //-c name1 sex1 bd1 name2 sex2 bd2 ...
                    for (int i = 1; i < args.length; i = i + 3) {
                        if (args[i + 1].equals("м")) {
                            allPeople.add(Person.createMale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);
                        } else if (args[i + 1].equals("ж")) {
                            allPeople.add(Person.createFemale(args[i], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 2])));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                    for (int i = 1; i < args.length; i = i + 4) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i + 1]);
                        person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 3]));
                        if (args[i + 2].equals("м")) {
                            person.setSex(Sex.MALE);
                        } else if (args[i + 2].equals("ж")) {
                            person.setSex(Sex.FEMALE);
                        }

                    }

                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    //-d id1 id2 id3 id4 ...
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
//Миронов м 15-Apr-1990


                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        String sex = "";
                        if(person.getSex().equals(Sex.FEMALE))
                        {
                            sex = "ж";
                        }else if(person.getSex().equals(Sex.MALE))
                        {
                            sex = "м";
                        }
                        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
                        String date = simpleDateFormat.format(person.getBirthDay());
                        System.out.println(person.getName()+ " "+sex +" "+ date);
                    }
                    break;

                }
        }
    }
}
