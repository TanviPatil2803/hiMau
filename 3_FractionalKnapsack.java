import java.util.*;

class Item{
    int value, weight;
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}

class MyComparator implements Comparator<Item>
{
    public int compare(Item a, Item b){
        double r1 = (double) (a.value)/(double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if(r1<r2)return 1;
        else if(r2<r1)return -1;
        else return 0;
    }
}
public class Main
{
    
    public static double fractionalKnapsack(int wt, Item arr[], int n){
        Arrays.sort(arr, new MyComparator()); // N log N
        int currWt = 0;
        double finalVal = 0.0;
        for(int i = 0; i < n; i++){ //O(N)
            if(currWt + arr[i].weight <= wt){
                currWt+=arr[i].weight;
                finalVal+=arr[i].value;
            }
            else{
                int remaining = wt-currWt;
                finalVal+=((double) arr[i].value / (double)arr[i].weight) * (double) remaining; //little remaining
                break;
            }
        }
        return finalVal;
    }
    
	public static void main(String[] args) {
		int n = 3, wt = 50;
		Item arr[] = {new Item(100,20), new Item(60,10), new Item(120,30)};
		double ans = fractionalKnapsack(wt, arr, n);
		System.out.print("Max val: " + ans);
	}
}

//TC:(N+N log N)
// SC : O(1) 




