import java.util.HashMap;

public class Menu {
  public HashMap<Integer, MenuItem> options;

  public Menu() {
    options = new HashMap<Integer, MenuItem>();
  }

  public void printItems() {
    for (int i = 0; i < options.size(); i++) {
      try {
      System.out.println(i + ": " + options.get(i).t);
      }
      catch (Exception e) {
        System.out.println("something went wrong");
      }
    }
  }
  
  public void addItem(int id, String s, Runnable r) {
    options.put (id, new MenuItem(s, r));
  }

  public void runItem(int id) {
    try {
      options.get(id).run();
    } 
    catch (Exception e) {
      System.out.println("Invalid Input");
    }
  }
}