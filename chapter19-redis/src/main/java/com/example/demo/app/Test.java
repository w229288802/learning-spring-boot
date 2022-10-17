package com.example.demo.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class Test {
    @GetMapping("/")
    public Mono<String> test() throws InterruptedException {
        Mono<Object> objectMono = Mono.fromCallable(() -> null);
        ExecutorService executors = Executors.newFixedThreadPool(5);
        List<Flux<String>> fluxList = IntStream.range(0, 10).boxed()
                .map(i -> generateTask(executors, i)).collect(Collectors.toList());
        byte[] c = new byte[1024];
        Mono<String> reduce = Flux.merge(fluxList).reduce("", (a, b) -> a + b + "<br/>");
        return reduce;
    }

    public Flux<String> generateTask(ExecutorService executorService, int i) {
        return Flux.<String>create(s -> {
            s.next(i + "-test");
            s.complete();
        }).subscribeOn(Schedulers.fromExecutor(executorService));
    }
}
