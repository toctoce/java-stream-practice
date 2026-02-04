package problem.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Problem19 {

    /**
     * 스트림을 사용하여 문자열 배열에서 TreeMap을 생성합니다. 배열의 각 요소를 key로 하고, 해당 요소의 길이를 value로 하는 TreeMap을 반환합니다.
     *
     * @param strings 문자열 배열
     * @return 생성된 TreeMap
     */
    public static Map<String, Integer> createTreeMapFromStream(String[] strings) {
        // 여기에 코드 작성
        return Arrays.stream(strings)
                .collect(Collectors.toMap(
                        string -> string,
                        String::length,
                        (oldValue, newValue) -> oldValue, // Merge Function: 중복 키 발생 시 처리 규칙
                        TreeMap::new
                ));
//                return Arrays.stream(strings)
//                .collect(
//                        TreeMap::new,                        // 1. Supplier: 빈 TreeMap 생성
//                        (map, s) -> map.put(s, s.length()),  // 2. Accumulator: 키와 길이를 맵에 추가
//                        TreeMap::putAll                      // 3. Combiner: 병렬 처리 시 맵 통합
//                );
    }
}
