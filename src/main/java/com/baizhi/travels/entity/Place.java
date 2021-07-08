package com.baizhi.travels.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Place {
    private Integer sid;
    private String sname;
    private String position;
    private Integer lid;
    private Integer pid;
    private Integer collect_counts;
    private String level;
    private String sdescription;
    private String spicture;
    private String lname;
    private String pname;
}
