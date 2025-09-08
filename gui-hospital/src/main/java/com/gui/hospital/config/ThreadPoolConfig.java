package com.gui.hospital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 */
@Configuration
@EnableAsync //开启异步任务
public class ThreadPoolConfig {

    /**
     * 用户发送短信的线程池对象
     * @return
     */
    @Bean("smsThreadPool")
    public Executor threadPoolExecutor(){
        // 创建Spring提供的线程池任务执行器实例
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 核心线程数：默认始终存活的线程数量（即使处于空闲状态）
        // 推荐值：根据CPU核心数和任务类型设置，IO密集型可适当增大
        executor.setCorePoolSize(5);

        // 最大线程数：线程池允许创建的最大线程数量
        // 推荐值：建议设置为核心线程数的2-3倍（根据机器配置调整）
        executor.setMaxPoolSize(10);

        // 队列容量：用于保存等待执行任务的阻塞队列大小
        // 注意：队列过大会导致内存消耗增加，过小容易触发拒绝策略
        executor.setQueueCapacity(100);

        // 空闲线程存活时间（秒）：超出核心线程数的空闲线程存活时间
        executor.setKeepAliveSeconds(60);

        // 线程名前缀：方便日志跟踪和问题排查
        executor.setThreadNamePrefix("sms-thread-");

        // 拒绝策略：当线程池和队列都满时的处理策略
        // CallerRunsPolicy：由调用者线程（如主线程）直接执行该任务
        // 其他策略：AbortPolicy(默认，抛出异常)/DiscardPolicy(静默丢弃)/DiscardOldestPolicy(丢弃队列最老任务)
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 初始化线程池（必须调用，否则参数不生效）
        executor.initialize();

        return executor;
    }

}
