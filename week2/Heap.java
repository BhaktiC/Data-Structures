import java.util.*;
public class Heap
{
	static int n;
	static int[] a;
    static int count=0;
	static int[] swap1;
	static int[] swap2;
	public static void siftDown(int k)
	{
		int min=k;
		int l=2*k+1;
		int r=2*k+2;
		if(r<n && a[r]<a[min])
			min=r;
		if(l<n && a[l]<a[min])
			min=l;
		if(min!=k)
		{
			int temp=a[k];
			a[k]=a[min];
			a[min]=temp;
			swap1[count]=k;
			swap2[count]=min;
			count++;
			siftDown(min);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		swap1=new int[n];
		swap2=new int[n];
		a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		for(int i=n/2;i>=0;i--)
			siftDown(i);
		System.out.println(count);
		for(int i=0;i<count;i++)
			System.out.println(swap1[i]+" "+swap2[i]);
	}
}