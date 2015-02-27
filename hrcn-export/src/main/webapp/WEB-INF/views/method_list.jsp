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


  <style>
      .appList {margin-top: 10px;}
  </style>

  <body>
  <div class="panel panel-default">
      <div class="panel-body">
          <div class="createApp">
              <button type="button" class="btn" onclick="window.location.href='/oauth/addMethod'">创建新方法</button>
          </div>

          <div class="appList" >
              <table class="table table-bordered">
                  <thead>
                      <tr>
                          <th>序号</th>
                          <th>方法ID</th>
                          <th>方法名称</th>
                          <th>方法URL</th>
                          <th>方法描述</th>
                          <th>所属角色</th>
                          <th>操作</th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="method" items="${methodList}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td>${method.method_id}</td>
                            <td>${method.method_name}</td>
                            <td>${method.method_url}</td>
                            <td>${method.method_desc}</td>
                            <td>${method.role_name}</td>
                            <td><a href="#">修改</a></td>
                        </tr>
                      </c:forEach>
                  </tbody>
              </table>
          </div>
      </div>
  </div>
  </body>
</html>
