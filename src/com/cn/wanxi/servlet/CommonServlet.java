package com.cn.wanxi.servlet;

import com.alibaba.fastjson.JSONObject;
import com.cn.wanxi.model.CompanyModel;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.service.CompanyService;
import com.cn.wanxi.service.NavService;
import com.cn.wanxi.service.impl.CompanyServiceImpl;
import com.cn.wanxi.service.impl.NavServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/common")
public class CommonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //   1。乱码处理
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        2.得到前端的值
//3.封装
//        4.调用服务逻辑层
        CompanyService companyService = new CompanyServiceImpl();
        CompanyModel companyModel = companyService.getCompanyModel();
        NavService navService = new NavServiceImpl();
        List<NavModel> navModelList = navService.getNavList();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("companyModel", companyModel);
        jsonObject.put("navModelList", navModelList);

        resp.getWriter().println(jsonObject);
    }
}
