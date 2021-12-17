/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('.app-btn-secondary').on('click', function () {
        alert("Added successful.");
    });
    $('.btn-in-cart').on('click', function () {
        var inID = $(this).attr('id');
        $.ajax({
            url: '/FoodWhale_SWP391/Ingredient/Detail',
            type: 'POST',
            data: {inID: inID, action: "add"}
        });
        alert("Added successful.");
    });
});
