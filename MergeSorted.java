import java.util.LinkedList;

public class MergeSorted {

  LinkedList<Integer> a = new LinkedList<Integer>();
  LinkedList<Integer> b = new LinkedList<Integer>();
  LinkedList<Integer> c = new LinkedList<Integer>();
  
  public MergeSorted(){
    a.add(1);
    a.add(4);
    a.add(5);
    a.add(8);
    b.add(2);
    b.add(3);
    b.add(6);
    b.add(7);
  }

  public void run(){
    for(int i=0;  i<a.size(); i++){
      if(a.get(i)>b.get(i)){
        c.add(b.get(i));
        c.add(a.get(i));
      } else{
        c.add(a.get(i));
        c.add(b.get(i));
      }
    }
    System.out.println("Sorted List is: " + c);
  }

  public void run1(){
    while(a.size() > 0){
      int x = a.removeFirst();

      if(x > b.getLast()) {
        b.addLast(x);
      }
      else {
        for(int i=0; i<b.size(); i++){
          if(b.get(i) > x){
            b.add(i, x);
            break;
          } 
        }
      }
    }

    System.out.println("Sorted List is: " + b);

  }
}