import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                }else if(o1[0]<o2[0]){
                    return -1;
                }
                return 0;
            }
        });
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=intervals[i-1][1]){
                continue;
            }
            if(intervals[i][0]<intervals[i-1][1]){
                count++;
                intervals[i][1] = Math.min(intervals[i-1][1],intervals[i][1]);
            }
        }
        return count;
    }
}
