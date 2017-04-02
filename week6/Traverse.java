import java.util.*;

    
class Traverse{
    static int n;
    static int[] key,left,right;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        key=new int[n];
        left=new int[n];
        right=new int[n];
        for(int i=0;i<n;i++){
            key[i]=sc.nextInt();
            left[i]=sc.nextInt();
            right[i]=sc.nextInt();
        }
        inorder();
        System.out.println();
        preorder();
        System.out.println();
        postorder();
    }
    
    static void inorder() {        
        //keep the nodes in the path that are waiting to be visited
        Stack<Integer> stack = new Stack<Integer>();
        int curr=0;
         
        //first node to be visited will be the left one
        while (curr != -1) {
            stack.push(curr);
            curr = left[curr];
        }
         
        // traverse the tree
        while (stack.size() > 0) {
           
            // visit the top node
            curr = stack.pop();
            System.out.print(key[curr] + " ");
            if (right[curr]!=-1) {
                curr = right[curr];
                while (curr!=-1) {
                    stack.push(curr);
                    curr = left[curr];
                }
            }
        }
    }
    public static void preorder(){
        Stack<Integer> stack = new Stack<Integer>();
        int curr=0;
        stack.push(0);
        // traverse the tree
        while (stack.size() > 0) {
            curr = stack.pop();
            System.out.print(key[curr] + " ");
            if (right[curr]!=-1) 
                stack.push(right[curr]);
            if(left[curr]!=-1)
                stack.push(left[curr]);
            
        }
    }
    public static void postorder(){
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
		int curr=0;
        stack.push(0);

       while (stack.size() > 0) {
            curr = stack.pop();
			stack2.push(curr);
            if(left[curr]!=-1)
			stack.push(left[curr]);
            if(right[curr]!=-1)
			stack.push(right[curr]);
        
		}
		while(stack2.size()>0)
		System.out.print(key[stack2.pop()]+" ");
 }
 }