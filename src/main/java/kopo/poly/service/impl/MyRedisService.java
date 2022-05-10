package kopo.poly.service.impl;

import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


@Slf4j
@Service("MyRedisService")
public class MyRedisService implements IMyRedisService {

    @Resource(name = "MyRedisMapper")
    private IMyRedisMapper myRedisMapper;

    @Override
    public int saveRedisString() throws Exception {
        log.info(this.getClass().getName()+ ".saveRedisString Start!");

        String redisKey = "myRedis_String";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("난 String타입으로 저장할 일반 문자열이다.");

        int res = myRedisMapper.saveRedisString(redisKey, pDTO);

        log.info(this.getClass().getName() + ".saveRedisString End!");

        return res;
    }

    @Override
    public RedisDTO getRedisString() throws Exception {
        log.info(this.getClass().getName()+ ".getRedisString Start!");

        String redisKey = "myRedis_String";

        RedisDTO rDTO = myRedisMapper.getRedisString(redisKey);

        if (rDTO == null) {
            rDTO = new RedisDTO();
        }

        log.info(this.getClass().getName() + ".saveRedisString End!");

        return rDTO;
    }

    @Override
    public int saveRedisStringJSON() throws Exception {
        log.info(this.getClass().getName()+ ".getRedisStringJSON Start!");

        String redisKey = "myRedis_String_JSON";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("난 String타입에 JSON 구조로 저장할 일반 문자열이다.");
        pDTO.setName("석경민");
        pDTO.setAddr("서울");
        pDTO.setEmail("sukm386@naver.com");

        int res = myRedisMapper.saveRedisStringJSON(redisKey, pDTO);

        log.info(this.getClass().getName() + ".getRedisStringJSON End!");

        return res;
    }

    @Override
    public int saveRedisList() throws Exception {

        log.info(this.getClass().getName() + ".saveRedisList Start!");

        String redisKey = "myRedis_List";

        List<RedisDTO> pList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i + "번째 데이터입니다.");

            pList.add(pDTO);
            pDTO = null;
        }

        int res = myRedisMapper.saveRedisList(redisKey, pList);

        log.info(this.getClass().getName() + ".saveRedisList End!");

        return res;
    }

    @Override
    public List<String> getRedisList() throws Exception {

        log.info(this.getClass().getName() + ".getRedisList Start!");

        String redisKsy = "myRedis_List";

        List<String> rList = myRedisMapper.getRedisList(redisKsy);

        if (rList == null) {
            rList = new LinkedList<>();
        }

        log.info(this.getClass().getName() + ".getRedisList End!");

        return rList;
    }

    @Override
    public int saveRedisListJSON() throws Exception {
        log.info(this.getClass().getName() + ".saveRedisListJSON Start!");

        String redisKey = "myRedis_List_JSON";

        List<RedisDTO> pList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {

            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i + "번째 데이터입니다.");
            pDTO.setName("석경민[" + i + "]");
            pDTO.setAddr("서울");
            pDTO.setEmail("sukm386@naver.com");

            pList.add(pDTO);
            pDTO = null;
        }

        int res = myRedisMapper.saveRedisListJSON(redisKey, pList);

        log.info(this.getClass().getName() + ".saveRedisListJSON End!");

        return res;
    }

    @Override
    public List<RedisDTO> getRedisListJSON() throws Exception {

        log.info(this.getClass().getName() + ".getRedisListJSON Start!");

        String redisKey = "myRedis_List_JSON";

        List<RedisDTO> rList = myRedisMapper.getRedisListJSON(redisKey);

        if (rList == null) {
            rList = new LinkedList<>();

        }

        log.info(this.getClass().getName() + ".getRedisListJSON End!");

        return rList;
    }

    @Override
    public int saveRedisListJSONRamda() throws Exception {
        log.info(this.getClass().getName() + ".saveRedisListJSONRamda Start!");

        String redisKey = "myRedis_List_JSON_Ramda";

        List<RedisDTO> pList =  new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i + "번째 데이터입니다.");
            pDTO.setName("석경민[" + i + "]");
            pDTO.setAddr("서울");
            pDTO.setEmail("sukm386@naver.com");

            pList.add(pDTO);
            pDTO = null;
        }

        int res = myRedisMapper.saveRedisListJSONRamda(redisKey, pList);

        log.info(this.getClass().getName() + ".saveRedisListJSONRamda End!");

        return res;
    }

    @Override
    public List<RedisDTO> getRedisListJSONRamda() throws Exception {

        log.info(this.getClass().getName() + ".getRedisListJSONRamda Start!");

        String redisKey = "myRedis_List_JSON_Ramda";

        List<RedisDTO> rList = myRedisMapper.getRedisListJSON(redisKey);

        if (rList == null) {
            rList = new LinkedList<>();

        }

        log.info(this.getClass().getName() + ".getRedisListJSONRamda End!");

        return rList;
    }

    @Override
    public int saveRedisHash() throws Exception {

        log.info(this.getClass().getName() + ".saveRedisHash Start!");

        String redisKey = "myRedis_Hash";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setName("석경민");
        pDTO.setAddr("서울");
        pDTO.setEmail("sukm386@naver.com");

        int res = myRedisMapper.saveRedisHash(redisKey, pDTO);

        log.info(this.getClass().getName() + ".saveRedisHash End!");

        return res;
    }

    @Override
    public RedisDTO getRedisHash() throws Exception {

        log.info(this.getClass().getName() + ".getRedisHash Start!");

        String redisKey = "myRedis_Hash";

        RedisDTO rDTO = myRedisMapper.getRedisHash(redisKey);

        if (rDTO == null) {
            rDTO = new RedisDTO();
        }

        log.info(this.getClass().getName() + ".getRedisHash End!");

        return rDTO;
    }
}
