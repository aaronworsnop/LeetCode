class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        # BFS and count distinct
        
        # Find all the 1s
        starting_points = []
        
        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == "1":
                    starting_points.append((row, col))

        print(starting_points)
        
        distinct = 0
        seen = set()

        for coord in starting_points:
            
            if coord in seen:
                continue
                
            distinct += 1
            
            # BFS
            queue = deque()
            queue.append(coord)
            
            while queue:
                current = queue.popleft()
                
                if (current in seen or
                    current[0] < 0 or
                    current[0] >= len(grid) or
                    current[1] < 0 or
                    current[1] >= len(grid[0]) or
                    grid[current[0]][current[1]] != "1"):
                    continue
                
                seen.add(current)
                
                queue.append((current[0] + 1, current[1]))
                queue.append((current[0] - 1, current[1]))
                queue.append((current[0], current[1] + 1))
                queue.append((current[0], current[1] - 1))
        
        return distinct