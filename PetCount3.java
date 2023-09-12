import classloading.*;
import java.util.*;
import java.util.stream.Collectors;

public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>,Integer>{
        public PetCounter(){
            Map<Class<? extends Pet>,Integer> linkedHashMap=LiteralPetCreator.allTypes.stream().collect(
                    Collectors.toMap(p->p, p->0, (p1,p2)->p1, LinkedHashMap::new));//LinkedHashMap::new
            putAll(linkedHashMap);
        }
        public void count(Pet pet){
            for(Map.Entry<Class<? extends Pet>,Integer> pair:
                    entrySet())//遍历entrySet()中的每一个元素
                if(pair.getKey().isInstance(pet))//判断pet是否是pair.getKey()的实例
                    put(pair.getKey(),pair.getValue()+1);
        }
        public String toString(){
            StringBuilder result=new StringBuilder("{");
            for(Map.Entry<Class<? extends Pet>,Integer> pair:
                    entrySet()){
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length()-2,result.length());
            result.append("}");
            return result.toString();
        }
    }
    public static void main(String[]args){
        PetCounter petCount=new PetCounter();
        for(Pet pet:Pets.createArray(20)){
            System.out.println(pet.getClass().getSimpleName()+" ");
            petCount.count(pet);
        }
        System.out.println();
        System.out.println(petCount);
    }
}
