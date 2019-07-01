package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.vo.CartVo;

public interface ICartService {

    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> delete(String productId, Integer userId);

    ServerResponse<CartVo> list(Integer userId);

    ServerResponse<CartVo> selectOrUnselect(Integer userId, Integer productId, Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
