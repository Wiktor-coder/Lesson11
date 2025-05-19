import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static final String MENU = """
            \nВыберите операцию:
            0. Выход
            1. Добавить
            2. Показать
            3. Удалить по номеру
            4. Удалить по названию
            5. Удаление по слову""";

    public static void main(String[] args) {
        boolean menu = true;

        while (menu) {
            System.out.println(MENU);
            System.out.print("Вашь выбор: ");

            String choice = scanner.nextLine().trim();
            System.out.println(" ");

            switch (choice) {
                case "0":
                    menu = false;
                    scanner.close();
                    break;
                case "1":
                    ToDoList.addTask();
                    break;
                case "2":
                    break;
                case "3":
                    ToDoList.removeByNumber();
                    break;
                case "4":
                    ToDoList.removeByName();
                    break;
                case "5":
                    ToDoList.removeByWord();
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
            ToDoList.showTasks();
        }

    }
}