<%--
  Created by IntelliJ IDEA.
  User: keesp
  Date: 2021-08-05
  Time: 오후 5:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    String heightStr = request.getParameter("height");
    String weightStr = request.getParameter("weight");
    int weightPoint = Integer.parseInt(weightStr);
    double heightPoint = Double.parseDouble(heightStr);
    double result = weightPoint / (  heightPoint * heightPoint );
    String bmi = null;

    if(result  <= 18.5 ){
        bmi = "과체중";

    }else if(result  <= 22.9 ){
        bmi = "정상";
    }else if(result  <= 24.9 ){
        bmi = "과체중";
    }else {
        bmi = "비만";
    }

//    public class Advice {
//        String bmi =
//        String advicePage = null;
//        public String check(){
//            if(bmi.equals("비만"){
//                advicePage = "https://www.oc.go.kr/health/contents.do?key=1487&";
//            }else{
//                advicePage = "https://www.baemin.com/";
//            })
//        }
//    }
//
//
//    this.check(bmi);


%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%= heightStr%></h1>
    <h1><%= weightStr%></h1>
    <a href = "<%advicePage%>"> <%= bmi%> </a>

    <a href="bmiInput.jsp">결과 다시 확인하기</a>
</body>
</html>
