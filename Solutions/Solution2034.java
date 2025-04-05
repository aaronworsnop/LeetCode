class StockPrice {
    TreeMap<Integer, Integer> priceFrequencyMap;
    TreeMap<Integer, Integer> timePriceMap;
    int latestTimestamp;

    public StockPrice() {
        this.priceFrequencyMap = new TreeMap<>();
        this.timePriceMap = new TreeMap<>();
        this.latestTimestamp = Integer.MIN_VALUE;
    }
    
    public void update(int timestamp, int price) {
        latestTimestamp = Math.max(latestTimestamp, timestamp);

        // Update old price if it exists
        if (timePriceMap.containsKey(timestamp)) {
            int oldPrice = timePriceMap.get(timestamp);

            priceFrequencyMap.put(oldPrice, priceFrequencyMap.get(oldPrice) - 1);
            if (priceFrequencyMap.get(oldPrice) == 0) {
                priceFrequencyMap.remove(oldPrice);
            }
        }

        timePriceMap.put(timestamp, price);
        priceFrequencyMap.put(price, priceFrequencyMap.getOrDefault(price, 0) + 1);
    }
    
    public int current() {
        return timePriceMap.get(latestTimestamp);
    }
    
    public int maximum() {
        return priceFrequencyMap.lastKey();
    }
    
    public int minimum() {
        return priceFrequencyMap.firstKey();
    }
}
