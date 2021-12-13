# 电商网站代码

学号：201930342486 姓名：罗奕城，
测试账号：admin，密码：123456
项目部署网址：http://120.25.216.49/myshop_war_exploded/
代码包括web文件夹和src文件夹。
web文件夹中，pages文件夹存放前端JSP页面，static文件夹存放CSS样式表以及静态资源（如图片），WEB-INF文件夹存放本项目需要用到的库的jar包以及xml配置文件。
src文件夹中，pojo包实现了七个类定义（购物车类、购物车商品项类、商品类、订单类、订单项类、页面类、用户类）；utils包定义了JdbcUtils类及WebUtils类，这两个工具类分别用于封装数据库基本操作及获取网页参数的基本操作；dao包定义并实现了四个dao接口类（GoodsDao、OrderDao、OrderItemDao、OrderItemDao、UserDao）这四个类分别用于实现对应数据库表的增删改查等操作；service包定义了并实现了三个接口类（GoodsService、OrderService、UserService），这三个类用于获取前端页面参数并调用dao层后处理相关业务；filter包实现了两个过滤器（ManagerFilter、TransactionFilter），用于访问控制及数据库事务提交及回滚；web包用于实现Servlet程序（BaseServlet、CartServlet、ClientGoodsServlet、GoodsServlet、LoginServlet、OrderServlet、RegistServlet、UserServlet）；test包则用于开发过程中用于测试。
