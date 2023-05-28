import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPersons;
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            if (scanner.hasNextInt()) {
                countPersons = scanner.nextInt();
                scanner.nextLine();
                if (countPersons > 1) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Это некорректное значение. Попробуем еще раз?");
        }
        Calculator calculator = new Calculator(countPersons);
        while (true) {
            System.out.println("Введите наименование товара:");
            String name = scanner.nextLine();
            float price;
            while (true) {
                System.out.println("Введите стоимость товара:");
                if (scanner.hasNextFloat()) {
                    price = scanner.nextFloat();
                    scanner.nextLine();
                    if (price > 0) {
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("Наверное вы ошиблись в стоимости. Попробуйте еще раз.");
            }

            Good good = new Good(name, price);
            calculator.addGood(good);
            System.out.println("Товар успешно добавлен.");
            System.out.println("Хотите добавить еще товар? Введите \"Завершить\" для окончания.");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("завершить")) {
                break;
            }
        }
        scanner.close();
        System.out.println("Добавленные товары:\n");
        System.out.println(calculator.names);
        Formatter formatter = new Formatter();
        System.out.println("Каждый человек должен заплатить " +
                formatter.getFormattedSum(calculator.sumByPerson()));
    }
}