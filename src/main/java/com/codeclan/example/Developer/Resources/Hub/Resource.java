package com.codeclan.example.Developer.Resources.Hub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection="resources") // Lets framework know this class presents each resource in the collection
@Data // lombok annotation that takes care of the getters and setters
@AllArgsConstructor // lombok annotation for creating a constructor that takes all the private fields as an argument
@NoArgsConstructor // lombok annotation that takes no parameters whatsoever
public class Resource {
    @Id // Lets the framework know id should be treated as the unique identifier for each resource
    private ObjectId id; //represents the id of the resource
    private String title;
    private String description;
    private String publicationDate;
    private String link;
    private double cost;
    private List<String> categories;
    private List<String> topics;
    private List<String> languages;
    private String image;
    @DocumentReference //creates a manual reference relationship
    private List<Review> reviewIds;
}
