package com.mall.dao.test;

import com.mall.dao.CategoryMapper;
import com.mall.pojo.Category;
import com.mall.service.impl.CategoryServiceImpl;
import com.mall.test.TestBase;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryDaoTest extends TestBase {


    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryServiceImpl iCategoryService;

    @Ignore
    @Test
    public void getCategoryChild(){
        Category d  = categoryMapper.selectByPrimaryKey(1);
        System.out.println(d);
        Category d4  = categoryMapper.selectByPrimaryKey(4);
        System.out.println(d4);
    }
    @Test
    public void testChildService(){
        iCategoryService.selectCategoryAndChildrenById(2);
    }

}
