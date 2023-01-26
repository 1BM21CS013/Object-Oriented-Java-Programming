import java.lang.*;
import java.util.*;

class Pair<First, Second> {

  First ob1;
  Second ob2;

  Pair(First x, Second y) {
    ob1 = x;
    ob2 = y;
  }

  First getob1() {
    return ob1;
  }

  Second getob2() {
    return ob2;
  }

  void showType() {
    System.out.println("type of First = " + ob1.getClass().getName());
    System.out.println("type of Second = " + ob2.getClass().getName());
  }
}

class Main {

  public static void main(String args[]) {
    Pair<Integer, String> pairObj;
    pairObj = new Pair<Integer, String>(13, "Akram");
    int x = pairObj.getob1();
    System.out.println("The value for x = " + x);
    String y = pairObj.getob2(); 
    System.out.println("The value for y = " + y);
    pairObj.showType();
  }
}