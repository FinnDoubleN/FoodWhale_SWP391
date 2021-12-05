// isotope js
$(window).on('load', function () {
    $('.filters_menu li').click(function () {
        $('.filters_menu li').removeClass('active');
        $(this).addClass('active');

        var data = $(this).attr('data-filter');
        $grid.isotope({
            filter: data
        });
        var isotope = $grid.data('isotope');
        removeHidden();
        function removeHidden() {
            $grid.find(".hidden").removeClass("hidden");
            isotope.filteredItems.slice(isotope.filteredItems.length).map(function (item) {
                return item.element;
            });
            $grid.isotope('layout');
            $("#view-more").hide();
        }
    });

    var $grid = $(".grid").isotope({
        itemSelector: ".all",
        percentPosition: false,
        masonry: {
            columnWidth: ".all"
        }
    });

    var initial_items = 6;
    var next_items = 3;
    var isotope = $grid.data('isotope');
    viewMore(initial_items);
    function viewMore(toShow) {
        $grid.find(".hidden").removeClass("hidden");
        var hiddenItems = isotope.filteredItems.slice(toShow, isotope.filteredItems.length).map(function (item) {
            return item.element;
        });
        $(hiddenItems).addClass('hidden');
        $grid.isotope('layout');
        if (hiddenItems.length === 0) {
            $("#view-more").hide();
        } else {
            $("#view-more").show();
        }
        ;
    }

    $(document).on("click", "#view-more", function (e) {
        e.preventDefault();
        if ($('#filters').data('clicked')) {
            next_items;
            j$('#filters').data('clicked', false);
        } else {
            next_items = next_items;
        }
        ;
        next_items = next_items + initial_items;
        viewMore(next_items);
    });
});

// nice select
$(document).ready(function () {
    $('select').niceSelect();
});

// client section owl carousel
$(".client_owl-carousel").owlCarousel({
    loop: true,
    margin: 0,
    dots: false,
    nav: true,
    navText: [],
    autoplay: true,
    autoplayHoverPause: true,
    navText: [
        '<i class="fa fa-angle-left" aria-hidden="true"></i>',
        '<i class="fa fa-angle-right" aria-hidden="true"></i>'
    ],
    responsive: {
        0: {
            items: 1
        },
        768: {
            items: 2
        },
        1000: {
            items: 2
        }
    }
});