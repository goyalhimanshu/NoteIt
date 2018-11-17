package com.example.noteitapi.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notebook")
public class Notebook {

    @Id
    private UUID id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook", cascade = CascadeType.ALL)
    private List<Note> notes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public int getNumberOfNotes(){
        return this.notes.size();
    }
}
