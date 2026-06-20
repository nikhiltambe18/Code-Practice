class Node {
    int data;
    Node next;

Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    
    void addBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    
    void addEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void addAtIndex(int data, int index) {
        if (index == 0) {
            addBegin(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteBegin() {
        if (head != null) {
            head = head.next;
        }
    }

    void deleteEnd() {
        if (head == null)
            return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    void deleteAtIndex(int index) {
        if (head == null)
            return;

        if (index == 0) {
            deleteBegin();
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addBegin(20);
        list.addBegin(10);
        list.addEnd(30);
        list.addAtIndex(25, 2);

        System.out.println("After Insertions:");
        list.display();

        list.deleteBegin();
        System.out.println("After Delete Begin:");
        list.display();

        list.deleteEnd();
        System.out.println("After Delete End:");
        list.display();

        list.deleteAtIndex(1);
        System.out.println("After Delete Index 1:");
        list.display();
    }
}