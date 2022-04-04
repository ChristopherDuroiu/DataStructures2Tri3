import java.util.ArrayList;
//import java.util.Random;
import java.util.Date;

public class Sort {

ArrayList<Integer> data;
ArrayList<Integer> sorted;
ArrayList<Integer> empty;
int current;
String output;
int size;
int merge_o;
int bubble_o;
int selection_o;
int selection1_o;
int insertion_o;
long merge_t;
long bubble_t;
long selection_t;
long selection1_t;
long insertion_t;
  
  public Sort(int s){
    data = new ArrayList<Integer>();
    sorted = new ArrayList<Integer>();
    output = new String("");
    size = s;
    merge_o = 0;
    bubble_o = 0;
    selection_o = 0;
    selection1_o = 0;
    insertion_o = 0;
    merge_t = 0;
    bubble_t = 0;
    selection_t = 0;
    selection1_t = 0;
    insertion_t = 0;
    
    for(int i=0; i < s; i++){
      int x = (int)(Math.random() * 1000);
      data.add(x);
    }

    //System.out.println("data: " + data);
    
    merge();
    insertion();
    bubble();
    selection();
    selection1();
    
  }
  
  public void merge() {
    for(int i=0; i < data.size(); i++){
      sorted.add(i, data.get(i));
    }

    Date date = new Date();
    long t_in = date.getTime();
    MergeSort(0, data.size()-1);
    date = new Date();
    merge_t = date.getTime() - t_in;
    
    //System.out.println("merge: " + sorted);
    
    this.output = this.output + "merge algorithm: size = " + size + " O = " + merge_o + " (" + size * (Math.log(size) / Math.log(2)) + ")" + " time = " + merge_t + "ms \n";
  }
  
  public void MergeSort(int l, int r){
    //System.out.println("merge sort " + l + " " + r + "d = " + sorted);
    int m = l + (r-l)/2;
    
    if(m > l){
      MergeSort(l, m);
      }
    if(r > m+1){    
      MergeSort(m+1, r);
      }
    mergearray(l, m, r);
    
  }

  public void mergearray(int l, int m, int r){
    ArrayList<Integer> halfone = new ArrayList(sorted.subList(l, m + 1));
    ArrayList<Integer> halftwo = new ArrayList(sorted.subList(m+1, r+1));

    //System.out.println("mergearray: " + l + " " + m + " " + r);
    //System.out.println("half one: " + halfone);
    //System.out.println("half two: " + halftwo);
    
    for(int i = 0; i<halftwo.size(); i++) {
      if(halftwo.get(i) > halfone.get(halfone.size()-1)) {
          halfone.add(halftwo.get(i));
          merge_o++;
      } else {
        int v = halfone.size();
        for(int j = 0; j<v; j++){
          if(halftwo.get(i) < halfone.get(j)) {
            halfone.add(j, halftwo.get(i));
            //System.out.println(i + " " + j + " halfone = " + halfone);
            merge_o++;
            break;
          }
        }
      }
    }

  for(int c = 0; c<halfone.size(); c++){
    sorted.set(c+l, halfone.get(c));
  }
    
  }
  
  public void insertion() {
    //copy original array into sorted
    sorted = new ArrayList<Integer>();
    for(int i=0; i < data.size(); i++){
      sorted.add(i, data.get(i));
    }

    Date date = new Date();
    long t_in = date.getTime();
    InsertionSort();
    date = new Date();
    insertion_t = date.getTime() - t_in;
    
    //System.out.println("insertion: " + sorted);
    
    this.output = this.output + "insertion algorithm: size = " + size + " O = " + insertion_o + " (" + size * (size + 1)/2 + ")" + " time = " + insertion_t + "ms \n";

    
  }

  public void InsertionSort(){

    for(int i = 0; i < sorted.size(); i++) {
      insertion_o ++;
      for(int j = 0; j<i; j++) {
        insertion_o ++;
        int x = sorted.get(i);
        if(sorted.get(j) > x) {
          sorted.remove(i);
          sorted.add(j, x);
          break;
        }
      }
    }
  }

