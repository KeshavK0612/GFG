//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
public ArrayList<String> findPath(int[][] mat) {
ArrayList<String> result = new ArrayList<>();
if (mat[0][0] == 0 || mat[mat.length - 1][mat[0].length - 1] == 0) {
return result; // Return empty if start or end is blocked
}
boolean[][] visited = new boolean[mat.length][mat[0].length]; StringBuilder path = new StringBuilder();
findPaths(mat, 0, 0, visited, path, result);
return result;
}
private void findPaths(int[][] mat, int row, int col, boolean[][] visited, StringBuilder path, ArrayList<String> result) {
int n = mat.length;
 
// Base case: if we reach the bottom-right cell
if (row == n - 1 && col == n - 1) {
result.add(path.toString());
return;
}
 
// Mark the cell as visited
visited[row][col] = true;
 
// Explore all four directions
// Down
if (isSafe(mat, row + 1, col, visited)) {
path.append('D');
findPaths(mat, row + 1, col, visited, path, result); path.deleteCharAt(path.length() - 1); // Backtrack
}
 
// Up
if (isSafe(mat, row - 1, col, visited)) {
path.append('U');
findPaths(mat, row - 1, col, visited, path, result); path.deleteCharAt(path.length() - 1); // Backtrack
}
 
// Right
if (isSafe(mat, row, col + 1, visited)) {
path.append('R');
findPaths(mat, row, col + 1, visited, path, result);
path.deleteCharAt(path.length() - 1); // Backtrack
}
 
// Left
if (isSafe(mat, row, col - 1, visited)) {
path.append('L');
findPaths(mat, row, col - 1, visited, path, result); path.deleteCharAt(path.length() - 1); // Backtrack
}
 
// Unmark the cell as visited for other paths
visited[row][col] = false;
}
 
private boolean isSafe(int[][] mat, int row, int col, boolean[][] visited) { int n = mat.length;
return (row >= 0 && row < n && col >= 0 && col < n && mat[row][col] == 1 && !visited[row][col]);
}
}