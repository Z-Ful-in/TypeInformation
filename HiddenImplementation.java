import interfacea.*;
import packageaccess.*;
import java.lang.reflect.*;
public class HiddenImplementation {
    public static void main(String[]args) throws Exception{
        A a=HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C': because C is not public
         /*if(a instanceof C){
            C c=(C)a;
            c.g();
        } */
        // Oops! Reflection still allows us to call g():
        callHiddenMethod(a,"g");
        // And even methods that are less accessible!
        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");
    }
    static void callHiddenMethod(Object a, String methodName) throws Exception{
        Method g=a.getClass().getDeclaredMethod(methodName);
        Parameter[] args= g.getParameters();
        g.setAccessible(true);
        if (args.length==0)
            g.invoke(a);
        else
            g.invoke(a,args);
    }
}
