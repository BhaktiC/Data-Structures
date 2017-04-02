import java.util.*;
import java.io.*;
public class tree_height
{
     
   	
		static int read() throws IOException {
		    
		int n;
		int root=0;
		LinkedList<Integer> adj[];
			Scanner in = new Scanner(System.in);
			n = in.nextInt();
			adj=new LinkedList[n];
			boolean flag[]=new boolean[n];
			int h[]=new int[n];
			for(int i=0;i<n;i++)
			{
			    flag[i]=false;
			    h[i]=0;
			    adj[i]=new LinkedList();
			 }
			for (int i = 0; i < n; i++) {
			    int k=in.nextInt();
			    if(k==-1)
			    root=i;
			    else
				adj[k].add(i);
			}
			LinkedList<Integer> queue = new LinkedList<Integer>();
			  flag[root]=true;
             int current=root;
             queue.add(root);
             h[root]=1;
             int max=h[root];
              while(queue.size()!=0)
                {
                current=queue.poll();
                  Iterator<Integer> i = adj[current].listIterator();
            while (i.hasNext())
            {
                int p = i.next();
               
                if (!flag[p])
                {
                    flag[p] = true;
                    queue.add(p);
                    h[p]=h[current]+1;
                    if(h[p]>max)
                    max=h[p];
                }
                
            }
           
		   }
		   return max;
         }
	

	static public void main(String[] args) throws IOException {
		System.out.println(read());
	}
}

