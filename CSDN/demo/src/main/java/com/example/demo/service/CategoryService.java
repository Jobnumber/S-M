package com.example.demo.service;

import com.example.demo.dataobject.ProductCategory;


import java.util.List;

public interface CategoryService {

    //根据Id查询
    public ProductCategory findOne(Integer caregoryId);

    //查询所有
    public List<ProductCategory>findAll();

    //根据编号的传入查询所有匹配数据
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //更新传入数据信息进行更新
    public ProductCategory save(ProductCategory productCategory);
}
