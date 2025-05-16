class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """

        num_stack = []
        index = 0
        num = 0
        operation = '+'

        while index < len(s):
            if s[index].isdigit():
                num *= 10
                num += int(s[index])

            if (not s[index].isdigit() and s[index] != ' ') or index == len(s) - 1:
                # Add the previous digit
                if operation == '+':
                    num_stack.append(num)
                elif operation == '-':
                    num_stack.append(-num)
                elif operation == '*':
                    num_stack.append(num_stack.pop() * num)
                elif operation == '/':
                    num_stack.append(int(num_stack.pop() / float(num)))
                
                num = 0
                operation = s[index]

            index += 1
        
        return sum(num_stack)
