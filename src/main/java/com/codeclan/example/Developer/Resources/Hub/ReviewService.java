package com.codeclan.example.Developer.Resources.Hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    /*
        Repositories are one way of talking to a database
        Templates are another - they're good for complex operations, or for when a repository is not suitable
        You can create dynamic queries and do the job inside the db without using the repository
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String title) {
        Review review = new Review(reviewBody); // Create a new review

        // Associate the review with the appropriate resource
         reviewRepository.insert(review);

         mongoTemplate.update(Resource.class)
                 //update the resource in the db where the title matches the argument passed in to review by user
                 .matching(Criteria.where("title").is(title))
                 // This is an update definition - updates the database
                 .apply(new Update().push("reviewIds").value(review));
    }
}
