package com.huongdanjava.gcppubsub;

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Application {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String projectId = "crested-trainer-341707";
        String topicId = "huongdanjava";

        TopicName topicName = TopicName.of(projectId, topicId);

        Publisher publisher = Publisher.newBuilder(topicName).build();

        String message = "Hello";
        ByteString data = ByteString.copyFromUtf8(message);
        // @formatter:off
        PubsubMessage pubsubMessage = PubsubMessage.newBuilder()
                .setData(data)
                .build();
        // @formatter:on

        ApiFuture<String> publish = publisher.publish(pubsubMessage);

        String messageId = publish.get();
        System.out.println("Published message ID: " + messageId);
    }
}
