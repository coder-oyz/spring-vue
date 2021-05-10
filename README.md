# spring-vue
spring-vue实现订餐系统

小萌神订餐系统的 项目需求和技术总结.   ( 以 txt文档形式或是xmind文档形式). 
需求：通过清晰的网页实现用户的在线订餐需求，实现菜品的浏览，实现登录、退出，登录后才可以使用加入购物车、购物车管理，保存购物车中菜品信息，下单的功能，在下单时获取联系电话，送餐地址，
以及送餐时间



使用springboot部署项目，前端使用vue+axios 使用阻止冒泡，
，后端使用MVC模式通过Controller接收请求，使用swagger自动生成api文档，在dao层使用jpa技术简单的单表操作可以直接调用Resgister
在bean使用lombok @Data注解自动生成get,set，  使用@Entity，和@Id配置jpa，使用enum记录订单状态以及返回结果的状态
