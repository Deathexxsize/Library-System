import java.sql.*;

public class DataAccessObject {

    private static final String url = "jdbc:postgresql://localhost:6969/LibrarySystem"; // your db name
    private static final String user = "postgres"; // your username
    private static final String password = "7482040607"; // your password

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            // System.out.println("успешно подключено!");
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return connection;
    }

    public static void createUser(String newUserLogin, String newUserPass) { // регистрирует нового пользователя

        String createNewuser = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(createNewuser)) {

            preparedStatement.setString(1, newUserLogin);
            preparedStatement.setString(2, newUserPass);
            preparedStatement.executeUpdate();

            System.out.print("\nВы успешно зарегистрировались!");
            Menu.checkUser();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public static void authorizeUser (String userLogin, String userPass) {
        String searchUser = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(searchUser)) {

            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, userPass);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("\nВы успешно авторизовались!");
            } else {
                System.out.println("\nНе верный логин или пароль");
                Menu.signupUser();
            }
        } catch (SQLException error) {
            System.out.println("Ошибка при выполнении запроса.");
            error.printStackTrace();
        }
    }
}
