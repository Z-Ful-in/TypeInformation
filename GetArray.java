import java.lang.reflect.Field;
import java.util.*;
import java.lang.reflect.*;
public class GetArray {
    public static void main(String[]args) throws Exception{
        ArrayList<Integer> list=new ArrayList<Integer>();
        Field f=list.getClass().getDeclaredField("elementData");
        f.setAccessible(true);
        Object[] o=(Object[])f.get(list);
        System.out.println(o.length);
    }
}
