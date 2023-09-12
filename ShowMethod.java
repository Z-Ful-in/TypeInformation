//Args: ShowMethod
import java.lang.reflect.*;
import java.util.regex.*;
public class ShowMethod {
    private static String usage=
            "usage:\n"+
        "ShowMethod qualified.class.name\n"+
        "To show all methods in class or:\n"+
        "ShowMethod qualified.class.name word\n"+
        "To search for methods involving 'word'";
    private static Pattern p=Pattern.compile("\\w+\\.");
    public static void main(String[] args){
        if(args.length<1){
            System.out.println(usage);
            System.exit(0);
        }
        int lines=0;
        try{
            Class<?>c =Class.forName(args[0]);
            Method[]methods=c.getMethods();
            Constructor[] ctors=c.getConstructors();
            if(args.length==1){
                for(Method method:methods)
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                for(Constructor constructor:ctors)
                    System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                lines=methods.length+ctors.length;
            }else{
                for(Method method:methods)
                    if(method.toString().contains(args[1])){
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                for(Constructor constructor:ctors)
                    if(constructor.toString().contains(args[1])){
                        System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        }catch (ClassNotFoundException e){
            System.out.println("No such class: "+e);
        }
    }
}
