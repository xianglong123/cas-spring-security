package com.cas.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cas.bean.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/23 11:27 上午
 * @desc
 */
@Mapper
public interface MenuMapper extends BaseMapper<SysMenu> {
    List<String> selectPermsByUserId(Long id);
}
