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
public class UserDto {

    private Long id;

    private String lastName;

    private String firstName;

    private String middleName;
}
