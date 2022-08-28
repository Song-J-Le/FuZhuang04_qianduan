package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.CompanyDao;
import com.cn.wanxi.dao.impl.CompanyImpl;
import com.cn.wanxi.model.CompanyModel;
import com.cn.wanxi.service.CompanyService;
import redis.clients.jedis.Jedis;

public class CompanyServiceImpl implements CompanyService {
    @Override
    public CompanyModel getCompanyModel() {
        CompanyDao companyDao = new CompanyImpl();
// 如果有大量访问对象，则第一次访问数据库，然后将数据存入redis
//        如果是第二次访问，则直接在redis里面去取数据
//        怎么判断它是第一次访问或者第二次访问？
        CompanyModel companyModel = new CompanyModel();
//        怎么拿到redis？
        Jedis jedis = new Jedis();
        boolean isHave = jedis.exists("address");
        if (isHave) {
            companyModel.setAddress(jedis.get("address"));
            companyModel.setPhone(jedis.get("phone"));
            companyModel.setNet(jedis.get("net"));
            companyModel.setLogo(jedis.get("logo"));
            companyModel.setEmail(jedis.get("email"));
            companyModel.setVersion(jedis.get("version"));
            companyModel.setLinePhone(jedis.get("linePhone"));
            System.out.println("jedis");
        } else {
            companyModel = companyDao.getCompanyModel();
            jedis.set("address", companyModel.getAddress());
//            jedis.expire("address",100);
//            jedis.setex("address",100,companyModel.getAddress());
            jedis.set("logo", companyModel.getLogo());
            jedis.set("phone", companyModel.getPhone());
            jedis.set("net", companyModel.getNet());
            jedis.set("email", companyModel.getEmail());
            jedis.set("version", companyModel.getVersion());
            jedis.set("linePhone", companyModel.getLinePhone());
            System.out.println("mysql");
        }
        return companyModel;
    }
}
