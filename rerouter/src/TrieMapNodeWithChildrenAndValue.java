import java.util.Arrays;

public class TrieMapNodeWithChildrenAndValue<V> extends TrieMapNodeWithChildren<V> {//polymorphism(только с вальюс или только с детьми или с обоими)
    private V value;
    private TrieMapNode[] children;

    public TrieMapNodeWithChildrenAndValue(){
        value = null;
        Arrays.fill(children = new TrieMapNode[95], null);
    }

    public TrieMapNodeWithChildrenAndValue(V value){
        this.value = value;
        Arrays.fill(children = new TrieMapNode[95], null);
    }

    public TrieMapNodeWithChildrenAndValue(TrieMapNodeWithChildren<V> oldnode, V v){
        this.children = oldnode.getChildren();
        this.value = v;
    }

    @Override
    public V getValue() {
        return value;
    }
    @Override
    public void setValue(V value) {
        this.value = value;
    }
    @Override
    public TrieMapNode<V> getChild(int i){
        return children[i];
    }
    @Override
    public void setChild(int i, TrieMapNode node) {
        children[i] = node;
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public boolean hasChildren(){
        return true;
    }

    @Override
    public TrieMapNode<V> withValue(V value) {
        this.setValue(value);
        return this;
    }

    @Override
    public TrieMapNode<V> withChildren(){
        return this;
    }
}

