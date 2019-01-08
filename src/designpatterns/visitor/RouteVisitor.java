package designpatterns.visitor;

public interface RouteVisitor {

    public void visit(TPLinkRouter r);

    public void visit(LinkSysRouter r);

    public void visit(DslLinkRouter r);
}
