package basicMath;

public class reverseNumber {
    public static int func1(int n){
        int ans=0;
        while(n>0){
            int lastDigit=n%10;
            ans=ans*10+lastDigit;
            n=n/10;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(func1(450));
    }

}
