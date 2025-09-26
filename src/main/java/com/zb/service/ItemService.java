package com.zb.service;

import com.zb.entity.Item;
import com.zb.util.SendData;

import java.util.List;


public interface ItemService {

    List<Item> getPriceList();

    Double totalPrice(SendData sendData);

}
