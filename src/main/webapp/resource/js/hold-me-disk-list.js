$(document).ready(function () {
    $('#error-modal').modal('hide');
    fillDiskTable();
});

function returnDisk(data) {
    $.ajax({
        url: 'http://127.0.0.1:8080/api/disk/return/' + data.id,
        type: "GET"
    }).done(function (data) {
        $('#hold-me-disk-table tbody tr').remove();
        fillDiskTable();
    }).fail(function (response) {
        $('.modal-body p').append(response.responseText);
        $('#error-modal').modal('show');
    });
}

function fillDiskTable() {
    function getOwnerName(disk) {
        return disk.owner.firstName + ' ' + disk.owner.lastName;
    }

    $.ajax({
        url: 'http://127.0.0.1:8080/api/disk/hold/me'
    }).done(function (response) {
        var trHTML = '';
        $.each(response, function (i, disk) {
            trHTML += '<tr><td>' + (i + 1) + '</td><td>' + disk.title + '</td><td>' + getOwnerName(disk) + '</td><td>' + disk.year + '</td><td><button onclick="returnDisk(this)" class="btn btn-default btn-xs" id="' + disk.id + '"><span class="glyphicon glyphicon-upload"></span> Return</button></td></tr>';
        });
        $('#hold-me-disk-table').append(trHTML);
    });
}