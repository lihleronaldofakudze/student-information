public class Payments extends Actions {
    int id;
    String type;
    String description;
    String name;
    int student_id;
    double amount;

    public Payments(int id, String type, String description, String name, int student_id, double amount) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.name = name;
        this.student_id = student_id;
        this.amount = amount;
    }

    public Payments() {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
