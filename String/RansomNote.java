package String;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem Statement <a href="https://leetcode.com/problems/ransom-note/">here</href>
 * Time Complexity - O(m+n)
 * Space Complexity - O(1)
 * */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> magzineCharMap = new HashMap<>();

        char[] magzineChars = magazine.toCharArray();
        for (char magzineChar : magzineChars) {
            magzineCharMap.computeIfPresent(magzineChar, (k,v) -> v+1);
            magzineCharMap.putIfAbsent(magzineChar, 1);
        }

        char[] ransomeChars = ransomNote.toCharArray();
        for (char ransomeChar : ransomeChars) {
            if(magzineCharMap.containsKey(ransomeChar)){
                int charCount = magzineCharMap.get(ransomeChar);
                if(charCount < 2) magzineCharMap.remove(ransomeChar);
                else magzineCharMap.put(ransomeChar, magzineCharMap.get(ransomeChar)-1);
            }
            else return false;
        }

        return true;
    }
}
