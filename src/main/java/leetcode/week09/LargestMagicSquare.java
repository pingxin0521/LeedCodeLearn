package leetcode.week09;

/**
 * https://leetcode-cn.com/problems/largest-magic-square/
 */
public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k=0;i+k<n&&j+k<m;k++) {
                    if (k+1>ans){
                        int sum =0;
                        boolean ok = true;
                        for (int x = 0; x <= k; x++) {
                            sum+=grid[i][j+x];
                        }
                        for (int x = 0; x <= k && ok; x++) {
                            int psum =0;
                            for (int y = 0; y <= k; y++) {
                                psum +=grid[i+x][j+y];
                            }
                            if (psum!=sum){
                                ok = false;
                            }
                        }
                        for (int x = 0; x <= k && ok; x++) {
                            int psum =0;
                            for (int y = 0; y <= k; y++) {
                                psum +=grid[i+y][j+x];
                            }
                            if (psum!=sum){
                                ok = false;
                            }
                        }
                        {
                            int psum =0;
                            for (int y = 0; y <= k; y++) {
                                psum +=grid[i+y][j+y];
                            }
                            if (psum!=sum){
                                ok = false;
                            }
                        }
                        {
                            int psum =0;
                            for (int y = 0; y <= k; y++) {
                                psum +=grid[i+y][j+k-y];
                            }
                            if (psum!=sum){
                                ok = false;
                            }
                        }
                        if (ok){
                            ans = Math.max(ans,k+1);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
