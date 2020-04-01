package sorter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Sorter {
    static public List<String> sortList(Map<String, Integer> map){
        List<String> l = new ArrayList<>();
        map = map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            l.add(entry.getKey());
            l.add(String.valueOf(entry.getValue()));
        }
        return l;
    }
}
