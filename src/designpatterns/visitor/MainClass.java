package designpatterns.visitor;

public class MainClass {



    public static void main(String[] args) {
        LinuxRouteConfigurer linuxConf = new LinuxRouteConfigurer();

        LinkSysRouter linksys = new LinkSysRouter();

        linksys.accept(linuxConf);

        DslLinkRouter dslLinkRouter = new DslLinkRouter();

        dslLinkRouter.accept(linuxConf);
    }


}
