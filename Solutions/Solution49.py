class Solution49(object):
    def groupAnagrams(self, strs):
        anagrams = defaultdict(list)
        for word in strs:
            count = [0] * 26
            for character in word:
                print(character)
                count[ord(character) - ord("a")] += 1
            anagrams[tuple(count)].append(word)
        return anagrams.values()