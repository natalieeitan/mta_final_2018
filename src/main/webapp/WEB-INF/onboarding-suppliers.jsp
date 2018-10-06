<%@ page import="com.entities.Couple" %>
<%@ page import="com.entities.Supplier" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: natalieeitan
  Date: 01/09/2018
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="he" dir="rtl">

<head>
    <meta charset="utf-8"/>
    <title>Perfect Match - החשבון שלי</title>
    <meta name="description" content=""/>
    <meta name="Author" content=""/>

    <!-- mobile settings -->
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0"/>
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
    <!-- WEB FONTS : use %7C instead of | (pipe) -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"
          rel="stylesheet" type="text/css"/>

    <!-- CORE CSS -->
    <link href="../client/html/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- THEME CSS -->
    <link href="../client/html/assets/css/layout.css" rel="stylesheet" type="text/css"/>


    <!-- PAGE LEVEL SCRIPTS -->
    <link href="../client/html/assets/css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="../client/html/assets/css/color_scheme/green.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="../client/html/assets/css/essentials.css" rel="stylesheet" type="text/css"/>
    <link href="../client/html/assets/css/MyStyle.css" rel="stylesheet"/>
    <link href="../client/html/assets/css/layout-RTL.css" rel="stylesheet"/>

    <!-- REVOLUTION SLIDER -->
    <link href="../client/html/assets/plugins/slider.revolution/css/extralayers.css" rel="stylesheet" type="text/css"/>
    <link href="../client/html/assets/plugins/slider.revolution/css/settings.css" rel="stylesheet" type="text/css"/>


</head>

<body class="smoothcircle enable-animation has-video-bg"
      data-background="../client/html/assets/images/_smarty/backgrounds/default.jpg"
      dir="rtl">
