<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

	<script>
		$(function(){
			
			$('#idcheck').click(function(e){ //아이디 중복 체크 메서드
				var query = {userid : $('#userid').val()};
				console.log(query);
				$.ajax({
					
					url : '/member/idcheck', 
					type : 'post',
					data : query,
					
					
					success : function(data) {
						if (data === 'duplicate') {
							$('#idcheckmsg').text('※ 아이디가 중복되어 사용할 수 없습니다.').css('color','#E83667');
							$('#userid').focus();
							$('#submit').attr('disabled', 'disabled');
						} else {
							$('#id-check-msg').text('사용 가능한 아이디입니다.').css('color','#09CE20');
							$('#submit').removeAttr('disabled');
						}
					}
				});
			});
	</script>
	
	<section class="wrap main-content">
		<div class="join-table">
				<div class="content">
		            <h2>회원가입</h2>
	            </div>
	            <div class="content">
			        <div class="form">
			            <form action="/member/join-insert" method="post">
			                <fieldset>
			                    <ul class="signform">
			                        <li>
			                            <label for="userid">아이디를 입력해 주세요!</label>
			                            <div class="input-wrap">
			                                <input type="text" name="userid" class="inputform" maxlength="16" placeholder="아이디를 16자 이내로 입력해주세요" required/>
			                                <button id="idcheck" type="button" class="btn btn-submit">중복확인</button>
			                            </div>
			                            <p id="id-check-msg">아이디 확인란</p>
			                        </li>
			
			                        <li>
			                            <label for="password">비밀번호</label>
			                            <div class="input-wrap">
			                                <input type="password" name="password" class="inputform" maxlength="16" placeholder="영문,숫자,특수문자 포함 8자 ~ 16자 이내로 입력해주세요" required/>
			                            </div>
			                        </li>
			                        
			                        <li>
			                            <label for="password-check">비밀번호 확인</label>
			                            <div class="input-wrap">
			                                <input type="password" name="password-check" class="inputform" maxlength="16" placeholder="확인을 위해 비밀번호를 한번 더 입력해주세요" required/>
			                                <p>비밀번호 확인란</p>
			                            </div>
			                        </li>
			
			
			                        <li>
			                            <label for="name">이름</label>
			                            <div class="input-wrap">
			                                <input type="text" name="name" class="inputform" maxlength="10" placeholder="이름을 입력해주세요" required/>
			                            </div>
			                        </li>
			
			                        <li>
			                            <label for="phone">휴대전화번호</label>
			                            <div class="input-wrap">
			                                <input type="text" name="phone" class="inputform" maxlength="11" placeholder="전화번호를 입력해 주세요 ('-'제외)" required/>
			                            </div>
			                        </li>
			
			                        <li>
			                            <label for="birth">생년월일</label>
			                            <div class="input-wrap">
			                                <input type="text" name="birth" class="inputform" maxlength="8" placeholder="생년월일을 입력해주세요" required/>
			                            </div>
            			            </li>
			                            <!--  
			                            <div class="input-wrap birth-wrap">
			                                <select id="birth" class="inputform">
			                                    <option>1945년</option>
			                                </select>
			                                <select id="birth" class="inputform">
			                                    <option>8월</option>
			                                </select>
			                                <select id="birth" class="inputform">
			                                    <option>15일</option>
			                                </select>
			                                
			                            </div>
			                            -->
									<li>
									 	<label for="address">주소</label>
			                            <div class="input-wrap">
			                                <input type="text" name="address" class="inputform" maxlength="100" placeholder="주소를 입력해주세요" required/>
			                            </div>
									</li>
			
			                        <li>
			                            <div class="replace-label"><span>성별</span></div>
			                            <div class="input-wrap gender-select">
			                                <input type="radio" name="gender" id="male" value="남성"checked/>
			                                <label for="male">남성</label>
			 
			                                <input type="radio" name="gender" id="female" value="여성"/>
			                                <label for="female">여성</label>
			                            </div>
			                        </li>
			
			                        <li>
			                        	<button id="submit" type="submit" class="btn submit">회원가입</button>
			                        </li>
			                    </ul>
			                </fieldset>
			            </form>
			        </div>
		        </div>
		    </div>
	    </section>
	<%@ include file="../includes/footer.jsp" %>