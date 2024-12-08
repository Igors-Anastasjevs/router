public  class TrieMapNode<V> {

    public TrieMapNode(){}

    public V getValue(){
        return null;
    }

    public TrieMapNode<V> getChild(int i) {
        return emptyNode();
    }

    public TrieMapNode<V> getChild(CharSequence key, int pos){
        return getChild(childIndex(key, pos));
    }

    public void setValue(V value){
        throw new UnsupportedOperationException();
    }

    public void setChild(int i, TrieMapNode<V> node){
        throw new UnsupportedOperationException();
    }

    public void setChild(CharSequence key, int pos, TrieMapNode<V> node){
        setChild(childIndex(key, pos), node);
    }

    public boolean hasValue(){
        return false;
    }

    public boolean hasChildren(){
        return false;
    }

    private int childIndex(CharSequence key, int pos) {
        return key.charAt(pos) - ' ';
    }

    public TrieMapNode<V> withValue(V value){
        return new TrieMapNodeWithValue<V>(value);
    }

    public TrieMapNode<V> withChildren(){
        return new TrieMapNodeWithChildren<>();
    }

    public boolean isEmpty(){
        return this == EMPTY_NODE;
    }

    private final static TrieMapNode<?> EMPTY_NODE=new TrieMapNode<>();

    public static <V1> TrieMapNode<V1> emptyNode(){
        return (TrieMapNode<V1>) EMPTY_NODE;
    }
}
