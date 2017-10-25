<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Disks list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="/resource/css/add-disk.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="/resource/js/add-disk.js"></script>
</head>
<body>
<jsp:include page="../fragment/header.jsp"/>

<div class="container">
    <br>
    <br>
    <br>
    <br>
    <form id="disk-add-form" class="row col-md-6 col-md-offset-3">
        <ul class="error"></ul>
        <div class="form-group">
            <label>Title</label>
            <input name="title" maxlength="255" class="form-control" placeholder="Title" autofocus/>
        </div>
        <div class="form-group">
            <label>Description</label>
            <textarea name="description" maxlength="255" class="form-control" placeholder="Description"></textarea>
        </div>
        <div class="form-group">
            <label>Year</label>
            <input name="year" maxlength="4" class="form-control" placeholder="Year"/>
        </div>

        <button class="btn btn-lg btn-primary">Submit</button>
    </form>
</div>
</body>
</html>