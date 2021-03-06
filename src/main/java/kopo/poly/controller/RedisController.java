package kopo.poly.controller;

import kopo.poly.dto.RedisDTO;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
public class RedisController {
    @Resource(name="MyRedisService")
    private IMyRedisService myRedisService;

    /**
     * Redis 문자열 저장 실습
     */
    @GetMapping(value = "redis/saveRedisString")
    public String saveRedisString() throws Exception{

        log.info(this.getClass().getName() + ".saveRedisString 시작");

        //수집 결과 출력
        String msg;

        int res = myRedisService.saveRedisString();

        if(res==1){
            msg ="success";
        }else{
            msg="fail";
        }

        log.info(this.getClass().getName() + ".saveRedisString 끝");

        return msg;
    }

    /**
     * Redis 문자열 저장된 값 가져오기
     */
    @GetMapping(value = "redis/getRedisString")
    public RedisDTO getRedisString() throws Exception{
        log.info(this.getClass().getName() + ".getRedisString 시작");

        RedisDTO rDTO = myRedisService.getRedisString();

        log.info(this.getClass().getName() + ".getRedisString 끝");

        return rDTO;
    }


    /**
     * JSON 저장 실습
     *
     */
    @GetMapping(value = "redis/saveRedisStringJSON")
    public String saveRedisStringJSON() throws Exception{
        log.info(this.getClass().getName() + ".getRedisStringJSON 시작");

        String msg;

        int res = myRedisService.saveRedisStringJSON();

        if(res==1){
            msg="success";
        }else{
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".getRedisStringJSON 끝");

        return msg;
    }


    /**
     * Redis 문자열을 JSON으로 저장된 값 가져오기
     */
    @GetMapping(value = "redis/getRedisStringJSON")
    public RedisDTO getRedisStringJSON() throws Exception{

        log.info(this.getClass().getName() + ".getRedisStringJSON 시작");

        RedisDTO rDTO = myRedisService.getRedisStringJSON();

        log.info(this.getClass().getName() + ".getRedisStringJSON 끝");

        return rDTO;
    }

    /**
     * List 타입에 여러 문자열로 저장하기(동기화)
     */
    @GetMapping(value = "redis/saveRedisList")
    public String saveRedisList() throws Exception {

        log.info(this.getClass().getName() + ".saveRedisList Start!");

        //수집 결과 출력
        String msg;

        int res = myRedisService.saveRedisList();

        if (res == 1) {
            msg = "sussess";
        } else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".saveRedisList End!");

