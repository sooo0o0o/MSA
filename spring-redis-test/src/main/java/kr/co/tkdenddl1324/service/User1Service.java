package kr.co.tkdenddl1324.service;

import kr.co.tkdenddl1324.dto.User1DTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class User1Service {

    private final static String KEY = "user1";
    private final RedisTemplate<String, User1DTO> redisTemplate;

    public void save(User1DTO user1DTO){
        redisTemplate.opsForHash().put(KEY, user1DTO.getUid(), user1DTO);
    }

    /*
        처음 한 번은 데이터를 추출해와야해서 log 가 찍히지만,
        cacheable 을 하면 한 번 불러온 데이터를 cache 에 저장하므로 로그가 출력되지 X
        하지만 한 번 cache 로 저장된 값은 자동으로 update 되지 않으므로
        cache 도 수정(update)가 필요하다!
     */
    @Cacheable(value = KEY, key="#uid")
    public User1DTO findByUid(String uid){
        log.info("######log######");
        return (User1DTO)redisTemplate.opsForHash().get(KEY, uid);
    }

    public Map<Object, Object> findAll(){
        return redisTemplate.opsForHash().entries(KEY);
    }

    public void update(User1DTO user1DTO){
        //save 와 동일
        redisTemplate.opsForHash().put(KEY, user1DTO.getUid(), user1DTO);
    }

    public void delete(String uid){
        redisTemplate.opsForHash().delete(KEY, uid);
    }

}
