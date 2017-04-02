import java.util.*;
class CheckBST2{
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
        if(inorder())
			System.out.println("CORRECT");
		else
			System.out.println("INCORRECT");
        
    }
    
    static boolean inorder() {        
        //keep the nodes in the path that are waiting to be visited
        Stack<Integer> stack = new Stack<Integer>();
        int curr=0;
		if(n==0)
			return true;
        //first node to be visited will be the left one
        while (curr != -1) {
            stack.push(curr);
			//System.out.println(key[curr]+" "+key[left[curr]]);
			if(left[curr]!=-1)
			if(key[left[curr]]==key[curr])
				return false;
            curr = left[curr];
        }
         int prev=stack.peek();
        while (stack.size() > 0) {
            curr = stack.pop();
			if(key[curr]<key[prev])
				return false;
			//System.out.print(key[curr]+" ");
			prev=curr;
            if (right[curr]!=-1) {
				curr = right[curr];
                while (curr!=-1) {
                    stack.push(curr);
					//System.out.println(key[curr]+" "+key[left[curr]]);
					if(left[curr]!=-1)
					if(key[left[curr]]==key[curr])
						return false;
                    curr = left[curr];
                }
            }
        }
		return true;
    }
	}
	
