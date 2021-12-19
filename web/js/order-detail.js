/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    updatePrice();
});

function updatePrice() {
    var total = 0;
    $('.order-cart-layout').each(function () {
        var qty = $(this).find('.input-num').val();
        var price = $(this).find('.price').text();
        var sum = (qty * price);
        $(this).find('.subtotal').text(sum);
        total += sum;
        $('.table-responsive').find('.total').text('$' + total);
        $("#total").attr('value', total);
    });
}

var plusBtn = $('.plus-btn');
var minusBtn = $('.minus-btn');
var deleteBtn = $('.delete-order');

var increQty = plusBtn.click(function () {
    var $n = $(this).parent('.cart-input-quantity').find('.input-num');
    $n.val(Number($n.val()) + 1);
    updatePrice();
});

var decreQty = minusBtn.click(function () {
    var $n = $(this).parent('.cart-input-quantity').find('.input-num');
    var qtyVal = Number($n.val());
    if (qtyVal > 0) {
        $n.val(qtyVal - 1);
    }
    updatePrice();
});

var deleteBtn = deleteBtn.click(function () {
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
                    'An ingredient has been removed.',
                    'success'
                    );
        }
        ;
    });
    $(this).parent().parent('.order-cart-layout').remove();
    updatePrice();
});
