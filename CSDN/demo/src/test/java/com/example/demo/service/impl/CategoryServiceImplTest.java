package com.example.demo.service.impl;

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
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory=categoryService.findOne(1);
        System.out.println("productCategory = " + productCategory);
        Assert.assertEquals(1,new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList=categoryService.findAll();
        for(ProductCategory productCategory:productCategoryList){
            System.out.println("================ = " + "================");
            System.out.println("productCategory = " + productCategory);
        }
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory>productCategoryList=categoryService.findByCategoryTypeIn( Arrays.asList(1,2,3));
        for(ProductCategory productCategory:productCategoryList){
            System.out.println("================ = " + "================");
            System.out.println("productCategory = " + productCategory);
        }
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryType(2);
        productCategory.setCategoryName("黑科技榜单");
        ProductCategory productCategory1=categoryService.save(productCategory);
        System.out.println("productCategory1 = " + productCategory1);
        Assert.assertNotNull(productCategory1);
    }
}