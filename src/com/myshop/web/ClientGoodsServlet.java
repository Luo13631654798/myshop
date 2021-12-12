package com.myshop.web;

import com.myshop.pojo.Goods;
import com.myshop.pojo.Page;
import com.myshop.service.GoodsService;
import com.myshop.service.impl.GoodsServiceImpl;
import com.myshop.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClientGoodsServlet", value = "/client/clientGoodsServlet")
public class ClientGoodsServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Goods> page = goodsService.page(pageNo,pageSize);
        page.setUrl("client/clientGoodsServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
    protected void pageByKey(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String key = req.getParameter("key");
        Page<Goods> page = goodsService.pageByKey(pageNo,pageSize,"%"+key+"%");

        StringBuilder sb = new StringBuilder("client/clientGoodsServlet?action=pageByKey");
        if(req.getParameter("key")!=null){
            sb.append("&key=").append(req.getParameter("key"));
        }
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.setAttribute("key" ,key);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
}
