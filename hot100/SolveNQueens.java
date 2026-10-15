import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// n皇后：一行只能出现一个棋子，该棋子的行列下表相加，等于其主对角线的各元素的行列下标相加，行列下标相减等于其副对角线的行列下标相减
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> vector = new ArrayList<>();
        List<char[]> board = new ArrayList<>();
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> add_set = new HashSet<>();
        HashSet<Integer> sub_set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n).toCharArray());
        }

        backTracking(vector,col,add_set,sub_set,n,0,board);
        return vector;
    }

    //row表示遍历到第几行，i表示列
    private void backTracking(List<List<String>> vector, HashSet<Integer> col, HashSet<Integer> addSet, HashSet<Integer> subSet, int n, int row, List<char[]> board) {
        if(row == n){
            ArrayList<String> path = new ArrayList<>();
            for (char[] chars : board) {
                StringBuilder temp = new StringBuilder();
                for (char aChar : chars) {
                    temp.append(aChar);
                }
                path.add(temp.toString());

            }
            vector.add(path);
        }
        for (int i = 0; i < n; i++) {
            if(col.contains(i) || addSet.contains(row+i)||subSet.contains(row-i)){
                continue;
            }
            col.add(i);
            addSet.add(row+i);
            subSet.add(row-i);
            board.get(row)[i]='Q';
            backTracking(vector,col,addSet,subSet,n,row+1,board);
            addSet.remove(row+i);
            subSet.remove(row-i);
            col.remove(i);
            board.get(row)[i]='.';
        }
    }
}
