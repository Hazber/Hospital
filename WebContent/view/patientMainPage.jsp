
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/WEB-INF/tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename='messages'/>
<html>
<head>
    <title><fmt:message key='greetingPatient'/></title>
</head>
<body>
<fmt:message key='greetingPatient'/><br/>
<c:out value="${patient_info.patientInfoEntity.name}"/>
<c:out value="${staff_info.patientInfoEntity.surname}"/>

<c:forEach items="${patient_info}" var="wrapper">
    ${wrapper.value.staffInfoEntity.name}<br/>
    ${wrapper.value.staffInfoEntity.surname}<br/>
    ${wrapper.value.diagnosisInfoEntity.name}<br/>

    <p><fmt:message key='initialRecipe'/></p>
    ${wrapper.value.initialPrescription.drugs}<br/>
    ${wrapper.value.initialPrescription.procedure}<br/>
    ${wrapper.value.initialPrescription.operation}<br/>

    <p><fmt:message key='currentRecipe'/></p>
    ${wrapper.value.currentPrescription.drugs}<br/>
    ${wrapper.value.currentPrescription.procedure}<br/>
    ${wrapper.value.currentPrescription.operation}<br/>
</c:forEach>

<my:commandbutton  command="exit">
    <fmt:message key='exit'/>
</my:commandbutton>
</body>
</html>
