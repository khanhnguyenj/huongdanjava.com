package com.huongdanjava.springcloudgcs;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class Application {

    public static void main(String[] args) {
        Storage storage = getStorage();
        Blob blob = storage.get(BlobId.of("sample-bucket", "test.txt"));

        System.out.println(blob.getGeneratedId());
    }

    private static Storage getStorage() {
        // @formatter:off
        StorageOptions storageOptions = StorageOptions.newBuilder()
            .setHost("http://localhost:4443")
            .build();
        // @formatter:on

        return storageOptions.getService();
    }

}
