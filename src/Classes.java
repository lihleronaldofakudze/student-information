import java.sql.Connection;
import java.sql.PreparedStatement;
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
        // TODO Auto-generated method stub

    }

    @Override
    void delete() {
        // TODO Auto-generated method stub

    }

    @Override
    void view() {
        // TODO Auto-generated method stub

    }

}
