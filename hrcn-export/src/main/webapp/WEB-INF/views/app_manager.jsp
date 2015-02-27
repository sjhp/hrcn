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
  <style>
      #main-nav {
          margin-left: 1px;
      }

      #main-nav.nav-tabs.nav-stacked > li > a {
          padding: 10px 8px;
          font-size: 12px;
          font-weight: 600;
          color: #4A515B;
          background: #E9E9E9;
          background: -moz-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
          background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FAFAFA), color-stop(100%,#E9E9E9));
          background: -webkit-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
          background: -o-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
          background: -ms-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
          background: linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
          filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9');
          -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9')";
          border: 1px solid #D5D5D5;
          border-radius: 4px;
      }
      #main-nav.nav-tabs.nav-stacked > li > a > span {
          color: #4A515B;
      }
      #main-nav.nav-tabs.nav-stacked > li.active > a, #main-nav.nav-tabs.nav-stacked > li > a:hover {
          color: #FFF;
          background: #3C4049;
          background: -moz-linear-gradient(top, #4A515B 0%, #3C4049 100%);
          background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#4A515B), color-stop(100%,#3C4049));
          background: -webkit-linear-gradient(top, #4A515B 0%,#3C4049 100%);
          background: -o-linear-gradient(top, #4A515B 0%,#3C4049 100%);
          background: -ms-linear-gradient(top, #4A515B 0%,#3C4049 100%);
          background: linear-gradient(top, #4A515B 0%,#3C4049 100%);
          filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049');
          -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049')";
          border-color: #2B2E33;
      }
      #main-nav.nav-tabs.nav-stacked > li.active > a, #main-nav.nav-tabs.nav-stacked > li > a:hover > span {
          color: #FFF;
      }
      #main-nav.nav-tabs.nav-stacked > li {
          margin-bottom: 4px;
      }
      /*定义二级菜单样式*/
      .secondmenu a {
          font-size: 10px;
          color: #4A515B;
          text-align: center;
      }
      .navbar-static-top {
          background-color: #212121;
          margin-bottom: 5px;
      }
      .navbar-brand {
          background: url('') no-repeat 10px 8px;
          display: inline-block;
          vertical-align: middle;
          padding-left: 50px;
          color: #fff;
      }
  </style>
  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
  <script type="text/javascript" src="/js/jquery.min.js"></script>

  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="/js/bootstrap-3.3.2/js/bootstrap.min.js"></script>

  <script type="text/javascript">
     var app_key = '<c:out value="${app.app_key}"/>';
     function baseMes(){
         $.ajax({
             type: "post",
             url: '/oauth/appBaseInfo',
             data: 'app_key='+app_key,
             dataType:'html',
             success: function(html){
                 $("#mainContent").html(html);
             }
         });
     }
     function appCert(){
         $.ajax({
             type: "post",
             url: '/oauth/appCert',
             data: 'app_key='+app_key,
             dataType:'html',
             success: function(html){
                 $("#mainContent").html(html);
             }
         });
     }
     function addRole(){
         $.ajax({
             type: "get",
             url: '/oauth/addRole',
             dataType:'html',
             success: function(html){
                 $("#mainContent").html(html);
             }
         });
     }

     function methodList(){
         $.ajax({
             type: "post",
             url: '/oauth/methodManage',
             data: 'app_key='+app_key,
             dataType:'html',
             success: function(html){
                 $("#mainContent").html(html);
             }
         });
     }

     function roleList() {
         $.ajax({
             type: "post",
             url: '/oauth/roleManage',
             data: 'app_key='+app_key,
             dataType:'html',
             success: function(html){
                 $("#mainContent").html(html);
             }
         });
     }

     function appAuth() {
         $.ajax({
             type: "get",
             url: '/oauth/appAuth',
             data: 'app_key='+app_key,
             dataType:'html',
             success: function(html){
                 $("#mainContent").html(html);
             }
         });
     }

  </script>

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

  <div class="container-fluid">
      <div class="row">
          <div class="col-md-2">
              <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
                  <li class="active">
                      <a href="/oauth/index">
                          <i class="glyphicon glyphicon-th-large"></i>
                          首页
                      </a>
                  </li>
                  <li>
                      <a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
                          <i class="glyphicon glyphicon-cog"></i>
                          应用设置
                          <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                      </a>
                      <ul id="systemSetting" class="nav nav-list collapse secondmenu" style="height: 0px;">
                          <li><a href="#" class="active" onclick="baseMes();"><i class="glyphicon glyphicon-user"></i>基本信息</a></li>
                          <li><a href="#" onclick="appCert();"><i class="glyphicon glyphicon-th-list"></i>应用证书</a></li>
                          <li><a href="#" onclick="appAuth();"><i class="glyphicon glyphicon-asterisk"></i>授权管理</a></li>
                      </ul>
                  </li>
                  <li>
                      <a href="#reports" class="nav-header collapsed" data-toggle="collapse">
                          <i class="glyphicon glyphicon-cog"></i>
                          报表中心
                          <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                      </a>
                      <ul id="reports" class="nav nav-list collapse secondmenu" style="height: 0px;">
                          <li><a href="#"><i class="glyphicon glyphicon-user"></i>API调用详情</a></li>
                          <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>API调用量</a></li>
                          <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>IP调用详情</a></li>
                      </ul>
                  </li>
                  <li>
                      <a href="#roleset" class="nav-header collapsed" data-toggle="collapse">
                          <i class="glyphicon glyphicon-cog"></i>
                          角色设置
                          <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                      </a>
                      <ul id="roleset" class="nav nav-list collapse secondmenu" style="height: 0px;">
                          <li><a href="#" onclick="roleList();"><i class="glyphicon glyphicon-user"></i>角色管理</a></li>
                          <li><a href="#" onclick="methodList();"><i class="glyphicon glyphicon-th-list"></i>方法管理</a></li>
                      </ul>
                  </li>
              </ul>
          </div>
          <div class="col-md-10">
              <div class="pathNav">
                  <ol class="breadcrumb">
                      <li><a href="#">控制台</a></li>
                      <li><a href="#">应用设置</a></li>
                      <li class="active">基本信息</li>
                  </ol>
              </div>
              <div id="mainContent">
                  <%@ include file="app_base_info.jsp" %>
              </div>
          </div>
      </div>
  </div>
  </body>
</html>
