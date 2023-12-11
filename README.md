# 出租房屋管理系统设计
java课设，主题设计一个出租房屋管理系统，要求使用到简单的java设计以及数据库的应用

```
RentManagementSystem
|-- src
|   |-- com.yourcompany.rent
|       |-- model
|           |-- Tenant.java          # 租户信息实体类
|       |-- dao
|           |-- TenantDAO.java       # 数据库操作接口
|           |-- TenantDAOImpl.java   # 数据库操作实现
|       |-- service
|           |-- TenantService.java   # 业务逻辑接口
|           |-- TenantServiceImpl.java   # 业务逻辑实现
|       |-- gui
|           |-- MainForm.java        # 主界面
|           |-- AddTenantForm.java   # 添加租户界面
|           |-- EditTenantForm.java  # 编辑租户界面
|       |-- util
|           |-- DBUtil.java          # 数据库连接工具类
|-- lib
|   |-- mysql-connector-java-x.x.xx.jar   # MySQL JDBC 驱动
|-- resources
|   |-- sql
|       |-- create_tables.sql     # 创建数据库表的SQL脚本
|-- test
|   |-- com.yourcompany.rent
|       |-- dao
|           |-- TenantDAOTest.java   # 数据库操作测试
|       |-- service
|           |-- TenantServiceTest.java   # 业务逻辑测试
|-- README.md   # 项目说明文档
|-- LICENSE     # 项目许可证

```

