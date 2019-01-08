package clrs.hashtables.Exercise1113;

public class DataHolder {
    private Integer key;
    private Integer noOfRepetitions;

    public DataHolder(Integer key, Integer noOfRepetitions) {
        this.key = key;
        this.noOfRepetitions = noOfRepetitions;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getNoOfRepetitions() {
        return noOfRepetitions;
    }

    public void setNoOfRepetitions(Integer noOfRepetitions) {
        this.noOfRepetitions = noOfRepetitions;
    }

    public void intcrementNoOfRepetiotionsByOne() {
        noOfRepetitions++;
    }

    public void decrementNoOfRepetitionsByOne() {
        noOfRepetitions--;
    }
}
