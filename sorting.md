# Welcome to my Sorting Takeaways

# Merge Sort

```
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
```
**Complexity of merge sort**
- The merge sort has a unique time complexity due to its divisions and subdivisions of the unsorted array
- The best, worst, and average time complexity is **o(n x log n)** for all cases because the sort will always divide the array and take a linear time to merge the halves

an extremely useful visual for how a merge sort works can be found below

![image](https://user-images.githubusercontent.com/89252299/161473186-c926e734-23f6-4de1-a46f-08fc6021752f.png)


# Insertion Sort


```
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

```
**Complexity of merge sort**
- An insertion sort has an average and worst case time complexity of **O(n^2)** and a best case of O(n)
- An insertion sort works by iterating through each element, and for each element, iterating through the entire unsorted aray all the way up to it and finding the first element for which it is larger than, and placing it after that

An extremely useful image for visualizing insertion sorts can be found below:

![image](https://user-images.githubusercontent.com/89252299/161471402-08a3b9ad-dfaf-4716-9e72-5e51d28bc115.png)


# Bubble Sort


```
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

```

**Complexity of a Bubble sort**
- A bubble sort works by constantly comparing elements to its adjacent ones and swapping them. Multiple passes of this strategy will work out over time
- A bubble sort has a worst and average time complexity of **O(n^2)** and a best case time complexity of O(n) which is when the elements are already sorted

A very useful image for visualizing the buble sort can be found below

![image](https://user-images.githubusercontent.com/89252299/161471669-089e6c1e-2c15-4d6b-a8d2-21288a8d6b81.png)


# Selection Sort


```
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

```
**Complexity of a Selection sort**
- A selection sort works by iterating through an array multiple times, and extracting and removing the minimum value each pass and placing it in an empty array
- The best, average, and worst case time complextiy for a selection sort is O(n^2)
- A bubble sort has a worst and average time complexity of **O(n^2)** and a best case time complexity of O(n) which is when the elements are already sorted
<br />
<br />
**Summary and Comparisons**
<br />
Here is what one run of my code looks like for 5000 elements:
![image](https://user-images.githubusercontent.com/89252299/161472123-9bb41929-8f0e-4ab2-bed6-df32b4be1b2d.png)
<br /> (selection1 is a modification I made of the selection algorithm to get the greatest element simulataneously with the smallest element with each pass to save time)
<br />
<br />
**For 12 runs removing corner cases of each sort algorithm the results are: **

**<br />merge average = 60 ms
<br />Insertion average = 68 ms
<br />bubble = 9325 ms
<br />Selection average = 72 ms**

Overall, in my case, merge sort consistently performed the best compared to the other algorithms, though it was quite close to both insertion and selection sort.
Bubble sort by far performed the worst, though my code is probably not optimal because it should not be taking this long.

The algorithms ranked best (fastest) to worst(slowest) are merge, selection = insertion, bubble 

