import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        String[] lst = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        if (arr.length == 3) {
            if (arr[0].matches("\\d+") && arr[2].matches("\\d+")) {
                if ("12345678910".contains(arr[0]) && "12345678910".contains(arr[2])) {
                    int a = Integer.parseInt(arr[0]);
                    int b = Integer.parseInt(arr[2]);
                    switch (arr[1]) {
                        case "+" -> System.out.println(a + b);
                        case "-" -> System.out.println(a - b);
                        case "*" -> System.out.println(a * b);
                        case "/" -> System.out.println(a / b);
                    }
                } else {
                    throw new IOException("Числа должны быть от 1 до 10 или от I до X");
                }
            }
            if (arr[0].matches("(^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$)")
                    && arr[2].matches("(^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$)")) {
                if ("IIIVIIIIX".contains(arr[0]) && "IIIVIIIIX".contains(arr[2])) {
                    int element0 = Searcher(lst, arr[0]);
                    int element1 = Searcher(lst, arr[2]);
                    int c;
                    switch (arr[1]) {
                        case "+" -> {
                            c = element0 + element1;
                            System.out.println(lst[c]);
                        }
                        case "-" -> {
                            c = element0 - element1;
                            if (c > 0) {
                                System.out.println(lst[c]);
                            } else {
                                throw new IOException("В римской системе нет отрицательных чисел");
                            }
                        }
                        case "*" -> {
                            c = element0 * element1;
                            System.out.println(lst[c]);
                        }
                        case "/" -> {
                            c = element0 / element1;
                            System.out.println(lst[c]);
                        }
                    }
                }
                else {
                    throw new IOException("Числа должны быть от I до X или от 1 до 10");
                }

            }
            if ((arr[0].matches("(^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$)") && arr[2].matches("\\d+"))
                    || arr[0].matches("\\d+") && arr[2].matches("(^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$)")) {
                throw new IOException("Используются одновременно разные системы счисления");
            }
        }
        if (arr.length < 3) {
            throw new IOException("Строка не является математической операцией");
        }
        if (arr.length > 3) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

    }

    public static int Searcher(String[] array, String el) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(el)) {
                return i;
            }
        }
        return 0;
    }

}