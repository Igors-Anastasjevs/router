import java.util.Arrays;

public class TrieMapNodeWithChildren<V> extends TrieMapNode<V> {
    private TrieMapNode<V>[] children;
    public TrieMapNodeWithChildren(){
        Arrays.fill(children = new TrieMapNode[95], null);
    }

    @Override
    public TrieMapNode<V> getChild(int i){
        return children[i];
    }

    protected TrieMapNode<V>[] getChildren(){
        return children;
    }

    @Override
    public void setChild(int i, TrieMapNode node) {
        children[i] = node;
    }

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public boolean hasChildren(){
        return true;
    }

    @Override
    public TrieMapNode<V> withValue(V value){
        return new TrieMapNodeWithChildrenAndValue<V>(this, value);
    }

    @Override
    public TrieMapNode<V> withChildren(){
        return this;
    }
}
