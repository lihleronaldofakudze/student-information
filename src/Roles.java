public class Roles extends Actions {
    int id;
    int role_id;
    String title;
    String module;
    String description;

    public Roles(int id, int role_id, String title, String module, String description) {
        this.id = id;
        this.role_id = role_id;
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
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
