import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Classes extends Actions {
    int id;
    String type;
    String description;
    String classroom;
    int student_id;
    String password;
    Scanner scanner = new Scanner(System.in);
    Connection connection = Connector.getConnection();

    public Classes(int id, String type, String description, String classroom, int student_id, String password) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.classroom = classroom;
        this.student_id = student_id;
        this.password = password;
    }

    public Classes() {
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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

    @Override
    void add() {
        System.out.println("Enter the type of class");
        setType(scanner.nextLine());

        System.out.println("Enter the description");
        setDescription(scanner.nextLine());

        System.out.println("Enter the classroom");
        setClassroom(scanner.nextLine());

        System.out.println("Enter the student id");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the password");
        setPassword(scanner.nextLine());

        String query = "INSERT INTO classes (type, description, classroom, student_id, password) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, getType());
            preparedStatement.setString(2, getDescription());
            preparedStatement.setString(3, getClassroom());
            preparedStatement.setInt(4, getStudent_id());
            preparedStatement.setString(5, getPassword());
            preparedStatement.executeUpdate();
            System.out.println("Class added successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void update() {
        System.out.println("Enter the id of the class");
        setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the type of class");
        setType(scanner.nextLine());

        System.out.println("Enter the description");
        setDescription(scanner.nextLine());

        System.out.println("Enter the classroom");
        setClassroom(scanner.nextLine());

        System.out.println("Enter the student id");
        setStudent_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the password");
        setPassword(scanner.nextLine());

        String query = "UPDATE classes SET type = ?, description = ?, classroom = ?, student_id = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, getType());
            preparedStatement.setString(2, getDescription());
            preparedStatement.setString(3, getClassroom());
            preparedStatement.setInt(4, getStudent_id());
            preparedStatement.setString(5, getPassword());
            preparedStatement.setInt(6, getId());
            preparedStatement.executeUpdate();
            System.out.println("Class updated successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void delete() {
        System.out.println("Enter the id of the class");
        setId(Integer.parseInt(scanner.nextLine()));

        String query = "DELETE FROM classes WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getId());
            preparedStatement.executeUpdate();
            System.out.println("Class deleted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    void view() {
        String query = "SELECT * FROM classes";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("type") + " "
                        + resultSet.getString("description") + " " + resultSet.getString("classroom") + " "
                        + resultSet.getInt("student_id") + " " + resultSet.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
