public class Students extends Actions {
    int id;
    int role_id;
    String name;
    String email;
    String address;
    String password;
    int mobile_number;
    int college_id;

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
        // TODO Auto-generated method stub

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