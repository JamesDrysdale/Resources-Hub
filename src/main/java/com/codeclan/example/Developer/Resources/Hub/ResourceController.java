package com.codeclan.example.Developer.Resources.Hub;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/resources")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources(){
        return new ResponseEntity<List<Resource>>(resourceService.allResources(), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    /*
    @PathVariable annotation lets framework know to take whatever we pass into the path and convert it
    into an ObjectId called id
     */
    public ResponseEntity<Optional<Resource>> getSingleResource(@PathVariable String title){
        return new ResponseEntity<Optional<Resource>>(resourceService.singleResource(title), HttpStatus.OK);
    }
}
