package com.czertainly.api.model.core.audit;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class AuditLogResponseDto {
	
	@Schema(
            description = "Page number",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private int page;
	
	@Schema(
            description = "Size of the data per page",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private int size;
	
	@Schema(
            description = "Number of pages",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private int totalPages;
	
	@Schema(
            description = "Audit log items",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private List<AuditLogDto> items;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<AuditLogDto> getItems() {
        return items;
    }

    public void setItems(List<AuditLogDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("page", page)
                .append("size", size)
                .append("totalPages", totalPages)
                .append("items", items)
                .toString();
    }
}
