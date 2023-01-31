package com.codeclan.example.Developer.Resources.Hub;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired // lets the framework know we want to instantiate this class here
    private ResourceRepository resourceRepository;

    public List<Resource> allResources(){
        return resourceRepository.findAll();
    }

    // Optional is used as we may pass into the path an id that does not exit in the database
    public Optional<Resource> singleResource(String title){
        return resourceRepository.findResourceByTitle(title);
    }
}
