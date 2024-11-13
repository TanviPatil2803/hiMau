import java.util.*;

public class Main{
	
	public static void quickSort(ArrayList<Integer> arr, int low, int high){
		if(low<high){
			int pivotIdx = partition(arr, low, high);
			quickSort(arr, low, pivotIdx-1);
			quickSort(arr, pivotIdx+1, high);
		}
	}


	public static int partition(ArrayList<Integer> arr, int low, int high){
		int pivot = arr.get(low);
		int i = low, j = high;
	
		//indicates that both partitions are acc to pivot
		while(i<j){
			while(arr.get(i) <= pivot && i<=high-1) i++;
			while(arr.get(j) >= pivot && j>= low+1) j--;
			if(i<j){
				int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
			}
		}
		int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
	}
	
	public static void main(String args[]){
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,3,7,8,9,10,1,4));
		int n = arr.size();
		quickSort(arr, 0, n-1); 
		for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
	}
}

// TC: (n log n)
// Sc : O(1) //no temp arr