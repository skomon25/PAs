public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        // Fill in this constructor
        this.front = new Node(null, null);
        Node x = this.front;
        for(E con : contents){
            x.next = new Node(con , null);
            x = x.next;
        }
        this.size = contents.length;
    }
    
    public E[] toArray() {
        // TODO Auto-generated method stub
        Node x = this.front;
        x = x.next;
        E[] list = (E[]) new Object(this.size);
        for(int i = 0; i < this.size; i++){
            
        }
    }
    public void transformAll(MyTransformer mt) {
        // TODO Auto-generated method stub
        LinkedGL<E> lgl = new LinkedGL<>(toArray());
        lgl.transformAll(mt);
    }
    public void chooseAll(MyChooser mc) {
        // TODO Auto-generated method stub
        LinkedGL<E> lgl = new LinkedGL<>(toArray());
        lgl.chooseAll(mc);
    }
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if(toArray().length == 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Fill in all methods

}