<%@ include file="taglibs.jsp" %>

<html>
<head>
    <title>Create contract</title>
</head>
<body>
<c:url var="addAction" value="add/"/>
<form:form action="${addAction}" modelAttribute="contract">
    <table>
        <td><form:label path="id">Contract ID:</form:label></td>
        <td><form:input path="id" readonly="true"/></td>
        <tr>
            <td>
                <form:label path="number">
                    <spring:message text="Number"/>
                </form:label>
            </td>
            <td><form:input path="number" value="${contract.number}"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="date">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td><form:input path="date" value="${contract.date}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                    <input type="submit"
                           value="<spring:message text="Add Contract"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
