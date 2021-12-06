/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function inDetail(inID) {
    document.cookie = "inID = " + inID;
    $.ajax({
       url: "/FoodWhale_SWP391/Ingredient/Detail",
       type: "GET",
       success: function() {
       },
       error: function() {
           alert("Error");
       }
    });
}

function recDetail(recID) {
    document.cookie = "recID = " + recID;
        $.ajax({
       url: "/FoodWhale_SWP391/Recipe/Detail",
       type: "GET",
       success: function() {
       },
       error: function() {
           alert("Error");
       }
    });
}