import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class SafiullinaJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод числа и проверка
        checkNumber(scanner);

        // Ввод имени и проверка
        checkName(scanner);

        // Проверка эелементов массива и вывод элементов, кратных 3
        checkMultipliesOfThree(scanner);

        scanner.close();
    }

    private static void checkNumber(Scanner scanner) {
        System.out.println("Введите число:");
        try {
            int number = scanner.nextInt();
            if (number > 7) {
                System.out.println("Привет");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено нечисловое значение.");
            scanner.next(); // очистка ввода
        }
        scanner.nextLine(); // очищаем ввод перед следующим чтением строки
    }

    private static void checkName(Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        if ("Вячеслав".equalsIgnoreCase(name)) {
            System.out.println("Привет, Вячеслав");
        } else {
            System.out.println("Нет такого имени");
        }
    }

    private static void checkMultipliesOfThree(Scanner scanner) {
        System.out.println("Введите элементы массива, разделенные пробелом:");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        List<Integer> numbers = null;
        try {
            numbers = Arrays.stream(inputArray)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено нечисловое значение.");
            return;
        }

        List<Integer> multiplesOfThree = numbers.stream()
                .filter(num -> num % 3 == 0)
                .collect(Collectors.toList());
        if (multiplesOfThree.isEmpty()) {
            System.out.println("Элементы массива, кратные 3, отсутствуют");
        } else {
            System.out.println("Элементы массива, кратные 3: " + multiplesOfThree);
        }
    }
}

