package com.zb.mapper;

import com.zb.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> getPriceList();

    Item getSingleItem(@Param("name") String name);
}
