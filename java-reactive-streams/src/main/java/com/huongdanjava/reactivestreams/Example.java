package com.huongdanjava.reactivestreams;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

public class Example {

    public static void main(String[] args) {
        Consumer c = new Consumer();

        SubmissionPublisher<Student> sp = new SubmissionPublisher<>();
        sp.subscribe(c);

        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("Student " + i);

            sp.submit(student);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sp.close();
    }
}
