package com.example.demo.app;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Data
@RequiredArgsConstructor
public class RedisLock implements Lock {

    @NonNull
    private String id;

    private final RedisTemplate redisTemplate;

    private String random = String.valueOf(System.nanoTime());

    private Sync sync = new Sync();

    private class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            RedisScript<Boolean> script = RedisScript.of(new ClassPathResource("lua/tryLock.lua"), Boolean.class);
            Object result = redisTemplate.execute(script, Arrays.asList(id), random);
            System.out.println(result);
            return (boolean) result;
        }

        @Override
        protected boolean tryRelease(int arg) {
            RedisScript<Boolean> script = RedisScript.of(new ClassPathResource("lua/tryRelease.lua"), Boolean.class);
            Object result = redisTemplate.execute(script, Arrays.asList(id), random);
            System.out.println(result);
            return (boolean) result;
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override



    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException();
    }
}
