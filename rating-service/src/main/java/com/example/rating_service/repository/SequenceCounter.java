package com.example.rating_service.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
public class SequenceCounter {

    @Id
    private String id;  // The name of the sequence (e.g., "your_entity_name")
    private long seq;   // The current sequence number

    // Constructor
    public SequenceCounter(String id, long seq) {
        this.id = id;
        this.seq = seq;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }
}
