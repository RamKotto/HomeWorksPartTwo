package LessonThree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public abstract class PhoneBook {
    static Map<String, ArrayList<String>> pBook = new TreeMap<>();

    // Добавляем значения в телефонную книгу
    public static void add(String name, String number) {
        if (pBook.containsKey(name)) {
            pBook.get(name).add(number);
        } else {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(number);
            pBook.put(name, phoneNumbers);
        }
    }

    // Получаем значения из телефонной книги
    public static void get(String name) {
        if (pBook.containsKey(name)) {
            System.out.println(name + " " + pBook.get(name));
        } else {
            System.out.println(name + " нет в телефонной книге!");
        }
    }

}