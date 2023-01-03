package String;

public class Permutations {

    static void perm(StringBuilder str, StringBuilder str2, int orginalLength){
        if (str2.length() == orginalLength){
            System.out.println(str2);
            return;
        }
        int i=0;
        StringBuilder temp;
        StringBuilder temp2;
        while(i<str.length()){
            temp2 = new StringBuilder(str2);
            temp2.append(str.charAt(i));

            temp = new StringBuilder(str);
            temp.deleteCharAt(i);

            perm(temp, temp2, orginalLength);
            i++;
        }
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abcd");
        perm(str, new StringBuilder(), str.length());
    }
}
