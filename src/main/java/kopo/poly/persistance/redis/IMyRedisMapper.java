package kopo.poly.persistance.redis;

import kopo.poly.dto.RedisDTO;

import java.util.List;
import java.util.Set;

public interface IMyRedisMapper {

    /**
     * String 타입 저장하기
     *
     * @param redisKey Redis 저장 키
     * @param pDTO 저장할 정보
     * @return 저장 성공 여부
     */
    int saveRedisString(String redisKey, RedisDTO pDTO) throws Exception;

    /**
     * String 타입 가져오기
     *
     * @param redisKey 가져올 RedisKey
     * @return 결과 값
     */
    RedisDTO getRedisString(String redisKey) throws Exception;

    /**
     * String 타입에 JSON 형태로 저장하기
     *
     * @param redisKey Redis 저장 키
     * @param pDTO 저장할 정보
     * @return 결과 값
     */
    int saveRedisStringJSON(String redisKey, RedisDTO pDTO) throws Exception;

    /**
     * List 타입에 여러 문자열로 저장하기(동기화)
     *
     * @param redisKey Redis저장 키
     * @param pList 저장할 정보들
     * @return 저장 성공 여부
     */
    int saveRedisList(String redisKey, List<RedisDTO> pList) throws Exception;

    /**
     * List타입에 여러 문자열로 저장된 데이터 가져오기
     *
     * @param redisKey 가져올 RedisKey
     * @return 결과 값
     */
    List<String> getRedisList(String redisKey) throws Exception;

    /**
     * List 타입에 JSON 형태로 저장하기(동기화)
     *
     * @param redisKey Redis 저장 키
     * @param pList 저장할 정보들
     * @return 저장 성공 여부
     */
    int saveRedisListJSON(String redisKey, List<RedisDTO> pList) throws Exception;

    /**
     * List타입에 JSON 형태로 저장된 데이터 가져오기
     *
     * @param redisKey 가져올 RedisKey
     * @return 결과 값
     */
    List<RedisDTO> getRedisListJSON(String redisKey) throws Exception;

    /**
     * List타입에 JSON 형태로 람다식을 이용하여 저장하기(비동기화)
     *
     * @param redisKey Redis저장 키
     * @param pList 저장할 정보들
     * @return 저장 성공 여부
     */
    int saveRedisListJSONRamda(String redisKey, List<RedisDTO> pList) throws Exception;

    /**
     * List타입에 JSON 형태로 저장된 데이터 가져오기
     * 
     * 람다식 저장된 Redis키 값이 달라서 함수 별도로 만듬
     * 매퍼 호출은 앞서 만든 getRedisListJSON 호출함
     */

    /**
     * Hash 타입에 문자열 형태로 저장하기
     *
     * @param redisKey Redis저장 키
     * @param pDTO 저장할 정보들
     * @return 저장 성공 여부
     */
    int saveRedisHash(String redisKey, RedisDTO pDTO) throws Exception;

    /**
     * Hash 타입에 무자열 형태로 저장된 값 가져오기
     *
     * @param redisKey 가져올 RedisKey
     * @return 결과 값
     */
    RedisDTO getRedisHash(String redisKey) throws Exception;
}
