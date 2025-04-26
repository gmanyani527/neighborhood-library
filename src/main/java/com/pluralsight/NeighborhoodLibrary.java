package com.pluralsight;

import java.util.Scanner;
import java.util.Arrays;
public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean On = true;
        boolean stillDeciding = true;
        Book[] books = {
                new Book(1, "0001", "Harry Potter and the Sorcerer's Stone", false, ""),
                new Book(2, "0002", "Jujutsu Kaisen Vol 1.", false, ""),
                new Book(3, "0003", "Jujutsu Kaisen Vol 2.", true, "Ash Singh"),
                new Book(4, "0004", "Jujutsu Kaisen Vol 3.", false, ""),
                new Book(5, "0005", "Jujutsu Kaisen Vol 4.", false, ""),
                new Book(6, "0006", "Jujutsu Kaisen Vol 5.", false, ""),
                new Book(7, "0007", "Jujutsu Kaisen Vol 6.", true, "James Mullen"),
                new Book(8, "0008", "The Great Gatsby", false, ""),
                new Book(9, "0009", "Harry Potter and the Chamber of Secrets", true, "Rick Riordan"),
                new Book(10, "0010", "War And Peace", false, ""),
                new Book(11, "0011", "The Da Vinci Code", false, ""),
                new Book(12, "0012", "Adventures of Huckleberry Finn.", false, ""),
                new Book(13, "0013", "Atomic Habits", false, ""),
                new Book(14, "0014", "Children of Blood and Bone", false, ""),
                new Book(15, "0015", "Diary of a Wimpy Kid", true, "Ash Singh"),
                new Book(16, "0016", "Percy Jackson: The Lightning Thief", false, ""),
                new Book(17, "0017", "The Book Thief", false, ""),
                new Book(18, "0018", "Matilda", false, ""),
                new Book(19, "0019", "Through the Looking-Glass", true, "Xavier Jones"),
                new Book(20, "0020", "The Adventures of Tom Sawyer", false, ""),
        };


        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("         HOME SCREEN");
        System.out.println("Welcome to the Universal Library");
        System.out.println();
        System.out.println("--------------------------------");

        while (On) {
            System.out.println();
            System.out.println("1. Show Available Books \n2. Show Checked Out Books \n3. Check In \n4. Exit \n(Enter number selection)");

            int userInput = scan.nextInt();
            scan.nextLine();
                switch (userInput) {
                    case 1: // Show Available Books

                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.println(book.getId() + " " + book.getIsbn() + " " + book.getTitle());
                        }
                    }
                        System.out.println();
                        while(stillDeciding) {
                        System.out.println("Would you like to check out a book or exit to home screen? ");
                        String input2 = scan.nextLine();

                        if (input2.equalsIgnoreCase("yes")) {
                            System.out.println("Enter a name: ");
                            String input3 = scan.nextLine();
                            System.out.println("Enter the ID number: ");
                            int input4 = scan.nextInt();
                            scan.nextLine();

                                for (Book book : books) {
                                    if (book.getId() == input4) {
                                        book.setCheckedOut(true);
                                        book.checkedOut(input3);
                                        System.out.println("Book Checked Out!");
                                        System.out.println();
                                        System.out.println("Would you like to choose another book? ");
                                        String input5 = scan.nextLine();
                                        if (input5.equalsIgnoreCase("no")) {
                                            stillDeciding = false;
                                        }
                                    }
                                }
                            }else{
                            stillDeciding = false;
                            }
                        }

                        break;
                        case 2:// Show Checked Out Books
                            stillDeciding = true;
                            for (Book book : books) {
                                if (book.isCheckedOut()) {
                                    System.out.println(book.getId() + " " + book.getIsbn() + " " + book.getTitle() + " - Checked Out By: " + book.getCheckedOutTo());
                                }
                            }

                            while(stillDeciding) {
                                System.out.println();
                                System.out.println("Would you like to check in a book or go back to the home screen? \n (Select 1 or 2)");
                                int input6 = scan.nextInt();
                                scan.nextLine();
                                if (input6 == 1) {
                                    System.out.println("Enter book ID to be checked in: ");
                                    int input7 = scan.nextInt();
                                    scan.nextLine();
                                    for (Book book : books) {
                                        if (input7 == book.getId() && book.isCheckedOut()) {
                                            book.checkIn();
                                            System.out.println("Book has been checked in!");
                                            System.out.println();
                                            System.out.println("Do you have another book to check in? ");
                                            String input8 = scan.nextLine();
                                            if (!input8.equalsIgnoreCase("yes")) {
                                                stillDeciding = false;
                                            }
                                        }
                                    }
                                }
                            }
                                System.out.println();
                                System.out.println("You have returned to the homepage! ");

                            break;
                        case 3: // Check In
                            stillDeciding = true;
                            while(stillDeciding) {
                                System.out.println();
                                System.out.println("Would you like to check in a book or go back to the home screen? \n (Select 1 or 2)");
                                int input6 = scan.nextInt();
                                scan.nextLine();
                                if (input6 == 1) {
                                    System.out.println("Enter book ID to be checked in: ");
                                    int input7 = scan.nextInt();
                                    scan.nextLine();
                                    for (Book book : books) {
                                        if (input7 == book.getId() && book.isCheckedOut()) {
                                            book.checkIn();
                                            System.out.println("Book has been checked in!");
                                            System.out.println();
                                            System.out.println("Do you have another book to check in? ");
                                            String input8 = scan.nextLine();
                                            if (!input8.equalsIgnoreCase("yes")) {
                                                stillDeciding = false;
                                            }
                                        }
                                    }
                                }
                            }

                            break;

                        case 4: // Exit
                            System.out.println();
                            System.out.println("See ya next Time!");
                            On = false;
                            break;
                        default:
                            System.out.println("I did not understand the inputs. Can you try again? ");
                            System.out.println("These are the four options: \n1. Show Available Books \n2. Show Checkedout Books \n3. Checked In A Book \n4. Exit ");

                            break;
                    }

                }


        }
    }

