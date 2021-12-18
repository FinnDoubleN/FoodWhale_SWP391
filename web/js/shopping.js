/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('.btn-rec-cart').on('click', function () {
        var recID = $(this).attr('id');
        Swal.fire(
                'Successful!',
                'Recipe Added',
                'success'
                ).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: '/FoodWhale_SWP391/Recipe/Detail',
                    type: 'POST',
                    data: {recID: recID, action: "add"}
                });
            }
        });
    });
    $('.btn-in-cart').on('click', function () {
        var inID = $(this).attr('id');
        Swal.fire(
                'Successful!',
                'Recipe Added',
                'success'
                ).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: '/FoodWhale_SWP391/Ingredient/Detail',
                    type: 'POST',
                    data: {inID: inID, action: "add"}
                });
            }
        });
    });
});
