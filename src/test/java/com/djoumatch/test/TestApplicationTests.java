package com.djoumatch.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TestApplicationTests {

    @Test
    void contextLoads() {
        assertThat(1).isEqualTo(1);
    }

}
