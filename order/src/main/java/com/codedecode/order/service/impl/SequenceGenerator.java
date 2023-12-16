package com.codedecode.order.service.impl;

import com.codedecode.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.query.Update;

@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOrderId(){
        Sequence counter = mongoOperations.findAndModify(
                query(where("_id").is("sequence")),
                new Update().inc("sequence", 1),
                options().returnNew(true).upsert(true),
                Sequence.class);
        return counter.getSequence();
        }
    }
/**
 * findAndModify: this method is used to find a document and modify it in a single atomic operation.
 * this method take four parameters.
 * i)query,ii)update,iii)options,iv)entity
 * i) query(where("_id").is("sequence")) ---> this specifies the query criteria.it is uses the where method to define the condition and
 * is to specify the value of the _id field.in this case it searches for a document with the _id equal to "sequence".
 * ii) new Update().inc("sequence", 1) ---> the inc method increments the value of the "sequence" field by 1.it creates a new Update obj
 * and specifies the field to update and increment value.
 * iii)options().returnNew(true).upsert(true) ---> here returnNew(true) options indicate that the modified document should be returned
 * as the result.the upsert(true) option specifies that if the document matching the query is not found ,a new document should be created.
 * Sequence.class --> class type of the document.
 */




