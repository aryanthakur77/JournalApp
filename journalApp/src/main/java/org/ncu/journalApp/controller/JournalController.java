
package org.ncu.journalApp.controller;

import org.ncu.journalApp.entity.Journal;
import org.ncu.journalApp.repositiory.JournalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    private final JournalRepository repo;

    public JournalController(JournalRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public void createEntry(@RequestBody Journal journal) {

        repo.save(journal);
    }

    @PostMapping("/batchInsert")
    public void batchInsert(@RequestBody List<Journal> journals) {
        repo.batchInsertRecords(journals);
    }

    @GetMapping
    public List<Journal> getAll() {
        return repo.findAll();
    }


    @GetMapping("/id/{id}")
    public Journal getJournalById(@PathVariable int id) {
        return repo.findById(id);
    }

    @PutMapping("/id/{id}")
    public void updateJournal(@PathVariable int id, @RequestBody Journal journal) {
        journal.setId(id);
        repo.update(journal);
    }

    @DeleteMapping("/id/{id}")
    public void deleteJournal(@PathVariable int id) {
        repo.deleteById(id);
    }
}






