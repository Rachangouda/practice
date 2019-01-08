package clrs.hashtables.exercise1114;

import java.util.LinkedList;

public class HugeArrayDict {

    Integer arraySize;

    Object[] array;
    LinkedList<CompositeObject> list;

    public HugeArrayDict(int i) {
        this.arraySize = i;
        array = new Object[i];
        list = new LinkedList<CompositeObject>();
    }


    public void search(Integer key) {

        if (list.size() == 0)
            return;


        if (array[key] == null) {
            return;
        }
        LookupObject lkp = (LookupObject) array[key];
        if (lkp.getLink() != null && lkp.getLink().getPositionInArray() == key) {
            System.out.println("Item found.");
        } else System.out.println("Item not found");
    }

    public void insert(Integer key, Integer value) {

        CompositeObject cmp = new CompositeObject(key, value, key);

        LookupObject lkp = new LookupObject();

        LookupObject lkpt;
        if (array[key] != null) {
            lkpt = (LookupObject) array[key];
            cmp.setNext(lkpt.getLink());
            lkpt.getLink().setPrev(cmp);
            lkp = lkpt;
        }
        lkp.setLink(cmp);
        array[key] = lkp;
        list.add(cmp);

        System.out.println("Item inserted.");
    }

    public void delete(Integer key) {

        if (list.size() == 0) {
            System.out.println("Empty dict..unable to delete");
            return;
        }

        if (array[key] == null) {
            return;
        }

        LookupObject lkp = (LookupObject) array[key];

        list.removeLastOccurrence(lkp.getLink());
        System.out.println("Removed item");

    }


}
