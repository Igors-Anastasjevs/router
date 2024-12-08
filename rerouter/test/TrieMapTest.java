import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieMapTest {

    @Test
    void trieMapTest() {
        TrieMap<String, String> trieMap = new TrieMap<>();
        trieMap.put("Hello", "World");
        trieMap.put("Saas", "Sees");
        assertEquals("World", trieMap.get("Hello"));
        assertEquals("Sees", trieMap.get("Saas"));
        assertEquals(null, trieMap.get("Rees"));
        assertEquals(null, trieMap.getWithPrefix("Saa3"));
    }
}