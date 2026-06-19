import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                students.add(new Student(id, name));
                System.out.println("Student Added Successfully!");

            }

            else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No Students Found!");
                } else {
                    System.out.println("\nStudent List:");
                    for (Student s : students) {
                        System.out.println("ID: " + s.id + " Name: " + s.name);
                    }
                }

            }

            else if (choice == 3) {

                System.out.print("Enter Student ID to Search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (Student s : students) {
                    if (s.id == searchId) {
                        System.out.println("Student Found!");
                        System.out.println("ID: " + s.id);
                        System.out.println("Name: " + s.name);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student Not Found!");
                }

            }

            else if (choice == 4) {

                System.out.print("Enter Student ID to Delete: ");
                int deleteId = sc.nextInt();

                boolean deleted = false;

                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).id == deleteId) {
                        students.remove(i);
                        deleted = true;
                        System.out.println("Student Deleted Successfully!");
                        break;
                    }
                }

                if (!deleted) {
                    System.out.println("Student Not Found!");
                }

            }

            else if (choice == 5) {

                System.out.print("Enter Student ID to Update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                boolean updated = false;

                for (Student s : students) {
                    if (s.id == updateId) {

                        System.out.print("Enter New Name: ");
                        s.name = sc.nextLine();

                        System.out.println("Student Updated Successfully!");
                        updated = true;
                        break;
                    }
                }

                if (!updated) {
                    System.out.println("Student Not Found!");
                }

            }

            else if (choice == 6) {

                System.out.println("Thank You!");
                break;

            }

            else {

                System.out.println("Invalid Choice!");

            }
        }

        sc.close();
    }
}