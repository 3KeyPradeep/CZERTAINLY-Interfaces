package com.czertainly.api.model.core.cryptography.tokenprofile;

import com.czertainly.api.model.common.NameAndUuidDto;
import com.czertainly.api.model.connector.cryptography.enums.TokenInstanceStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class TokenProfileDto extends NameAndUuidDto {
    @Schema(
            description = "Description of Token Profile"
    )
    private String description;

    @Schema(
            description = "UUID of Token Instance",
            required = true
    )
    private String tokenInstanceUuid;

    @Schema(
            description = "Name of Token instance",
            required = true
    )
    private String tokenInstanceName;

    @Schema(
            description = "Token Instance Status",
            required = true
    )
    private TokenInstanceStatus tokenInstanceStatus;

    @Schema(
            description = "Enabled flag - true = enabled; false = disabled",
            required = true
    )
    private Boolean enabled;
}
