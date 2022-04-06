public class Subjects extends Actions {
    int id;
    String type;
    String description;
    int year;
    int student_id;
    String password;
    int mobile_number;

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