package designpatterns.visitor;

public interface Router {


    public void sendData();

    public char[] receiveData();

    public void accept(RouteVisitor v);
}
