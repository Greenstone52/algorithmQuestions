public class Quest2 {
    public static void main(String[] args){

        char[][] board = {{'8','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }

    //public static boolean canJump(int[] nums) {
//
    //    int aim = nums.length - 1;
//
    //    int result = 0;
    //    int initialPoint = nums[0];
    //    int index = 0;
//
    //    if(initialPoint == 0 && nums.length == 1){
    //        return true;
    //    }else if(initialPoint == 0){
    //        return false;
    //    }
//
    //    for (int i = 1; i <= initialPoint; i++) {
    //        index += i;
    //        result = result + nums[index];
//
    //
    //    }
//
    //    if(result == aim){
    //        return true;
    //    }
    //    return false;
    //}

    //public static boolean iteration(int limit){
//
    //    for (int i = 0; i < limit; i++) {
//
    //    }
//
    //}

    public static boolean isValidSudoku(char[][] board) {
        boolean failCounter = false;

        int[] nums = new int[9];
        char [] numChar = {'1','2','3','4','5','6','7','8','9'};

        // row control
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                if(board[i][j] != '.'){
                    for (int k = 0; k < 9; k++) {
                        if(board[i][j] == numChar[k]){
                            nums[k]++;
                        }
                    }
                }
            }

            for (int k = 0; k < 9; k++) {
                if(nums[k] > 1){
                    return false;
                }
            }

            for (int k = 0; k < 9; k++) {
                nums[k] = 0;
            }
        }


        // column control
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                if(board[j][i] != '.'){
                    for (int k = 0; k < 9; k++) {
                        if(board[j][i] == numChar[k]){
                            nums[k]++;
                        }
                    }
                }
            }

            for (int k = 0; k < 9; k++) {
                if(nums[k] > 1){
                    return false;
                }
            }

            for (int k = 0; k < 9; k++) {
                nums[k] = 0;
            }
        }

        // 3X3 table control


        for (int i = 0; i <= 6; i = i+3) {
            for (int j = 0; j <= 6; j = j+3) {
                boolean result = tableControl(board,i,j);

                if(result == false){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean tableControl(char[][] board, int startRow, int startColumn){

        int[] nums = new int[9];
        char [] numChar = {'1','2','3','4','5','6','7','8','9'};

        int endColumn = startColumn + 2;
        int endRow = startRow + 2;

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {

                if(board[i][j] != '.'){
                    for (int k = 0; k < 9; k++) {
                        if(board[i][j] == numChar[k]){
                            nums[k]++;
                        }
                    }
                }

            }
        }

        for (int i = 0; i < 9; i++) {
            if(nums[i] > 1){
                System.out.println(numChar[i]);
                return false;
            }
        }

        return true;

    }


}
