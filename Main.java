
import java.util.Scanner; //java library for user input


public class Main {   
  static void do_0() {
      return;    
  }
  
    static void do_1() {
      System.out.println("Hello, World of Monkeys!");
    }

    static void do_3() {
      new MonkeyLoop().printPoem();
    }

    static void do_4() {
      new MonkeyList().print();
    }

    static void do_5() {
      MonkeyList ml = new MonkeyList();
      ml.print();
      ml.printPoem();
    }

    static void do_merge() {
      MergeSorted ms = new MergeSorted();
      ms.run1();
    }

    static void do_stack() {
      StackQueue s = new StackQueue();
      s.run();
    }

    static void do_calculator() {
      Calculator simpleMath = new Calculator("100 + 200  * 3");
      System.out.println("Simple Math\n" + simpleMath);
  
       simpleMath = new Calculator("(100 + 200)  * 3");
      System.out.println("Simple Math\n" + simpleMath);
  
       simpleMath = new Calculator("100.2 - 99.3");
      System.out.println("Simple Math\n" + simpleMath);
  
       simpleMath = new Calculator("300 % 200");
      System.out.println("Simple Math\n" + simpleMath);
  
       simpleMath = new Calculator("300/200");
      System.out.println("Simple Math\n" + simpleMath);

       simpleMath = new Calculator("200%(300+5+300)/200+1*100");
      System.out.println("Simple Math\n" + simpleMath);

       simpleMath = new Calculator("2 ^ 3");
      System.out.println("Simple Math\n" + simpleMath);

     simpleMath = new Calculator("SQRT 4");
      System.out.println("Simple Math\n" + simpleMath);

    }
  
  
    static public void main(String[] args)  { 
        Menu m = new Menu();
        m.addItem(0, new String("Quit"),           Main::do_0);
        m.addItem(1, new String("Hello"),          Main::do_1);
        m.addItem(2, new String("Printy"),         Printy::main);
        m.addItem(3, new String("Loopy"),          Main::do_3);
        m.addItem(4, new String("Classy Print"),   Main::do_4);
        m.addItem(5, new String("Classy Poem"),    Main::do_5);
        m.addItem(6, new String("Binary"),         Biny::main);
        m.addItem(7, new String("Termy"),          Termy::main);
        m.addItem(8, new String("LinkedList"),     MyLinkedList::main);
        m.addItem(9, new String("MergeSorted"),    Main::do_merge);
        m.addItem(10, new String("StackQue"),      Main::do_stack);
        m.addItem(11, new String("Calculator"),    Main::do_calculator);
        String banner = new String();
        banner = "-------------------------\n";
        banner = banner + "Choose from these choices\n";
        banner = banner + "-------------------------\n";

        menu(banner, m); 
    } 
  
    public static void menu(String banner, Menu m) {
        int selection;  
        Scanner scan = new Scanner(System.in);  

 
        //The block of outputs below is used to present a menu to the user. 
        System.out.println(banner);
        m.printItems();
              
      try {
        //Using Scanner Class to get integer as input
        selection = scan.nextInt();  //Using nextInt() method to get an integer value

        if (selection == 0) {
          return;
        } else {
          m.runItem(selection);          
        }
      }
      catch(Exception e) {
        
      }
      
      menu(banner, m);
    }

}