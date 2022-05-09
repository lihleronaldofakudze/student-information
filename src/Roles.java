import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Roles extends Actions {
    int id;
    String title;
    String module;
    String description;
    Scanner scanner = new Scanner(System.in);
    Connection connection = Connector.getConnection();

    public Roles(int id, int role_id, String title, String module, String description) {
        this.id = id;
        this.title = title;
        this.module = module;
        this.description = description;
    }

    public Roles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    void add() {
        System.out.println("Enter title: ");
        setTitle(scanner.nextLine());

        System.out.println("Enter module: ");
        setModule(scanner.nextLine());

        System.out.println("Enter description: ");
        setDescription(scanner.nextLine());

        String sql = "INSERT INTO roles (title, module, description) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, getTitle());
            preparedStatement.setString(2, getModule());
            preparedStatement.setString(3, getDescription());
            preparedStatement.executeUpdate();
            System.out.println("Role added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        System.out.println("Enter id: ");
        setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter title: ");
        setTitle(scanner.nextLine());

        System.out.println("Enter module: ");
        setModule(scanner.nextLine());

        System.out.println("Enter description: ");
        setDescription(scanner.nextLine());

        String sql = "UPDATE roles SET title = ?, module = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, getTitle());
            preparedStatement.setString(2, getModule());
            preparedStatement.setString(3, getDescription());
            preparedStatement.setInt(4, getId());
            preparedStatement.executeUpdate();
            System.out.println("Role updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        System.out.println("Enter id: ");
        setId(Integer.parseInt(scanner.nextLine()));

        String sql = "DELETE FROM roles WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getId());
            preparedStatement.executeUpdate();
            System.out.println("Role deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void view() {
        String sql = "SELECT * FROM roles";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("title") + " "
                        + resultSet.getString("module") + " " + resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
