package com.huongdanjava.jackson;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;

public class Application {

  public static void main(String[] args) throws IOException {
    JsonNode jsonNode = new ObjectMapper().readTree(new File("src/main/resources/data.json"));

    CsvSchema.Builder builder = CsvSchema.builder()
        .addColumn("name")
        .addColumn("code")
        .addColumn("date");

//    CsvSchema.Builder builder = CsvSchema.builder();
//    jsonNode.elements().next().fieldNames().forEachRemaining(f -> builder.addColumn(f));

    CsvSchema csvSchema = builder.build().withHeader();

    CsvMapper csvMapper = new CsvMapper();
    csvMapper.configure(Feature.IGNORE_UNKNOWN, true);
    csvMapper.writerFor(JsonNode.class)
        .with(csvSchema)
        .writeValue(new File("src/main/resources/data.csv"), jsonNode);
  }
}
