import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15);


        Stream<Integer> stream = list.stream();
        Comparator<Integer> comparator = (x1, x2) -> x1.compareTo(x2);
        BiConsumer<Integer,Integer> biConsumer = (integer, integer2) -> integer.equals(integer2);
        findMinMax(stream,comparator,biConsumer) ;
        evevAnd(list);


    }
    public  static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
    )
    {
        List<T> listStream;
        listStream = stream
                .limit(20)
                .sorted()
                .collect(Collectors.toList());
        T minNum = null;
        T maxNum = null;
        if (listStream.size() != 0){
            minNum = listStream.get(0);
            maxNum = listStream.get(listStream.size()-1);

        }
        minMaxConsumer.accept(minNum,maxNum);
        System.out.println(listStream);
    }
    public static void evevAnd(List<Integer> list){
        System.out.println(list.stream()
                .filter(i -> i % 2 == 0)
                .count());
    }

}