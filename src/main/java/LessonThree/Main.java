package LessonThree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание №1:");
        wordsCount();

        System.out.println("\nЗадание №2:");
        phoneBook();
    }

    public static void wordsCount() {
        // массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
        String[] myArray = {"Mother", "Potato", "Father", "Orange", "Brother",
                "Sister", "Mother", "Potato", "Mother", "Brother", "Apple",
                "Orange", "Apple", "Potato"};

        // список уникальных слов, из которых состоит массив
        Set<String> mySet = new TreeSet<>(Arrays.asList(myArray));

        // Посчитать сколько раз встречается каждое слово
        Map<String, Integer> countOfWordsInArray = new HashMap<>();
        List<String> myList = new ArrayList<>(Arrays.asList(myArray));
        for (String i : mySet) {
            countOfWordsInArray.put(i, Collections.frequency(myList, i));
        }

        // Вывод количества
        for (Map.Entry<String, Integer> i : countOfWordsInArray.entrySet()) {
            if (i.getValue() > 1){
                System.out.println("Слово: " + i.getKey() + " встречается " + i.getValue() + " разa.");
            } else {
                System.out.println("Слово: " + i.getKey() + " встречается " + i.getValue() + " раз.");
            }
        }
    }


    public static void phoneBook() {
        // Заносим телефоны в справочник
        PhoneBook.add("Superman", "555-55-55");
        PhoneBook.add("Superman", "333-33-33");
        PhoneBook.add("Batman", "777-77-77");
        PhoneBook.add("Batman", "888-88-88");
        PhoneBook.add("Batman", "555-55-55");
        PhoneBook.add("TMNT", "111-11-11");

        // Извлекаем телефоны из спарвочника
        PhoneBook.get("Superman");
        PhoneBook.get("Batman");
        PhoneBook.get("TMNT");
        PhoneBook.get("Chipolino");
    }
}
