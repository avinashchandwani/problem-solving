
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DoublyNode> cacheMap = null;
    private int capacity;
    private DoublyNode<Integer, Integer> head, tail;

    public LRUCache() {
        init(Integer.MAX_VALUE);
    }

    public LRUCache(int capacity) {
        init(capacity);
    }

    private void init(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new DoublyNode();
        this.tail = new DoublyNode();
        this.head.setNextNode(this.tail);
        this.tail.setPreviousNode(this.head);
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) { //update scenario
            DoublyNode valueNode = cacheMap.get(key);
            valueNode.setValue(value);
            moveNodeToFront(valueNode);
        } else {// new key scenario
            DoublyNode valueNode = new DoublyNode(key, value);
            cacheMap.put(key, valueNode);
            addNodeToFront(valueNode);
            if (cacheMap.size() > this.capacity) {
                int removalKey = removeLRUNode();
                cacheMap.remove(removalKey);
            }
        }
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        DoublyNode valueNode = cacheMap.get(key);
        moveNodeToFront(valueNode);
        return (int) valueNode.getValue();
    }

    private void addNodeToFront(DoublyNode node) {
        node.setNextNode(head.getNextNode());
        head.getNextNode().setPreviousNode(node);
        head.setNextNode(node);
        node.setPreviousNode(head);
    }

    private int removeLRUNode() {
        DoublyNode lruNode = this.tail.getPreviousNode();
        removeNode(lruNode);
        return (int) lruNode.getKey();
    }

    private void removeNode(DoublyNode node) {
        node.getNextNode().setPreviousNode(node.getPreviousNode());
        node.getPreviousNode().setNextNode(node.getNextNode());
    }

    private void moveNodeToFront(DoublyNode node) {
        removeNode(node);
        addNodeToFront(node);
    }
}

class DoublyNode<K, V> {
    private K key;
    private V value;
    private DoublyNode previousNode;
    private DoublyNode nextNode;

    public DoublyNode() {
    }

    public DoublyNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public DoublyNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyNode previousNode) {
        this.previousNode = previousNode;
    }

    public DoublyNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyNode nextNode) {
        this.nextNode = nextNode;
    }
}
