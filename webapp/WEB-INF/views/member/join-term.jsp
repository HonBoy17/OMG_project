<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<%@ include file="../includes/header.jsp" %>
	<script>
		$(function(){
	        $('#all_agree').change(function(){
	            $('.agreement input[type="checkbox"]').prop('checked', $(this).prop('checked'));
	        });
	    });
	</script>
	
	<section class="wrap main-content">
		<div class="join-table">
			<div class="content">
				<h2>OMG의 약관에 동의해주세요</h2>
			</div>
			<div class="content agreement-box">
				<div class="agreement">
	                <input type="checkbox" id="all_agree">
	                <label class="check" for="all_agree">
	                	<strong>OMG의 모든 약관에 동의 합니다.</strong>
	                </label>
	            </div>
	            <div class="agreement">
	                <input type="checkbox" id="one_agree">
	                <label class="check" for="one_agree">
	                   	<span class="required-text">[필수]</span>이용약관
	                    <span><a href="#">약관 전체보기</a></span>
	                </label>
	            </div> 
	            <div class="agreement">
	                <input type="checkbox" id="two_agree">
	                <label class="check" for="two_agree">
	                	<span class="required-text">[필수]</span>이용약관
	                    <span><a href="#">약관 전체보기</a></span>
	                </label>
	            </div>
	            <a href="/member/join-insert" class="btn fill">약관 동의 완료</a>
            </div>
		</div>
	</section>
	
	<%@ include file="../includes/footer.jsp" %>