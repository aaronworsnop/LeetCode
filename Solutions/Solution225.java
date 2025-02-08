class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private boolean mainQueueIs1;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        mainQueueIs1 = true;
    }
    
    public void push(int x) {
        if (mainQueueIs1) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }
    
    public int pop() {
        int val;

        if (mainQueueIs1) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }

            val = queue1.poll();
            mainQueueIs1 = false;
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }

            val = queue2.poll();
            mainQueueIs1 = true;
        }

        return val;
    }
    
    public int top() {
        int val;

        if (mainQueueIs1) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }

            val = queue1.peek();
            queue2.offer(queue1.poll());
            mainQueueIs1 = false;
        } else {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }

            val = queue2.peek();
            queue1.offer(queue2.poll());
            mainQueueIs1 = true;
        }

        return val;
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
