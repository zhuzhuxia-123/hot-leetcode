public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0){
            return null;
        }

        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color,int start) {
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc] == color||image[sr][sc]!=start){
            return;
        }
        image[sr][sc] = color;
        dfs(image,sr+1,sc,color,start);
        dfs(image,sr-1,sc,color,start);
        dfs(image,sr,sc+1,color,start);
        dfs(image,sr,sc-1,color,start);
    }
}
