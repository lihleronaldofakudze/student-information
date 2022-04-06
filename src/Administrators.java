import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Administrators extends Actions {
    int id;
    int role_id;
    String name;
    String email;
    String address;
    String password;
    Scanner scanner = new Scanner(System.in);
    Connection connection = Connector.getConnection();

    public Administrators(int id, int role_id, String name, String email, String address, String password) {
        this.id = id;
        this.role_id = role_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public Administrators() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    void add() {
        System.out.println("Enter the role id");
        setRole_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the name");
        setName(scanner.nextLine());

        System.out.println("Enter the email");
        setEmail(scanner.nextLine());

        System.out.println("Enter the address");
        setAddress(scanner.nextLine());

        System.out.println("Enter the password");
        setPassword(scanner.nextLine());

        String query = "INSERT INTO administrators(role_id, name, email, address, password) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getRole_id());
            preparedStatement.setString(2, getName());
            preparedStatement.setString(3, getEmail());
            preparedStatement.setString(4, getAddress());
            preparedStatement.setString(5, getPassword());
            preparedStatement.executeUpdate();
            System.out.println("Administrator added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        System.out.println("Enter the administrator id");
        setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the role id");
        setRole_id(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the name");
        setName(scanner.nextLine());

        System.out.println("Enter the email");
        setEmail(scanner.nextLine());

        System.out.println("Enter the address");
        setAddress(scanner.nextLine());

        System.out.println("Enter the password");
        setPassword(scanner.nextLine());

        String query = "UPDATE administrators SET role_id = ?, name = ?, email = ?, address = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getRole_id());
            preparedStatement.setString(2, getName());
            preparedStatement.setString(3, getEmail());
            preparedStatement.setString(4, getAddress());
            preparedStatement.setString(5, getPassword());
            preparedStatement.setInt(6, getId());
            preparedStatement.executeUpdate();
            System.out.println("Administrator updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        System.out.println("Enter the administrator id");
        setId(Integer.parseInt(scanner.nextLine()));

        String query = "DELETE FROM administrators WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getId());
            preparedStatement.executeUpdate();
            System.out.println("Administrator deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void view() {
        String query = "SELECT * FROM administrators";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("role_id") + " "
                        + resultSet.getString("name") + " " + resultSet.getString("email") + " "
                        + resultSet.getString("address") + " " + resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}