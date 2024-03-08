public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello adgag3"));
    }

    public static int lengthOfLastWord(String s) {

        int lastIndex = s.length() - 1;

        while(s.charAt(lastIndex) == ' '){
            lastIndex--;
        }

        int counter = 0;

        //if(!s.contains(" ")){
        //    return s.length();
        //}

        while(s.charAt(lastIndex) != ' '){
            lastIndex--;

            if(lastIndex == -1){
                return ++counter;
            }

            counter++;
        }


        return counter;
    }
}