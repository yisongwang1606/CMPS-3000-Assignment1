package com.zb.util;


import com.zb.entity.ItemCount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendData {

    private String membershipStatus;

    private List<ItemCount> count;
}
