<%--
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
    <title>מארגנת החתונות - החשבון שלי</title>
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

<body class="smoothcircle enable-animation has-video-bg" data-background="../client/html/assets/images/_smarty/backgrounds/default.jpg"
      dir="rtl">
<div id="wrapper">
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
                        </ul>

                    </nav>
                </div>
            </div>
        </header>
        <!-- /Top Nav -->

    </div>

    <!-- My Account -->
    <section id="MyAccount" class="" style="margin-top: -70px">
        <div class="container">
            <!--header-->
            <!-- <div class="col-lg-3 col-md-4 col-sm-12">

                <div class="box-static box-border-top p-30">
                    <div class="box-icon-title text-center">
                        <i class="fa fa-user ico-rounded ico-hover-dark "></i>
                        <h2>ירדן וקובי לביא</h2>
                    </div>

                </div>
            </div> -->
            <header class="text-center mb-60">
                <h2 class="turText">החשבון שלנו</h2>
                <hr/>
            </header>

            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div id="start" class="col-md-12">
                            <div class="box-icon box-icon-center box-icon-content  text-center">
                                <h2>ערכו את פרטיכם</h2>
                                <i class="ico-light ico-lg ico-hover et-tools-2" style="cursor: pointer"
                                   onclick="editSettings()"></i>
                            </div>

                        </div>

                        <!--edit-->
                        <div id="editSuppliersSettings" style="display: none">
                            <form class="m-0 sky-form boxed" action="/supplier" method="post" dir="rtl">
                                <input name="action_onboarding_suppliers" hidden>
                                <input name="id" id="id" hidden>
                                <fieldset>

                                    <div class="justify-content-around row">
                                        <!--name-->
                                        <div class="col-md-4 col-sm-4">
                                            <label>שם האולם*</label>
                                            <label class="input mb-10">
                                                <i class="ico-append fa fa-home"></i>
                                                <input name="venueName" type="text" required>
                                                <b class="tooltip tooltip-bottom-right">שם האולם</b>
                                            </label>
                                        </div>
                                        <!--phone-->
                                        <div class="col-md-4 col-sm-4">
                                            <label>טלפון נוסף*</label>
                                            <label class="input mb-10">
                                                <i class="ico-append fa fa-phone"></i>
                                                <input name="phone" type="text">
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
                                                <input name="maxCapacity" type="number" min="80" max="1200" placeholder="80" required>
                                                <b class="tooltip tooltip-bottom-right">תפוסה מקסימלית</b>
                                            </label>
                                        </div>
                                        <!--price-->
                                        <div class="col-md-4 col-sm-4">
                                            <label>מחיר מנה מינימלי*</label>
                                            <label class="input mb-10">
                                                <i class="ico-append fa fa-dollar"></i>
                                                <input name="minPrice" type="number" min="80" placeholder="80" required>
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
                                            <button type="submit" id="save" class="btn btn-info btn-round btn-lg" onsubmit="changeText(this)">שמור
                                            </button>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                        <!--/edit-->

                        <script>
                            function editSettings() {
                                document.getElementById('start').style.display = "none";
                                document.getElementById('editSuppliersSettings').style.display = "block";
                            }
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- /My Account -->

    <!-- MyOffers -->
    <section id="MyOffers" class="bgImage sectionOpacity">
        <h1 class="turText text-center" style="margin-top: -30px">ההצעות שלכם</h1>
        <div class="container">
            <div class="col-sm-12 text-center">
                <div class="table-responsive-sm">
                    <table class="table">
                        <thead class="thead-light pinkText">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">שם הזוג</th>
                            <th scope="col">מספר אורחים</th>
                            <th scope="col">מחיר מנה</th>
                            <th scope="col">חודשים מועדף</th>
                            <th scope="col">ימים מועדפים</th>
                            <th scope="col">צור קשר עם הזוג</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>ירדן וקובי</td>
                            <td>250</td>
                            <td>350-400</td>
                            <td>יולי, אוגוסט</td>
                            <td>חמישי</td>
                            <td>
                                <button type="button" class="btn btn-info" onclick="changeText(this)"> שלח
                                    <span class="glyphicon glyphicon-send"></span>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>נטלי ובר</td>
                            <td>400-450</td>
                            <td>לא גובש תקציב</td>
                            <td>אוגוסט</td>
                            <td>ראשון, שני, שלישי, רביעי, חמישי, שישי,שבת</td>
                            <td>
                                <button type="button" class="btn btn-info" onclick="changeText(this)"> שלח
                                    <span class="glyphicon glyphicon-send"></span>
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>לירון ודליה</td>
                            <td>300-350</td>
                            <td>לא גובש תקציב</td>
                            <td>אין עונה מועדפת</td>
                            <td>אין יום מועדף</td>
                            <td>
                                <button type="button" class="btn btn-info" onclick="changeText(this)"> שלח
                                    <span class="glyphicon glyphicon-send"></span>
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script>
            function changeText(element) {
                element.innerText = "נשלח"
                element.disabled = true;
            }
        </script>
    </section>
    <!-- /MyOffers -->

    <!-- Statistics -->
    <section id="Statistics">
        <h1 class="turText text-center" style="margin-top: -30px">סטטיסטיקות</h1>
        <div class="container">
            <div class="callout alert alert-border mt-100">
                <div class="row countTo-sm text-center">
                    <div class="col-5 col-sm-3 col-5">
                        <i class="ico-lg ico-transparent glyphicon glyphicon-sunglasses"></i>
                        <div class="block fs-50" style="color: #17a2b8;">
                            <strong class="countTo fs-50" data-speed="3000">50</strong>%
                        </div>
                        <h3 class="mt-10 mb-0">מהזוגות רוצים להתחתן בקיץ</h3>
                    </div>

                    <div class="col-5 col-sm-3 col-5">
                        <i class="ico-lg ico-transparent glyphicon glyphicon-cloud"></i>
                        <div class="block fs-50" style="color: #17a2b8;">
                            <strong class="countTo fs-50" data-speed="3000">10</strong>%
                        </div>
                        <h3 class="mt-10 mb-0">מהזוגות רוצים להתחתן בחורף</h3>
                    </div>

                    <div class="col-5 col-sm-3 col-5">
                        <i class="ico-lg ico-transparent fa fa-glass"></i>
                        <div class="block fs-50" style="color: #17a2b8;">
                            <strong class="countTo fs-50" data-speed="3000">60</strong>%
                        </div>
                        <h3 class="mt-10 mb-0">מהזוגות רוצים להתחתן בסוף השבוע</h3>
                    </div>

                    <div class="col-5 col-sm-3 col-5">
                        <i class="ico-lg ico-transparent fa fa-calendar"></i>
                        <div class="block fs-50" style="color: #17a2b8;">
                            <strong class="countTo fs-50" data-speed="3000">40</strong>%
                        </div>
                        <h3 class="mt-10 mb-0">מהזוגות רוצים להתחתן באמצע השבוע</h3>
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
    <script>var plugin_path = 'assets/plugins/';</script>
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