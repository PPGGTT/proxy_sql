package com.pgt.proxy_sql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pgt.proxy_sql.bean.Country;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyMapper extends BaseMapper<Country> {
}
