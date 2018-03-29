<!DOCTYPE html>

<html lang="en">
<head>
    <title>CPD System</title>
    <link rel='stylesheet' href='/webjars/bootstrap/3.3.5/css/bootstrap.min.css'>
</head>
<body>
<h2>Policy opportunity List</h2>
<table>
    <thead>
    <tr>
        <td>subrulekey</td>
        <td></td>
        <td>midrulekey</td>
        <td></td>
        <td>disposition</td>
        <td></td>
        <td>disposition Note</td>
        <td></td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <#list opportunities as opportunity>
    <tr>
        <td>${opportunity.subRuleKey}</td>
        <td>${opportunity.midRuleKey}</td>
        <td>${opportunity.disposition}</td>
        <td>${opportunity.dispositionNote}</td>
        <td><a href="editDisposition/${opportunity.id}"><button type="button">update disposition</button></a></td>
        <td><a href="editDispositionNote/${opportunity.id}"><button type="button">update disposition Note</button></a></td>
        <td><a href="delete/${opportunity.id}"><button type="button">delete</button></a></td>
    </tr>
    </#list>
    <tr>
        <td colspan="4" align="right"><a href="create"><button type="button">add</button></a></td>
    </tr>
    </tbody>
</table>
</body>
</html>
