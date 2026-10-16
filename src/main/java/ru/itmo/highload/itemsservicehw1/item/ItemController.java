package ru.itmo.highload.itemsservicehw1.item;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@Valid @RequestBody ItemRequest request) {
        return repository.create(request);
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable long id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable long id, @Valid @RequestBody ItemRequest request) {
        return repository.update(id, request).orElseThrow(() -> new ItemNotFoundException(id));
    }
}
