$(document).ready(function () {
    $.ajax({
        url: 'http://127.0.0.1:8080/api/user'
    }).done (function (response){
        var trHTML = '';
        $.each(response, function (i, item) {
            trHTML += '<tr><td>' + (i + 1) + '</td><td>' + item.lastName + '</td><td>' + item.firstName + '</td><td>' + item.middleName + '</td></tr>';
        });
        $('#user-table').append(trHTML);
    });
});