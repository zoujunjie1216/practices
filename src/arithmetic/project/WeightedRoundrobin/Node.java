package arithmetic.project.WeightedRoundrobin;

public class Node implements Comparable<Node> {
    final Invoker invoker;
    //固定后端权重
    final Integer weight;
    //后端有效权重（实际轮询过程中使用的权重，如果在实请求过程中遇见异常将该值降低，
    // 后续正常再将该值加回）
    Integer effectiveWeight;
    //（当前权重）轮询带动该值改变
    Integer currentWeight;

    public Node(Invoker invoker, Integer weight) {
        this.invoker = invoker;
        this.weight = weight;
        this.effectiveWeight=weight;
        this.currentWeight=0;
    }

    @Override
    public int compareTo(Node o) {
        return currentWeight>o.currentWeight?1:(currentWeight.equals(o.currentWeight) ? 0 : -1);
    }

    //调用成功后，effectiveWeight小于weight 则权重值加1
    public void onInvokeSuccess(){
        if (effectiveWeight < this.weight)
            effectiveWeight++;
    }

    //调用失败后，effectiveWeight-1
    public void onInvokeFail(){
        effectiveWeight--;
    }

}
