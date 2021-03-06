(function ($) {
    "use strict";

    getCurrentVersion();
    getAllCustomers();

    $(".fab").click(() => {
        $.ajax({
            url: "/v1/random-names",
            type: 'GET',
            dataType: 'json',
            success: addCustomer
        });
    });

    function addCustomer(customerNames) {
        $.ajax({
            url: "/v1/customers",
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (createdPerson) {
                $('.table').append(
                    `
                    <div class="row">
                        <div class="cell" data-title="ID">
                            ${createdPerson.id}
                        </div>
                        <div class="cell" data-title="Full Name">
                            ${createdPerson.name}
                        </div>
                    </div>
                    `
                )
            },
            data: JSON.stringify({name: customerNames[0]})
        });
    }

    function getAllCustomers() {
        $.ajax({
            url: "/v1/customers",
            type: 'get',
            dataType: 'json',
            contentType: 'application/json',
            success: function (customers) {
                customers.forEach(createdPerson => {
                    $('.table').append(
                        `
                    <div class="row">
                        <div class="cell" data-title="ID">
                            ${createdPerson.id}
                        </div>
                        <div class="cell" data-title="Full Name">
                            ${createdPerson.name}
                        </div>
                    </div>
                    `
                    )
                });
            },
        });
    }

    function getCurrentVersion() {
        $.ajax({
            url: "/v1/versions",
            type: 'get',
            dataType: 'json',
            contentType: 'application/json',
            success: function (version) {
                $('#appVersion').text(version['applicationVersion'])
            },
        });
    }
})(jQuery);

