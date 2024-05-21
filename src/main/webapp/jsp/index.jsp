<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Property Risk Mitigation Quiz</title>
</head>
<body>
    <h1>Property Risk Mitigation Quiz</h1>
    <form action="quiz" method="post">
        <c:forEach var="question" items="${questions}" varStatus="status">
            <p>${question}</p>
            <c:forEach var="option" items="${options[status.index]}">
                <label>
                    <input type="radio" name="answer${status.index}" value="${option.charAt(0)}">
                    ${option}
                </label><br>
            </c:forEach>
        </c:forEach>
        <input type="submit" value="Submit">
    </form>
</body>
</html>