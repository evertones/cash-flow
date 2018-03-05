$(document).ready(function() {

    /**
     * Function to format and print dates in a short format - dd/mm/yyyy.
     * To run this function the element must have the CSS class `shortDateFormat`.
     * It must be used only on text elements that present the date as text.
     * It does not work for input elements.
     */
    $(".shortDateFormat").each(function(x,y) {
        var d = new Date(y.innerHTML);
        var day   = d.getDate() > 9 ? d.getDate() : "0" + d.getDate();
        var month = d.getMonth() > 8 ? d.getMonth() + 1 : "0" + (d.getMonth() + 1);
        var year  = d.getFullYear();

        y.innerHTML = day +"/" + month + "/" + year;
    });

});