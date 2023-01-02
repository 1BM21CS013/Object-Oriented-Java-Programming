import java.util.Scanner;

class WrongAge extends Exception {
    String msg = new String();
    WrongAge()
    {
        msg = "Age Error";
    }
    WrongAge(String ss)
    {
        msg = ss;
    }
    public String toString()
    {
        return msg;
    }
}
class InputScanner {
    Scanner s;
    InputScanner() {
        s = new Scanner(System.in);
    }
}
class Father extends InputScanner {
    int fatherAge;
    Father() throws WrongAge {      
        Scanner ss = new Scanner(System.in);  
        System.out.print("Enter Father's age: ");
        fatherAge = s.nextInt();
        if(fatherAge<0)
        throw new WrongAge("Age cannot be negative");

    }
    void display()
    {
        System.out.println("Father's age: "+fatherAge);
    }
}
class Son extends Father {
    int sonAge;
    Son() throws WrongAge {
        System.out.print("Enter Son's age: ");
        sonAge = s.nextInt();
        if(sonAge>fatherAge)
            throw new WrongAge("Son's age cannot be greater than father's age");
        else if (sonAge<0)
            throw new WrongAge("Age cannot be negative");
    }
    void display()
    {
        super.display();
        System.out.println("Son's age: "+sonAge);
    }
}
class Main {
    public static void main (String args[])
    {
        try
        {
            Son s1 = new Son();        
            s1.display();
        }
        catch(WrongAge wa)
        {
            System.out.println(wa);
        }
    }
}