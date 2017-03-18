import java.io.*;
import java.util.*;

 class Node{
		long time;
		int index;
		}

public class Jobq {
    private static int n,m;
    private static long[] jobs;

    private static int[] assignedWorker;
    private static long[] startTime;
    
	public static void siftDown(ArrayList<Node> thread, int k)
	{
		int min=k;
		int l=2*k+1;
		int r=2*k+2;
		if(r<n && thread.get(r).time<thread.get(min).time)
			min=r;
		if(l<n && thread.get(l).time<thread.get(min).time)
			min=l;
		if(r<n && thread.get(r).time==thread.get(min).time && thread.get(r).index<thread.get(min).index)
			min=r;
		if(l<n && thread.get(l).time==thread.get(min).time && thread.get(l).index<thread.get(min).index)
			min=l;
		
		if(min!=k)
		{
			Node temp=thread.get(k);
			thread.set(k,thread.get(min));
			thread.set(min,temp);
			siftDown(thread,min);
		}
	}
	
	public static void updateThread(ArrayList<Node> thread, int i)
	{
		startTime[i]=thread.get(0).time;
		assignedWorker[i]=thread.get(0).index;
		thread.get(0).time+=jobs[i];
		siftDown(thread,0);
	}

    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Jobq jb=new Jobq();
		n=sc.nextInt();
		m=sc.nextInt();
		jobs=new long[m];
		assignedWorker=new int[m];
		startTime=new long[m];
		for(int i=0;i<m;i++)
		{
			jobs[i]=sc.nextLong();
		}
		ArrayList<Node> threads=new ArrayList<Node>(n);
		for(int i=0;i<n;i++)
		{
		    Node ob=new Node();
			ob.index=i;
			ob.time=0;
			threads.add(ob);
		}
		for(int i=n/2;i>=0;i--)
			siftDown(threads,i);
		for(int i=0;i<m;i++)
		{
			updateThread(threads,i);
		}
			
		for(int i=0;i<m;i++)
			System.out.println(assignedWorker[i]+" "+startTime[i]);
	}
}	