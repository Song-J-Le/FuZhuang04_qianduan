package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.impl.NavImpl;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.service.NavService;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

public class NavServiceImpl implements NavService {
    @Override
    public List<NavModel> getNavList() {
        Jedis jedis = new Jedis();
        List<NavModel> list = new ArrayList<>();
//        同步锁:单线程
        synchronized ("A") {
            boolean isHave = jedis.exists("navHref");
            if (isHave) {
                List<String> navHrefList = jedis.lrange("navHref", 0, jedis.llen("navHref"));
                List<String> navTitleList = jedis.lrange("navTitle", 0, jedis.llen("navTitle"));
                for (int i = 0; i < 5; i++) {
                    NavModel navModel = new NavModel();
                    navModel.setTitle(navTitleList.get(i));
                    navModel.setHref(navHrefList.get(i));
                    list.add(navModel);
                }
                System.out.println("navRedis");
            } else {
                NavDao navDao = new NavImpl();
                list = navDao.getNavList();
//            jedis.set("", list);
                for (int i = 0; i < list.size(); i++) {
                    jedis.rpush("navHref", list.get(i).getHref());
                    jedis.rpush("navTitle", list.get(i).getTitle());
//                jedis.rpush("navList", list.toString());
                }
                System.out.println("navMysql");
            }
        }
        return list;
    }
}
