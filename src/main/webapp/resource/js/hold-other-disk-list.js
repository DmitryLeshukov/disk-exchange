$(document).ready(function () {
    function getHolderName (disk){
        return disk.holder.firstName + ' ' + disk.holder.lastName;
    }

    $.ajax({
        url: 'http://127.0.0.1:8080/api/disk/hold/other'
    }).done(function (response) {
        var trHTML = '';
        $.each(response, function (i, disk) {
            trHTML += '<tr><td>' + (i + 1) + '</td><td>' + disk.title + '</td><td>' + getHolderName(disk) + '</td><td>' + disk.year + '</td></tr>';
        });
        $('#hold-other-disk-table').append(trHTML);
    });
});