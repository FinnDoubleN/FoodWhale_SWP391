/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function viewMore() {
    $.ajax({
        url: "/FoodWhale_SWP391/ViewMore",
        type: "get",
        success: function (data) {
            var recipe = document.getElementById('recipe');
            recipe.innerHTML += data;
        },
        error: function () {
            alert("Error");
        }
    });
}