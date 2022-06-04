package controllers.controllers.controller;



import com.google.gson.GsonBuilder;
import controllers.controllers.wrapper.KotikWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "kotiki")
public class KotikController {

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    @PostMapping(value = "Update")
    public ResponseEntity<?> Update(@RequestBody KotikWrapper kotik) {
        var json = new GsonBuilder().create().toJson(kotik, KotikWrapper.class);
        kafkaTemplate.send("kotiki.update", json);

        return ResponseEntity.ok().body("I'm aweasome, i have sent all data!");
    }


}
