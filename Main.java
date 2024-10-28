import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
class Name {
    String name, surname, otchestvo;
    public Name(String name){
        this.name = name;
        this.surname = "";
        this.otchestvo = "";
    }
    public Name(String surname, String name){
        this.surname = surname;
        this.name = name;
        this.otchestvo = "";
    }

    public Name(String surname, String name, String otchestvo){
        this.name = name;
        this.surname = surname;
        this.otchestvo = otchestvo;
    }
    public String toString(){
        String fio = "";
        fio += this.surname;
        if(fio.isEmpty() || this.name.isEmpty()){
            fio += this.name;
        }else{
            fio += " " + this.name;
        }
        if(fio.isEmpty() || this.otchestvo.isEmpty()){
            fio += this.otchestvo;
        }else{
            fio += " " + this.otchestvo;
        }
        return fio;

    }
}

class Person{
    Name name;
    int height;
    Person father;
    public Person(String name, int height){
        this(new Name(name), height);
    }
    public Person(String name, int height, Person father){
        this(new Name(name), height);
        addFather(father);
    }
    public Person(Name name, int height, Person father){
        this(name, height);
        addFather(father);
    }
    public Person(Name name, int height){
        this.name = name;
        this.height = height;
    }
    public void addFather(Person father){
        this.father = father;
        if (name.surname.isEmpty()){
            name.surname = this.father.name.surname;
        }
        if(name.otchestvo.isEmpty()){
            name.otchestvo = father.name.name + "ович";
        }
    }
    public String toString(){

        return this.name.toString() + ", " + Integer.toString(this.height);
    }
}

class City{
    String name;
    Map<String, java.lang.Integer> neighbours = new HashMap<String, java.lang.Integer>();
    public City(String name){
        this.name = name;
    }
    public void addNeighbour(String city, int cost){
        this.neighbours.put(city, cost);
    }
    public String toString(){
        String output = "Город: " + name + "\n" + "Куда можно доехать: ";
        Set<String> keys = this.neighbours.keySet();
        for(String key: keys){
            output += "\n" + key + ": " + neighbours.get(key);
        }
        return output;
    }
}

class Cat{
    String name;
    public Cat(String name){
        this.name = name;
    }
    public String toString(){
        return "Имя: " + this.name;
    }
    public String Meow(){
        return this.name + ": мяу!";
    }
    public String Meow(int N){
        String output = this.name + ": ";
        for(int i = 0; i < N - 1; i++){
            output += "мяу-";
        }
        output += "мяу!";
        return output;
    }
}

public class Main {
    public static void main(String[] args) {
        int task_num;
        Name name1, name2, name3, name4;
        Person person1, person2, person3;
        City a, b, c, d, e, f;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Лабораторная работа 2. Вариант 3");
        System.out.println("Введите номер задачи:");
        task_num = scanner.nextInt();
        switch (task_num){
            case 1:
                name1 = new Name("", "Клеопатра", "");
                name2 = new Name("Пушкин", "Александр", "Сергеевич");
                name3 = new Name("Маяковский", "Владимир", "");
                System.out.println(name1.toString());
                System.out.println(name2.toString());
                System.out.println(name3.toString());
                break;
            case 2:
                name1 = new Name("", "Клеопатра", "");
                name2 = new Name("Пушкин", "Александр", "Сергеевич");
                name3 = new Name("Маяковский", "Владимир", "");
                person1 = new Person(name1, 152);
                person2 = new Person(name2, 167);
                person3 = new Person(name3, 189);
                System.out.println("Задание 2.2");
                System.out.println(person1.toString());
                System.out.println(person2.toString());
                System.out.println(person3.toString());


                name1 = new Name("Чудов", "Иван", "");
                name2 = new Name("Чудов", "Петр", "");
                name3 = new Name("", "Борис", "");
                person1 = new Person(name1, 152);
                person2 = new Person(name2, 167);
                person3 = new Person(name3, 189);
                person2.addFather(person1);
                person3.addFather(person2);
                System.out.println("Задание 2.3");
                System.out.println(person1.toString());
                System.out.println(person2.toString());
                System.out.println(person3.toString());
                break;
            case 3:
                a = new City("A");
                b = new City("B");
                c = new City("C");
                d = new City("D");
                e = new City("E");
                f = new City("F");
                a.addNeighbour("B", 5);
                a.addNeighbour("F", 1);
                a.addNeighbour("D", 6);
                b.addNeighbour("A", 5);
                b.addNeighbour("C", 3);
                c.addNeighbour("B", 3);
                c.addNeighbour("D", 4);
                d.addNeighbour("A", 6);
                d.addNeighbour("C", 4);
                d.addNeighbour("E", 2);
                e.addNeighbour("F", 2);
                f.addNeighbour("B", 1);
                f.addNeighbour("E", 2);
                System.out.println("Список городов и стоимости путей из них в другие города:");
                System.out.println(a.toString());
                System.out.println(b.toString());
                System.out.println(c.toString());
                System.out.println(d.toString());
                System.out.println(e.toString());
                System.out.println(f.toString());
                break;
            case 4:
                System.out.println("Задача 4.5");
                name1 = new Name("Клеопатра");
                name2 = new Name("Пушкин", "Александр", "Сергеевич");
                name3 = new Name("Маяковский", "Владимир");
                name4 = new Name("Бонифатьевич", "Христофор");
                System.out.println(name1.toString());
                System.out.println(name2.toString());
                System.out.println(name3.toString());
                System.out.println(name4.toString());

                System.out.println("Задача 4.6");
                person1 = new Person("Лев", 170);
                person2 = new Person(new Name("Пушкин", "Сергей"), 168, person1);
                person3 = new Person("Александр", 167, person2);
                System.out.println(person1.toString());
                System.out.println(person2.toString());
                System.out.println(person3.toString());
                break;
            case 5:
                Cat cat = new Cat("Барсик");
                System.out.println(cat.Meow());
                System.out.println(cat.Meow(3));
                break;
            default:
                System.out.println("Такого задания нет");
        }


    }
}
