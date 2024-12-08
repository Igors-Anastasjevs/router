public abstract class TrieMapNode<V> {
    public TrieMapNode(){}

    public V getValue(){
        return null;
    }

    public TrieMapNode<V> getChild(int i) {
        return null;
    }

    public TrieMapNode<V> getChild(CharSequence key, int pos){
        return getChild(childIndex(key, pos));
    }

    public void setValue(V value){}

    public void setChild(int i, TrieMapNode<V> node){}

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

    public TrieMapNode<V> withChildrenAndValue(V value){
        return new TrieMapNodeWithChildrenAndValue<>(value);
    }
}
