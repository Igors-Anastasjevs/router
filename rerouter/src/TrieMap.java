import java.util.*;

public class TrieMap <K extends CharSequence, V>{
    private TrieMapNode<V> trieMapNodeHead;
    public TrieMap(){
        trieMapNodeHead = new TrieMapNodeWithChildren<>();
    }

    private TrieMapNode<V> navigation(K k, boolean returnToPreviousIfNotFound)
    {
        TrieMapNode<V> temp = trieMapNodeHead;

        for(int i = 0; i < k.length(); i++) {
            TrieMapNode<V> child = temp.getChild(k, i);
            if ( child.isEmpty() ) {
                if (returnToPreviousIfNotFound) {
                    break;
                }
                return TrieMapNode.emptyNode();
            }
            temp = child;
        }

        return temp;
    }

    /**
     * Trie-Find(x, key)
     *     for 0 ≤ i < key.length do
     *         if x.Children[key[i]] = nil then
     *             return false
     *         end if
     *         x := x.Children[key[i]]
     *     repeat
     *     return x.Value
     * the "if" is not implemented
     */
    public V get(K k){
        return navigation(k, false).getValue();
    }


    public V getWithPrefix(K strWithPrefix){
        return navigation(strWithPrefix, true).getValue();
    }

    /**
     * Trie-Insert(x, key, value)
     * for 0 ≤ i < key.length do
     *  if x.Children[key[i]] = nil then
     *      x.Children[key[i]] := Node()
     *   end if
     *  x := x.Children[key[i]]
     * repeat
     * x.Value := value
     * x.Is-Terminal := True
     *
     * @return
     */
    public V put(K k, V v){
        TrieMapNode<V> temp = trieMapNodeHead;
        for(int i = 0; i < k.length(); i++){
            TrieMapNode<V> child = temp.getChild(k, i);

            child = i == k.length() - 1 ? child.withValue(v) : child.withChildren();
            temp.setChild(k, i, child);

            temp = child;
        }
        return v;
    }
}