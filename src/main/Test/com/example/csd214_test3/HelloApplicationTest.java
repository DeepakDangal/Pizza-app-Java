package com.example.csd214_test3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {

    @Test
    void main() {
        HelloController a = new HelloController();
        assertEquals(a.total_bill("L", 3), 13.75);
    }
}