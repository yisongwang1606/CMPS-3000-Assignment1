package com.zb.controller;

import com.zb.service.ItemService;
import com.zb.util.ResponseResult;
import com.zb.util.SendData;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value="itemController",tags={"PriceListApi"})
@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @GetMapping("list")
    public ResponseResult priceList(){
        return ResponseResult.success(itemService.getPriceList());
    }

    @PostMapping("buy")
    public ResponseResult buy(@RequestBody SendData sendData){
        return ResponseResult.success(itemService.totalPrice(sendData));
    }
}
