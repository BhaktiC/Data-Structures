import java.util.*;
import java.io.*;

class Merge{
    static int n;
    static int[] size, rank, parent;
	static int max=0;
	
	public static int find(int x){
		if(parent[x]!=x)
			parent[x]=find(parent[x]);
		return parent[x];
	}
	
	public static void mergeTable(int x, int y){
		x=find(x);
		y=find(y);
		if(x==y)
			return;
		/*if(rank[x]>rank[y]){
			parent[y]=x;
			size[x]+=size[y];
			size[y]=size[x];
		}
		else{
			parent[x]=y;
			size[y]+=size[x];
			size[x]=size[y];
		}*/
		parent[x]=y;
		size[y]+=size[x];
		size[x]=0;
		if(size[y]>max)
			max=size[y];
		/*if(size[x]>max)
			max=size[x];
		if(rank[x]==rank[y])
			rank[y]+=1;*/
	}
	
	
    public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
		size=new int[n+1];
		rank=new int[n+1];
		parent=new int[n+1];
		int m=sc.nextInt();
		for(int i=1;i<=n;i++){
			size[i]=sc.nextInt();
			parent[i]=i;
			if(size[i]>max)
				max=size[i];
		}
		for(int t=0;t<m;t++){
			int src=sc.nextInt();
			int dest=sc.nextInt();
			mergeTable(src,dest);
			System.out.println(max);
		}
	}
}
		