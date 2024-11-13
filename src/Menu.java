import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        checkUser();
    }

    public static void checkUser () { // выбор - создать аккаунт или зарегистрироваться
        System.out.println("\n\n==========================");
        System.out.println("          NurBook         ");
        System.out.println("       главное меню       ");
        System.out.println("==========================");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\n1. Войти в учетную запись\n2. Зарегистрироваться\nвыбрать: ");
            byte regOrSignup = scanner.nextByte();

            if (regOrSignup == 1) {
                signupUser(); // вызов метода авторизации
                break;
            } else if (regOrSignup == 2) {
                registUser(); // вызов метода регистрации
                break;
            } else {
                System.out.println("\n== Введите верное значение! ==");
            }
        }
    }

    public static void registUser () { // Регистрация
        System.out.println("\n\n==========================");
        System.out.println("        Регистрация       ");;
        System.out.println("==========================");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведите логин: ");
        String newUserLogin = scanner.nextLine();

        System.out.print("Придумайте пароль: ");
        String newUserPass = scanner.nextLine();

        DataAccessObject.createUser(newUserLogin, newUserPass);
    }

    public static void signupUser() { // авторизация
        System.out.println("\n\n==========================");
        System.out.println("        Авторизация       ");;
        System.out.println("==========================");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nВведите логин: ");
        String userLogin = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String userPass = scanner.nextLine();

        DataAccessObject.authorizeUser(userLogin, userPass);

    }
}