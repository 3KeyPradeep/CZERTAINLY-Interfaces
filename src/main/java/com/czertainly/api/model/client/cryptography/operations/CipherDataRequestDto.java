package com.czertainly.api.model.client.cryptography.operations;

import com.czertainly.api.model.client.attribute.RequestAttributeDto;
import com.czertainly.api.model.common.attribute.v2.MetadataAttribute;
import com.czertainly.api.model.connector.cryptography.operations.data.CipherRequestData;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CipherDataRequestDto {

    @Schema(
            description = "List of cipher Attributes",
            required = true
    )
    private List<RequestAttributeDto> cipherAttributes;

    @Schema(
            description = "Encrypted/decrypted data",
            required = true
    )
    private List<CipherRequestData> cipherData;

}
