class Solution8(object):
    def myAtoi(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()  # Remove leading and trailing whitespaces
        
        if not s:
            return 0  # If the string is empty, return 0
        
        sign = 1
        i = 0
        
        if s[i] == "-":
            sign = -1
            i += 1
        elif s[i] == "+":
            i += 1
        
        result = 0
        
        while i < len(s) and s[i].isdigit():
            digit = int(s[i])
            if result > (2**31 - 1 - digit) // 10:
                return 2**31 - 1 if sign == 1 else -2**31
            result = (result * 10) + digit
            i += 1
        
        return result * sign