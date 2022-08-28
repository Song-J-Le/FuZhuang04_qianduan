package com.cn.wanxi.servlet;

import com.alibaba.fastjson.JSONObject;
import com.cn.wanxi.VO.HomeModel;
import com.cn.wanxi.model.CompanyModel;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.service.CompanyService;
import com.cn.wanxi.service.NavService;
import com.cn.wanxi.service.NewsService;
import com.cn.wanxi.service.ProductService;
import com.cn.wanxi.service.impl.CompanyServiceImpl;
import com.cn.wanxi.service.impl.NavServiceImpl;
import com.cn.wanxi.service.impl.NewsServiceImpl;
import com.cn.wanxi.service.impl.ProductServiceImpl;
import com.cn.wanxi.util.Const;
import com.cn.wanxi.util.Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/back/news/newsStyleId")
public class NewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   1。乱码处理
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String newsStyleId=req.getParameter("newsStyleId");
        String page=req.getParameter("page");
        String limit=req.getParameter("limit");
        NewsModel newsModel=new NewsModel();
        newsModel.setNewsStyleId(Tool.strToInt(newsStyleId));
        newsModel.setLimit(Tool.strToLimit(limit));
        newsModel.setPage(Tool.strToPage(page));

        NewsService newsService=new NewsServiceImpl();
        List<NewsModel> list=newsService.getNewsListForNewsPage(newsModel);
        resp.getWriter().println(JSONObject.toJSONString(list));
    }
}
