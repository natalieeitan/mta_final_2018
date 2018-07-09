<%@ page import="com.services.ListsServiceImpl" %>
<%@ page import="java.time.DayOfWeek" %>
<%@ page import="com.utilities.Season" %>
<%
ListsServiceImpl managementService = new ListsServiceImpl();
//todo - replace to db after implement in dbService
long thursdayStatistics = managementService.getCouplesNumberByDayOfWeek(DayOfWeek.THURSDAY);
long summerStatistics = managementService.getCouplesNumberBySeason(Season.SUMMER);
long winterStatistics = managementService.getCouplesNumberBySeason(Season.WINTER);
%>
<!DOCTYPE html>
<html>
<body>

<meta charset="UTF-8">
<title>Title</title>
<h4> מספר הזוגות שרוצים להתחתן בקיץ<%=summerStatistics%> </h4>
<h4> מספר הזוגות שרוצים להתחתן בחורף<%=winterStatistics%> </h4>
<h4> מספר הזוגות שרוצים להתחתן ביום חמישי<%=thursdayStatistics%> </h4>
<body>
<div id="sidenav">

</div>
<script>
    $(function(){
        $("#sidenav").load("supplier-side-bar.html");
    });
</script>
</body>
</html>
