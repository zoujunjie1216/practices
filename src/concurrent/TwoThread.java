package concurrent;

public class TwoThread {

    public static void main(String[] args) {

        Student aa=new Student();

        //两条线程创建同一个对象发生了什么
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {

                aa.setId(1);
                aa.setName("zoujj");
                int i=0;
                while (i++<100){
                    System.out.println(aa.getId()+"_a"+i);
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread b=new Thread(()-> {
            aa.setId(2);
            aa.setName("zoujj2");
            int i=0;
            while (i++<100){
                System.out.println(aa.getId()+"_b"+i);
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        a.start();
        b.start();
    }

}
