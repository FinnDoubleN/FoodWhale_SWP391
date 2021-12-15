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

    $('.user-option').on('click', function () {

    });
});


// regex password : "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"