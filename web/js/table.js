/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#myTable').DataTable({
        "orderCellsTop": true,
        "ordering": false,
        "lengthChange": false,
        "info": false,
        "pageLength": 6,
        "dom": '<"row margin-6"Bf>rtip',
        "columnDefs": [
            {
                "searchable": false,
                "orderable": false,
                "targets": 0
            }
        ],
        "order": [[1, 'asc']],
        "buttons": [
            {
                "text": 'Create',
                "className": 'btn app-btn-secondary',
                action: function (e, dt, node, config) {
                    window.location.replace("${pageContext.request.contextPath}/Dashboard/AddAccount");
                }
            }
        ],
        initComplete: function () {
            var api = this.api();
            $('.filterrole', api.table().header()).each(function () {
                var column = api.column(5);
                var select = $('<select class="cell bold"><option value="">Role</option></select>')
                        .appendTo($(this).empty())
                        .on('change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                    $(this).val()
                                    );
                            column.search(val ? '^' + val + '$' : '', true, false).draw();
                        });
                column.data().unique().sort().each(function (d, j) {
                    select.append('<option value="' + d + '">' + d + '</option>');
                });
            });
            $('.filterstatus', api.table().header()).each(function () {
                var column = api.column(6);
                var select = $('<select class="cell bold"><option value="">Status</option></select>')
                        .appendTo($(this).empty())
                        .on('change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                    $(this).val()
                                    );
                            column.search(val ? '^' + val + '$' : '', true, false).draw();
                        });
                column.data().unique().sort().each(function (d, j) {
                    select.append('<option value="' + d + '">' + d + '</option>');
                });
            });
            $('.filtercate', api.table().header()).each(function () {
                var column = api.column(2);
                var select = $('<select class="cell bold"><option value="">Category</option></select>')
                        .appendTo($(this).empty())
                        .on('change', function () {
                            var val = $.fn.dataTable.util.escapeRegex(
                                    $(this).val()
                                    );
                            column.search(val ? '^' + val + '$' : '', true, false).draw();
                        });
                column.data().unique().sort().each(function (d, j) {
                    select.append('<option value="' + d + '">' + d + '</option>');
                });
            });
        }
    });
});
