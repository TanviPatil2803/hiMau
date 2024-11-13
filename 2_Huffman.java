import java.util.*;
public class Main
{
    public static void printCode(HuffmanNode root, String s){
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            System.out.println(root.c + ":" + s);//s is code genetrated
            return;
        }
        printCode(root.left, s+"0");
        printCode(root.right, s+"1");
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 4;
		char ch[] = {'a', 'b', 'c', 'd'};
		int freq[] = {8, 7, 4, 2};
		
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(n, new MyComparator());
		for(int i = 0; i < n; i++){
		    HuffmanNode hn = new HuffmanNode();
		    hn.c = ch[i];
		    hn.data = freq[i];
		    hn.left = null;
		    hn.right = null;
		    pq.add(hn);
		}
		HuffmanNode root = null;
		while(pq.size() > 1)
		{
		    HuffmanNode x = pq.peek();
		    pq.poll();
		    HuffmanNode y = pq.peek();
		    pq.poll();
		    HuffmanNode f = new HuffmanNode();
		    f.data = x.data + y.data;
		    f.c = '-';
		    f.left = x;
		    f.right = y;
		    root=f;
		    pq.add(f);
		}
		printCode(root, "");
	}
}

class HuffmanNode{
    int data;
    char c;
    HuffmanNode left; 
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.data - y.data;
    }
}

//Building the Priority Queue+Building the Huffman Tree+Generating Huffman Codes:
//TC: O(nlogn)+O(nlogn)+O(n)=O(nlogn)
//SC: O(n)+O(n)+O(logn)=O(n)