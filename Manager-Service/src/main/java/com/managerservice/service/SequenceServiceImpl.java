package com.managerservice.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.managerservice.entity.Sequence;

@Service
public class SequenceServiceImpl {
	 @Autowired
	    private MongoOperations mongoOperations;

	    public int getSequenceNumber(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq", 1);
	        //modify in document
	        Sequence counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        Sequence.class);

	        return !Objects.isNull(counter) ? counter.getSeq() : 1;
	       // return !Objects.isNull(counter)?counter.getSeq(): 1;
	    }
}
