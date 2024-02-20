package ru.geekbrains.junior.lesson3.hw3;

import ru.geekbrains.junior.lesson3.task1.UserData;

import java.io.*;

//Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
//Обеспечьте поддержку сериализации для этого класса.
//Создайте объект класса Student и инициализируйте его данными.
//Сериализуйте этот объект в файл.
//Десериализуйте объект обратно в программу из файла.
//Выведите все поля объекта, включая GPA, и ответьте на вопрос,
//почему значение GPA не было сохранено/восстановлено.
//
//2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Tarantino", 25, 4.5);

        try (FileOutputStream fileOut = new FileOutputStream("student.bin");
             ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(student);
            System.out.println("Объект student сериализован.");
        }

        try (FileInputStream fileIn = new FileInputStream("student.bin");
             ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            student = (Student) in.readObject();
            System.out.println("Объект student десериализован.");
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());

    }
}
