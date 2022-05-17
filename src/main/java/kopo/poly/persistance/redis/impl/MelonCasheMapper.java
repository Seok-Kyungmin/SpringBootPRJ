package kopo.poly.persistance.redis.impl;

import kopo.poly.dto.MelonDTO;
import kopo.poly.persistance.redis.IMelonCasheMapper;
import kopo.poly.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component("MelonCasheMapper")
public class MelonCasheMapper implements IMelonCasheMapper {

    public final RedisTemplate<String, Object> redisDB;

    public MelonCasheMapper(RedisTemplate<String,Object> redisDB) {
        this.redisDB = redisDB;
    }

    @Override
    public int insertSong(List<MelonDTO> pList, String redisKey) throws Exception {

        log.info(this.getClass().getName() + ".insertSong Start!");

        int res = 0;

        String key = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(MelonDTO.class));

        pList.forEach(melon -> redisDB.opsForList().leftPush(key, melon));

        redisDB.expire(key, 1, TimeUnit.HOURS);

        res = 1;

        log.info(this.getClass().getName() + ".insertSong End!");

        return res;
    }

    @Override
    public boolean getExistkey(String key) throws Exception{

        if(redisDB.hasKey(key)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<MelonDTO> getSongList(String key) throws Exception {

        log.info(this.getClass().getName() + ".getSongList Start!");

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(MelonDTO.class));

        List<MelonDTO> rList = null;

        if(redisDB.hasKey(key))  {
            rList= (List) redisDB.opsForList().range(key, 0, -1);
        }

        log.info(this.getClass().getName() + ".getSongList End!");

        return rList;
    }
}
