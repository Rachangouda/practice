package clrs.hashtables.exercise1114;

public class CompositeObject {

    private final Integer key;
    private final Integer value;
    private final Integer positionInArray;
    private CompositeObject next;
    private CompositeObject prev;

    public CompositeObject(Integer key, Integer value, Integer positionInArray) {
        this.key = key;
        this.value = value;
        this.positionInArray = positionInArray;
    }

    public CompositeObject getNext() {
        return next;
    }

    public void setNext(CompositeObject next) {
        this.next = next;
    }

    public CompositeObject getPrev() {
        return prev;
    }

    public void setPrev(CompositeObject prev) {
        this.prev = prev;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getPositionInArray() {
        return positionInArray;
    }
}
