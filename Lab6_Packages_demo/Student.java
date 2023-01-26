package CIE;
import java.util.Scanner;

public class Student {
    protected String usn = new String();
    protected String name = new String();
    protected int sem;

    public void inputStudentDetails()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("USN: ");
        usn = s.next();
        System.out.print("Name: ");
        name = s.next();
        System.out.print("Sem: ");
        sem = s.nextInt();
    }
    public void displayStudentDetails()
    {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Sem: " + sem);
    }
}