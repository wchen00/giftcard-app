<!DOCTYPE html>
<html>
<head>
    <title>Home</title>

    <!-- For-Mobile-Apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Hotel Booking Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- //For-Mobile-Apps -->

    <!-- Style -->
    <link rel="stylesheet" href="../../../css/style.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="../../../css/jquery-ui.css"/>
    <!-- JavaScript -->
    <script type="text/javascript" src="../../js/jquery.min.js"></script>

</head>
<body>

<h1 class="book">Send coins</h1>

<div class="reg">

    <h1>Select friends</h1>

    <div class="members">
        <form name="myForm" action="#" onsubmit="return validateForm()" method="post">
            Name: <input type="text" name="fname">
            <input type="submit" value="Submit">
        </form>
    </div>
    <div class="members">
        <div class="adult">
            <h2>No. of ITEMS</h2>

            <div class="dropdown-button">
                <select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
                    <option value="">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
        </div>

        <div class="child">
            <h2>No. of Children</h2>

            <div class="dropdown-button">
                <select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
                    <option value="">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
            </div>
        </div>
        <div class="clear"></div>
    </div>

    <div class="suite">
        <div class="dropdown-button">
            <h2>Friend</h2>
            <select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"flat"}'>
                <option value="1">-</option>
                <option value="1">ITEM1</option>
                <option value="2">ITEM2</option>
                <option value="2">ITEM2</option>
            </select>
        </div>
    </div>

    <div class="book-pag">
        <h2>Select Date</h2>

        <div class="book-pag-frm1">
            <label>Input1</label>
            <input class="date" id="datepicker1" type="text" value="Date" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = '';}" required="">
        </div>
        <div class="book-pag-frm2">
            <label>Input2</label>
            <input class="date" id="datepicker2" type="text" value="Date" onfocus="this.value = '';"
                   onblur="if (this.value == '') {this.value = '';}" required="">
        </div>
        <div class="clear"></div>
    </div>

    <!--Date Picker-->

    <script src="../../js/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker,#datepicker1,#datepicker2").datepicker();
        });
    </script>
    <!--//Date Picker-->

    <div class="rs">
        <div class="check_box">
            <div class="radio"><label><input type="checkbox" name="radio" checked=""><i></i>Transfer</label>
            </div>
        </div>
    </div>

    <div class="food">
        <h2>Choose ITEM</h2>

        <div class="radio-btns">
            <div class="check_box">
                <div class="radio"><label><input type="radio" name="radio" checked=""><i></i>Local</label></div>
            </div>
            <div class="check_box">
                <div class="radio"><label><input type="radio" name="radio"><i></i>Multi</label></div>
            </div>
        </div>
    </div>

    <div class="submit">
        <input type="submit" class="book" value="Send">
    </div>

</div>

<div class="reg-footer">
    <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.blackhawk.com/">
    </a></p>
</div>

</body>
</html>