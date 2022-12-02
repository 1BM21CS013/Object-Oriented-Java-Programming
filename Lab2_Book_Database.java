import java.util.Scanner;

class Books
{
    String name;
    String author;
    int price;
    int numPages;

    Books()
    {}
    Books(String name, String author, int price, int numPages)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }
    public String toString()
    {
        String name, author, price, numPages;
        name = "Book name: " + this.name + "\n";
        author = "Author name: " + this.author + "\n";
        price = "Price: " + this.price + "\n";
        numPages = "Number of pages: " + this.numPages + "\n";

        return name + author + price + numPages;
    }
}
class Main
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n;

        String name;
        String author;
        int price;
        int numPages;

        System.out.print("Enter the number of books: ");
        n = s.nextInt();

        Books b[];
        b = new Books[n];

        for(int i=0;i<n;i++)
        {
            System.out.println("Book " + (i+1) + ":");
            System.out.print("Enter the name of the book: ");
            name = s.next();
            System.out.print("Enter the author of the book: ");
            author = s.next();
            System.out.print("Enter the price of the book: ");
            price = s.nextInt();
            System.out.print("Enter the number of pages of the book: ");
            numPages = s.nextInt();

            b[i] = new Books(name,author,price,numPages);
            System.out.println();
        }

        for(int i=0;i<n;i++)
            System.out.print("Book " + (i+1) + ":\n" + b[i]);
    }
}