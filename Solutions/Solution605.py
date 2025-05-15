class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """

        # We can be greedy
        new_flowers = 0
        can_place = True
        for i in range(len(flowerbed)):

            if flowerbed[i] == 1:
                can_place = False
            else:
                # Empty spot
                if not can_place:
                    # Prepare for the next spot to be placed
                    can_place = True
                else:
                    # Place here (if possible)
                    if i == len(flowerbed) - 1 or flowerbed[i + 1] == 0:
                        new_flowers += 1
                        can_place = False
                    else:
                        can_place = False

        return new_flowers >= n