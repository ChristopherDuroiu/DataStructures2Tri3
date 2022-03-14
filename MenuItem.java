
public class MenuItem {
  public String t;
  private Runnable toRun;

  public MenuItem(String s, Runnable r){
    this.t = new String(s);
    this.toRun = r;
  }

  public void run(){
    toRun.run();
  }

  public String getString(){
    return t;
  }
}