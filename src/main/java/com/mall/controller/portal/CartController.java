package com.mall.controller.portal;

import com.mall.common.Const;
import com.mall.common.ResponseCode;
import com.mall.common.ServerResponse;
import com.mall.service.ICartService;
import com.mall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mall.pojo.User;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<CartVo> list(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.list(user.getId());
    }

    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse<CartVo> add(Integer count, Integer productId, HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.add(user.getId(), productId, count);
    }

    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse<CartVo> update(Integer count, Integer productId, HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.update(user.getId(), productId, count);
    }

    @RequestMapping("delete.do")
    @ResponseBody
    public ServerResponse<CartVo> deleteProduct(String productId, HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.delete(productId, user.getId());
    }

    @RequestMapping("select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> selectAll(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.selectOrUnselect(user.getId(), null, Const.Cart.CHECKED);
    }

    @RequestMapping("unselect_all.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelectAll(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.selectOrUnselect(user.getId(), null, Const.Cart.UNCHECKED);
    }

    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse<CartVo> select(HttpSession httpSession, Integer productId){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.selectOrUnselect(user.getId(), productId, Const.Cart.CHECKED);
    }

    @RequestMapping("unselect.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelect(HttpSession httpSession, Integer productId){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return iCartService.selectOrUnselect(user.getId(), productId, Const.Cart.UNCHECKED);
    }

    @RequestMapping("get_cart_product_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession httpSession){
        User user = (User) httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createBySuccess(0);
        }

        return iCartService.getCartProductCount(user.getId());
    }
}
