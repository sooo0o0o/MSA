package kr.co.tkdenddl1324.controller;

import kr.co.tkdenddl1324.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MainService mainService;

    @PostMapping("/redis/string")
    public void setValue(String key, String value){
        //[http://localhost:8080/redis/string?key=a101&value=홍길동] -> 데이터 삽입됨
        mainService.setValue(key, value);
    }

    @GetMapping("/redis/string/{key}")
    public ResponseEntity getValue(@PathVariable String key){
        String value = mainService.getValue(key);

        return ResponseEntity.ok().body(value);
    }

    @PostMapping("/redis/list/right")
    public ResponseEntity addToListFromRight(String key, String value){
        mainService.addToListFromRight(key, value);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/redis/list/left")
    public ResponseEntity addToListFromLeft(String key, String value){
        mainService.addToListFromLeft(key, value);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/redis/list")
    public ResponseEntity getFromList(String key, int index){
        String result = mainService.getFromList(key, index);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/redis/list/range")
    public ResponseEntity<List<String>> getRangeFromList(String key, int start, int end){
        List<String> list = mainService.getRangeFromList(key, start, end);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/redis/set")
    public ResponseEntity addToSet(String key, String... values){
        mainService.addToSet(key, values);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/redis/set")
    public ResponseEntity<Set<String>> getFromSet(String key){
        Set<String> result = mainService.getFromSet(key);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/redis/hash")
    public ResponseEntity addToHash(String key, String hashKey, String value){
        mainService.addToHash(key, hashKey, value);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/redis/hash")
    public ResponseEntity getFromHash(String key, String hashKey){
        String value = mainService.getFromHash(key, hashKey);
        return ResponseEntity.ok(value);
    }

}
