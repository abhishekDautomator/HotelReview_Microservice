package com.example.rating_service.service;

import com.example.rating_service.repository.SequenceCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class SequenceGeneratorService  {
    @Autowired
    private MongoTemplate mongoTemplate;

    public long getNextSequence(String seqName) {
        Query query = new Query(Criteria.where("_id").is(seqName));
        Update update = new Update().inc("seq", 1);
        SequenceCounter counter = mongoTemplate.findAndModify(query, update, SequenceCounter.class);

        if (counter == null) {
            // If the counter does not exist, create it
            counter = new SequenceCounter(seqName, 1);
            mongoTemplate.insert(counter);
            return 1;
        }

        return counter.getSeq();
    }
}
