class Logger(object):

    def __init__(self):
        self.message_dict = {}

    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message not in self.message_dict or self.message_dict.get(message) < timestamp - 9:
            self.message_dict[message] = timestamp
            return True
        else:
            return False
        