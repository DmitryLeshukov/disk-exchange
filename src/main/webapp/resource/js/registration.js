$(document).ready(function() {
    $('#reg-form').submit(function (e) {

        var formData = {
            'login'             : $('input[name=login]').val(),
            'lastName'          : $('input[name=lastName]').val(),
            'firstName'         : $('input[name=firstName]').val(),
            'middleName'        : $('input[name=middleName]').val(),
            'password'          : $('input[name=password]').val(),
            'passwordConfirm'   : $('input[name=passwordConfirm]').val()
        };

        $.ajax({
            type:           "POST",
            url:            "/api/registration",
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

        e.preventDefault();
    });
});