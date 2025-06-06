class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;
    int count;

    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.add(x);
        top = x;
        count++;
    }
    
    public int pop() {

        while(q1.size() > 1){
            int temp = q1.poll();
            q2.add(temp);
        }

        int ans = q1.poll();

        while(!q2.isEmpty()){
            int temp = q2.poll();
            q1.add(temp);
        }
        count--;

        return ans;
    }
    
    public int top() {
        while(q1.size() > 1){
            int temp = q1.poll();
            q2.add(temp);
        }

        top = q1.peek();
        q2.add(top);

        while(!q2.isEmpty()){
            int temp = q2.poll();
            q1.add(temp);
        }
        return top;
    }
    
    public boolean empty() {
        return (count > 0) ? false : true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */