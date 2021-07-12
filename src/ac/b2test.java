package ac;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class b2test extends bTest {
    public void print1(){
        int a=super.geta();
        System.out.println(a);
        Hashtable hashtable=new Hashtable();
        Iterator iterator=hashtable.values().iterator();
        Map<String,String> b=new HashMap<String, String>();

    }
}
