
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/WEB-INF/tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename='messages'/>
<html>
<head>
    <title><fmt:message key='nurse'/></title>
</head>
<body>
<fmt:message key='greetingNurse'/><br/>
<c:out value="${staff_info.name}"/>
<c:out value="${staff_info.surname}"/>
<c:forEach items="${info_about_patient}" var="wrapper">

    ${wrapper.value.patientInfoEntity.name}<br/>
    ${wrapper.value.patientInfoEntity.surname}<br/>
    ${wrapper.value.diagnosisInfoEntity.name}<br/>

    <p><fmt:message key='initialRecipe'/>n</p>
    ${wrapper.value.initialPrescription.drugs}<br/>
    ${wrapper.value.initialPrescription.procedure}<br/>
    ${wrapper.value.initialPrescription.operation}<br/>

    <p><fmt:message key='currentRecipe'/></p>
    ${wrapper.value.currentPrescription.drugs}<br/>
    ${wrapper.value.currentPrescription.procedure}<br/>
    ${wrapper.value.currentPrescription.operation}<br/>
    <my:commandbutton info="${wrapper.key}" command="giveTablets">
        <fmt:message key='giveGrugs'/>
    </my:commandbutton>
    <my:commandbutton info="${wrapper.key}" command="makeProcedure">
        <fmt:message key='makeProcedure'/>
    </my:commandbutton>
</c:forEach>

<my:commandbutton  command="exit">
    <fmt:message key='exit'/>
</my:commandbutton>
</body>
</html>
