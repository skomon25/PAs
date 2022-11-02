public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    public E[] toArray() {
        // TODO Auto-generated method stub
        return elements;
    }
    public void transformAll(MyTransformer mt) {
        // TODO Auto-generated method stub
        ArrayGL<E> agl = new ArrayGL<>(this.elements);
        agl.transformAll(mt);
    }
    public void chooseAll(MyChooser mc) {
        // TODO Auto-generated method stub
        ArrayGL<E> agl = new ArrayGL<>(this.elements);
        agl.chooseAll(mc);
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

    // Fill in all required methods here
}