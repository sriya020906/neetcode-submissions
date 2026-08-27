class LinkedList {
    class node {
        int val;
        node next;

        public node(int val){
            this.val = val;
            this.next = null;
        }
    }

    private node head;
    private node tail;

    public LinkedList() {
        this.head = new node(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        node curr = head.next;
        int i = 0;
        while (curr != null){
            if (i==index) {
                return curr.val;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        node newnode = new node(val);
        newnode.next = head.next;
        head.next = newnode;

        if (newnode.next == null) {
            tail = newnode;
        }
    }

    public void insertTail(int val) {
        tail.next = new node(val);
        tail = tail.next;
    }

    public boolean remove(int index) {
        node curr = head;
        int i = 0;
        while (i<index && curr != null){
            curr = curr.next;
            i++;
        }
        if (curr != null && curr.next != null){
            if (curr.next == tail) {
                tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        node curr = head.next;
        while(curr != null){
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}
