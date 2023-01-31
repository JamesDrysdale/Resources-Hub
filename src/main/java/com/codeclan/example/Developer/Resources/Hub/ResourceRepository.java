package com.codeclan.example.Developer.Resources.Hub;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, ObjectId> {
    Optional<Resource> findResourceByTitle(String title);
}
