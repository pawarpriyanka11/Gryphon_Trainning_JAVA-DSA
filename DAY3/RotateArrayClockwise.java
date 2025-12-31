package DAY3;

public class RotateArrayClockwise {




	
	public static void main(String args[]) {
		int[][] a= {{1,2,3,},{4,5,6},{7,8,9}};
		System.out.println("Original of array: ");
		print(a);
		transpose(a);
		System.out.println("Transpose of array: ");
		print(a);
		System.out.println("Reverse transposed array: ");
		reverse(a);
		print(a);
		
	}
	
	static void print(int[][] a) {
		for(int[] row:a) {
			for(int val: row) {
				System.out.print(val+" ");
				
			}
			System.out.println();
		}
	}
	
	static void transpose(int[][] a) {
		int n=a.length;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int temp=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=temp;	
			}	
	}
	}
	
	static void print1(int[][] a) {
		for(int[] row:a) {
			for(int val: row) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}

	static void reverse(int[][] matrix)
	{
		//Reverse the each row
		int n=matrix.length;
		
		for(int i=0;i<n;i++)
		{
			int start=0;
			int end=n-1;
			while(start<end)
			{
				int temp=matrix[i][start];
				matrix[i][start]=matrix[i][end];
				matrix[i][end]=temp;
				start++;
				end--;
			}
		}
		
	}
}