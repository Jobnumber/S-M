package com.example.demo.dao;

import com.example.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    /*查询*/
    @Test
    public void findOne(){
        ProductCategory productCategory=productCategoryDao.findById(1).get();
        Assert.assertNotNull(productCategory);
        System.out.println("productCategory = " + productCategory);
    }

    /*测试新增数据*/
    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("最佳科技榜单");
        productCategory.setCategoryType(1);
        productCategoryDao.save(productCategory);
    }

    /*测试更新*/
    @Test
    public void updateTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("科技榜单");
        productCategory.setCategoryType(10);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer>lists= Arrays.asList(1,2,3);

        List<ProductCategory> result=productCategoryDao.findByCategoryTypeIn(lists);
        Assert.assertNotEquals(0,result.size());
    }

}