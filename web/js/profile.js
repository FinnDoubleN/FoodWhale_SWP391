/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('.btn--m').on('click', function () {
        $(this).parent('.profile-avatar').find('.file-img').click();
    });
    $('._text').on('click', function () {
        var index = $('._text').index(this);
        $o = $(this).parent().parent().parent().parent().attr('class');
        if (index === 0) {
            $(this).parent().parent().parent().parent().attr('class', 'user-option user-option--open');
            $(this).parent().parent().parent().parent().find('.profile-body').attr('class', 'profile-body profile-body--open');
            $(this).parent().parent().find('a').eq(0).attr('class', 'profile select');
            $(this).parent().parent().find('a').eq(1).attr('class', 'profile');
            $(this).parent().parent().parent().parent().parent().find('.profile-link').eq(1).attr('class', 'profile-link');
            $('.profile-info').attr('class', 'card mb-3 profile-info');
            $('.change-password').attr('class', 'card mb-3 change-password hidden');
            $('.history').attr('class', 'card mb-3 history hidden');
        } else if (index === 1) {
            $(this).parent().parent().parent().parent().attr('class', 'user-option user-option--open');
            $(this).parent().parent().parent().parent().parent().find('.user-option').eq(0).attr('class', 'user-option');
            $(this).parent().parent().parent().parent().parent().find('.profile-body').attr('class', 'profile-body');
            $(this).parent().parent().parent().parent().parent().find('.profile-link').eq(index).attr('class', 'profile-link select');
            $('.profile-info').attr('class', 'card mb-3 profile-info hidden');
            $('.change-password').attr('class', 'card mb-3 change-password hidden');
            $('.history').attr('class', 'card mb-3 history');
        }
    });

    $('.profile-option').on('click', function () {
        var index = $('.profile-option').index(this);
        $uo = $(this).parent().parent().parent().parent().attr('class');
        if ($uo === 'user-option user-option--open') {
            if (index === 0) {
                $('.profile-info').attr('class', 'card mb-3 profile-info');
                $('.change-password').attr('class', 'card mb-3 change-password hidden');
                $('.history').attr('class', 'card mb-3 history hidden');
                $(this).parent().parent().find('a').eq(0).attr('class', 'profile select');
                $(this).parent().parent().find('a').eq(1).attr('class', 'profile');
            } else if (index === 1) {
                $('.profile-info').attr('class', 'card mb-3 profile-info hidden');
                $('.change-password').attr('class', 'card mb-3 change-password');
                $('.history').attr('class', 'card mb-3 history hidden');
                $(this).parent().parent().find('a').eq(1).attr('class', 'profile select');
                $(this).parent().parent().find('a').eq(0).attr('class', 'profile');
            }
        } else {
            console.log('no');
        }
    });

    $('.currentpass').change(function () {
        var curr = $(this).val();
        var username = $('#uName').val();
        $.ajax({
            url: '/FoodWhale_SWP391/Profile',
            type: 'POST',
            data: {Action: 'checkPW', username: username, curr: curr},
            success: function (data) {
                if (data === "Success") {
                    $('.currentpass').parent().parent().parent().find('.flexible').eq(0).attr('class', 'col-md-12 flexible hidden');
                    $('.currentpass').parent().parent().parent().find('.flexible').eq(1).attr('class', 'col-md-12 flexible hidden');
                } else if (data === "Error") {
                    if ($('.currentpass').val().length < 6) {
                        $('.currentpass').parent().parent().parent().find('.flexible').eq(0).attr('class', 'col-md-12 flexible hidden');
                        $('.currentpass').parent().parent().parent().find('.flexible').eq(1).attr('class', 'col-md-12 flexible');
                    } else {
                        $('.currentpass').parent().parent().parent().find('.flexible').eq(0).attr('class', 'col-md-12 flexible');
                        $('.currentpass').parent().parent().parent().find('.flexible').eq(1).attr('class', 'col-md-12 flexible hidden');
                    }
                }
            },
            error: function (data) {
            }
        });
        $f = $(this).parent().parent().parent().find('.flexible');
        var count = 0;
        for (var i = 0; i < $f.length; i++) {
            if ($f.eq(i).attr('class')) {
                count++;
            }
        }
        if (count === $('.flexible').length) {
            if ($('.newpass').val() !== '' && $('.retypepass').val() !== '' && $('.currentpass').val() !== '') {
                $('.btn--m').prop('disabled', false);
            } else {
                $('.btn--m').prop('disabled', true);
            }
        }
    });

    $('.newpass').change(function () {
        var regex = new RegExp(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$/);
        var newpass = $(this).val();
        var retypepass = $('.retypepass').val();
        if (newpass.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,16}$/)) {
            $(this).parent().parent().parent().find('.flexible').eq(2).attr('class', 'col-md-12 flexible hidden');
        } else {
            $(this).parent().parent().parent().find('.flexible').eq(2).attr('class', 'col-md-12 flexible');
        }
        if (newpass === retypepass) {
            $(this).parent().parent().parent().find('.flexible').eq(2).attr('class', 'col-md-12 flexible hidden');
            $(this).parent().parent().parent().find('.flexible').eq(3).attr('class', 'col-md-12 flexible hidden');
        }
        $f = $(this).parent().parent().parent().find('.flexible');
        var count = 0;
        for (var i = 0; i < $f.length; i++) {
            if ($f.eq(i).attr('class')) {
                count++;
            }
        }
        if (count === $('.flexible').length) {
            if ($('.newpass').val() !== '' && $('.retypepass').val() !== '' && $('.currentpass').val() !== '') {
                $('.btn--m').prop('disabled', false);
            } else {
                $('.btn--m').prop('disabled', true);
            }
        }
    });

    $('.retypepass').change(function () {
        var regex = new RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,16}$/);
        var newpass = $('.newpass').val();
        var retypepass = $(this).val();
        if (retypepass === '') {
            $(this).parent().parent().parent().find('.flexible').eq(3).attr('class', 'col-md-12 flexible');
            $(this).parent().parent().parent().find('.flexible').eq(4).attr('class', 'col-md-12 flexible hidden');
        }
        if (newpass !== retypepass) {
            $(this).parent().parent().parent().find('.flexible').eq(3).attr('class', 'col-md-12 flexible hidden');
            $(this).parent().parent().parent().find('.flexible').eq(4).attr('class', 'col-md-12 flexible');
        }
        if (newpass === retypepass) {
            $(this).parent().parent().parent().find('.flexible').eq(3).attr('class', 'col-md-12 flexible hidden');
            $(this).parent().parent().parent().find('.flexible').eq(4).attr('class', 'col-md-12 flexible hidden');
        }
        $f = $(this).parent().parent().parent().find('.flexible');
        var count = 0;
        for (var i = 0; i < $f.length; i++) {
            if ($f.eq(i).attr('class')) {
                count++;
            }
        }
        if (count === $('.flexible').length) {
            if ($('.newpass').val() !== '' && $('.retypepass').val() !== '' && $('.currentpass').val() !== '') {
                $('.btn--m').prop('disabled', false);
            } else {
                $('.btn--m').prop('disabled', true);
            }
        }
    });

//    $('input[type=file]').change(function () {
//        var filename = $('input[type=file]').val().split('\\').pop();
//        var file = $('input[type=file]').prop('files');
//        var data = new FormData();
//        data.append(filename, file);
//        $.ajax({
//            url: 'Google_Script_Url',
//            type: 'POST',
//            data: data,
//            processData: false, // tell jQuery not to process the data
//            contentType: false, // tell jQuery not to set contentType
//            success: function (results) {
//                console.log(JSON.stringify(results));
//            },
//            error: function (results) {
//                console.log(JSON.stringify(results));
//            }
//        });
//    });
});

// regex password : "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"