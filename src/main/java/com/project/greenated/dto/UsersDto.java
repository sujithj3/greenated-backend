package com.project.greenated.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private Integer userId;
    private String name;
    private String email;
    private Integer roleId;
    private Integer parentId;
}