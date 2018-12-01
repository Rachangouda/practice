package clrs.hashtables.Exercise1113;


/*Suggest how to implement a direct-address table in which the keys of stored elements
do not need to be distinct and the elements can have satellite data. All
three dictionary operations (INSERT, DELETE, and SEARCH) should run in O.1/
time. (Don’t forget that DELETE takes as an argument a pointer to an object to be
deleted, not a key.)*/

public class MainClass {

    Integer [] keySet = new Integer[]{1,2,3,3,4};






    public static void main(String[] args) {
        DirectAccessTable dat = new DirectAccessTable(55);
        dat.insert(1);
        dat.insert(2);
        dat.insert(3);
        dat.insert(3);
        dat.insert(55);


    }


}
