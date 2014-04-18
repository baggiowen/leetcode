public class Solution {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int length = matrix[0].length;
        int width = matrix.length;
        
        int x = 0;
        int y = 0;
        
        while (length > 0 && width > 0) {
            if (length == 1) {
                for (int i = 0; i < width; i++) {
                    res.add(matrix[x++][y]);
                }
                break;
            }
            else if (width == 1) {
                for (int i = 0; i < length; i++) {
                    res.add(matrix[x][y++]);
                }
                break;
            }
            
            for (int i = 0; i < length - 1; i++) {
                res.add(matrix[x][y++]);
            }
            for (int i = 0; i < width - 1; i++) {
                res.add(matrix[x++][y]);
            }
            for (int i = 0; i < length - 1; i++) {
                res.add(matrix[x][y--]);
            }
            for (int i = 0; i < width - 1; i++) {
                res.add(matrix[x--][y]);
            }
            x++;
            y++;
            length -= 2;
            width -= 2;
        }
        return res;
    }
}

//be careful with length&width&coordination
//don't forget to deal with the case that width=1 or length=1
