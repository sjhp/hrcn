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
    <title></title>
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
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button class="navbar-toggle collapsed" aria-expanded="false" aria-controls="navbar" type="button" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">巨商汇开放平台</a>
            </div>
            <div class="navbar-collapse collapse" id="navbar">
                <ul class="nav navbar-nav navbar-right" style="margin-right: 30%;">
                    <li><a href="#">文档</a></li>
                    <li><a href="#">API</a></li>
                    <li><a href="#">支持</a></li>
                    <li><a href="#">控制台</a></li>
                </ul>
                <form class="navbar-form navbar-right">
                    <input class="form-control" type="text" placeholder="Search...">
                </form>
            </div>
        </div>
    </nav>
    <div class="panel panel-default">
        <div class="panel-body">
            <form action="/oauth/appAuth" method="post" role="form">
                <input type="hidden" name="token_id" value="${accessToken.token_id}"/>
                <label for="name" class=" control-label" >第一步: 授权商铺</label>
                <div class="form-group clearfix" >
                   <!-- <label for="name" class="col-lg-3 control-label">填写商铺</label>-->


                            <input class="form-control" id="name" name="seller_ids" placeholder="请输入商铺ID，以逗号分隔"/>


                </div>
                <label for="name" class=" control-label" >第二步: 授权方法</label></br>
                <div class="appList" >
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>选择</th>
                            <th>方法ID</th>
                            <th>方法名称</th>
                            <th>方法URL</th>
                            <th>方法描述</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="method" items="${methodList}" varStatus="status">
                            <tr>
                                <td><input type="checkbox" name="mothodId" value="${method.method_id}"></td>
                                <td>${method.method_id}</td>
                                <td>${method.method_name}</td>
                                <td>${method.method_url}</td>
                                <td>${method.method_desc}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="form-group clearfix">
                    <input type="submit" class="btn pull-left" value="授权" id="suboauth" />
                </div>
            </form>
        </div>
    </div>
  </body>
</html>
