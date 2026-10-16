package ru.itmo.highload.itemsservicehw1.item;

import jakarta.validation.constraints.NotBlank;

public record ItemRequest(@NotBlank String name, String description) {
}
