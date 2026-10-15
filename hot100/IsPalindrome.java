public class IsPalindrome {
    public boolean isPalindrome(String s) {
        //字符串转为小写字母
        s = s.toLowerCase();
        char[] charArray = s.toCharArray();
        int index = 0;
        for(int t=0;t<charArray.length;t++){
            if((charArray[t]>=97&&charArray[t]<=122)||(charArray[t]>=48&&charArray[t]<=57)){
                charArray[index]=charArray[t];
                index++;
            }
        }
        int i =0,j=index-1;
        boolean flag = true;
        while (i<j){
            if(charArray[i]!=charArray[j]){
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }

}
