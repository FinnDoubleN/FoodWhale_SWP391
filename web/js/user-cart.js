/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    updatePrice();
    $('.input-num, .flex-item-price').on('click', function (e) {
        updatePrice();
    });
});

function updatePrice() {
    var total = 0;
    $('.item-box-layout').each(function () {
        var qty = $(this).find('.input-num').val();
        var price = $(this).find('.flex-item-price').text();
        var sum = (qty * price);
        $(this).find('.total').text(sum);
        total += sum;
        $(".cart-buy").find('.seperate-1').text(total);
        $("#total").attr('value', total);
    });
}

var increQty;
var decreQty;
var plusBtn = $('.plus-btn');
var minusBtn = $('.minus-btn');
var inputNum = $('.input-num');
var deleteBtn = $('.btn-delete');

var increQty = plusBtn.click(function () {
    var $n = $(this).parent('.cart-input-quantity').find('.input-num');
    $n.val(Number($n.val()) + 1);
    var inID = Number($n.attr('id'));
    updatePrice();
    var total = Number($('.seperate-1').text());
    $.ajax({
        url: '/FoodWhale_SWP391/Cart',
        type: 'POST',
        data: {action: 'up', inID: inID, total: total}
    });
});

var decreQty = minusBtn.click(function () {
    var $n = $(this).parent('.cart-input-quantity').find('.input-num');
    var qtyVal = Number($n.val());
    var inID = Number($n.attr('id'));
    if (qtyVal > 1) {
        $n.val(qtyVal - 1);
    }
    updatePrice();
    var total = Number($('.seperate-1').text());
    $.ajax({
        url: '/FoodWhale_SWP391/Cart',
        type: 'POST',
        data: {action: 'down', inID: inID, total: total}
    });
});

var deleteBtn = deleteBtn.click(function () {
    var $n = $(this).parent('.flex-5').find('.btn-delete');
    var inID = Number($n.attr('id'));
    $.ajax({
        url: '/FoodWhale_SWP391/Cart',
        type: 'POST',
        data: {action: 'delete', inID: inID}
    });
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                    'Deleted!',
                    'Your ingredient has been removed.',
                    'success'
                    );
            $(this).parent('.flex-5').parent('.item-flex').parent('.item-box-layout').remove();
            updatePrice();
        }
        ;
    });
});

//var inputNum = inputNum.change(function () {
//    var $n = $(this).parent('.cart-input-quantity').find('.input-num');
//    var qtyVal = Number($n.val());
//    if (qtyVal < 1) {
//        var qty = $n.val(Number(1));
//        $.ajax({
//            url: '/FoodWhale_SWP391/Cart',
//            type: 'POST',
//            data: {qty: qty}
//        });
//    }
//    $.ajax({
//        url: '/FoodWhale_SWP391/Cart',
//        type: 'POST',
//        data: {qty: qtyVal}
//    });
//    updatePrice();
//});