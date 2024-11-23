class Solution
{
public:
    string longestCommonPrefix(vector<string> &strs)
    {
        int longestPrefix = 0;

        // Find the shortest word
        int shortestLength = INT_MAX;
        for (auto iterator = strs.begin(); iterator != strs.end(); ++iterator)
        {
            if ((*iterator).length() < shortestLength)
            {
                shortestLength = (*iterator).length();
            }
        }

        for (int position = 0; position < shortestLength; ++position)
        {
            char positionCharacter = strs[0][position];
            bool allSame = true;

            auto iterator = strs.begin();
            ++iterator;

            for (; iterator != strs.end(); ++iterator)
            {
                if ((*iterator)[position] != positionCharacter)
                {
                    allSame = false;
                    break;
                }
            }

            if (!allSame == true)
            {
                break;
            }

            ++longestPrefix;
        }

        return strs[0].substr(0, longestPrefix);
    }
};