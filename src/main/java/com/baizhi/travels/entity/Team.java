package com.baizhi.travels.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain=true)
public class Team {
    private Integer tid;
    private String tname;
    private String  phonenumber;
    private String  tdescription;
    private Integer tcost;
    private Integer sid;
    private String map;
}
