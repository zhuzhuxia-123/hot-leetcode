public class MaxArea {
    //暴力枚举法
  /*  public int maxArea(int[] height) {
        int volume = 0;
        for(int i =0;i<height.length;i++){
            int weight =1;
            for(int j = i+1 ;j<height.length;j++){
                int temp =  Math.min(height[i],height[j])*weight;
                weight++;
                volume = Math.max(temp, volume);
            }
        }
        return volume;
    }*/
    //双指针法
    //选出左右高度最矮的柱子当作高，每次移动高度更矮的指针，由于若当前面积是S,宽度最大，移动高度更高那边指针，
    //只会遇见比更矮还矮的柱子，宽度变小，高度也变小，其面积比S小
    public int maxArea(int[] height) {
       int i = 0,j=height.length-1;
       int maxArea = 0;
       while (i<j){
           maxArea = Math.max(maxArea,(Math.min(height[i],height[j])*(j-i)));
           if(height[i]<height[j]){
               i++;
           }else {
               j--;
           }
       }
       return maxArea;
    }
}
