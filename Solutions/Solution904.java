class Solution {
    public int totalFruit(int[] fruits) {        
        if (fruits.length < 2) {
            return fruits.length;
        }
        
        int max = 2;
        
        int[] types = new int[]{-1, -1};
        
        if (fruits[0] == fruits[1]) {
            types = new int[]{fruits[0], fruits[0]};
        } else {
            types = new int[]{fruits[0], fruits[1]};
        }
        
        int left = 0;
        for (int right = 2; right < fruits.length; right++) {
            if (!basketMatch(types, fruits[right])) {
                left = right - 1;
                
                while (left > 0 && fruits[left - 1] == fruits[right - 1]) {
                    left--;
                }
                
                types = updateBasket(fruits[left], fruits[right]);
            } 
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
    
    private boolean basketMatch(int[] types, int fruit) {
        return types[0] == fruit || types[1] == fruit;
    }
                
    private int[] updateBasket(int type1, int type2) {
        return new int[]{type1, type2};
    }
}