class Print{
    static void print(boolean flag)
    {
        if(flag)
        {
            System.out.println("BMS college of Engineering");
        }
        else
            System.out.println("CSE");
    }

}
class BMS extends Thread
{
    public void run()
    {
        try{
            for(int i=0;i<5;i++)
            {
                Print.print(true);
                Thread.sleep(10000);
            }
        }
                catch(Exception e)
        {
            System.out.println("Error occured");
        }
    }
}
class CSE extends Thread
{
    public void run()
    {
        try{
            for(int i=0;i<10;i++)
            {
                Print.print(false);
                Thread.sleep(2000);
            }
        }

        catch(Exception e)
        {
            System.out.println("Error occured");
        }
    }
}

class Main{
    public static void main(String args[])
    {
        BMS thread1= new BMS();
        CSE thread2= new CSE();

        thread1.start();
        thread2.start();
    }
}