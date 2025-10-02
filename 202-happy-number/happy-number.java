class Solution {
    public boolean isHappy(int n) {
        int slow=n, fast=n;
        do{
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }
        while(slow!=fast);
        return slow == 1;
    }
    private int getNext(int n){
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            sum += d*d;
            n  /= 10;
        }
        return sum;
    }
}