import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Students extends Actions {
    int id;
    int role_id;
    String name;
    String email;
    String address;
    String password;
    int mobile_number;
    int college_id;
    Scanner scanner = new Scanner(System.in);
    Connection connection = Connector.getConnection();

    public Students(int id, int role_id, String name, String email, String address, String password, int mobile_number,
            int college_id) {
        this.id = id;
        this.role_id = role_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.mobile_number = mobile_number;
        this.college_id = college_id;
    }

    public Students() {
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

    public int getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
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

        System.out.println("Enter the mobile number");
        setMobile_number(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the college id");
        setCollege_id(Integer.parseInt(scanner.nextLine()));

        String sql = "insert into students(role_id,name,email,address,password,mobile_number,college_id) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getRole_id());
            preparedStatement.setString(2, getName());
            preparedStatement.setString(3, getEmail());
            preparedStatement.setString(4, getAddress());
            preparedStatement.setString(5, getPassword());
            preparedStatement.setInt(6, getMobile_number());
            preparedStatement.setInt(7, getCollege_id());
            preparedStatement.executeUpdate();
            System.out.println("Student added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void update() {
        System.out.println("Enter the id");
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

        System.out.println("Enter the mobile number");
        setMobile_number(Integer.parseInt(scanner.nextLine()));

        System.out.println("Enter the college id");
        setCollege_id(Integer.parseInt(scanner.nextLine()));

        String sql = "update students set role_id=?,name=?,email=?,address=?,password=?,mobile_number=?,college_id=? where id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getRole_id());
            preparedStatement.setString(2, getName());
            preparedStatement.setString(3, getEmail());
            preparedStatement.setString(4, getAddress());
            preparedStatement.setString(5, getPassword());
            preparedStatement.setInt(6, getMobile_number());
            preparedStatement.setInt(7, getCollege_id());
            preparedStatement.setInt(8, getId());
            preparedStatement.executeUpdate();
            System.out.println("Student updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void delete() {
        System.out.println("Enter the id");
        setId(Integer.parseInt(scanner.nextLine()));

        String sql = "delete from students where id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getId());
            preparedStatement.executeUpdate();
            System.out.println("Student deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void view() {
        String sql = "select * from students";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2) + " " + resultSet.getString(3) + " "
                        + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6) + " "
                        + resultSet.getInt(7) + " " + resultSet.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}