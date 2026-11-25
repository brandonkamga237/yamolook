package com.brandonkamga.yamolook.library.domain.model;

import java.util.Locale;
import java.util.Objects;

import com.brandonkamga.yamolook.library.domain.exception.InvalidLibraryNameException;

public record LibraryName(
    String value,
    String normalizeValue
) {
    
    public LibraryName(String value) {
        this(validateAndKeep(value), normalize(value));
    }

    public LibraryName {

        Objects.requireNonNull(value);
        Objects.requireNonNull(normalizeValue);
    }

    private static String validateAndKeep( String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidLibraryNameException("value must be not null");
        }

        return value;
    }

    private static String normalize(String value) {
        return value.trim()
                    .replace("\\s+", " ")
                    .toLowerCase(Locale.ROOT);

    }

}
