package kopo.poly.service.impl;

import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service("MyRedisService")
public class MyRedisService implements IMyRedisService {
    @Resource(name="MyRedisMapper")
    private IMyRedisMapper myRedisMapper;

    @Override
    public int saveRedisString() throws Exception{
        log.info(this.getClass().getName() + ".saveRedisString 시작");

        String redisKey="myRedis_String";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("난 String타입으로 지정할 일반 문자열이다!!!");

        int res = myRedisMapper.saveRedisString(redisKey, pDTO);

        log.info(this.getClass().getName() + ".saveRedisString 끝");

        return res;
    }
/**피피티 확인*/
    @Override
    public RedisDTO getRedisString() throws Exception{
        log.info(this.getClass().getName() + ".etRedisString 시작");

        String redisKey = "myRedis_String";

        RedisDTO rDTO = myRedisMapper.getRedisString(redisKey);

        if(rDTO == null){
            rDTO = new RedisDTO();
        }

        log.info(this.getClass().getName() + ".etRedisString 끝");

        return rDTO;
    }


    @Override
    public int saveRedisStringJSON() throws Exception{
        log.info(this.getClass().getName() + ".etRedisStringJSON 시작");

        String redisKey = "myRedis_String_JSON";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("난 Strint타입에 JSON 구조로 저장할 일반 문자열");
        pDTO.setName("석경민");
        pDTO.setAddr("서울");
        pDTO.setEmail("JNA@naver.com");

        int res = myRedisMapper.saveRedisStringJSON(redisKey, pDTO);

        log.info(this.getClass().getName() + ".etRedisStringJSON 끝");

        return res;
    }
/**피피티 확인 끝*/

    @Override
    public RedisDTO getRedisStringJSON() throws Exception{

        log.info(this.getClass().getName() + ".getRedisStringJSON 시작");

        String redisKey = "myRedis_String_JSON";

        RedisDTO rDTO = myRedisMapper.getRedisStringJSON(redisKey);

        if(rDTO==null){
            rDTO= new RedisDTO();
        }

        log.info(this.getClass().getName() + ".getRedisStringJSON 끝");

        return rDTO;
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
            pDTO.setEmail("gsejglsegj@naver.com");

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
            pDTO.setEmail("dfjlsefjl@naver.com");

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
    public int saveRedisHash() throws Exception{

        log.info(this.getClass().getName()+".saveRedisHash 시작");

        String redisKey = "myRedis_Hash";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setName("석경민");
        pDTO.setAddr("서울");
        pDTO.setEmail("ifdifis@naver.com");

        int res = myRedisMapper.saveRedisHash(redisKey, pDTO);

        log.info(this.getClass().getName()+".saveRedisHash 끝");

        return res;
    }

    @Override
    public RedisDTO getRedisHash() throws Exception{
        log.info(this.getClass().getName()+".saveRedisHash 시작");

        String redisKey = "myRedis_Hash";

        RedisDTO rDTO = myRedisMapper.getRedisHash(redisKey);

        if(rDTO == null){
            rDTO=new RedisDTO();
        }

        log.info(this.getClass().getName()+".saveRedisHash 끝");

        return rDTO;
    }

    @Override
    public int saveRedisSetJSONRamda() throws Exception{

        log.info(this.getClass().getName() + ".saveRedissaveRedisSetJSONRamda 시작");

        String redisKey = "myRedis_Set_JSON";

        Set<RedisDTO> pSet = new HashSet<>();

        for (int i =0; i<10; i++){
            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i + "번째 데이터입니다");
            pDTO.setName("석경민[" + i + "]");
            pDTO.setAddr("서울");
            pDTO.setEmail("falwjif@naver.com");

            pSet.add(pDTO);
            pDTO=null;
        }

        int res = myRedisMapper.saveRedisSetJSONRamda(redisKey, pSet);

        log.info(this.getClass().getName() + ".saveRedissaveRedisSetJSONRamda 끝");

        return res;
    }

    @Override
    public Set<RedisDTO> getRedisSetJSONRamda() throws Exception{

        log.info(this.getClass().getName() + ".getRedissaveRedisSetJSONRamda 시작");

        String redisKey = "myRedis_Set_JSON";

        Set<RedisDTO> rSet = myRedisMapper.getRedisSetJSONRamda(redisKey);

        if(rSet == null){
            rSet = new HashSet<>();
        }

        log.info(this.getClass().getName() + ".getRedissaveRedisSetJSONRamda 끝");

        return rSet;
    }

    @Override
    public int saveRedisZSetJSON() throws Exception{

        log.info(this.getClass().getName() + ".saveRedisZSetJSON 시작");

        String redisKey = "myRedis_Zset_JSON";

        List<RedisDTO> pList = new LinkedList<>();

        for(int i = 0; i<10; i++){
            RedisDTO pDTO = new RedisDTO();
            pDTO.setTest_text(i + "번째 데이터입니다");
            pDTO.setName("석경민[" + i +"]");
            pDTO.setAddr("서울");
            pDTO.setEmail("egsge@naver.com");

            pList.add(pDTO);
            pDTO = null;
        }

        int res= myRedisMapper.saveRedisZSetJSON(redisKey, pList);

        log.info(this.getClass().getName() + ".saveRedisZSetJSON 끝");

        return res;
    }

    @Override
    public Set<RedisDTO> getRedisZSetJSON() throws Exception {

        log.info(this.getClass().getName() + ".getRedisZSetJSON Start!");

        String redisKey = "myRedis_Zset_JSON";

        Set<RedisDTO> rSet = myRedisMapper.getRedisZSetJSON(redisKey);

        if (rSet == null) {
            rSet = new HashSet<>();

        }

        log.info(this.getClass().getName() + ".getRedisZSetJSON End!");

        return rSet;
    }

    @Override
    public Set<RedisDTO> getRedisZSetJSONRamda() throws Exception {

        log.info(this.getClass().getName() + ".getRedisZSetJSONRamda Start!");

        String redisKey = "myRedis_ZSet_JSON";

        Set<RedisDTO> rSet = myRedisMapper.getRedisZSetJSONRamda(redisKey);

        if (rSet == null) {
            rSet = new HashSet<>();

        }

        log.info(this.getClass().getName() + ".getRedisZSetJSONRamda End!");

        return rSet;
    }

    @Override
    public boolean deleteDataJSON() throws Exception {

        log.info(this.getClass().getName() + ".deleteData Start!");

        String redisKey = "myRedis_Zset_JSON";

        boolean res = myRedisMapper.deleteDataJSON(redisKey);

        log.info(this.getClass().getName() + ".deleteData End!");

        return res;
    }

    @Override
    public boolean deleteDataString() throws Exception {

        log.info(this.getClass().getName() + ".deleteDataString Start!");

        String redisKey = "myRedis_Hash";

        boolean res = myRedisMapper.deleteDataJSON(redisKey);

        log.info(this.getClass().getName() + ".deleteDataString End!");

        return res;
    }
}
