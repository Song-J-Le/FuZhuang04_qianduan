package com.cn.wanxi.servlet;

import com.alibaba.fastjson.JSONObject;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.NewsService;
import com.cn.wanxi.service.impl.NewsServiceImpl;
import com.cn.wanxi.util.Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/back/newsDetail/findById")
public class NewsDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   1。乱码处理
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        2.得到前端的值
        String id=req.getParameter("id");
        NewsModel model=new NewsModel();
        model.setId(Tool.strToInt(id));
//3.封装
//        4.调用服务逻辑层
        NewsService newsService=new NewsServiceImpl();
        List<NewsModel> list=newsService.getNewsDetailList(model);
        resp.getWriter().println(JSONObject.toJSONString(list));
    }
}
