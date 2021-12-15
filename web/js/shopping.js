/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('.btn-rec-cart').on('click', function () {
        var recID = $(this).attr('id');
        $.ajax({
            url: '/FoodWhale_SWP391/Recipe/Detail',
            type: 'POST',
            data: {recID: recID, action: "add"}
        });
        alert("Added successful.");
    });
    $('.btn-in-cart').on('click', function () {
        var recID = $(this).attr('id');
        $.ajax({
            url: '/FoodWhale_SWP391/Ingredient/Detail',
            type: 'POST',
            data: {recID: recID, action: "add"}
        });
        alert("Added successful.");
    });
});
