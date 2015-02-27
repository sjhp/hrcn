<%--

          Copyright 2010 Newcastle University

             http://research.ncl.ac.uk/smart/

    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%--@elvariable id="oauthParams" type="org.apache.oltu.oauth2.client.demo.model.OAuthParams"--%>
<style type="text/css">
    .search{width:50px;height: 20px;}
</style>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>巨商汇开放平台</title>
  </head>

  <!-- 新 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="/js/bootstrap-3.3.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/index.css">
  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script type="text/javascript" src="/js/jquery.min.js"></script>

  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="/js/bootstrap-3.3.2/js/bootstrap.min.js"></script>


  <body>
  <h4>应用名称：${app.app_name}</h4>
  <h4>应用描述：${app.app_desc}</h4>
  <h4>应用URL：${app.app_url}</h4>
  <h4>跳转地址：${app.redirect_url}</h4>
  <h4>应用角色：${app.role_id}</h4>
  </body>
</html>
