package vn.codegym.model.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Override
    public String translate(String key) {
        String result = "Không tìm thấy";
        Map<String, String> map = new HashMap<>();
        map.put("one", "một");
        map.put("two", "hai");
        map.put("three", "ba");
        map.put("four", "bốn");
        for (String str : map.keySet()) {
            if (str.equals(key)) {
                return map.get(str);
            }
        }
        return result;
    }
}
