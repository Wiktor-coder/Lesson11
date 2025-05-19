import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class ToDoList {
    private static List<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addTask() {
        System.out.print("Введите название задачи: ");
        String newTask = scanner.nextLine().trim();
        if (!list.contains(newTask)) {
            list.add(newTask);
            System.out.println("Добавлено");
        } else {
            System.out.println("Задача уже существует");
        }

    }

    public static void showTasks() {
        if (list.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            System.out.println("Вашь список дел: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, list.get(i));
            }
        }
    }

    public static void removeByNumber() {
        try {
            System.out.println("Введите номет для удаления: ");
            int number = Integer.parseInt(scanner.nextLine());
            if (number >= 1 && number <= list.size()) {
                String removedTask = list.remove(number - 1);
                System.out.println("Удалено! ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число!");
        }
    }

    public static void removeByName() {
        System.out.print("Введите задачу для удаления: ");
        String taskToRemove = scanner.nextLine();
        if (list.contains(taskToRemove)) {
            list.remove(taskToRemove);
            System.out.println("удалено! ");
        } else {
            System.out.println("Такого дела нет в списке.");
        }
    }

    public static void removeByWord() {
        System.out.print("Введите слово для удаления задач: ");
        String wordToRemove = scanner.nextLine().trim();

        if (wordToRemove.isEmpty()) {
            System.out.println("Ошибка: введена пустая строка");
            return;
        }
        
        boolean removed = false;
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String task = iterator.next();
            if (task.contains(wordToRemove)) {
                iterator.remove();
                removed = true;
            }
        }

        if (removed) {
            System.out.println("Удалены все задачи, содержащие слово: " + wordToRemove);
        } else {
            System.out.println("Не найдено задач, содержащих слово: " + wordToRemove);
        }
    }
}