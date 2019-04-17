$(function () {
    $('#id').onkeypress(function () {
        $.ajax({
            type="POST",
            url:"/com/fehead/TestServlet"
        })
    })
})