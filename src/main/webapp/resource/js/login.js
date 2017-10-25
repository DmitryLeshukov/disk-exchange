$(document).ready(function() {
    var params = (new URL(location)).searchParams;

    if(params.has('logout')){
        $('.logout').append('You\'ve been logged out successfully.');
    }

    if(params.has('error')){
        $('.error').append('Invalid username or/and password!');
    }
});