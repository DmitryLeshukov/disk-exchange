package com.leshukov.disk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 * @author dleshukov@alvioneurope.ru
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdDto {
    private Long id;
}
