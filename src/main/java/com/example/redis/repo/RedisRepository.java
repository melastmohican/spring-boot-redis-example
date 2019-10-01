package com.example.redis.repo;

import com.example.redis.model.RedisObject;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<RedisObject, String> {
}
