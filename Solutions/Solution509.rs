impl Solution {
    pub fn fib(n: i32) -> i32 {
        if n < 1 {
            return 0;
        } else if n == 1 {
            return 1;
        }

        let mut tail = 0;
        let mut head = 1;
        let mut sum = 0;

        for _ in 2..=n {
            sum = tail + head;
            tail = head;
            head = sum;
        }

        sum
    }
}
