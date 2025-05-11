from Solution200 import Solution

class Test:
    def setup_method(self):
        self.solution = Solution()
    
    def test_empty(self):
        islands = [[]]
        expected_num_islands = 0
        
        num_islands = self.solution.numIslands(islands)

        assert num_islands == expected_num_islands

    def test_one(self):
        islands = [["1"]]
        expected_num_islands = 1
        
        num_islands = self.solution.numIslands(islands)

        assert num_islands == expected_num_islands

    def test_small(self):
        islands = [["1", "0"], ["0", "1"]]
        expected_num_islands = 2
        
        num_islands = self.solution.numIslands(islands)

        assert num_islands == expected_num_islands

    def test_ring(self):
        islands = [["1", "1", "1", "1"], ["1", "0", "0", "1"], ["1", "0", "0", "1"], ["1", "1", "1", "1"]]
        expected_num_islands = 1
        
        num_islands = self.solution.numIslands(islands)

        assert num_islands == expected_num_islands

    def test_ring_two(self):
        islands = [["1", "1", "1", "1"], ["1", "0", "0", "1"], ["1", "0", "0", "1"], ["1", "1", "1", "1"], ["0", "0", "0", "0"], ["1", "1", "1", "1"], ["1", "0", "0", "1"], ["1", "0", "0", "1"]]
        expected_num_islands = 2
        
        num_islands = self.solution.numIslands(islands)

        assert num_islands == expected_num_islands