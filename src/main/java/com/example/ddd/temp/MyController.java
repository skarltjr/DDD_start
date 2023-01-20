package com.example.ddd.temp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {
    private final MyService myService;

    @PostMapping
    public void hello() {
        myService.outer();
    }
}
