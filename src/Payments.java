import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Payments extends Actions {
    int id;
    String type;
    String description;
    String name;
    int student_id;
    double amount;
    Scanner scanner = new Scanner(System.in);
    Connection connection = Connector.getConnection();

    public Payments(int id, String type, String description, String name, int student_id, double amount) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.name = name;
        this.student_id = student_id;
        this.amount = amount;
    }

    public Payments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    void add() {
        System.out.println("Enter the type of payment: ");
        setType(scanner.nextLine());

        System.out.println("Enter the description of payment: ");
        setDescription(scanner.nextLine());

        System.out.println("Enter the name of payment: ");
        setName(scanner.nextLine());

        System.out.println("Enter the student id: ");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the amount: ");
        setAmount(Double.parseDouble(scanner.nextLine()));

        String query = "INSERT INTO payments (type, description, name, student_id, amount) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, student_id);
            preparedStatement.setDouble(5, amount);
            preparedStatement.executeUpdate();
            System.out.println("Payment added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        System.out.println("Enter the id of payment: ");
        setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the type of payment: ");
        setType(scanner.nextLine());

        System.out.println("Enter the description of payment: ");
        setDescription(scanner.nextLine());

        System.out.println("Enter the name of payment: ");
        setName(scanner.nextLine());

        System.out.println("Enter the student id: ");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the amount: ");
        setAmount(Double.parseDouble(scanner.nextLine()));

        String query = "UPDATE payments SET type = ?, description = ?, name = ?, student_id = ?, amount = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, student_id);
            preparedStatement.setDouble(5, amount);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
            System.out.println("Payment updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        System.out.println("Enter the id of payment: ");
        setId(Integer.parseInt(scanner.nextLine()));

        String query = "DELETE FROM payments WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Payment deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void view() {
        String query = "SELECT * FROM payments";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Type: " + resultSet.getString("type"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Student ID: " + resultSet.getInt("student_id"));
                System.out.println("Amount: " + resultSet.getDouble("amount"));
                System.out.println("-----------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
