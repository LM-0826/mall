package com.kidsphoto.mall.service.impl;

import com.kidsphoto.mall.dao.ProductRepository;
import com.kidsphoto.mall.dao.ProductStandardRepository;
import com.kidsphoto.mall.entity.Product;
import com.kidsphoto.mall.entity.ProductStandard;
import com.kidsphoto.mall.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李明
 * @create 2019-11-21 9:01
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStandardRepository productStandardRepository;

    @Override
    @Transactional
    public void save(Product product) {

        this.productRepository.save(product);
    }

    @Override
    public Product findDetail(Long productId) {
        return this.productRepository.findProduct(productId);
    }

    @Override
    @Transactional
    public void delete(Long productId) {
        this.productRepository.deleteById(productId);
    }

    @Override
    public Map<String, Object>  findList(String school, int offset, int size) {

        Map<String, Object> map = new HashMap<>();
        int count = this.productRepository.findCount(school);
        List<Product> list = this.productRepository.findList(school, offset, size);
        map.put("list", list);
        map.put("count", count);
        return map;
    }

    @Override
    public Map<String, Object> goodsList(String school) {

        Map<String, Object> map = new HashMap<>();
        List<String> productType = productStandardRepository.findProductTypeBySchool(school);
        for(int i = 0; productType.size() > i; i++) {
           if(StringUtils.isNoneBlank(productType.get(i))) {
               List<ProductStandard> list = productStandardRepository.findTaoCanList(school, productType.get(i));
               map.put(productType.get(i), list);
           }
        }
        List<Product> list = productRepository.findBySchool(school);
        map.put("单品", list);

        return map;
    }

    @Override
    public List<Product> findHaveStandard(String schoolName) {

        List<Product> list = productRepository.findHaveStandard(schoolName);
        return list;
    }
}
