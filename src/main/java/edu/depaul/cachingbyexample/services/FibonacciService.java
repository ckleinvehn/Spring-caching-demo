package edu.depaul.cachingbyexample.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class FibonacciService {

    /** Calculate the nth Fibonacci number, where the first two in the sequence are:
     *      calculateFibonacci(0) == 0
     *      calculateFibonacci(1) == 1
     *
     * And every number thereafter is calculated recursively as:
     *      calculateFibonacci(n) == calculateFibonacci(n - 1) + calculateFibonacci(n - 2)
     *
     * E.g.,
     *      calculateFibonacci(2) == calculateFibonacci(1) + calculateFibonacci(0)
     *                            == 1 + 0
     *                            == 1
     */
    public int calculateFibonacci(int n) {
        if (n < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Argument n must be >= 0");
        return n < 2 ? n : calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}