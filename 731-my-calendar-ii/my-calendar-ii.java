import java.util.*;
class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlaps;
    public MyCalendarTwo() {
        bookings=new ArrayList<>();
        overlaps=new ArrayList<>();
    }
    public boolean book(int start,int end) {
        for(int[] o:overlaps){
            if(start<o[1]&&end>o[0]) return false;
        }
        for(int[] b:bookings){
            if(start<b[1]&&end>b[0]){
                overlaps.add(new int[]{Math.max(start,b[0]),Math.min(end,b[1])});
            }
        }
        bookings.add(new int[]{start,end});
        return true;
    }
}
