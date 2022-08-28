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
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//   1。乱码处理
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        2.得到前端的值
        String newsWhereShow = req.getParameter("newsWhereShow");
        String productWhereShow = req.getParameter("productWhereShow");
//        String newsLimit=req.getParameter("newsLimit");
//        String productLimit=req.getParameter("productLimit");
//3.封装
        HomeModel model = new HomeModel();
        model.setNewsWhereShow(Tool.strToInt(newsWhereShow));
        model.setNewsLimit(Const.HOME_NEWS_LIMIT);
        model.setProductLimit(Const.HOME_PRODUCT_LIMIT);
        model.setProductWhereShow(Tool.strToInt(productWhereShow));
//        4.调用服务逻辑层

        CompanyService companyService = new CompanyServiceImpl();
        CompanyModel companyModel = companyService.getCompanyModel();
//        req.setAttribute("companyModel", companyModel);
        NavService navService = new NavServiceImpl();
        List<NavModel> navModelList = navService.getNavList();
//        req.setAttribute("navModelList", navModelList);
//        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);

        NewsService newsService = new NewsServiceImpl();
        List<NewsModel> newsModelList = newsService.getNewsList(model);


        ProductService productService = new ProductServiceImpl();
        List<ProductModel> productModelList = productService.getProductList(model);

//        List<Object> list = new ArrayList<>();
//        list.add(companyModel);
//        list.add(navModelList);
//        list.add(newsModelList);
//        Map map=new HashMap();
//        map.put("companyModel",companyModel);
//        map.put("navModelList",navModelList);
//        map.put("newsModelList",newsModelList);
//        model.setCompanyModel(companyModel);
//        model.setNavModellist(navModelList);
//        model.setNewsModelList(newsModelList);
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("companyModel", companyModel);
//        jsonObject.put("navModelList", navModelList);
        jsonObject.put("newsModelList", newsModelList);
        resp.getWriter().println(jsonObject);
    }
}
