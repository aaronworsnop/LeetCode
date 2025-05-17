class Solution {
    public int maxEvents(int[][] events) {
        // Sort by the start date
        Arrays.sort(events, (eventA, eventB) -> eventA[0] - eventB[0]);
        
        // Find all the last day of an event
        
        int lastDay = 1;
        for (int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }
        
        int maxAttendance = 0;
        int eventIndex = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Iterate through all event days
        for (int day = 1; day <= lastDay; day++) {
            // Choose the event that ends the earliest
            
            // First, add all events that are now available to us on this day
            while(eventIndex < events.length && events[eventIndex][0] == day) {
                pq.offer(events[eventIndex][1]);
                eventIndex++;
            }
            
            // Secondly, remove all events that have finished
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            
            // Finally, choose the event that ends the earliest
            if (!pq.isEmpty()) {
                pq.poll();
                maxAttendance++;
            }
        }
        
        return maxAttendance;
    }
}
