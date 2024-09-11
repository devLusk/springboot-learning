package com.example.note_manager.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesRepository notesRepository;

    // Metodo para listar (GET)
    @GetMapping
    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    // Metodo para obter nota por ID (GET)
    @GetMapping("/{id}")
    public Notes getNoteById(@PathVariable Long id) {
        return notesRepository.findById(id).orElse(null);
    }

    // Metodo para criar nota (POST)
    @PostMapping
    public Notes createNote(@RequestBody Notes note) {
        return notesRepository.save(note);
    }

    // Metodo para atualizar nota (PUT)
    @PutMapping("/{id}")
    public Notes updateNote(@PathVariable Long id, @RequestBody Notes updateNote) {
        Optional<Notes> existingNoteOptional = notesRepository.findById(id);

        if (existingNoteOptional.isPresent()) {
            Notes existingNote = existingNoteOptional.get();

            existingNote.setTitle(updateNote.getTitle());
            existingNote.setContent(updateNote.getContent());

            return notesRepository.save(existingNote);
        } else {
            return null;
        }
    }

    // Metodo para deletar nota (DELETE)
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        notesRepository.deleteById(id);
    }
}