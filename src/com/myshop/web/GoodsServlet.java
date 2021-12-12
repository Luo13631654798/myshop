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
import java.util.List;

@WebServlet(name = "GoodsServlet",value = "/manager/goodsServlet")
public class GoodsServlet extends BaseServlet {
    private GoodsService goodsService = new GoodsServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Goods goods = WebUtils.copyParamToBean(req.getParameterMap(),new Goods());
            goodsService.addGoods(goods);
//            req.getRequestDispatcher("/manager/goodsServlet?action=list").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/manager/goodsServlet?action=page");

    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"),0);
        goodsService.deleteGoodsById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/goodsServlet?action=page");

    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = WebUtils.copyParamToBean(req.getParameterMap(), new Goods());
        goodsService.updateGoods(goods);
        resp.sendRedirect(req.getContextPath()+"/manager/goodsServlet?action=page");

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goods = goodsService.queryGoods();
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("/pages/manager/goods_manager.jsp").forward(req,resp);

    }

    protected void getGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            int id = WebUtils.parseInt(req.getParameter("id"),0);
        Goods goods = goodsService.queryGoodsById(id);
        req.setAttribute("goods",goods);
            req.getRequestDispatcher("/pages/manager/goods_edit.jsp").forward(req,resp);

    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Goods> page = goodsService.page(pageNo,pageSize);
        page.setUrl("manager/goodsServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/goods_manager.jsp").forward(req,resp);

    }
}
