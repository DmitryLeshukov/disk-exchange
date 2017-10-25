$(document).ready(function() {
    $('#disk-add-form').submit(function (e) {
        e.preventDefault();

        var formData = {
            'title'     : $('input[name=title]').val(),
            'description'     : $('textarea[name=description]').val(),
            'year'     : $('input[name=year]').val()
        };

        $.ajax({
            type:           "POST",
            url:            "/api/disk",
            data:           JSON.stringify(formData),
            contentType:    "application/json; charset=utf-8"
        }).done (function (data){
            window.location.replace("/disk/free");
        }).fail (function (data){
            var trHTML = '';
            $.each(data.responseJSON, function (i, error) {
                trHTML += '<li>' + error + '</li>';
            });
            $('.error').append(trHTML);
        });
    });
});