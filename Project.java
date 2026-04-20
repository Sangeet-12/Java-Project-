import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LibrarySystem {

    static class Book {
        int id;
        String title;
        String author;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        void display() {
            System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Issued Book");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    books.add(new Book(id, title, author));
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();

                    boolean removed = false;
                    Iterator<Book> it = books.iterator();

                    while (it.hasNext()) {
                        Book b = it.next();
                        if (b.id == removeId) {
                            it.remove();  // SAFE removal
                            System.out.println("Book removed!");
                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Title to search: ");
                    String search = sc.nextLine();

                    boolean found = false;
                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(search)) {
                            b.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : books) {
                            b.display();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
