/*
package org.ncu.journalApp.controller;

import org.ncu.journalApp.entity.Journal;
import org.ncu.journalApp.repositiory.JournalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {

    private Map<Long, Journal> journal = new HashMap<>();

    @PostMapping
    public boolean createEntry(@RequestBody Journal myEntry) {   // localhost:8080/journal  POST
        journal.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping
    public List<Journal> getAll(){   // localhost:8080/journal  GET

        return new ArrayList<>(journal.values());
    }

    @GetMapping("/id/{myId}")
    public Journal getJournalById(@PathVariable Long myId){   // localhost:8080/journal/id/(myId)  GET

        return journal.get(myId);
        }

    @DeleteMapping("/id/{myId}")
    public Journal deleteJournal(@PathVariable Long myId){   // localhost:8080/journal/id/(myId)  DELETE

        return journal.remove(myId);
    }

    @PutMapping("/id/{id}")
    public Journal updateJournal(@PathVariable Long id, @RequestBody Journal myEntry){   // localhost:8080/journal/id/(id)  PUT
        return journal.put(id, myEntry);
    }
}
*/


