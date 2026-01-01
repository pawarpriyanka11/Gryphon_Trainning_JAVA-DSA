package DAY4;

public class String3Operation {

	public static void main(String[] args) {
		
		String input="India maharashtra nagar kopargaon";
		System.out.print(reverseString(input));
	}
	
	
	static String reverseString(String input)
	{
		char[] chars=input.toCharArray();
		int n=chars.length;
		//reverse entire string
		reverse(chars,0,n-1);
		
		//reverse each word
		int start=0;
		
		for(int end=0;end<n;end++)
		{
			if(chars[end]==' ')
			{
				reverse(chars,start,end-1);
				start=end+1;
			}
			
		}
		reverse(chars,start,n-1);
		
		return new String(chars);
	}
	static void reverse(char[] chars,int start,int end)
	{
		while(start<end)
		{
			char temp=chars[start];
			chars[start]=chars[end];
			chars[end]=temp;
			start++;
			end--;
			
		}
	}
}


