import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Stationery extends Actions {
    int id;
    String type;
    String description;
    String name;
    int student_id;
    Scanner scanner = new Scanner(System.in);
    Connection connection = Connector.getConnection();

    public Stationery(int id, String type, String description, String name, int student_id) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.name = name;
        this.student_id = student_id;
    }

    public Stationery() {
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

    @Override
    void add() {
        System.out.println("Enter the type of stationery: ");
        setType(scanner.nextLine());

        System.out.println("Enter the description of stationery: ");
        setDescription(scanner.nextLine());

        System.out.println("Enter the name of stationery: ");
        setName(scanner.nextLine());

        System.out.println("Enter the student id: ");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        String sql = "INSERT INTO stationery (type, description, name, student_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, getType());
            preparedStatement.setString(2, getDescription());
            preparedStatement.setString(3, getName());
            preparedStatement.setInt(4, getStudent_id());
            preparedStatement.executeUpdate();
            System.out.println("Stationery added successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void update() {
        System.out.println("Enter the id of stationery: ");
        setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the type of stationery: ");
        setType(scanner.nextLine());

        System.out.println("Enter the description of stationery: ");
        setDescription(scanner.nextLine());

        System.out.println("Enter the name of stationery: ");
        setName(scanner.nextLine());

        System.out.println("Enter the student id: ");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        String sql = "UPDATE stationery SET type = ?, description = ?, name = ?, student_id = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, getType());
            preparedStatement.setString(2, getDescription());
            preparedStatement.setString(3, getName());
            preparedStatement.setInt(4, getStudent_id());
            preparedStatement.setInt(5, getId());
            preparedStatement.executeUpdate();
            System.out.println("Stationery updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void delete() {
        System.out.println("Enter the id of stationery: ");
        setId(Integer.parseInt(scanner.nextLine()));

        String sql = "DELETE FROM stationery WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getId());
            preparedStatement.executeUpdate();
            System.out.println("Stationery deleted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void view() {
        String sql = "SELECT * FROM stationery";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Type: " + resultSet.getString("type"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Student id: " + resultSet.getInt("student_id"));
                System.out.println("-------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
