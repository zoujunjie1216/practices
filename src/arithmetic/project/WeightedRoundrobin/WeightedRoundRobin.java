package arithmetic.project.WeightedRoundrobin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 加权轮询算法-平滑
 * 在过程中单个节点故障会被剔除然后重新开始计算
 *
 * 1.每次用节点的currentweight + effectiveWeight 变为currentweight
 * 2.选取最大权重的节点值
 * 3.被选节点currentweight-sum（effectiveWeight）
 * */
public class WeightedRoundRobin {
    //约定的invoker和权重的键值对
    final private List<Node> nodes;

    public WeightedRoundRobin(Map<Invoker, Integer> invokersWeight) {
        if (invokersWeight != null && !invokersWeight.isEmpty()) {
            nodes = new ArrayList<>(invokersWeight.size());
            invokersWeight.forEach((invoker, weight) -> nodes.add(new Node(invoker, weight)));
        } else
            nodes = null;
    }

    //加权选择
    public Invoker select(){
        if (! checkNodes())
            return null;
        else if (nodes.size() == 1) {
            if (nodes.get(0).invoker.isAvalable())
                return nodes.get(0).invoker;
            else
                return null;
        }
        Integer total = 0;
        Node nodeOfMaxWeight = null;
        for (Node node : nodes) {
            total += node.effectiveWeight;
            node.currentWeight += node.effectiveWeight;

            if (nodeOfMaxWeight == null) {
                nodeOfMaxWeight = node;
            }else{
                nodeOfMaxWeight = nodeOfMaxWeight.compareTo(node) > 0 ? nodeOfMaxWeight : node;
            }
        }

        nodeOfMaxWeight.currentWeight -= total;
        return nodeOfMaxWeight.invoker;
    }

    //有可选择节点
    private boolean checkNodes(){
        return (nodes != null && nodes.size() > 0);
    }

    public void onInvokeSuccess(Invoker invoker){
        if (checkNodes()){
            nodes.stream()
                    .filter((Node node)->invoker.id().equals(node.invoker.id()))
                    .findFirst()
                    .get()
                    .onInvokeSuccess();
        }
    }

    public void printCurrenctWeightBeforeSelect(){
        if (checkNodes()) {
            final StringBuffer out = new StringBuffer("{");
            nodes.forEach(node->out.append(node.invoker.id())
                    .append("=")
                    .append(node.currentWeight+node.effectiveWeight)
                    .append(","));
            out.append("}");
            System.out.print(out);
        }
    }

    public void printCurrenctWeight(){
        if (checkNodes()) {
            final StringBuffer out = new StringBuffer("{");
            nodes.forEach(node->out.append(node.invoker.id())
                    .append("=")
                    .append(node.currentWeight)
                    .append(","));
            out.append("}");
            System.out.print(out);
        }
    }

    public static void main(String[] args){
        Map<Invoker, Integer> invokersWeight = new HashMap<>(3);
        Integer aWeight = 4;
        Integer bWeight = 2;
        Integer cWeight = 1;

        invokersWeight.put(new Invoker() {
            @Override
            public Boolean isAvalable() {
                return true;
            }
            @Override
            public String id() {
                return "a";
            }
        }, aWeight);

        invokersWeight.put(new Invoker() {
            @Override
            public Boolean isAvalable() {
                return true;
            }
            @Override
            public String id() {
                return "b";
            }
        }, bWeight);

        invokersWeight.put(new Invoker() {
            @Override
            public Boolean isAvalable() {
                return true;
            }
            @Override
            public String id() {
                return "c";
            }
        }, cWeight);

        Integer times = 7;
        WeightedRoundRobin roundRobin = new WeightedRoundRobin(invokersWeight);
        for(int i=1; i<=times; i++){
            System.out.print(new StringBuffer(i+"").append("    "));
            roundRobin.printCurrenctWeightBeforeSelect();
            Invoker invoker = roundRobin.select();
            System.out.print(new StringBuffer("    ").append(invoker.id()).append("    "));
            roundRobin.printCurrenctWeight();
            System.out.println();
        }
    }
}
