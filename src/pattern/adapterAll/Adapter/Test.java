package pattern.adapterAll.Adapter;

public class Test {
    public static void main(String[] args) {
        Turkey turkey=new WildTurkey();
        Duck duck=new MallardDuck();
        Duck duckAdapter=new TurkeyAdapter(turkey);
        System.out.println("--------------duck-----------");
        duck.fly();
        duck.quack();
        System.out.println("--------------TurkeyAdapter-----------");
        duckAdapter.fly();
        duckAdapter.quack();
    }


}
