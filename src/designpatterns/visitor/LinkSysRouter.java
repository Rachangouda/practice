package designpatterns.visitor;

public class LinkSysRouter implements Router {
    @Override
    public void sendData() {
        System.out.println("link sys sending data");
    }

    @Override
    public char[] receiveData() {
        System.out.println("link sys receiving data");
        return new char[0];
    }

    @Override
    public void accept(RouteVisitor v) {
        v.visit(this);
    }
}
