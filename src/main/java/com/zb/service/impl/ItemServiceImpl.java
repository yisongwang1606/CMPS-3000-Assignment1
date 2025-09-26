package com.zb.service.impl;

import com.zb.entity.Item;
import com.zb.entity.ItemCount;
import com.zb.mapper.ItemMapper;
import com.zb.service.ItemService;
import com.zb.util.SendData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public List<Item> getPriceList() {
        List<Item> priceList = itemMapper.getPriceList();
        return priceList;
    }

    @Override
    public Double totalPrice(SendData sendData) {

        Double totalPrice = 0.0;


        if (membershipCheck(sendData.getMembershipStatus())){
            for (ItemCount items : sendData.getCount()){
                if (countCheck(items.getCount())){
                    if (promotionCheck(items.getPromotion())){
                        Double promotion= Double.parseDouble(items.getPromotion());
                        totalPrice = totalPrice + items.getCount() * (items.getPrice() - promotion);
                    }else {
                        totalPrice = totalPrice + items.getCount() * items.getPrice();
                    }
                }else {
                    totalPrice = totalPrice + items.getCount() * items.getPrice();
                }
            }
            return totalPrice;
        }else {
            for (ItemCount items : sendData.getCount()){
                totalPrice = totalPrice + items.getCount() * items.getPrice();
            }
            return totalPrice;
        }
    }

    private boolean membershipCheck(String membership){
        if (membership.equals("true")){
            return true;
        }
        return false;
    }

    private boolean countCheck(Integer count){
        if (count>2){
            return true;
        }
        return false;
    }

    private boolean promotionCheck(String hasPromotion){
        if (hasPromotion != null){
            return true;
        }
        return false;
    }

}
