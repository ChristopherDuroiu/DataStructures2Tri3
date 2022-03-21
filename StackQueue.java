import java.util.LinkedList;

public class StackQueue {

  LinkedList<Integer> a = new LinkedList<Integer>();
  LinkedList<Integer> b = new LinkedList<Integer>();
  
  public StackQueue(){
    a.add(1);
    a.add(2);
    a.add(3);
    a.add(4);
  }
  public void run(){
    for(int i = a.size()-1; i>= 0; i--){
      b.add(a.get(i));
    }
    System.out.println("Reversed Stack: " + b);
  }
}