public class TrieMapNodeWithValue<V> extends TrieMapNode<V> {
    private V value;

    public TrieMapNodeWithValue(V value){
        this.value = value;
    }

    @Override
    public V getValue(){
        return value;
    }

    @Override
    public void setValue(Object value){
        this.value = (V)value;
    }

    @Override
    public TrieMapNode<V> withValue(V value) {
        return new TrieMapNodeWithChildrenAndValue<>(value);
    }

    @Override
    public TrieMapNode<V> withChildren() {
        return new TrieMapNodeWithChildrenAndValue<>(this.value);
    }

    public boolean hasValue(){
        return true;
    }
}
