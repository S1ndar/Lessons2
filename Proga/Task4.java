package Proga;

import java.time.LocalDate;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        uniqueWordsCount();
        phoneBook();
        listChet();
        sortEventsByDate();
        generateRandomString();
    }

    public static void uniqueWordsCount() {
        String text = "кот собака кот птица рыба собака кот слон";
        String[] words = text.split(" ");
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Количество уникальных слов: " + uniqueWords.size());
        System.out.println("Уникальные слова: " + uniqueWords);
    }

    public static void phoneBook() {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Добавить контакт");
            System.out.println("2. Найти номер по имени");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Выйти");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                System.out.print("Введите номер телефона: ");
                String phone = scanner.nextLine();
                phoneBook.put(name, phone);
                System.out.println("Контакт добавлен");
            } else if (choice == 2) {
                System.out.print("Введите имя для поиска: ");
                String name = scanner.nextLine();
                if (phoneBook.containsKey(name)) {
                    System.out.println("Номер: " + phoneBook.get(name));
                } else {
                    System.out.println("Контакт не найден");
                }
            } else if (choice == 3) {
                System.out.print("Введите имя для удаления: ");
                String name = scanner.nextLine();
                if (phoneBook.remove(name) != null) {
                    System.out.println("Контакт удалён");
                } else {
                    System.out.println("Контакт не найден");
                }
            } else if (choice == 4) {
                break;
            }
        }
    }

    public static void listChet() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = new ArrayList<>();

        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }

        System.out.println("Исходный список: " + numbers);
        System.out.println("Чётные числа: " + evenNumbers);
    }

    public static void sortEventsByDate() {
        List<Event> events = new ArrayList<>();
        events.add(new Event("Конференция", LocalDate.of(2026, 6, 15)));
        events.add(new Event("Семинар", LocalDate.of(2026, 5, 20)));
        events.add(new Event("Встреча", LocalDate.of(2026, 7, 1)));
        events.add(new Event("Выставка", LocalDate.of(2026, 5, 10)));

        System.out.println("До сортировки:");
        for (Event event : events) {
            System.out.println(event);
        }

        events.sort((e1, e2) -> e1.getDate().compareTo(e2.getDate()));

        System.out.println("\nПосле сортировки по дате:");
        for (Event event : events) {
            System.out.println(event);
        }
    }

    public static void generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10000; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }

        String result = sb.toString();
        System.out.println("Сгенерирована строка из " + result.length() + " символов");
        System.out.println("Первые 50 символов: " + result.substring(0, Math.min(50, result.length())));
    }
}

class Event {
    private String name;
    private LocalDate date;

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return name + " - " + date;
    }
}
