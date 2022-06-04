package controllers.controllers.controller;


import com.google.gson.GsonBuilder;
import controllers.controllers.wrapper.KotikWrapper;
import controllers.controllers.wrapper.OwnerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    @PostMapping(value = "Update")
    public ResponseEntity<?> Update(@RequestBody OwnerWrapper owner){
        var json = new GsonBuilder().create().toJson(owner, KotikWrapper.class);
        kafkaTemplate.send("owner.update", json);
        return ResponseEntity.ok().body("Everything went well!");
    }

}
