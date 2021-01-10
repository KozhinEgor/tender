$(document).ready(function() {
    var url = 'http://localhost:8081/demo/getAll';
    $.get(url, function(response) {
        var table = new Tabulator('#example-table', {
            data: JSON.parse(response),
            layout: 'fitColumns',
            columns: [
                { title: 'id', field: 'id', width: 550 },
                { title: 'NameTender', field: 'NameTender', width: 550 },
                { title: 'BicoTender', field: 'BicoTender', width: 550 },
                { title: 'GosZakupki', field: 'GosZakupki', width: 550 },
                { title: 'price', field: 'price', width: 550 },
                { title: 'currency', field: 'currency', width: 550 },
                { title: 'rate', field: 'rate', width: 550 },
                { title: 'sum', field: 'sum', width: 550 }
            ]
        });
    });
});