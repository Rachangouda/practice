package problemsolving;

/*
 * memberid1
 * memberid2
 * memberid3
 * ... memberidn
 * direct connections
 * fallowing_memberid fallower
 * ...fallowing_memberid fallower
 *
 * membertostart
 * membertoreach
 *
 * */

/*
 * 4
 * 5
 * 7
 * 8
 * 3
 * 4 7
 * 5 8
 * 8 7
 * 5
 * 7
 * */

import java.util.*;

public class HaskelReachabilityCheck {

    public static void main(String[] args) {

        List<Integer> memberids = new ArrayList<>();
        memberids.add(4);
        memberids.add(5);
        memberids.add(7);
        memberids.add(8);

        int numberofConnections = 3;

        List<Link> links = new ArrayList<>();

        links.add(new Link(4, 7));
        links.add(new Link(5, 8));
        links.add(new Link(8, 7));

        int startMemberid = 5;
        int endreachablitycheckmember = 7;


        Map<Integer, Node> graph = new HashMap<>();


        for (Link link : links
        ) {
            if (graph.containsKey(link.from)) {
                Node tempreachablenode = graph.get(link.from);
                tempreachablenode.outgoingedges.add(link.to);
            } else {
                Node node = new Node();
                node.outgoingedges.add(link.to);
                graph.put(link.from, node);
            }


        }


    }

    private static class Node {
        public int name;
        Set<Integer> outgoingedges;
        Set<Integer> incomingedges;

        public Node() {
            outgoingedges = new HashSet<>();
            incomingedges = new HashSet<>();
        }
    }

    private static class Link {
        int from;
        int to;

        public Link(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