  public void bubble() {
    sorted = new ArrayList<Integer>();

    for(int i=0; i < data.size(); i++){
      sorted.add(i, data.get(i));
    }

    Date date = new Date();
    long t_in = date.getTime();
    BubbleSort();
    date = new Date();
    bubble_t = date.getTime() - t_in;
    
    //System.out.println("bubble: " + sorted);
    
    this.output = this.output + "bubble algorithm: size = " + size + " O = " + bubble_o + " (" + size * size + ")" + " time = " + bubble_t + "ms \n";
  }
  
  public void BubbleSort(){
    boolean swapped; 

    while(true) {
       swapped = false;
      for(int i = 1; i<sorted.size(); i++){
        bubble_o++;
        if(sorted.get(i) < sorted.get(i-1)){
          int x = sorted.get(i);
          swapped = true;
          sorted.remove(i);
          sorted.add(i-1, x);
        }
      }

      if(!swapped){
        break;
      }
    }
    
  }

  public void selection() {
    sorted = new ArrayList<Integer>();
    
    for(int i=0; i < data.size(); i++){
      sorted.add(i, data.get(i));
    }

    Date date = new Date();
    long t_in = date.getTime();
    SelectionSort();
    date = new Date();
    selection_t = date.getTime() - t_in;
    
    //System.out.println("selection: " + sorted);
    
    this.output = this.output + "selection algorithm: size = " + size + " O = " + selection_o + " (" + size * size + ")" + " time = " + selection_t + "ms \n";
  }

  public void SelectionSort() {
    int min;
    int id;
    
    for(int i = 0; i < sorted.size(); i++) {
      min = sorted.get(i);
      id = i;
      selection_o++;
      
      for (int j=i+1; j< sorted.size(); j++) {
        selection_o++;
        if (sorted.get(j) < min) {
          min = sorted.get(j);
          id = j;
        }
      }
      
      //int k = sorted.get(id);
      sorted.remove(id);
      sorted.add(i, min);
    }
  }

  public void selection1() {
    sorted = new ArrayList<Integer>();
    
    for(int i=0; i < data.size(); i++){
      sorted.add(i, data.get(i));
    }

    Date date = new Date();
    long t_in = date.getTime();
    Selection1Sort();
    date = new Date();
    selection1_t = date.getTime() - t_in;
    
    //System.out.println("selection1: " + sorted);
    
    this.output = this.output + "selection1 algorithm: size = " + size + " O = " + selection1_o + " (" + size * size + ")" + " time = " + selection1_t + "ms \n";
  }

  public void Selection1Sort() {
    int min, max;
    int minid, maxid;
    
    for(int i = 0; i < sorted.size()/2; i++) {
      //System.out.println("i = " + i);
      min = sorted.get(i);
      max = sorted.get(i);
      minid = i;
      maxid = i;
      
      selection1_o++;
      
      for (int j=i+1; j < sorted.size() - i; j++) {
        //System.out.println("j = " + j);

        selection1_o++;
        
        if (sorted.get(j) < min) {
          min = sorted.get(j);
          minid = j;
        }
        if (sorted.get(j) > max) {
          max = sorted.get(j);
          maxid = j;
        }

      }

      //System.out.println("minid = " + minid + " maxid = " + maxid);
      //System.out.println("min = " + min + " max = " + max);

      //int kmin = sorted.get(minid);
      //int kmax = sorted.get(maxid);
      
      if(maxid != minid) {
        sorted.remove(minid);
        //System.out.println("sorted: " + sorted);
        
        sorted.add(i, min);
        //System.out.println("sorted: " + sorted);

        if (minid > maxid) {
          maxid++;
        }
        
        sorted.remove(maxid);
        //System.out.println("sorted: " + sorted);

        sorted.add(sorted.size()-i, max);
        //System.out.println("sorted: " + sorted);

      } else {
        
      }
      
      //System.out.println("sorted: " + sorted);
    }
  }
  
  
  public String toString() {
    return (this.output + "\n");
  }
  
}