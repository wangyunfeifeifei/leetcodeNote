import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
      if (board == null || board.length < 9 || board[0].length < 9)
        return false;
      Set<Character> row = new HashSet<>();
      Set<Character> col = new HashSet<>();
      Set<Character> block = new HashSet<>();

      for (int i=0; i<9; i++) {
        row.clear();
        col.clear();
        for(int j=0; j<9; j++) {
          if (board[i][j] != '.') {
            // 检查行
            if(row.contains(board[i][j]))
              return false;
            row.add(board[i][j]);
          }
          if (board[j][i] != '.') {
            // 检查列
            if(col.contains(board[j][i]))
             return false;
            col.add(board[j][i]);
          }
          if(i % 3 == 0 && j % 3 == 0) {
            // 检查块
            block.clear();
            for(int k = i; k < i + 3; k++) {
              for(int l = j; l < j + 3; l++) {
                if(board[k][l] != '.') {
                  if(block.contains(board[k][l]))
                    return false;
                  block.add(board[k][l]);
                }
              }
            }
          }
        }
      }

      return true;
    }
    public static void main(String[] args) {
      
    }
}
