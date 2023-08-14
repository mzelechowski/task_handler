$(document.readyState, function () {
    $(function () {
        $('#location').change(function () {
            let value = $(this).val();

            $.get({
                type: "GET",
                url: `/?locations?location=` + value,
                async: false,
                success: function(){
                    location.reload();
                    console.log(value);
                }
            })
        })
    })
});