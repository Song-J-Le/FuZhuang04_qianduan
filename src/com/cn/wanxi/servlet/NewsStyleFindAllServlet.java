package com.cn.wanxi.servlet;

import com.alibaba.fastjson.JSONObject;
import com.cn.wanxi.model.CompanyModel;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.NewsStyleModel;
import com.cn.wanxi.service.CompanyService;
import com.cn.wanxi.service.NavService;
import com.cn.wanxi.service.NewsStyleService;
import com.cn.wanxi.service.impl.CompanyServiceImpl;
import com.cn.wanxi.service.impl.NavServiceImpl;
import com.cn.wanxi.service.impl.NewsStyleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/back/newsStyle/findAll")
public class NewsStyleFindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   1。乱码处理
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        2.得到前端的值
//3.封装
//        4.调用服务逻辑层
        NewsStyleService newsStyleService = new NewsStyleServiceImpl();
        List<NewsStyleModel> list = newsStyleService.getList();


        resp.getWriter().println(JSONObject.toJSONString(list));
    }
}
