package GeneralTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DistinctByKey {

    private static String[] nodes;
    static int i=0;
    public static void main(String[] args) {

        List<NodeInfo> nodesInfoResponse = new ArrayList<NodeInfo>();
        nodesInfoResponse.add(new NodeInfo("A"));
        nodesInfoResponse.add(new NodeInfo("A"));
        nodesInfoResponse.add(new NodeInfo("B"));
        List<NodeInfo> nodeInfoList  = nodesInfoResponse.stream()
                .filter(distinctNodesByHostNameKey(nodeInfo -> nodeInfo.getName()))
                .collect(Collectors.toList());

        nodes = new String[nodeInfoList.size()];
        nodeInfoList.stream().forEach(nodeInfo -> {accept(nodeInfo);});

        System.out.println("node strings:" + Arrays.asList(nodes).toString());

    }


    public static <T> Predicate<T> distinctNodesByHostNameKey(
            Function<? super T, ?> nodeNameExtractFun) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return nodeInfo -> seen.putIfAbsent(nodeNameExtractFun.apply(nodeInfo), Boolean.TRUE) == null;
    }

    private static void accept(NodeInfo nodeInfo) {
        nodes[i++] = nodeInfo.name;
    }

    private static class NodeInfo {

        public NodeInfo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }
}
