package edu.depaul.cachingbyexample.controllers;

import edu.depaul.cachingbyexample.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fibonacci")
public class FibonacciController {
    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/{n}")
    public int fibonacci(@PathVariable int n) {
        return fibonacciService.calculateFibonacci(n);
    }
}
