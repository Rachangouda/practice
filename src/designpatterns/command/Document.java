package designpatterns.command;

public interface Document {

    public void open();
    public void close();
    public void delete();
    public void save();
}
