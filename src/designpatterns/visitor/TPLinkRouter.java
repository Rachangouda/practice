package designpatterns.visitor;

public class TPLinkRouter implements Router{


    @Override
    public void sendData() {
        System.out.println("TP link sending data");
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
