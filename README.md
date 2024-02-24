![image](https://github.com/ryu-jaehyun/Myongchelin_Guide/blob/master/images/%EB%AA%85%EC%8A%90%EB%9E%AD%EA%B0%80%EC%9D%B4%EB%93%9C_logo.png?raw=true)








#  프로젝트 소개

> 명지대학교 자연캠퍼스 인근에 위치한 맛집을 소개하는 웹사이트이다.
>
> 차별화된 인공지능 기반 맛집추천 + 솔직한 리뷰정보를 제공한다.
>
> 사용자에게는 간편한 메뉴검색과 그에 따른 맛집정보를 제공하고 찜 기능을 통해 편리성을 제공한다. 
>
> Spring Boot & MongoDB를 사용해 기본적인 REST API를 구현하고, Postman을 통해 API TEST 했으며, AWS,S3 등을 이용해 서버를 배포했다.


> ###  개발 기간 및 인원
>
> 23.03.06 ~ 23.06.05 (3개월)
>
> Frontend  : 전재오
> 
> Backend  : 하정민(AI), 류제현(Server)-PM




# 데이터베이스 - MongoDB

![데이터베이스](https://github.com/ryu-jaehyun/Myongchelin_Guide/blob/master/images/mongo%20db%20structure.png?raw=true)

# 기술 스택

![기술스택](https://github.com/ryu-jaehyun/Myongchelin_Guide/blob/master/images/%EA%B8%B0%EC%88%A0%EC%8A%A4%ED%83%9D-%EB%AA%85%EC%8A%90%EB%9E%AD%EA%B0%80%EC%9D%B4%EB%93%9C.png?raw=true)

# 주요기능

###  회원가입, 로그인

+ 사용자는 명지대학교 이메일, 닉네임, 아이디, 비밀번호를 이용해 회원가입할 수 있다.
+ 명지대학교 사람들을 목적으로 한 웹이기에 신뢰성을 고려해 이메일을 명지대학교 이메일로 받고 특정 사용자의 명지대학교 이메일로 인증번호를 발송한다.
+ 회원가입 시 기입한 아이디와 비밀번호로 로그인 할 수 있다.

### 맛집 탐색

+ 메인페이지 하단에서 리뷰기반 평점으로 4.5 평점 이상인 식당들을 랜덤으로 보여주고 사용자에게 추천한다.
+ 검색창에 대화형 텍스트로 또는 음성인식 등 다양한 방법으로 맛집을 검색할 수 있다. ex) 여자친구랑 같이 가기 좋은 가성비 카페 [click here to show!](https://github.com/ryu-jaehyun/Myongchelin_Guide/blob/master/images/%EB%AA%85%EC%8A%90%EB%9E%AD%EA%B0%80%EC%9D%B4%EB%93%9C_%EA%B2%80%EC%83%89%EA%B2%B0%EA%B3%BC.png?raw=true)
+ 인공지능을 통해 사용자에게 맞춤으로 맛집들을 보여주고, 영업시간,전화번호, 식당리뷰의 전체 리뷰 평점등을 같이 보여줘서 한눈에 파악할수 있다.
+ 검색결과 리스트에서 하트모양을 눌러 찜등록/취소를 할 수있다.

###  마이페이지

+ 사용자는 아이디,비밀번호 찾기, 비밀번호 변경 등 여러가지 기능을 이용할 수 있다.
+ 사용자는 마이페이지를 통해 사용자가 찜한 맛집목록과 작성한 전체 리뷰를 볼수 있다.

###  리뷰

+ 사용자는 리뷰 내용, 별점(1~5점) , 이미지 파일 첨부등 기능을 이용할 수 있다.
+ 사용자는 하단의 탐색 탭을 클릭하여 전체 사용자들의 리뷰들을 한 군데 미리보기로 보면서 클릭시 작성자, 별점, 사진, 내용 등을 확인할 수 있다.

# API 명세서

|   **Domain**   |        **URL**        | **Http Method** |       **Description**      |
|:--------------:|:---------------------:|:---------------:|:--------------------------:|
|    **User**    |        /user/id       |       POST      |       아이디 중복검증      |
|                |       /user/name      |       POST      |       닉네임 중복검증      |
|                |      /user/email      |       POST      |     명지대 이메일 인증     |
|                |     /user/register    |       POST      |       사용자 회원가입      |
|                |      /user/login      |       POST      |        사용자 로그인       |
|                |      /user/findId     |       POST      |         아이디 찾기        |
|                |      /user/findPw     |       POST      |        비밀번호 찾기       |
|                |     /user/changePw    |       POST      |        비밀번호 변경       |
|                |     /user/my-page     |       POST      |      사용자 정보 조회      |
| **Restaurant** |  /restaurant/like/add |       POST      |        맛집 찜 등록        |
|                | /restaurant/like/show |       GET       |  사용자 찜 맛집리스트 조회 |
|   **Review**   |      /review/add      |       POST      |       맛집 리뷰 추가       |
|                |   /review/recommend   |       GET       |   상위평점 리뷰 랜덤 조회  |
|                |  /review/image/upload |       POST      |       리뷰 사진 첨부       |
|                |    /review/show/all   |       GET       |     전체 맛집 리뷰 조회    |
|                |   /review/show/user   |       GET       | 특정 사용자 전체 리뷰 조회 |

