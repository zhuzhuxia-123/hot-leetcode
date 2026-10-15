import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    private final HashMap<Character, String> map = new HashMap<>();
    private final List<String> s = new ArrayList<>();
    private final StringBuilder pathBuilder = new StringBuilder();
    public List<String> letterCombinations(String digits) {

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        char[] arr = digits.toCharArray();
        backTracking(arr,pathBuilder,0);
        return s;
    }

    private void backTracking(char[] arr,StringBuilder path,Integer index) {
        if(arr.length == path.length()){
            s.add(path.toString());
            return;
        }
        if(index>=arr.length){
            return;
        }
        for (char c : map.get(arr[index]).toCharArray()) {
            path.append(c);
            backTracking(arr,path,index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
