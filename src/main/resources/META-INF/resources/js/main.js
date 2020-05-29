(function ($) {
    "use strict";

    getAllCustomers();
    $(".fab").click(() => {
        $.ajax({
            url: "https://namey.muffinlabs.com/name.json?count=1&with_surname=true&frequency=common",
            type: 'GET',
            dataType: 'json',
            success: addCustomer
        });
    });

    function addCustomer(customerNames) {
        $.ajax({
            url: "http://localhost:8080/v1/customers",
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
            url: "http://localhost:8080/v1/customers",
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
})(jQuery);

