package org.palituxd.pocs.sumandos.dao.repository.cache;

import org.palituxd.pocs.sumandos.commons.OperationCommon;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class OperationRepositoryCache {

    private static final String KEY = "Operations";

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, OperationCommon> hashOperations;

    public void add(OperationCommon op) {
        hashOperations.putIfAbsent(KEY, String.valueOf(op.hashCode()), op);
    }

    public OperationCommon get(OperationCommon op) {
        return hashOperations.get(KEY, String.valueOf(op.hashCode()));
    }

    public void remove(OperationCommon op) {
        hashOperations.delete(KEY, String.valueOf(op.hashCode()));
    }

    public boolean contains(OperationCommon operationCommon) {
        return get(operationCommon) != null;
    }
}