        return msg;
    }

    /**
     * List타입에 여러 문자열로 저장된 데이터 가져오기
     */
    @GetMapping(value = "redis/getRedisList")
    public List<String> getRedisList() throws Exception {

        log.info(this.getClass().getName() + ".getRedisList Start!");

        List<String> rList = myRedisService.getRedisList();

        log.info(this.getClass().getName() + ".getRedisList End!");

        return rList;
    }

    /**
     * List타입에 JSOM 형태로 저장하기(동기화)
     */
    @GetMapping(value = "redis/saveRedisListJSON")
    public String saveRedisListJSON() throws Exception {

        log.info(this.getClass().getName() + ".saveRedisListJSON Start!");

        //수집 결과 출력
        String msg;

        int res = myRedisService.saveRedisListJSON();

        if (res == 1) {
            msg = "success";
        } else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".saveRedisListJSON End!");

        return msg;
    }

    /**
     * List타입에 JSON 형태로 저장된 데이터 가져오기
     */
    @GetMapping(value = "redis/getRedisListJSON")
    public List<RedisDTO> getRediosListJSON() throws Exception {

        log.info(this.getClass().getName() + ".getRedisListJSON Start!");

        List<RedisDTO> rList = myRedisService.getRedisListJSON();

        log.info(this.getClass().getName() + ".getRedisListJSON End!");

        return rList;
    }

    /**
     * List타입에 JSON 형태로 람다식을 이용하여 저장하기(비동기화)
     */
    @GetMapping(value = "redis/saveRedisListJSONRamda")
    public String saveRedisListJSONRamda() throws Exception {

        log.info(this.getClass().getName() + ".saveRedisListJSONRamda start!");

        // 수집 결과 출력
        String msg;

        int res = myRedisService.saveRedisListJSONRamda();

        if (res == 1) {
            msg = "success";

        } else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".saveRedisListJSONRamda End!");

        return msg;
    }

    /**
     * List 타입에 JSON형태로 저장된 데이터 가져오기
     */
    @GetMapping(value = "redis/getRedisListJSONRamda")
    public List<RedisDTO> getRedisListJSONRamda() throws Exception {

        log.info(this.getClass().getName() +".getRedisListJSONRamda Start!");

        List<RedisDTO> rList = myRedisService.getRedisListJSONRamda();

        log.info(this.getClass().getName() +".getRedisListJSONRamda End!");

        return rList;
    }


    /**
     * Hash 타입에 문자열 형태로 저장하기
     */
    @GetMapping(value="redis/saveRedisHash")
    public String saveRedisHash() throws Exception{

        log.info(this.getClass().getName()+".saveRedisHash 시작");

        // 수집 결과 출력
        String msg;

        int res = myRedisService.saveRedisHash();

        if(res==1){
            msg = "success";
        }else{
            msg = "fail";
        }

        log.info(this.getClass().getName()+".saveRedisHash 끝");

        return msg;
    }

    /**
     * Hash 타입에 문자열 형태로 지정된 값 가져오기
     */
    @GetMapping(value = "redis/qetRedisHash")
    public RedisDTO getRedisHash() throws Exception{

        log.info(this.getClass().getName()+".saveRedisHash 시작");

        RedisDTO rDTO = myRedisService.getRedisHash();

        log.info(this.getClass().getName()+".saveRedisHash 끝");

        return rDTO;
    }

    /**
     * Set타입에 JSON 형태로 람다식을 이용하여 저장하기
     */
    @GetMapping(value = "redis/saveRedisSetJSONRamda")
    public String saveRedisSetJSONRamda() throws Exception{

        log.info(this.getClass().getName() + ".saveRedissaveRedisSetJSONRamda 시작");

        String msg;

        int res = myRedisService.saveRedisSetJSONRamda();

        if(res ==1){
            msg = "success";
        }else{
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".saveRedissaveRedisSetJSONRamda 끝");

        return msg;
    }

    /**
     * Set타입에 JSON 형태로 람다식을 이용하여 저장된 값 가져오기
     */
    @GetMapping(value = "redis/getRedisSetJSONRamda")
    public Set<RedisDTO> getRedisSetJSONRamda() throws Exception{

        log.info(this.getClass().getName() + ".getRedissaveRedisSetJSONRamda 시작");

        Set<RedisDTO> rSet=myRedisService.getRedisSetJSONRamda();

        log.info(this.getClass().getName() + ".getRedissaveRedisSetJSONRamda 끝");

        return rSet;
    }

    /**
     * ZSet타입에 JSON 형태로 저장하기
     */
    @GetMapping(value ="redis/saveRedisZSetJSON")
    public String saveRedisZSetJSON() throws Exception{

        log.info(this.getClass().getName() + ".saveRedisZSetJSON 시작");

        //수집 결과 출력
        String msg;

        int res = myRedisService.saveRedisZSetJSON();

        if(res ==1){
            msg ="success";
        }else{
            msg="fail";
        }

        log.info(this.getClass().getName() + ".saveRedisZSetJSON 끝");

        return msg;
    }

    /**
     * ZSet타입에 JSON 형태로 저장된 값 가져오기
     */
    @GetMapping(value ="redis/getRedisZSetJSON")
    public Set<RedisDTO> getRedisZSetJSON() throws Exception{

        log.info(this.getClass().getName() + ".getRedisZSetJSON Start");

        Set<RedisDTO> rSet = myRedisService.getRedisZSetJSON();

        log.info(this.getClass().getName() + ".getRedisZSetJSON End!");

        return rSet;
    }

    /**
     * Set타입에 JSON 형태로 람다시을 이용하여 저장된 값 가져오기
     */
    @GetMapping(value ="redis/getRedisZSetJSONRamda")
    public Set<RedisDTO> getRedisZSetJSONRamda() throws Exception{

        log.info(this.getClass().getName() + ".getRedisZSetJSONRamda Start");

        Set<RedisDTO> rSet = myRedisService.getRedisZSetJSONRamda();

        log.info(this.getClass().getName() + ".getRedisZSetJSONRamda End!");

        return rSet;
    }

    /**
     * RedisDB 데이터 삭제하기
     */
    @GetMapping(value ="redis/deleteDataJSON")
    public boolean deleteDataJSON() throws Exception{

        log.info(this.getClass().getName() + ".deleteDataJSON Start");

        boolean res = myRedisService.deleteDataJSON();

        log.info(this.getClass().getName() + ".deleteDataJSON End!");

        return res;
    }

    /**
     * RedisDB 데이터 삭제하기
     */
    @GetMapping(value ="redis/deleteDataString")
    public boolean deleteDataString() throws Exception{

        log.info(this.getClass().getName() + ".deleteDataString Start");

        boolean res = myRedisService.deleteDataString();

        log.info(this.getClass().getName() + ".deleteDataString End!");

        return res;
    }
}
