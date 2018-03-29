<!DOCTYPE html>

<html lang="en">
<head>
    <title>CPD System</title>
</head>
<body>
<h2>Update disposition</h2>
<form name="opportunity" action="/updateDisposition" method="post">
    <table>
        <tr>
            <td><label>Subrule Key</label></td>
            <td><label>:</label></td>
            <td><label><input type="text" name="subRuleKey" value="${opportunity.subRuleKey}" disabled="true"></label></td>
        </tr>
        <tr>
            <td><label>Midrule key</label></td>
            <td><label>:</label></td>
            <td><label><input type="text" name="midRuleKey" value="${opportunity.midRuleKey}" disabled="true"></label><br></td>
        </tr>
        <tr>
            <td><label>Disposition</label></td>
            <td><label>:</label></td>
            <td><label><input type="text" name="disposition" value="${opportunity.disposition}"></label><br></td>
            <td><input type="hidden" name="id" value="${opportunity.id}"></td>
        </tr>
         <tr>
            <td><label>Disposition Note</label></td>
            <td><label>:</label></td>
            <td><label><input type="text" name="dispositionNote" value="${opportunity.dispositionNote}"></label><br></td>
            <td><input type="hidden" name="id" value="${opportunity.id}"></td>
        </tr>
        <tr>
            <td><input type="submit" name="update"></td>
        </tr>
    </table>
</form>
</body>
</html>
