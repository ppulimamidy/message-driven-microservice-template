<!DOCTYPE html>

<html lang="en">
<head>
    <title>CPD System</title>
</head>
    <body>
    <h2>Add Policy Opportunity</h2>
        <form name="opportunity" action="create" method="post">

            <table>
                <tr>
                    <td><label>SubRule key</label></td>
                    <td><label>:</label></td>
                    <td><label><input type="text" name="subRuleKey"></label></td>
                </tr>
                <tr>
                    <td><label>Midrule key</label></td>
                    <td><label>:</label></td>
                    <td><label><input type="text" name="midRuleKey"></label><br></td>
                </tr>
                <tr>
                    <td><label>Disposition</label></td>
                    <td><label>:</label></td>
                    <td><label><input type="text" name="disposition"></label><br></td>
                </tr>
                <tr>
                    <td><label>Disposition Note</label></td>
                    <td><label>:</label></td>
                    <td><label><input type="text" name="dispositionNote"></label><br></td>
                </tr>
                <tr>
                    <td><input type="submit" name="Add"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
