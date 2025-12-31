package DAY3;



public class TestCaseBasedQuestionDSA {
    
    public static void main(String[] args)
    {
        int sum1=0;
        int sum2=0;
        int[] A={1,2,3};
        int n=A.length;
        int[] q={1,0,2};
        int[] q1={2,0,2};


        int type=q[0];
        int l=q[1];
        int r=q[2];

        int type1=q1[0];

        if(type==1)
        {
            for(int i=0;i<n;i++)
            {
                A[i]=(i+l+1)*A[l];
                sum1+=A[i];
                
            }
        }

        if(type1==2)
        {
            
            for(int i=0;i<n;i++)
            {
                sum2+=A[i];
            }
        }
        int res=sum1+sum2;

        System.out.println("The Final Answer is "+res);
    }
}