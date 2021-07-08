package com.baizhi.travels.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class UserStrategy {
    private Integer uid;
    private Integer sid;
    private Integer tid;
    private Integer tcost;
    private String tname;
    private String tdescription;
    private String phonenumber;
    private String mymap;
    private String sname;
}
