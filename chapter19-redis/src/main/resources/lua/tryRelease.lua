-- 添加一个延迟任务
-- 1.将延迟任务存放到key为 {PROJECT}:REDIS_DELAY_TABLE 的 HASH_TABLE中
-- 2.将TOPIC:ID 作为member ;执行时间戳作为 score  放入 {PROJECT}:RD_ZSET_BUCKET: 的ZSET队列中;


local lock_name = "lock:"..KEYS[1];
local random = ARGV[1]
if redis.call("GET", lock_name) == random then
    redis.call("DEL", lock_name)
    return true
else
    return false
end

