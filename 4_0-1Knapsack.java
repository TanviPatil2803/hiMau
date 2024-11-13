import java.util.*;
public class Main
{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight+1];
        for(int w = weight[0]; w<=maxWeight; w++){
            dp[0][w] = value[0];
        }

        for(int i = 1; i<n; i++){
            for(int w = 0; w<=maxWeight; w++){
                int notTake = dp[i-1][w];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= w){
                    take = value[i] + dp[i-1][w- weight[i]];
                }
                dp[i][w] = Math.max(take, notTake);
            }
        }
        return dp[n-1][maxWeight];
    }
    
	public static void main(String[] args) {
		int n = 4;
		int weight[] = {1,2,4,5};
		int value[] = {5,4,8,6};
		int maxWeight = 5;
		int result = knapsack(weight, value, n, maxWeight);
		System.out.println(result); //13 as {1,5} (5+8)
	}
}

//tC: O(n×maxWeight)
//SC: O(n×maxWeight)