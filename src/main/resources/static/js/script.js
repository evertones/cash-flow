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

    /**
     * Function to format inputs to be filled like currency - i.e. "10000.00".
     */
    $(".money").mask("00000000.00", {reverse: true});

    $(".moneyFormat").each(function(x, y) {
        var value = y.innerHTML;

        if (value.split("")[value.length-2] === ".") {
            value = value + "0";
        }

        y.innerHTML = round(value, 2);
    });

    /**
     * Function to format inputs to be filled like percentage - i.e. "10.00".
     */
    $(".percentage").mask("000.00", {reverse: true});

    $(".percentageFormat").each(function(x, y) {
        var value = y.innerHTML;

        if (value.split("")[value.length-2] === ".") {
            value = value + "0";
        }

        y.innerHTML = value;
    });

});

function round(number, precision) {
    var shift = function (number, precision, reverseShift) {
        if (reverseShift) {
            precision = -precision;
        }
        numArray = ("" + number).split("e");
        return +(numArray[0] + "e" + (numArray[1] ? (+numArray[1] + precision) : precision));
    };
    return shift(Math.round(shift(number, precision, false)), precision, true);
}
