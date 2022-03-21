import java.util.LinkedList;

public class MyLinkedList {

  static LinkedList<String> sentence = new LinkedList<String>();

  static public void enque(String s){
    sentence.add(s);
    
    System.out.println("Enqueued data: " + s);
    
    printlist();
  }

  static public void printlist(){
    System.out.print("Words count: "+ sentence.size() + " data: ");

    if(sentence.size() == 0){
      System.out.println("null");
      System.out.flush();
    } 
    else {
      for(int i=0; i<sentence.size(); i++){
        System.out.print(sentence.get(i) + " ");
      }
      System.out.println("");
    }
  }
  
  static public void deque() {
    System.out.println("Dequeued data: " + sentence.removeFirst());

    printlist();
  }

  static public void run(){
    System.out.println("MyLinkedList main");

    enque("seven");
    enque("slimy");
    enque("snakes");
    enque("sallying");
    enque("slowly");
    enque("slithered");
    enque("southward");
    deque();
    deque();
    deque();
    deque();
    deque();
    deque();
    deque();
    deque();

  }
  
  static public void main()  {  
   run();
  }
  
}