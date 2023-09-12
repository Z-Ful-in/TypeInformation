package classloading;
import java.util.*;
public class ForNameCreator extends PetCreator{
    private static List<Class<? extends Pet>> types=new ArrayList<Class<? extends Pet>>();
    private static String[]typeNames={
        "classloading.Mutt",
        "classloading.Pug",
        "classloading.EgyptianMau",
        "classloading.Manx",
        "classloading.Cymric",
        "classloading.Rat",
        "classloading.Mouse",
        "classloading.Hamster"
    };
    @SuppressWarnings("unchecked")
    private static void loader(){
        try{
            for(String type: typeNames)
                types.add((Class<? extends Pet>)Class.forName(type));
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    static{loader();}
    @Override
    public List<Class<? extends Pet>> types(){
        return types;
    }
}
