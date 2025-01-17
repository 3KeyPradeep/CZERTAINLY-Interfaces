package com.czertainly.api.model.common.attribute.v2.content;

import com.czertainly.api.model.client.attribute.BaseAttributeContentDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

@Schema(implementation = BaseAttributeContentDto.class)
public class BaseAttributeContent<T> extends AttributeContent {
    @Schema(description = "Content Reference")
    private String reference;

    @Schema(description = "Content Data", requiredMode = Schema.RequiredMode.REQUIRED)
    private T data;

    public BaseAttributeContent() {
    }

    public BaseAttributeContent(String reference) {
        this.reference = reference;
    }

    public BaseAttributeContent(String reference, T data) {
        this.reference = reference;
        this.data = data;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        if (this == o) return true;
        BaseAttributeContent<?> that = (BaseAttributeContent<?>) o;

        if(that.reference == null) return false;
        return Objects.equals(this.reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference, data);
    }
}
