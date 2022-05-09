import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Subjects extends Actions {
    int id;
    String type;
    String description;
    int year;
    int student_id;
    String password;
    int mobile_number;
    Scanner scanner = new Scanner(System.in);
    Connection connection = Connector.getConnection();

    public Subjects(int id, String type, String description, int year, int student_id, String password,
            int mobile_number) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.year = year;
        this.student_id = student_id;
        this.password = password;
        this.mobile_number = mobile_number;
    }

    public Subjects() {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    @Override
    void add() {
        System.out.println("Enter the type of subject");
        setType(scanner.nextLine());

        System.out.println("Enter the description");
        setDescription(scanner.nextLine());

        System.out.println("Enter the year");
        setYear(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the student id");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the password");
        setPassword(scanner.nextLine());

        System.out.println("Enter the mobile number");
        setMobile_number(Integer.parseInt(scanner.nextLine()));

        String sql = "INSERT INTO subjects (type, description, year, student_id, password, mobile_number) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, getType());
            preparedStatement.setString(2, getDescription());
            preparedStatement.setInt(3, getYear());
            preparedStatement.setInt(4, getStudent_id());
            preparedStatement.setString(5, getPassword());
            preparedStatement.setInt(6, getMobile_number());
            preparedStatement.executeUpdate();
            System.out.println("Subject added successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void update() {
        System.out.println("Enter the id of subject to be updated");
        setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the type of subject");
        setType(scanner.nextLine());

        System.out.println("Enter the description");
        setDescription(scanner.nextLine());

        System.out.println("Enter the year");
        setYear(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the student id");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the password");
        setPassword(scanner.nextLine());

        System.out.println("Enter the mobile number");
        setMobile_number(Integer.parseInt(scanner.nextLine()));

        String sql = "UPDATE subjects SET type = ?, description = ?, year = ?, student_id = ?, password = ?, mobile_number = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, getType());
            preparedStatement.setString(2, getDescription());
            preparedStatement.setInt(3, getYear());
            preparedStatement.setInt(4, getStudent_id());
            preparedStatement.setString(5, getPassword());
            preparedStatement.setInt(6, getMobile_number());
            preparedStatement.setInt(7, getId());
            preparedStatement.executeUpdate();
            System.out.println("Subject updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void delete() {
        System.out.println("Enter the id of subject to be deleted");
        setId(Integer.parseInt(scanner.nextLine()));

        String sql = "DELETE FROM subjects WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getId());
            preparedStatement.executeUpdate();
            System.out.println("Subject deleted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void view() {
        String sql = "SELECT * FROM subjects";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("type") + " "
                        + resultSet.getString("description")
                        + " " + resultSet.getInt("year") + " " + resultSet.getInt("student_id") + " "
                        + resultSet.getString("password")
                        + " " + resultSet.getInt("mobile_number"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}