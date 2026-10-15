import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int g_n = 0,s_n = 0;
        while (g_n<g.length&&s_n<s.length){
            if (g[g_n] >= s[s_n]) {
                g_n++;
            }
            s_n++;
        }
        return g_n;
    }
}