<div id="wrapper">
    <%
        Supplier currSupplier = (Supplier) request.getAttribute("supplier");
        String venueName = (currSupplier != null) ? currSupplier.getVenueName() : "";
        String phone = (currSupplier != null) ? currSupplier.getPhone() : "";
        int maxCapacity = (currSupplier != null) ? currSupplier.getMaxCapacity() : 0;
        int minPrice = (currSupplier != null) ? currSupplier.getMinPricePerPerson() : 0;
        String area = (currSupplier != null) ? currSupplier.getAreaName(currSupplier.getArea()) : "מרכז";
        String style = (currSupplier != null) ? currSupplier.getStyleName(currSupplier.getStyle()) : "כפרי";

    %>
    <div id="header" class="navbar-toggleable-md sticky header-md dark clearfix" style="color:black">
        <header id="topNav">
            <div class="container">

                <!-- Mobile Menu Button -->
                <button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Logo -->
                <!--<a class="logo float-left scrollTo" href="#top">
                <img src="assets/images/_smarty/logo_light.png" alt="" />
                <img src="assets/images/_smarty/logo_dark.png" alt="" />
            </a>-->

                <div class="navbar-collapse collapse float-right nav-main-collapse">
                    <nav class="nav-main">

                        <ul id="topMain" class="nav nav-pills nav-main nav-onepage">
                            <li class="active">
                                <!-- HOME -->
                                <a href="#MyAccount" class="turText">
                                    החשבון שלכם
                                </a>
                            </li>
                            <li>
                                <a href="#MyOffers" class="turText">
                                    ההצעות שלכם
                                </a>
                            </li>
                            <li>
                                <a href="#Statistics" class="turText">
                                    סטטיסטיקות
                                </a>
                            </li>
                            <li>
                                <a data-toggle="modal" data-target="#myModal" style="color: #a9a1a1">
                                    התנתקות
                                </a>
                            </li>
                        </ul>

                    </nav>
                </div>
            </div>
        </header>
        <!-- /Top Nav -->
    </div>

    <!-- log off menu -->
    <div class="container text-center">
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">התנתקות</h4>
                    </div>
                    <div class="modal-body">
                        <p>אתם בטוחים שתרצו להתנתק?</p>
                    </div>
                    <div class="modal-footer justify-content-around">
                        <form action="/user" method="post">
                            <input name="action_logOff" hidden>
                            <div class="row">
                                <div class="col-6" style="width: 100%">
                                    <button type="button" class="btn btn-info" data-dismiss="modal">רוצים לחזור
                                    </button>
                                </div>
                                <div class="col-6">
                                    <button type="sumbit" class="btn btn-outline-secondary">רוצים להתנתק</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /log off menu -->

    <!-- My Account -->
    <section id="MyAccount" class="" style="margin-top: -70px">
        <div class="container" style="margin-top: 3%; margin-bottom: 7%;">
            <header class="text-center mb-60">
                <h2 class="turText">החשבון שלנו</h2>
                <hr/>
            </header>
            <div class="row">
                <div class="col-md-12">
                    <div class="text-center">
                        <div class="box-icon-title">
                            <i class="fa fa-user text-center ico-lg"></i>
                            <%
                                String fullVanue = "";
                                String loggedName = (String) request.getAttribute("loggedName");
                                if (venueName != "")
                                    fullVanue = "מאולם האירועים " + venueName;
                            %>
                            <h3>
                                <%=loggedName%>
                            </h3>
                            <h3>
                                <%=fullVanue%>
                            </h3>
                        </div>
                    </div>
                </div>
            </div>
            <div id="accordion">
                <div class="justify-content-around row text-center" style="padding-top: 55px;">
                    <div id="headingOne" class="col-md-5">
                        <h5 class="mb-0">
                            <button class="btn btn-info first" data-toggle="collapse" data-target="#collapseOne"
                                    aria-expanded="true"
                                    aria-controls="collapseOne" style="width:175px">
                                <span class="ico-hover et-gears" style="margin-left:10px"></span>
                                צפו בהגדרות שלכם
                            </button>
                        </h5>
                    </div>
                    <div id="headingTwo" class="col-md-5">
                        <h5 class="mb-0">
                            <button class="btn btn-info s" data-toggle="collapse" data-target="#collapseTwo"
                                    aria-expanded="false"
                                    aria-controls="collapseTwo" style="width:175px">
                                <span class="ico-hover et-tools-2" style="margin-left:10px"></span>
                                ערכו את ההגדרות
                            </button>
                        </h5>
                    </div>

                </div>
                <div>
                    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body">
                            <hr/>
                            <div class="box-static box-border-top p-30" style="border-top-color:black">
                                <table class="table tableCol">
                                    <tbody>
                                    <tr>
                                        <td class="bold">שם האולם:</td>
                                        <td><%=venueName%>
                                        </td>
                                        <td class="bold">טלפון:</td>
                                        <td><%=phone%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="bold">תפוסה מקסימלית:</td>
                                        <td><%=maxCapacity%>
                                        </td>
                                        <td class="bold">מחיר מינימלי למנה:</td>
                                        <td><%=minPrice%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="bold">אזור בארץ:</td>
                                        <td><%=area%>
                                        </td>
                                        <td class="bold">סגנון המקום:</td>
                                        <td><%=style%>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                        <div class="card-body">
                            <hr/>
                            <!--edit-->
                            <div id="editSuppliersSettings">
                                <form class="m-0 sky-form boxed" action="/supplier" method="post" dir="rtl"
                                      style="background-color: rgba(0,0,0,0.05);">
                                    <input name="action_onboarding_suppliers" hidden>
                                    <input name="id" id="id" hidden>
                                    <fieldset>
                                        <div class="justify-content-around row" style="margin-top: 30px">
                                            <!--name-->
                                            <div class="col-md-4 col-sm-4">
                                                <label>שם האולם*</label>
                                                <label class="input mb-10">
                                                    <i class="ico-append fa fa-home"></i>
                                                    <input name="venueName" type="text" value="<%=venueName%>" required>
                                                    <b class="tooltip tooltip-bottom-right">שם האולם</b>
                                                </label>
                                            </div>
                                            <!--phone-->
                                            <div class="col-md-4 col-sm-4">
                                                <label>טלפון נוסף*</label>
                                                <label class="input mb-10">
                                                    <i class="ico-append fa fa-phone"></i>
                                                    <input name="phone" type="text" value="<%=phone%>">
                                                    <b class="tooltip tooltip-bottom-right">טלפון נוסף</b>
                                                </label>
                                            </div>

                                        </div>

                                        <div class="justify-content-around row">
                                            <!--maxPeople-->
                                            <div class="col-md-4 col-sm-4">
                                                <label>תפוסה מקסימלית*</label>
                                                <label class="input mb-10">
                                                    <i class="ico-append fa fa-group"></i>
                                                    <input name="maxCapacity" type="number" min="80" max="1200"
                                                           placeholder="80" required
                                                           value="<%=maxCapacity%>">
                                                    <b class="tooltip tooltip-bottom-right">תפוסה מקסימלית</b>
                                                </label>
                                            </div>
                                            <!--price-->
                                            <div class="col-md-4 col-sm-4">
                                                <label>מחיר מנה מינימלי*</label>
                                                <label class="input mb-10">
                                                    <i class="ico-append fa fa-dollar"></i>
                                                    <input name="minPrice" type="number" min="80" placeholder="80"
                                                           value="<%=minPrice%>"
                                                           required>
                                                    <b class="tooltip tooltip-bottom-right">מחיר מנה מינימלי</b>
                                                </label>
                                            </div>
                                        </div>

                                        <div class="justify-content-around row">
                                            <!--area-->
                                            <div class="col-md-4 col-sm-4">
                                                <label>אזור בארץ*</label>
                                                <label class="input mb-10">
                                                    <select name="area" class="selectpicker show-tick" required>
                                                        <option value="GUSH_DAN">מרכז</option>
                                                        <option value="HAIFA">חיפה</option>
                                                        <option value="NORTH">צפון</option>
                                                        <option value="SHFELA">שפלה</option>
                                                        <option value="JERUSALEM">ירושלים</option>
                                                        <option value="SHARON">שרון</option>
                                                        <option value="SOUTH">דרום</option>
                                                    </select>
                                                </label>
                                            </div>
                                            <!--style-->
                                            <div class="col-md-4 col-sm-4">
                                                <label>סגנון המקום*</label>
                                                <label class="input mb-10">
                                                    <select name="style" required="" class="selectpicker show-tick">
                                                        <option value="RURAL">כפרי</option>
                                                        <option value="CLASSIC">קלאסי</option>
                                                        <option value="URBAN">אורבני</option>
                                                    </select>
                                                </label>
                                            </div>
                                        </div>


                                        <!--save-->
                                        <div class="justify-content-around row text-left">
                                            <div class="col-12">
                                                <button type="submit" id="save" class="btn btn-info btn-round btn-lg"
                                                        onsubmit="changeText(this)">
                                                    שמור
                                                </button>
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                            <!--/edit-->
                        </div>
                    </div>
                </div>
                <!--<div id="start" class="col-md-12">
                    <div class="box-icon box-icon-center box-icon-content  text-center">
                        <h2>ערכו את פרטיכם</h2>
                        <i class="ico-light ico-lg ico-hover et-tools-2" style="cursor: pointer"
                           onclick="editSettings()"></i>
                    </div>

                </div>-->


                <script>
                    function editSettings() {
                        document.getElementById('start').style.display = "none";
                        document.getElementById('editSuppliersSettings').style.display = "block";
                    }
                </script>
            </div>
        </div>
    </section>
    <!-- /My Account -->

    <!-- MyOffers -->
    <section id="MyOffers" class="bgImage sectionOpacity">
        <% String supplierId = (String) request.getAttribute("userId"); %>
        <h1 class="turText text-center" style="margin-top: -30px">ההצעות שלכם</h1>
        <div class="container">
            <div class="col-sm-12 text-center">
                <form action="/supplier" method="post">
                    <input name="connectSupplierCouple" hidden>
                    <div class="table-responsive">
                        <table class="table">
                            <%List<Couple> potentialCouples = (List<Couple>) request.getAttribute("potentialCouples"); %>
                            <%List<Couple> couplesAlreadyConnected = (List<Couple>) request.getAttribute("couplesAlreadyConnected"); %>

                            <thead class="thead-light pinkText">
                            <tr>
                                <th scope="col">שם הזוג</th>
                                <th scope="col">מספר אורחים</th>
                                <th scope="col">מחיר מנה</th>
                                <th scope="col">חודשים מועדף</th>
                                <th scope="col">ימים מועדפים</th>
                                <th scope="col">תאריך ספציפי</th>
                                <th scope="col">צור קשר עם הזוג</th>
                            </tr>
                            </thead>
                            <tbody
                            <%
                                if (couplesAlreadyConnected != null) {
                                    for (int i = 0; i < couplesAlreadyConnected.size(); ++i) {
                            %>
                            <tr>
                                <td><%= couplesAlreadyConnected.get(i).getName() %>
                                </td>
                                <td><%= couplesAlreadyConnected.get(i).getNumOfInvites() %>
                                </td>
                                <td><%= couplesAlreadyConnected.get(i).getPriceRangeName(couplesAlreadyConnected.get(i).getPricing()) %>
                                </td>
                                <td><%= couplesAlreadyConnected.get(i).getMonthsList(couplesAlreadyConnected.get(i).getPreferredMonths()) %>
                                </td>
                                <td><%= couplesAlreadyConnected.get(i).getDaysList(couplesAlreadyConnected.get(i).getDayOfWeek()) %>
                                </td>
                                <td><%= couplesAlreadyConnected.get(i).getDateString(couplesAlreadyConnected.get(i).getDate()) %>
                                </td>
                                <td>
                                    <button class="btn btn-info connect-couple" style="width: 72px;" disabled>
                                        נשלח
                                    </button>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                                if (potentialCouples != null) {
                                    for (int i = 0; i < potentialCouples.size(); ++i) {
                            %>
                            <tr>
                                <%--<td style="display:none;" class="couple_id"><%= potentialCouples.get(i).getId() %>--%>
                                <%--</td>--%>
                                <% String coupleId = potentialCouples.get(i).getID(); %>
                                <td><%= potentialCouples.get(i).getName() %>
                                </td>
                                <td><%= potentialCouples.get(i).getNumOfInvites() %>
                                </td>
                                <td><%= potentialCouples.get(i).getPriceRangeName(potentialCouples.get(i).getPricing()) %>
                                </td>
                                <td><%= potentialCouples.get(i).getMonthsList(potentialCouples.get(i).getPreferredMonths()) %>
                                </td>
                                <td><%= potentialCouples.get(i).getDaysList(potentialCouples.get(i).getDayOfWeek()) %>
                                </td>
                                <td><%= potentialCouples.get(i).getDateString(potentialCouples.get(i).getDate()) %>
                                </td>
                                <input id="couple" name="coupleId" type="text" hidden>
                                <td>
                                    <button type="submit" class="btn btn-info connect-couple" id="<%=coupleId%>"
                                            onClick="reply_click(this.id)">שלח
                                        <span class="glyphicon glyphicon-send"></span>
                                    </button>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>
        <script type="text/javascript">
            function reply_click(clicked_id) {

                document.getElementById("couple").value = clicked_id;

            }
        </script>
        <script>
            function changeText(element) {
                element.innerText = "נשלח";
                element.disabled = true;
            }

        </script>
    </section>
    <!-- /MyOffers -->

    <!-- Statistics -->
    <section id="Statistics" style="padding-bottom: 15%;">
        <h1 class="turText text-center" style="margin-top: -30px">סטטיסטיקות</h1>
        <div class="container">
            <div class="callout alert alert-border mt-100" style="padding-top: 5%;">
                <div class="row countTo-sm text-center">
                    <div class="col-md-3">
                        <i class="ico-lg ico-transparent glyphicon glyphicon-sunglasses"></i>
                        <div class="block fs-50" style="color: #17a2b8;">
                            <strong class="countTo fs-50" data-speed="3000">50</strong>%
                        </div>
                        <h3 class="mt-10 mb-0">מהזוגות רוצים להתחתן בקיץ</h3>
                    </div>

                    <div class="col-md-3">
                        <i class="ico-lg ico-transparent fa fa-users"></i>
                        <div class="block fs-50" style="color: #17a2b8;">
                            <strong class="countTo fs-50" data-speed="3000">350</strong>
                        </div>
                        <h3 class="mt-10 mb-0">מספר האורחים הממוצע לחתונה </h3>
                    </div>

                    <div class="col-md-3">
                        <i class="ico-lg ico-transparent fa fa-money"></i>
                        <div class="block fs-50" style="color: #17a2b8;">
                            <strong class="countTo fs-50" data-speed="3000">290</strong>
                        </div>
                        <h3 class="mt-10 mb-0">מחיר המנה הממוצע לחתונה</h3>
                    </div>


                    <div class="col-md-3">
                        <i class="ico-lg ico-transparent et-target"></i>
                        <div class="block fs-50" style="color: #17a2b8;">
                            <strong class="countTo fs-50" data-speed="3000">60</strong>%
                        </div>
                        <h3 class="mt-10 mb-0">מהזוגות רוצים להתחתן במרכז</h3>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- /Statistics -->
    <a href="#" id="toTop"></a>


    <script>
        function disableStart() {
            document.getElementById("start").style.display = "none";
        }
    </script>


    <!-- PRELOADER -->
    <div id="preloader">
        <div class="inner">
            <span class="loader"></span>
        </div>
    </div>
    <!-- /PRELOADER -->

    <!-- JAVASCRIPT FILES -->
    <script>var plugin_path = '../client/html/assets/plugins/';</script>
    <script src="../client/html/assets/plugins/jquery/jquery-3.3.1.min.js"></script>
    <!-- SLIDER -->
    <script src="../client/html/assets/plugins/slider.revolution/js/jquery.themepunch.tools.min.js"></script>
    <script src="../client/html/assets/plugins/slider.revolution/js/jquery.themepunch.revolution.min.js"></script>
    <script src="../client/html/assets/js/view/demo.revolution_slider.js"></script>
    <script src="../client/html/assets/js/scripts.js"></script>
    <script src="../client/html/assets/js/contact.js"></script>


</div>
</body>

</html>
