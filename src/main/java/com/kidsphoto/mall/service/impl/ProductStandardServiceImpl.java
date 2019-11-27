package com.kidsphoto.mall.service.impl;

import com.kidsphoto.mall.dao.ProductStandardRepository;
import com.kidsphoto.mall.entity.ProductStandard;
import com.kidsphoto.mall.service.ProductStandardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李明
 * @create 2019-11-27 17:29
 */
@Service
public class ProductStandardServiceImpl implements ProductStandardService {

    @Autowired
    private ProductStandardRepository productStandardRepository;

    @Override
    public void save(ProductStandard productStandard) {
        this.productStandardRepository.save(productStandard);
    }

    @Override
    public void delete(Long id) {

        this.productStandardRepository.deleteById(id);
    }

    @Override
    public List<ProductStandard> findList(String name) {
        List<ProductStandard> list = new ArrayList<>();
        if(StringUtils.isBlank(name)) {
            list = productStandardRepository.findAllList();
        } else {
            list = productStandardRepository.findList(name);
        }
        return null;
    }
}
