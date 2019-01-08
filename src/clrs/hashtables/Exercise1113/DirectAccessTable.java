package clrs.hashtables.Exercise1113;

import java.util.ArrayList;

public class DirectAccessTable implements Operations {

    Integer initTableSize;
    ArrayList<DataHolder> directAccessTable;

    public DirectAccessTable() {
        this(5);
    }

    public DirectAccessTable(int initTableSize) {
        this.initTableSize = initTableSize;
        this.directAccessTable = new ArrayList<DataHolder>(initTableSize);

        for (int i = 0; i < initTableSize; i++) {
            directAccessTable.add(new DataHolder(Integer.MIN_VALUE, Integer.MIN_VALUE));
        }
    }


    @Override
    public void insert(Integer insertValue) {

        if (isInsertItemInTableRange(insertValue)) {
            DataHolder dh = search(insertValue);
            if (isValidItem(dh)) {
                dh.intcrementNoOfRepetiotionsByOne();
            } else {
                DataHolder dho = new DataHolder(insertValue, 1);
                directAccessTable.add(insertValue, dho);
            }
        } else System.out.println("Inserting item is out of Direct access Table Range:0 to " + initTableSize);
    }

    private boolean isValidItem(DataHolder dh) {
        if (dh.getKey() == Integer.MIN_VALUE && dh.getNoOfRepetitions() == Integer.MIN_VALUE)
            return false;
        return true;
    }

    private boolean isInsertItemInTableRange(Integer insertValue) {
        if (insertValue >= 0 && this.initTableSize >= insertValue)
            return true;
        return false;
    }

    @Override
    public void delete(Integer DeleteKey) {

    }

    @Override
    public DataHolder search(Integer SearchKey) {
        return getDHforkey(SearchKey);
    }

    private DataHolder getDHforkey(Integer searchKey) {

        return this.directAccessTable.get(searchKey);
    }
}
