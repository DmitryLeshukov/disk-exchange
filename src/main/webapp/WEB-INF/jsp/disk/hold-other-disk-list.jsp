<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Disks list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="/resource/js/hold-other-disk-list.js"></script>
</head>
<body>
    <jsp:include page="../fragment/header.jsp"/>

    <div class="container">
        <br>
        <br>
        <br>
        <br>
        <div class="row col-md-8 col-md-offset-2">
            <table id="hold-other-disk-table" class="table table-hover">
                <caption>
                    <span class="align-left"><strong>My disks hold by others</strong></span>
                </caption>
                <thead>
                <tr>
                    <th class="col-md-1">Row</th>
                    <th class="col-md-6">Title</th>
                    <th class="col-md-4">Holder</th>
                    <th class="col-md-1">Year</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</body>
</html>