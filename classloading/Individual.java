package classloading;

public class Individual {
    private static int id;
    private String name;
    public Individual(String name){
        this.name=name;
    }
    public Individual(){}
    public String toString(){
        return getClass().getSimpleName()+
                (name==null?"":" "+name);
    }
    public static int getId(){
        return id;
    }
}
