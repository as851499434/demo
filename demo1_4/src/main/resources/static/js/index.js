$(function () {
    getInmage();
})

function getInmage() {
    $.ajax({
        type: "GET",
        url: "/captchar/captchaImage",
        // data: {},
        cache: false,
        contentType: false,
        processData: false,
        dataType: 'text',
        success: function(result) {
            result = "data:image/png;base64," + result;
            $("#img").attr('src',result);
            console.log(result)
        },
        error: function(error) {
        }
    });
}