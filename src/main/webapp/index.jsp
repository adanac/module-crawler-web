<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Test</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="RES/css/common.css" />
	<script type="text/javascript" src="RES/js/jquery.min.js"></script>
	<script type="text/javascript" src="RES/js/craw.js"></script>
	
  </head>
  
  <body>
    	<div class="container">
    			<fieldset>
				    <legend>数据抓取</legend>
				    <button id="crawl" onclick="crawl()">抓取网易新闻头条</button>
		    		<select id="category">
		    			<option value="photo">图片</option>
		    			<option value="shehui">社会</option>
		    			<option value="domestic">国内</option>
		    			<option value="world">国际</option>
		    		</select>
				</fieldset>
				<fieldset>
				    <legend>Lucene操作</legend>
				    <button id="indexFiles" onclick="indexFiles()">查看所有文件</button>
				    <button id="deleteIndexes" onclick="deleteIndexes()">删除索引</button>
				    <button id="listIndexes" onclick="listIndexes()">列出所有索引数据</button>
				    <textarea id="keyword"></textarea>
				   <button id="search" onclick="search()">查询</button>
				</fieldset>
				<fieldset>
				    <legend>IKAnalyzer中文分词</legend>
				    <textarea id="content"></textarea>
				    <input type="checkbox" id="isMaxLength" ><label for="isMaxLength" style="font-size:15;">最大长度分词？</label><button id="split" onclick="split()">查询</button>
				</fieldset>
    	</div>
    	<div class="container2">
				<div id="tip">...</div>
    			<div id="show"></div>
		</div>
  </body>
</html>
