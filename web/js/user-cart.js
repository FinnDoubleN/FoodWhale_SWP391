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
    var total = 0.0;
    $('.item-box-layout').each(function () {
        var qty = $(this).find('.input-num').val();
        var price = $(this).find('.flex-item-price').text();
        var sum = (qty * price);
        $(this).find('.total').text(sum);
        total += sum;
        $(".cart-buy").find('.seperate-1').text('Total: $' + total);
    });
}

var increQty;
var decreQty;
var plusBtn = $('.plus-btn');
var minusBtn = $('.minus-btn');
var increQty = plusBtn.click(function () {
    var $n = $(this).parent('.cart-input-quantity').find('.input-num');
    $n.val(Number($n.val()) + 1);
    updatePrice();
});

var decreQty = minusBtn.click(function () {
    var $n = $(this).parent('.cart-input-quantity').find('.input-num');
    var qtyVal = Number($n.val());
    if (qtyVal > 1) {
        $n.val(qtyVal - 1);
    }
    updatePrice();
});