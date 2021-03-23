import java.util.ArrayList;
import java.util.List; 
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomList {
    public static List<Integer> createRandList(int n) { 
          
        List<Integer> list = IntStream.rangeClosed(1, n)
            .boxed()
            .collect(Collectors.toList());
            
        Random random = new Random();
     
        for(int j=0; j<n; j++){
            int r = random.nextInt(n);
            int temp = list.get(r);
            list.set(r, list.get(j));
            list.set(j, temp);
        }
        return list; 
    }
    
    public static void main(String[] args) {
            System.out.println(createRandList(20)); 
    }
}
