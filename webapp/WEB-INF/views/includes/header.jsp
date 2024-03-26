<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>OMG</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	<link rel="stylesheet" href="/resources/css/reset.css">
	<link rel="stylesheet" href="/resources/css/common.css">
	<link rel="stylesheet" href="/resources/css/index.css">
	<link rel="stylesheet" href="/resources/css/admin.css">
	<link rel="stylesheet" href="/resources/css/member.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="/resources/js/script.js"></script>
</head>
<body>
	<header>
		<nav class="wrap">
			<div class="content header">
			<h1><a href="/">OMG</a></h1>
			<a href="#" id="trigger">
				<span></span>
				<span></span>
				<span></span>
			</a>
			
			<ul id="main-menu">
				<li>
					<a href="#">소개</a>
				</li>
				<li>
					<a href="#">서비스1</a>
				</li>
				<li>
					<a href="#">서비스2</a>
				</li>
				<li>
					<a href="#">서비스3</a>
				</li>
			</ul>
			
			<c:if test="${member == null}"><!-- 로그아웃 상태 -->
				<ul class="top-menu">
					<li><a href="/member/login"><i class="bi bi-box-arrow-in-right"></i></a></li>
					<li><a href="/member/join-term"><i class="bi bi-person-fill-add"></i></a></li>
				</ul>
			</c:if>
			
		</div>
		</nav>
	</header>