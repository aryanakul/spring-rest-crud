package com.spring.rest.crud.item.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {

    private Integer id;
    @NotEmpty
    private String name;
    private String desc;
}
