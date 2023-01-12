package com.example.databasebooks;
import java.sql.*;
import java.util.Collections;
import org.sqlite.JDBC;

public class DbHandler {

    private static final String CON_STR = "jdbc:sqlite:D:/users.db";
    public  Connection connection;


    void create2() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }


    void create() {
        {
            try {

                this.connection = DriverManager.getConnection("jdbc:sqlite:D:/Программирование/SQLite/boooks.db");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void addBook(Book book) throws SQLException {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO users (`id`, `Name`, `Author`) " +
                        "VALUES(?, ?, ?)")) {
            statement.setObject(1, book.id);
            statement.setObject(2, book.Name);
            statement.setObject(3, book.Author);

            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void DeleteAllBooks() throws SQLException {
         PreparedStatement statement = this.connection.prepareStatement("DELETE FROM users");
         statement.execute();
    }
    public BookList getAllBooks() {

        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {
            // В данный список будем загружать наши продукты, полученные из БД
            BookList books = new BookList();
            // В resultSet будет храниться результат нашего запроса,
            // который выполняется командой statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT id, Name, Author FROM users");
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {
                books.Add(new Book(
                        resultSet.getString("Name"),
                        resultSet.getString("Author"),
                        resultSet.getInt("id")
                ));
            }
            // Возвращаем наш список
            return books;

        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекци
            return null;
        }
    }

    public void UpdateBook(String ind,String Name, String Author){
        try (PreparedStatement statement = this.connection.prepareStatement(
                "UPDATE users SET Name = ? WHERE id = " + ind  +" ")) {
            statement.setObject(1, Name);
            statement.setObject(2, Author);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}