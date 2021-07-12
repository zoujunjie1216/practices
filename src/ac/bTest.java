package ac;

public  class bTest implements aTest {
    private int a=3;

    public bTest() {
        System.out.println("b类实例化创建");
    }

    public int geta(){
        return this.a;
    }
    public void seta(int x){
         this.a=x;
    }
    public void print(){
        System.out.println("b继承后的print");
        int a=10;
        String b="nihao";
        switch (b){
            case "nihao":
                System.out.println("woshinidaye");
            default:
                System.out.println("打扰l");

        }
    }
}
