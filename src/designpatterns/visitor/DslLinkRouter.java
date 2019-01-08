package designpatterns.visitor;

public class DslLinkRouter implements Router {


    @Override
    public void sendData() {
        System.out.println("Dsllink sending data");
    }

    @Override
    public char[] receiveData() {
        System.out.println("TP link receiving data");
        return new char[0];
    }

    @Override
    public void accept(RouteVisitor v) {
        v.visit(this);
    }
}
