import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Grades extends Actions {
    int id;
    int role_id;
    String name;
    String description;
    int student_id;
    String registration_date;
    int grade;
    Scanner scanner = new Scanner(System.in);
    Connection connection = Connector.getConnection();

    public Grades(int id, int role_id, String name, String description, int student_id, String registration_date,
            int grade) {
        this.id = id;
        this.role_id = role_id;
        this.name = name;
        this.description = description;
        this.student_id = student_id;
        this.registration_date = registration_date;
        this.grade = grade;
    }

    public Grades() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    void add() {
        System.out.println("Enter the role id: ");
        setRole_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the name: ");
        setName(scanner.nextLine());

        System.out.println("Enter the student id: ");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the description: ");
        setDescription(scanner.nextLine());

        System.out.println("Enter the grade: ");
        setGrade(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the registration date: ");
        setRegistration_date(scanner.nextLine());

        String sql = "INSERT INTO grades (role_id, name, student_id, description, grade, registration_date) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getRole_id());
            preparedStatement.setString(2, getName());
            preparedStatement.setInt(3, getStudent_id());
            preparedStatement.setString(4, getDescription());
            preparedStatement.setInt(5, getGrade());
            preparedStatement.setString(6, getRegistration_date());
            preparedStatement.executeUpdate();
            System.out.println("Grade added successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void update() {
        System.out.println("Enter the id: ");
        setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the role id: ");
        setRole_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the name: ");
        setName(scanner.nextLine());

        System.out.println("Enter the student id: ");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the description: ");
        setDescription(scanner.nextLine());

        System.out.println("Enter the grade: ");
        setGrade(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the registration date: ");
        setRegistration_date(scanner.nextLine());

        String sql = "UPDATE grades SET role_id = ?, name = ?, student_id = ?, description = ?, grade = ?, registration_date = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getRole_id());
            preparedStatement.setString(2, getName());
            preparedStatement.setInt(3, getStudent_id());
            preparedStatement.setString(4, getDescription());
            preparedStatement.setInt(5, getGrade());
            preparedStatement.setString(6, getRegistration_date());
            preparedStatement.setInt(7, getId());
            preparedStatement.executeUpdate();
            System.out.println("Grade updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void delete() {
        System.out.println("Enter the id: ");
        setId(Integer.parseInt(scanner.nextLine()));

        String sql = "DELETE FROM grades WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getId());
            preparedStatement.executeUpdate();
            System.out.println("Grade deleted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void view() {
        String sql = "SELECT * FROM grades";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt("id"));
                System.out.println("Role id: " + resultSet.getInt("role_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Student id: " + resultSet.getInt("student_id"));
                System.out.println("Description: " + resultSet.getString("description"));
                System.out.println("Grade: " + resultSet.getInt("grade"));
                System.out.println("Registration date: " + resultSet.getString("registration_date"));
                System.out.println("-------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
