package com.example.redis.repo;

import com.example.redis.model.RedisObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataRedisTest
class RedisRepositoryTest {

    @Autowired
    RedisRepository repository;

    @Test
    void testAdd() {
        Map<String, String> doubleBraceMap = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
        }};
        RedisObject testObj = new RedisObject("111", "doubleBraceMap", doubleBraceMap);
        testObj = repository.save(testObj);
        assertNotNull(testObj);
    }

    @Test
    void testFindById() {
        Optional<RedisObject> testObj = repository.findById("111");
        assertTrue(testObj.isPresent());
        RedisObject ro = testObj.get();
        assertNotNull(ro);
        assertEquals("111", ro.getId());
    }

}