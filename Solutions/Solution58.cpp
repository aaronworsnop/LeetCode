class Solution {
public:
    int lengthOfLastWord(string s) {
        int lengthOfLast = 0;

        int endIndex = s.size() - 1;
        while (s[endIndex] == ' ')
        {
            endIndex--;
        }

        while (endIndex >= 0 && s[endIndex] != ' ')
        {
            lengthOfLast++;
            endIndex--;
        }

        return lengthOfLast;
    }
};
