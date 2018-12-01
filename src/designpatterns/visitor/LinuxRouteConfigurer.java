package designpatterns.visitor;

public class LinuxRouteConfigurer implements RouteVisitor{
    @Override
    public void visit(TPLinkRouter r) {
        System.out.println("TP link configured for linux");
    }

    @Override
    public void visit(LinkSysRouter r) {

        System.out.println("link sys configured for Linux");

    }

    @Override
    public void visit(DslLinkRouter r) {
        System.out.println("dsllink configured for Linux");
    }
}
