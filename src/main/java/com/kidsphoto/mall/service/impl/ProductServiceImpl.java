package com.kidsphoto.mall.service.impl;

import com.kidsphoto.mall.dao.ProductRepository;
import com.kidsphoto.mall.entity.Product;
import com.kidsphoto.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李明
 * @create 2019-11-21 9:01
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

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
    public List<Product> findList(String school, int offset, int size) {

        List<Product> list = this.productRepository.findList(school, offset, size);
        return list;
    }
}
