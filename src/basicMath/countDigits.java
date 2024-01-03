package basicMath;

public class countDigits {
    public static int func1(int n){
        int ans=0;
        while(n>0){
            ans=ans+1;
            n=n/10;
        }
        return ans;
        //TC=O(LOGN) BASE 10
    }

    public static int func2(int n){
        return (int)Math.log10(n)+1;
    }
    public static void main(String[] args) {
        System.out.println(func1(2003));
        System.out.println(func2(2003));
    }
}
