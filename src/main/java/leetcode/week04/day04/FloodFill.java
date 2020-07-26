package leetcode.week04.day04;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in leetcode.week04.day04
 * hyp create at 20-6-22
 **/
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int oc = image[sr][sc];
        dfs(image, sr, sc, newColor, oc);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 ||
                sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr, sc + 1, newColor, oldColor);
        dfs(image, sr, sc - 1, newColor, oldColor);
    }
}
