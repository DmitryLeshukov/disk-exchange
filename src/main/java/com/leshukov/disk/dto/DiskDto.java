package com.leshukov.disk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author dleshukov@alvioneurope.ru
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiskDto {

    private Long id;

    @NotBlank(message = "Enter title")
    private String title;

    @NotBlank(message = "Enter description")
    private String description;

    @Min(value = 1900, message = "Min year value must be equals or greater than 1900")
    @Max(value = 2018, message = "Max year value must be less than 2018")
    private int year;

    private UserDto owner;

    private UserDto holder;
}
