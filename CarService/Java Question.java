import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int [n];
        int i = 0;
        int negativeCount = 0;
        while(i<n){
            int val = sc.nextInt();
            if(val==0) continue;
            else{
                if(val<0){
                    negativeCount++;
                }
                A[i] = val;
                i++;
            }
        }
        for(int j = 0;j<n-2;j++){
            for(int k= j+1;k<n-1;k++){
                for(int l = k+1;l<n;l++){
                    if((negativeCount==0)||(negativeCount==n)){
                        System.out.println(-1);
                        return;
                    }else if((A[j] + A[k] + A[l])==0){
                        System.out.println(A[j] +" "+ A[k]+" " + A[l] );
                        return;
                    }
                }
            }
        }System.out.println(-1);
	}
}
TC : O(n^3)
SC : O(n)

test cases :-
1) n = 5,A[-4,1,3,-2,-1] output : -4 1 3
2) n = 4, A[-4,1,5,3] output : -4 1 3
3) n = 5, A[3,5,7,9,2] output : -1
4) n = 5, A[-4,-2,-5,-9,-7] output : -1