
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/WEB-INF/tag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename='messages'/>
<html>
<head>
    <title><fmt:message key='doctor'/></title>
</head>
<body>
<div>
    <fmt:message key='greetingDoctor'/>!<br/>
    <c:out value="${staff_info.name}"/>
    <c:out value="${staff_info.surname}"/>
    <form action="" method="post">
        <c:forEach items="${info_about_patient}" var="wrapper"><br/>
            <table>
                <tr>
                    <td><fmt:message key='name'/></td>
                    <td><fmt:message key='surname'/></td>
                    <td><fmt:message key='nameDiagnosis'/></td>
                </tr>
                <tr>
                    <td>${wrapper.value.patientInfoEntity.name}</td>
                    <td>${wrapper.value.patientInfoEntity.surname}</td>
                    <td>${wrapper.value.diagnosisInfoEntity.name}</td>
                </tr>
            </table>
            <table>
                <tr>
                    <td colspan="3"><fmt:message key='initialRecipe'/></td>
                </tr>
                <tr>
                    <td>${wrapper.value.initialPrescription.drugs}</td>
                    <td>${wrapper.value.initialPrescription.procedure}</td>
                    <td>${wrapper.value.initialPrescription.operation}</td>
                </tr>
                <tr>
                    <td colspan="3"><fmt:message key='currentRecipe'/></td>
                </tr>
                <tr>
                    <td>${wrapper.value.currentPrescription.drugs}</td>
                    <td>${wrapper.value.currentPrescription.procedure}</td>
                    <td>${wrapper.value.currentPrescription.operation}</td>

                    <td>
                        <my:commandbutton info="${wrapper.key}" command="giveTablets">
                            <fmt:message key='giveGrugs'/>
                        </my:commandbutton>
                    </td>
                    <td>
                        <my:commandbutton info="${wrapper.key}" command="makeProcedure">
                            <fmt:message key='makeProcedure'/>
                        </my:commandbutton>
                    </td>
                    <td>
                        <my:commandbutton info="${wrapper.key}" command="makeOperation">
                            <fmt:message key='makeOperation'/>
                        </my:commandbutton>
                    </td>
                </tr>
            </table>
        </c:forEach>
    </form>
    <my:commandbutton command="goToSetDiagnosis">
        <fmt:message key='setDiagnosis'/>
    </my:commandbutton>
    <my:commandbutton command="goToDischarge">
        <fmt:message key='discharge'/>
    </my:commandbutton>
</div>
</body>
</html>
