package com.huongdanjava.projectreactor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import reactor.test.StepVerifier;

class DemoTest {

  @Test
  void testGetStudentName() {
    Demo demo = new Demo();

    StepVerifier.create(demo.getStudentName())
        .expectNext("Khanh")
        .verifyComplete();
  }

  @Test
  void testGetStudentNames() {
    Demo demo = new Demo();

    StepVerifier.create(demo.getStudentNames())
        .recordWith(ArrayList::new)
        .expectNextCount(2)
        .consumeRecordedWith(r -> {
          assertThat(r)
              .contains("Khanh", "Quan");
        })
        .verifyComplete();
  }
}
