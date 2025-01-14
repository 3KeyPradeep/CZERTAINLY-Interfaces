package com.czertainly.api.model.common.collection;

import com.czertainly.api.exception.ValidationError;
import com.czertainly.api.exception.ValidationException;
import com.czertainly.api.model.common.attribute.v2.content.BaseAttributeContent;
import com.czertainly.api.model.common.attribute.v2.content.StringAttributeContent;
import com.czertainly.api.model.core.cryptography.key.KeyUsage;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DigestAlgorithm {
    SHA_1(1,"SHA-1", "Secure hash algorithm 1", "SHA1"),
    SHA_224(2,"SHA-224", "Secure hash algorithm 2 with digest length of 224 bits", "SHA224"),
    SHA_256(1, "SHA-256", "Secure hash algorithm 2 with digest length of 256 bits", "SHA256"),
    SHA_384(2, "SHA-384", "Secure hash algorithm 2 with digest length of 384 bits", "SHA384"),
    SHA_512(3, "SHA-512", "Secure hash algorithm 2 with digest length of 512 bits", "SHA512"),
    SHA3_256(4, "SHA3-256", "Secure hash algorithm 3 with digest length of 256 bits", "SHA3-256"),
    SHA3_384(5, "SHA3-384", "Secure hash algorithm 3 with digest length of 384 bits", "SHA3-384"),
    SHA3_512(6, "SHA3-512", "Secure hash algorithm 3 with digest length of 512 bits", "SHA3-512");

    private static final DigestAlgorithm[] VALUES;

    static {
        VALUES = values();
    }

    private final int id;
    private final String name;
    private final String description;
    private final String providerName;

    DigestAlgorithm(int id, String name, String description, String providerName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.providerName = providerName;
    }

    public int getId() {
        return id;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getProviderName() {
        return providerName;
    }

    @Override
    public String toString() {
        return name();
    }

    public static DigestAlgorithm valueOf(int id) {
        DigestAlgorithm item = resolve(id);
        if (item == null) {
            throw new IllegalArgumentException("No matching constant for [" + id + "]");
        }
        return item;
    }

    @Nullable
    public static DigestAlgorithm resolve(int id) {
        // Use cached VALUES instead of values() to prevent array allocation.
        for (DigestAlgorithm item : VALUES) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }

    @JsonCreator
    public static DigestAlgorithm findByCode(String code) {
        return Arrays.stream(DigestAlgorithm.values())
                .filter(k -> k.name.equals(code))
                .findFirst()
                .orElseThrow(() ->
                        new ValidationException(ValidationError.create("Unknown code {}", code)));
    }

    public static List<BaseAttributeContent> asStringAttributeContentList() {
        return List.of(values()).stream()
                .map(item -> new StringAttributeContent(item.name(), item.getName()))
                .collect(Collectors.toList());
    }

    public static List<BaseAttributeContent> asStringAttributeContentWithIdReferenceList() {
        return List.of(values()).stream()
                .map(item -> new StringAttributeContent(Integer.toString(item.getId()), item.getName()))
                .collect(Collectors.toList());
    }
}
