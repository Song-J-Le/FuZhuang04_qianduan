package com.cn.wanxi.service;

import com.cn.wanxi.VO.HomeModel;
import com.cn.wanxi.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> getProductList(HomeModel model);
}
