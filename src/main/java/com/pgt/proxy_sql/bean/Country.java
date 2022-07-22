package com.pgt.proxy_sql.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("countries")
public class Country {
    private String countryId;

    private String countryName;

    @TableId
    private Integer regionId;

}
