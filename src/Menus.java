import java.util.Scanner;

public class Menus {
    Administrators administrators;
    Classes classes = new Classes();
    Payments payments = new Payments();
    Students students = new Students();
    Grades grades = new Grades();
    Subjects subjects = new Subjects();
    Stationery stationery = new Stationery();
    Roles roles = new Roles();
    Scanner scanner = new Scanner(System.in);

    public Menus() {
    }

    public void menu() {
        System.out.println("1. Students");
        System.out.println("2. Classes");
        System.out.println("3. Payments");
        System.out.println("4. Grades");
        System.out.println("5. Subjects");
        System.out.println("6. Stationery");
        System.out.println("7. Roles");
        System.out.println("8. Administrators");
        System.out.println("9. Exit");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                students_menu();
                break;
            case 2:
                classes_menu();
                break;
            case 3:
                payments_menu();
                break;
            case 4:
                grades_menu();
                break;
            case 5:
                subjects_menu();
                break;
            case 6:
                stationery_menu();
                break;
            case 7:
                roles_menu();
                break;
            case 8:
                administrators_menu();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void administrators_menu() {
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Back");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                administrators.add();
                break;
            case 2:
                administrators.update();
                break;
            case 3:
                administrators.delete();
                break;
            case 4:
                administrators.view();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void roles_menu() {
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Back");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                roles.add();
                break;
            case 2:
                roles.update();
                break;
            case 3:
                roles.delete();
                break;
            case 4:
                roles.view();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void stationery_menu() {
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Back");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                stationery.add();
                break;
            case 2:
                stationery.update();
                break;
            case 3:
                stationery.delete();
                break;
            case 4:
                stationery.view();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void subjects_menu() {
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Back");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                subjects.add();
                break;
            case 2:
                subjects.update();
                break;
            case 3:
                subjects.delete();
                break;
            case 4:
                subjects.view();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void grades_menu() {
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Back");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                grades.add();
                break;
            case 2:
                grades.update();
                break;
            case 3:
                grades.delete();
                break;
            case 4:
                grades.view();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void payments_menu() {
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Back");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                payments.add();
                break;
            case 2:
                payments.update();
                break;
            case 3:
                payments.delete();
                break;
            case 4:
                payments.view();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void classes_menu() {
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Back");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                classes.add();
                break;
            case 2:
                classes.update();
                break;
            case 3:
                classes.delete();
                break;
            case 4:
                classes.view();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void students_menu() {
        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Back");
        System.out.println("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                students.add();
                break;
            case 2:
                students.update();
                break;
            case 3:
                students.delete();
                break;
            case 4:
                students.view();
                break;
            case 5:
                menu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
