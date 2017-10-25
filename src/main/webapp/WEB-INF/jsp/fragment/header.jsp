<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">
                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"> </span>
                <span>Disk Exchange</span>
            </a>
        </div>

        <ul id="navigation-bar" class="nav navbar-nav">
            <li><a href="/user">Users</a></li>
            <li><a href="/disk/free">Free disks</a></li>
            <li><a href="/disk/hold/me">Disks hold by me</a></li>
            <li><a href="/disk/hold/other">My disks hold by others</a></li>
        </ul>

        <div class="nav navbar-nav pull-right">
            <a href="/disk/add" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-plus"></span> Add Disk</a>
            <p id="user-name" class="navbar-text"></p>
            <a href="/logout" class="btn btn-default btn-sm navbar-btn">
                <span class="glyphicon glyphicon-log-out"></span> Sign out
            </a>
        </div>
    </div>

    <script>
        $('ul.nav > li > a[href="' + document.location.pathname + '"]').parent().addClass('active');
        if(document.location.pathname === '/'){
            $('ul.nav > li > a[href="/disk/free"]').parent().addClass('active');
        }

        $.ajax({
            type: "GET",
            url: "/api/user/info",
        }).done(function (data) {
            if (data) {
                $('#user-name').append(data);
            }
        });
    </script>
</nav>
