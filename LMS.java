// -------------------------------------Library Management System--------------------------------
import java.util.*;
class AllBooks{
    int bookId;
    String author;
    String title;
    boolean isIssued;
    int TotalBooks;

    AllBooks(int bookId, String title, String author, boolean isIssued, int TotalBooks){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
        this.TotalBooks = TotalBooks;
    }
}
class LMS{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<AllBooks> library = new ArrayList<>();
        
        int choice;

        do {
            System.out.println("------------Choose-----------");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show Available Books");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");

            System.out.print("Enter choice : ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                // Add Book
                case 1:
                    System.out.print("Enter Book Id : ");
                    int AbookId =Integer.parseInt(sc.nextLine());
                    System.out.println("--------------------------------");
                    System.out.print("Enter Book title : ");
                    String Abooktitle = sc.nextLine();
                    System.out.println("--------------------------------");
                    System.out.print("Enter Book Author : ");
                    String Abookauthor = sc.nextLine();
                    System.out.println("--------------------------------");
                    System.out.print("How many Books : ");
                    int TotalBooks = Integer.parseInt(sc.nextLine());
                    boolean isIssued = false;

                    library.add(new AllBooks(AbookId, Abooktitle, Abookauthor, isIssued, TotalBooks));
                    System.out.println("Book ID : "+AbookId+"   ||   Book Author : "+Abookauthor+"   ||   Book Title : "+Abooktitle+"  ||  Total "+TotalBooks+" books are available\nBook Added Successfully !!");
                break;
                // Issue Book
                case 2:
                    System.out.print("Enter Book Title : ");
                    String Ibooktitle = sc.nextLine();
                    System.out.println("------------------------------");

                    System.out.print("Enter how many books needed--(don't enter -ve value)-- : ");
                    int need = Integer.parseInt(sc.nextLine());
                    boolean Found = false;

                    for(AllBooks ab : library){
                        if(ab.title.equalsIgnoreCase(Ibooktitle)){
                            if(need > 0){
                                if(need >= ab.TotalBooks){
                                    Found = true;
                                    System.out.println("Sorry ! we only have "+ab.TotalBooks+" Books");
                                } else {
                                    ab.TotalBooks -= need;
                                    System.out.println(need+" "+ab.title+" Book/Books is/are Issued successfully");
                                    Found = true;
                                    break;
                                }
                            } else {
                                System.out.println("Can't enter negative value !!");
                            }
                        }
                    }
                    if(!Found){
                        System.out.println("Enter title of book is not available !!");
                    }
                break;
                // Return Book
                case 3:
                    System.out.print("Enter title of book you had borrowed : ");
                    String Rbooktitle = sc.nextLine();
                    System.out.println("-------------------------------");
                    System.out.print("Enter how many books you gonna return : ");
                    int bookreturn = Integer.parseInt(sc.nextLine());

                    boolean found1 = false;
                    
                    for(AllBooks ab : library){
                        if(Rbooktitle.equalsIgnoreCase(ab.title)){
                            found1 = true;
                            if(bookreturn > 0){
                                ab.TotalBooks += bookreturn;
                                System.out.println("Book/Books of title '"+Rbooktitle+"' has been returned");
                                found1 = true;
                                break;
                            } else {
                                System.out.println("Please enter =ve value !!");
                            }
                        } 
                    }
                    if(!found1){
                        System.out.println("No book of title '"+Rbooktitle+"' found in libraray !!");
                    }
                break;
                // Show Available Books
                case 4:
                    for(AllBooks ab : library){
                        if(ab.TotalBooks > 0){
                            System.out.println(ab.bookId+"   ||   "+ab.title+"   ||   "+ab.author+"   ||   "+ab.isIssued+"   ||   "+ab.TotalBooks);
                            System.out.println("-------------------------------------------------------------------------");
                        }
                    }
                break;
                // Search Book
                case 5:
                    System.out.print("Enter Book Title : ");
                    String Sbooktitle = sc.nextLine();

                    boolean found2 = false;

                    for(AllBooks ab : library){
                        if(Sbooktitle.equalsIgnoreCase(ab.title)){
                            found2 = true;
                            if(ab.TotalBooks > 0){
                                System.out.println(ab.bookId+"   ||   "+ab.title+"   ||   "+ab.author+"   ||   "+ab.isIssued+"   ||   "+ab.TotalBooks);
                                found2 = true;
                                break;
                            } else {
                                System.out.println("Books found but currently not available !!");
                            }
                        }
                    }
                    if(!found2){
                        System.out.println("Book not found !");
                    }
                break;
                // Exit
                case 6:
                    System.out.println("Thanks for using\nExiting !!");
                break;

                default:
                    System.out.println("Please enter valid choice");
            }
            
        } while (choice != 6);
    }
}
