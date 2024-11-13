import java.util.*;
public class Main
{
    public static void fibboIterative(int n){
        int n1 = 0, n2=1;
        for(int i = 0; i < n; i++){
            System.out.print(n1 + " ");
            int n3 = n1+n2;
            n1 = n2;
            n2 = n3;
        }
    }//TC:  O(N) , SC:O(1)
    
    public static int fibboRecursive(int n){
        if(n<=1)return n;
        return fibboRecursive(n-1) + fibboRecursive(n-2);
    }//TC : Time Complexity: O(2^N)  Auxiliary Space: O(n)


    
	public static void main(String[] args) {
	    int n = 10;
	    System.out.print("Iterative: ");
		fibboIterative(n);
		System.out.println();
		System.out.print("Recursive: " );
		for (int i = 0; i < n; i++) {
    		System.out.print(fibboRecursive(i) + " ");
		}
	}
}

