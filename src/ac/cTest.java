package ac;

public class cTest extends bTest  {
    public cTest() {
        System.out.println("c类创建");
    }

    @Override
    public int geta() {
        return super.geta();
    }

    @Override
    public void print() {
        super.seta(10);
    }
}
