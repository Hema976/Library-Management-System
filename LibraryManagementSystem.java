import java.util.*;

class Book {
    int id;
    String title;
    boolean issued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();

                books.add(new Book(id, title));
                System.out.println("Book Added Successfully!");

            }

            else if (choice == 2) {

                if (books.isEmpty()) {
                    System.out.println("No Books Found!");
                } else {

                    System.out.println("\nBook List:");

                    for (Book b : books) {
                        System.out.println("ID: " + b.id +
                                " | Title: " + b.title +
                                " | Status: " + (b.issued ? "Issued" : "Available"));
                    }
                }

            }

            else if (choice == 3) {

                System.out.print("Enter Book ID to Search: ");
                int searchId = sc.nextInt();

                boolean found = false;

                for (Book b : books) {
                    if (b.id == searchId) {
                        System.out.println("Book Found!");
                        System.out.println("ID: " + b.id);
                        System.out.println("Title: " + b.title);
                        System.out.println("Status: " + (b.issued ? "Issued" : "Available"));
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Book Not Found!");
                }

            }

            else if (choice == 4) {

                System.out.print("Enter Book ID to Delete: ");
                int deleteId = sc.nextInt();

                boolean deleted = false;

                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).id == deleteId) {
                        books.remove(i);
                        deleted = true;
                        System.out.println("Book Deleted Successfully!");
                        break;
                    }
                }

                if (!deleted) {
                    System.out.println("Book Not Found!");
                }

            }

            else if (choice == 5) {

                System.out.print("Enter Book ID to Issue: ");
                int issueId = sc.nextInt();

                boolean found = false;

                for (Book b : books) {
                    if (b.id == issueId) {

                        if (!b.issued) {
                            b.issued = true;
                            System.out.println("Book Issued Successfully!");
                        } else {
                            System.out.println("Book Already Issued!");
                        }

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Book Not Found!");
                }

            }

            else if (choice == 6) {

                System.out.print("Enter Book ID to Return: ");
                int returnId = sc.nextInt();

                boolean found = false;

                for (Book b : books) {
                    if (b.id == returnId) {

                        if (b.issued) {
                            b.issued = false;
                            System.out.println("Book Returned Successfully!");
                        } else {
                            System.out.println("Book is Already Available!");
                        }

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Book Not Found!");
                }

            }

            else if (choice == 7) {

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