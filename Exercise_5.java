import java.util.Stack;

class Pair {

    int start;
    int end;

    Pair(int start , int end) {
        this.start = start;
        this.end = end;
    }
}

class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable 
       /* swapping without extra variable - showing the incorrect output 
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
        */
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
      int pivot = arr[h]; // takes last element as pivot
      int i = l - 1;
      for(int j=l; j<= h-1;j++) {
        if(arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
      }
      swap(arr, i+1 , h);
      return (i+1); // return the index of pivot element
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(l, h));

        while(!stack.isEmpty()) {
            l = stack.peek().start;
            h = stack.peek().end;
            stack.pop();

            int pivotIndex = partition(arr, l, h);

            if(pivotIndex - 1 > l) {
                stack.push(new Pair(l, pivotIndex-1));
            }

            if(pivotIndex + 1 < h) {
                stack.push(new Pair(pivotIndex+1,h));
            }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 