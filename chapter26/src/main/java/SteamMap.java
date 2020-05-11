import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaijin
 * @title: java8流式操作
 * @description: 参考：https://mp.weixin.qq.com/s/J7ojCKStDFpBxJ-0lYUbWw
 * @date 2020/5/1115:14
 */
public class SteamMap {
    /**
     * map，flatmap映射操作的区别
     * flatMap与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> strArray = Arrays.stream(strs)
                .map(str -> str.split(""))  //映射成为Stream<String[]>
                .distinct()
                .collect(Collectors.toList());
        strArray.forEach(strings -> {
            for (String string : strings) {
                System.out.print(string + " ");
            }
        });
        System.out.println();


        List<String> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)          // 扁平化为Stream<String>
                .distinct().collect(Collectors.toList());
        distinctStrs.forEach(item -> {
            System.out.print(item + " ");
        });
        System.out.println();
    }
}
