<%@ page import="com.entities.Couple" %>
<%@ page import="com.entities.Supplier" %>
<%@ page import="com.utilities.PriceRange" %>
<%@ page import="com.utilities.SchedulingRange" %>
<%@ page import="java.util.List" %>
<%@ page import="static com.utilities.SchedulingRange.*" %>
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
        String alert = "מלאו את העדפותיכם כדי לקבל הצעות!";
        String spon = "ספונטנים";
        String days = "";
        String months = "";
        String dateSelected = "";
        String styles = "";
        String priceRange = "";
        int howManyInvites = 0;
        String areas = "";
        SchedulingRange schedRange = null;
        String alertWhen = "";
        String alertStyle = "";
        String alertWhere = "";
        String alertBudget = "";

        Couple currCouple = (Couple) request.getAttribute("couple");
        if (currCouple != null) {
            howManyInvites = currCouple.getNumOfInvites();
            if (howManyInvites == 0)
                alertBudget = alert;
            styles = currCouple.getStylesList(currCouple.getStyle());
            if (styles == "")
                alertStyle = alert;
            areas = currCouple.getAreasList(currCouple.getArea());
            if (areas == "")
                alertWhere = alert;
            priceRange = (currCouple.getPricing() != 0) ?
                    currCouple.getPriceRangeName(currCouple.getPricing()) :
                    PriceRange.NO_RANGE.getName();
            if (priceRange == "")
                alertBudget = alert;
            schedRange = convertIntToSchedulingRange(currCouple.getSchedulingRange());

            if (schedRange != null) {
                switch (schedRange) {
                case ANYTIME: {
                    days = spon;
                    months = spon;
                    dateSelected = spon;
                    break;
                }
                case SEASON: {
                    days = (currCouple != null) ? currCouple.getDaysList(currCouple.getDayOfWeek()) : "";
                    months = (currCouple != null) ? currCouple.getMonthsList(currCouple.getPreferredMonths()) : "";
                    break;
                }
                case SPECIFIC: {
                    dateSelected = (currCouple != null && currCouple.getDate() != null) ?
                            currCouple.getDateString(currCouple.getDate()) :
                            "";
                    break;
                }
                default:
                    break;
                }
            } else {
                alertWhen = alert;
            }
        }
    %>
    <div id="header" class="navbar-toggleable-md sticky transparent header-md clearfix">
        <header id="topNav">
            <div class="container">

                <!-- Mobile Menu Button -->
                <button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>

                <div class="navbar-collapse collapse float-right nav-main-collapse">
                    <nav class="nav-main">

                        <ul id="topMain" class="nav nav-pills nav-main nav-onepage">
                            <li class="active">
                                <!-- HOME -->
                                <a href="#MyAccount" class="pinkText">
                                    החשבון שלנו
                                </a>
                            </li>
                            <li>
                                <a href="#MyOffers" class="pinkText">
                                    ההצעות שלכם
                                </a>
                            </li>
                            <li>
                                <a href="#Recommendation" class="pinkText">
                                    מומלצים
                                </a>
                            </li>
                            <li>
                                <a data-toggle="modal" data-target="#ContactModal" class="pinkText">
                                    צור קשר
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

    <!-- contact us-->
    <div class="container text-center">
        <div class="modal fade" id="ContactModal" role="dialog">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <form class="sky-form" action="/contactUs" method="post" dir="rtl">
                        <input name="action_contactUsCouples" hidden>
                        <div class="modal-header text-center pinkText">
                            <h2 class="modal-title pinkText">צור קשר</h2>
                        </div>
                        <div class="modal-body text-center ">
                            <div class="container">
                                <div class="container">
                                    <div class="row justify-content-around text-right">
                                        <label class="col-md-5">מה תרצו להגיד לנו?*</label>
                                        <label class="textarea mb-10">
                                            <textarea type="text" name="contactMessage" style="font-weight: normal" required ></textarea>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer justify-content-around">
                            <div class="row container text-center">
                                <div class="col-md-6">
                                    <button class="btn btn-info" data-dismiss="modal">ביטול</button>
                                </div>
                                <div class="col-md-6">
                                    <button type="sumbit" class="btn btn-info">שלח
                                        <span class="glyphicon glyphicon-send"></span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--/contact us-->


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


    <!--got married-->
    <div class="container text-center">
        <div class="modal fade" id="gotMarried" role="dialog">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <form class="sky-form" action="/couple" method="post">
                        <div class="modal-header text-center pinkText">
                            <h2 class="modal-title pinkText">מזל טוב!</h2>
                        </div>
                        <div class="modal-body text-center ">
                            <div class="container">
                                <div class="row">
                                    <label class="pinkText">ספרו לנו על החתונה שלכם</label>
                                </div>
                                <div class="container">
                                    <input name="action_gotMarried" hidden>
                                    <div class="row justify-content-around text-right">
                                        <div class="row text-right">
                                            <label class="col-md-8 text-right">התחתנו דרך Perfect Match</label>
                                            <div class="col-md-2">
                                                <label class="radio-btn">
                                                    <input type="radio" name="byPerfectMatch" value="true" required="">
                                                    <i></i>כן</label>
                                            </div>
                                            <div class="col-md-2">
                                                <label class="radio-btn">
                                                    <input type="radio" name="byPerfectMatch" value="false" required="">
                                                    <i></i>לא</label>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="row justify-content-around text-right">
                                        <label class="col-md-5">מתי אתם מתחתנים?</label>
                                        <label class="input mb-10">
                                            <input type="text" class="datepicker chooseSpecificDate"
                                                   data-format="dd/mm/yyyy"
                                                   style="display: inline; margin-top: 1px !important; position: unset; "
                                                   name="dateMarried">
                                        </label>
                                    </div>
                                    <div class="row justify-content-around text-right">
                                        <label class="col-md-5 ">איפה אתם מתחתנים?</label>
                                        <label class="input mb-10">
                                            <input type="text" name="whereMarried" style="font-weight: normal">
                                        </label>
                                    </div>
                                    <div class="row justify-content-around text-right">
                                        <label class="col-md-5">ספרו לנו על החתונה שלכם</label>
                                        <label class="textarea mb-10">
                                            <textarea type="text" name="detailsMarried" style="font-weight: normal">
                                            </textarea>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer justify-content-around">
                            <div class="row container text-center">
                                <p style="color: red; font-weight: normal">*בלחיצה על אישור, אתם מאשרים שלא תקבלו הצעות
                                    נוספות מאיתנו</p>

                                <div class="col-md-6">
                                    <button type="sumbit" class="btn btn-info">אישור</button>
                                </div>
                                <div class="col-md-6">
                                    <button class="btn btn-info" data-dismiss="modal">ביטול</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--/got married-->


    <!-- My Account -->
    <section id="MyAccount" class="">
        <div class="container" style="margin-top: 3%; margin-bottom: 10%;">
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
                <h2 class="pinkText">החשבון שלנו</h2>
                <hr/>
            </header>

            <div class="row">
                <div class="col-md-12">
                    <div class="text-center">
                        <div class="box-icon-title">
                            <i class="fa fa-user text-center ico-lg"></i>
                            <%String loggedName = (String) request.getAttribute("loggedName"); %>
                            <h3><%=loggedName%>
                            </h3>
                        </div>
                    </div>
                </div>
            </div>
            <div id="accordion">
                <div class="justify-content-around row text-center">
                    <div id="headingOne" class="col-md-3">
                        <h5 class="mb-0">
                            <button class="btn btn-info first" data-toggle="collapse" data-target="#collapseOne"
                                    aria-expanded="true" aria-controls="collapseOne" style="width:175px">
                                <span class="ico-hover et-gears" style="margin-left:10px"></span>
                                צפו בהגדרות שלכם
                            </button>
                        </h5>
                    </div>
                    <div id="headingTwo" class="col-md-3">
                        <h5 class="mb-0">
                            <button class="btn btn-info s" data-toggle="collapse" data-target="#collapseTwo"
                                    aria-expanded="false" aria-controls="collapseTwo" style="width:175px">
                                <span class="ico-hover et-tools-2" style="margin-left:10px"></span>
                                ערכו את ההגדרות
                            </button>
                        </h5>
                    </div>
                    <div id="headingThree" class="col-md-3">
                        <h5 class="mb-0">
                            <button class="btn btn-info" data-toggle="modal" data-target="#gotMarried"
                                    style="width:175px">
                                <span class="ico-hover fa fa-heart-o" style="margin-left:10px"></span>
                                סגרתם חתונה?
                            </button>
                        </h5>
                    </div>
                </div>
                <div>
                    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                        <div class="card-body">
                            <hr/>
                            <div id="ShowSettings">
                                <div class="container">
                                    <div class="justify-content-around row" style="margin-top:15px">
                                        <div class="col-md-5" id="WhenSettings">
                                            <div class="box-static box-border-top MyP30">
                                                <div>
                                                    <h2 class="fs-20  text-center">מתי</h2>
                                                    <p style="color: red;" class="text-center">
                                                        <%=alertWhen%>
                                                    </p>
                                                </div>
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <td style="font-weight: bold">חודשים:</td>
                                                        <td><%=months%>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td style="font-weight: bold">ימים:</td>
                                                        <td><%=days%>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td style="font-weight: bold">תאריך ספציפי:</td>
                                                        <td><%=dateSelected%>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-md-5" id="WhereSettings">
                                            <div class="box-static box-border-top p-30r">
                                                <div>
                                                    <h2 class="fs-20  text-center">איפה</h2>
                                                    <p style="color: red;" class="text-center">
                                                        <%=alertWhere%>
                                                    </p>
                                                </div>
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <td style="font-weight: bold">אזורים:</td>
                                                        <td><%=areas%>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="container">
                                    <div class="justify-content-around row" style="margin-top:15px">
                                        <div class="col-md-5" id="StyleSetting">
                                            <div class="box-static box-border-top p-30">
                                                <div>
                                                    <h2 class="fs-20 text-center">סגנון</h2>
                                                    <p style="color: red;" class="text-center">
                                                        <%=alertStyle%>
                                                    </p>
                                                </div>
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <td style="font-weight: bold">סגנונות:</td>
                                                        <td><%=styles%>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="col-md-5" id="BudgetSettings">
                                            <div class="box-static box-border-top p-30 text-center">
                                                <div>
                                                    <h2 class="fs-20">תקציב</h2>
                                                    <p style="color: red;" class="text-center">
                                                        <%=alertBudget%>
                                                    </p>
                                                </div>
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <td style="font-weight: bold">כמה אורחים:</td>
                                                        <td><%=howManyInvites%>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td style="font-weight: bold">מחיר למנה:</td>
                                                        <td><%=priceRange%>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                        <div class="card-body">
                            <hr/>
                            <div class="container" style="margin-bottom: 15%; margin-top: 5%;" id="editSettings">
                                <div class="row">

                                    <!-- tabs -->
                                    <div class="col-md-3 col-sm-3">
                                        <ul class="nav nav-tabs nav-stacked flex-column text-right">
                                            <li class="nav-item">
                                                <a class="nav-link" href="#When" data-toggle="tab"
                                                   onclick="disableStart()">
                                                    מתי נתחתן?
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#Where" data-toggle="tab"
                                                   onclick="disableStart()">
                                                    איפה נתחתן?
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#OurStyle" data-toggle="tab"
                                                   onclick="disableStart()">
                                                    מה הסטייל שלנו?
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#Budget" data-toggle="tab"
                                                   onclick="disableStart()">
                                                    על כמה נשלם?
                                                </a>
                                            </li>
                                        </ul>
                                    </div>

                                    <!-- tabs content -->
                                    <div class="col-md-9 col-sm-9">
                                        <div class="d-none d-sm-block">
                                            <div id="start" class="row box-static box-border-top text-center">
                                                <div class="col-4">
                                                    <img src='../client/html/arrow.png'>
                                                </div>
                                                <div class="col d-flex align-items-center">
                                                    <h2>
                                                        איך תרצו להתחתן?
                                                    </h2>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="tab-content tab-stacked nav-alternate text-right">
                                            <div id="When" class="tab-pane">
                                                <form id="formWhen" action="/couple" method="post">
                                                    <input name="action_When" hidden>
                                                    <div class="row"></div>
                                                    <div class="checkbox col-12">

                                                        <!--spontaneous-->
                                                        <label class="checkbox">
                                                            <input type="radio" id="spontaneousCB" value="ANYTIME"
                                                                   name="whenRadio"
                                                                   onclick="WhenToggle('spontaneousCB')" required>
                                                            <i></i> ספונטנים
                                                        </label>
                                                        <div class="divider"></div>

                                                        <!--season-->
                                                        <label class="checkbox">
                                                            <input type="radio" value="SEASON" id="seasonCB"
                                                                   name="whenRadio" onclick="WhenToggle('seasonCB')">
                                                            <i></i> תמיד חלמתי להתחתן ב...
                                                        </label>
                                                        <div id="chooseSeason" class="collapse">
                                                            <!--season-->
                                                            <div class="row">
                                                                <!-- summer -->
                                                                <div class="col-md-3">
                                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content">
                                                                        <div class="box-icon-title">
                                                                            <i class="handle-small fa fa-sun-o"></i>
                                                                            <h2 class="pinkText">קיץ</h2>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="JUNE"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> יוני
                                                                            </label>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="JULY"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> יולי
                                                                            </label>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="AUGUST"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> אוגוסט
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <!-- fall -->
                                                                <div class="col-md-3">
                                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content">
                                                                        <div class="box-icon-title">
                                                                            <i class="handle-small fa fa-leaf"></i>
                                                                            <h2 class="pinkText">סתיו</h2>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="SEPTEMBER"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> ספטמבר
                                                                            </label>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="OCTOBER"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> אוקטובר
                                                                            </label>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="NOVEMBER"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> נובמבר
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <!-- winter -->
                                                                <div class="col-md-3">
                                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content">
                                                                        <div class="box-icon-title">
                                                                            <i class="handle-small fa fa-umbrella"></i>
                                                                            <h2 class="pinkText">חורף</h2>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="DECEMBER"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> דצמבר
                                                                            </label>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="JANUARY"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> ינואר
                                                                            </label>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="FEBRUARY"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> פברואר
                                                                            </label>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <!-- spring -->
                                                                <div class="col-md-3">
                                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content">
                                                                        <div class="box-icon-title">
                                                                            <i class="handle-small fa fa-tree"></i>
                                                                            <h2 class="pinkText">אביב</h2>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="MARCH"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> מרץ
                                                                            </label>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="APRIL"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> אפריל
                                                                            </label>
                                                                        </div>
                                                                        <div class="col-12">
                                                                            <label class="checkbox">
                                                                                <input type="checkbox" value="MAY"
                                                                                       class="chooseSeasonCB"
                                                                                       name="chooseSeasonCB">
                                                                                <i></i> מאי
                                                                            </label>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                            <!--days-->
                                                            <div class="row">
                                                                <div class="col-md-12">

                                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content text-center">
                                                                        <div class="box-icon-title">
                                                                            <i class="handle-small fa fa-calendar-o"></i>
                                                                            <h2 class="pinkText">ימים בשבוע</h2>
                                                                        </div>
                                                                        <label class="checkbox">
                                                                            <input type="checkbox" value="SUNDAY"
                                                                                   class="chooseSeasonCB"
                                                                                   name="chooseDaysCB">
                                                                            <i></i> ראשון
                                                                        </label>
                                                                        <label class="checkbox">
                                                                            <input type="checkbox" value="MONDAY"
                                                                                   class="chooseSeasonCB"
                                                                                   name="chooseDaysCB">
                                                                            <i></i> שני
                                                                        </label>
                                                                        <label class="checkbox">
                                                                            <input type="checkbox" value="TUESDAY"
                                                                                   class="chooseSeasonCB"
                                                                                   name="chooseDaysCB">
                                                                            <i></i> שלישי
                                                                        </label>
                                                                        <label class="checkbox">
                                                                            <input type="checkbox" value="WEDNESDAY"
                                                                                   class="chooseSeasonCB"
                                                                                   name="chooseDaysCB">
                                                                            <i></i> רביעי
                                                                        </label>
                                                                        <label class="checkbox">
                                                                            <input type="checkbox" value="THURSDAY"
                                                                                   class="chooseSeasonCB"
                                                                                   name="chooseDaysCB">
                                                                            <i></i> חמישי
                                                                        </label>
                                                                        <label class="checkbox">
                                                                            <input type="checkbox" value="FRIDAY"
                                                                                   class="chooseSeasonCB"
                                                                                   name="chooseDaysCB">
                                                                            <i></i> שישי
                                                                        </label>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="divider"></div>

                                                        <!--specific-->
                                                        <label class="checkbox">
                                                            <input type="radio" value="SPECIFIC" id="specificCB"
                                                                   name="whenRadio" onclick="WhenToggle('specificCB')">
                                                            <i></i> חייבים להתחתן ביום הולדת!
                                                        </label>
                                                        <div id="chooseSpecific" style="display: none">
                                                            <div class="row text-center">
                                                                <label class="pinkText">בחרו את התאריך שלכם:</label>
                                                                <input type="text" id="specificDateInput"
                                                                       onchange="dateValue()"
                                                                       class="datepicker pinkText chooseSpecificDate"
                                                                       name="specificDate" data-format="dd/mm/yyyy"
                                                                       style="display: inline; margin-top: 1px !important; position: unset; ">
                                                            </div>
                                                        </div>

                                                        <!--save-->
                                                        <div class="row">
                                                        </div>
                                                        <div class="row text-left">
                                                            <div class="col-12">
                                                                <button type="submit" id="submitWhen"
                                                                        class="btn btn-info btn-round btn-lg" disabled>
                                                                    שמור
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <script>
                                                        function WhenToggle(id) {
                                                            var cbarray = document.getElementsByClassName('chooseSeasonCB');
                                                            switch (id) {
                                                                case 'spontaneousCB':
                                                                    document.getElementById('chooseSeason').style.display = "none";
                                                                    document.getElementById('chooseSpecific').style.display = "none";
                                                                    document.getElementById('submitWhen').disabled = false;
                                                                    for (var i = 0; i < cbarray.length; i++) {
                                                                        cbarray[i].checked = false;
                                                                    }
                                                                    $('.chooseSpecificDate').val('').datepicker('update');
                                                                    break;
                                                                case 'seasonCB':
                                                                    document.getElementById('chooseSeason').style.display = "block";
                                                                    document.getElementById('chooseSpecific').style.display = "none";
                                                                    document.getElementById('submitWhen').disabled = true;
                                                                    $('.chooseSpecificDate').val('').datepicker('update');
                                                                    break;
                                                                default: //specific
                                                                    document.getElementById('chooseSeason').style.display = "none";
                                                                    document.getElementById('chooseSpecific').style.display = "block";
                                                                    document.getElementById('submitWhen').disabled = true;
                                                                    for (var i = 0; i < cbarray.length; i++) {
                                                                        cbarray[i].checked = false;
                                                                    }
                                                            }
                                                        }

                                                        function dateValue() {
                                                            if (document.getElementsByClassName('chooseSpecificDate').valueOf())
                                                                document.getElementById('submitWhen').disabled = false;
                                                        }
                                                    </script>

                                                    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js">
                                                    </script>
                                                    <script>
                                                        var checkBoxes = $('.chooseSeasonCB');
                                                        $('.chooseSeasonCB').change(function () {
                                                            $('#submitWhen').prop('disabled', checkBoxes.filter(':checked').length < 1);
                                                        });
                                                    </script>
                                                </form>
                                            </div>

                                            <div id="Where" class="tab-pane">
                                                <form id="formWhere" action="/couple" method="post">
                                                    <input name="action_Where" hidden>
                                                    <div class="row">
                                                        <div class="col-4">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="GUSH_DAN" name="AreaCB"
                                                                       class="chooseAreaCB">
                                                                <i></i> מרכז
                                                            </label>
                                                        </div>
                                                        <div class="col-4">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="NORTH" name="AreaCB"
                                                                       class="chooseAreaCB">
                                                                <i class="btn-pink"></i> צפון
                                                            </label>
                                                        </div>
                                                        <div class="col-4">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="SHFELA" name="AreaCB"
                                                                       class="chooseAreaCB">
                                                                <i></i> שפלה
                                                            </label>
                                                        </div>
                                                        <div class="col-4">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="JERUSALEM" name="AreaCB"
                                                                       class="chooseAreaCB">
                                                                <i></i> ירושלים
                                                            </label>
                                                        </div>
                                                        <div class="col-4">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="SHARON" name="AreaCB"
                                                                       class="chooseAreaCB">
                                                                <i></i> שרון
                                                            </label>
                                                        </div>
                                                        <div class="col-4">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="SOUTH" name="AreaCB"
                                                                       class="chooseAreaCB">
                                                                <i></i> דרום
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <!--save-->
                                                    <div class="row text-left">
                                                        <div class="col-12 text-left">
                                                            <button type="submit" class="btn btn-info btn-round btn-lg"
                                                                    id="submitArea" disabled>
                                                                שמור
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                            <script>
                                                var checkBoxesArea = $('.chooseAreaCB');
                                                $('.chooseAreaCB').change(function () {
                                                    $('#submitArea').prop('disabled', checkBoxesArea.filter(':checked').length < 1);
                                                });
                                            </script>

                                            <div id="OurStyle" class="tab-pane">
                                                <form id="formStyle" action="/couple" method="post">
                                                    <input name="action_Style" hidden>
                                                    <div class="row">
                                                        <div class="col-md-4">
                                                            <div class="row">
                                                                <img src="../client/html/chandelier.png"
                                                                     onclick="toggleCheck('classic')"
                                                                     class="my-img-hover">
                                                            </div>
                                                            <label class="checkbox text-center">
                                                                <input type="checkbox" value="CLASSIC" id="classic"
                                                                       name="styleCB" class="chooseStyleCB">
                                                                <i></i> קלאסי
                                                            </label>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="row">
                                                                <img src="../client/html/graffiti.png"
                                                                     onclick="toggleCheck('urban')"
                                                                     class="my-img-hover">
                                                            </div>
                                                            <label class="checkbox text-center">
                                                                <input type="checkbox" value="URBAN" id="urban"
                                                                       name="styleCB" class="chooseStyleCB">
                                                                <i></i> אורבני
                                                            </label>
                                                        </div>
                                                        <div class="col-md-4">
                                                            <div class="row">
                                                                <img src="../client/html/house.png"
                                                                     onclick="toggleCheck('rural')"
                                                                     class="my-img-hover">
                                                            </div>
                                                            <label class="checkbox text-center">
                                                                <input type="checkbox" value="RURAL" id="rural"
                                                                       name="styleCB" class="chooseStyleCB">
                                                                <i></i> כפרי
                                                            </label>
                                                        </div>
                                                    </div>

                                                    <!--save-->
                                                    <div class="row text-left">
                                                        <div class="col-12">
                                                            <button type="submit" class="btn btn-info btn-round btn-lg"
                                                                    id="submitStyle" disabled>
                                                                שמור
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                                <script>
                                                    function toggleCheck(idToToggle) {
                                                        document.getElementById(idToToggle).checked = !document.getElementById(idToToggle).checked;
                                                    }
                                                </script>
                                                <script>
                                                    var checkBoxesStyle = $('.chooseStyleCB');
                                                    $('.chooseStyleCB').change(function () {
                                                        $('#submitStyle').prop('disabled', checkBoxesStyle.filter(':checked').length < 1);
                                                    });
                                                </script>
                                            </div>

                                            <div id="Budget" class="tab-pane">
                                                <form id="formBudget" action="/couple" method="post">
                                                    <input name="action_Budget" hidden>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="budgetHeight box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content text-center">
                                                                <div class="box-icon-title">
                                                                    <i class="fa fa-users d-none d-sm-block"
                                                                       style="margin-right:-25px"></i>
                                                                    <h2>כמה אנשים אתם תהיו?</h2>
                                                                </div>
                                                                <input type="number" min=80 value="<%=howManyInvites%>"
                                                                       class="selectAmount"
                                                                       name="howManyPeople" id="howManyInput"
                                                                       onchange="budgetValues()">
                                                            </div>

                                                        </div>

                                                        <div class="col-md-6">
                                                            <div class="budgetHeight box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content text-center">
                                                                <div class="box-icon-title">
                                                                    <i class="fa fa-dollar d-none d-sm-block"
                                                                       style="margin-right:-25px"></i>
                                                                    <h2>
                                                                        מה התקציב לכל למנה?
                                                                    </h2>
                                                                </div>
                                                                <select class="selectpicker show-tick selectBudget"
                                                                        name="price" on="budgetValues()" required>
                                                                    <option value="">מה התקציב שלכם?</option>
                                                                    <option value="NO_RANGE">עוד לא גיבשנו תקציב
                                                                    </option>
                                                                    <option value="ONE_FIFTY">150-200</option>
                                                                    <option value="TWO_HUNDRED">200-250</option>
                                                                    <option value="TWO_FIFTY">250-300</option>
                                                                    <option value="THREE_HUNDRED">300-350</option>
                                                                    <option value="THREE_FIFTY">350-400</option>
                                                                    <option value="FOUR_HUNDRED">400-450</option>
                                                                    <option value="FOUR_FIFTY">450-500</option>
                                                                    <option value="FIVE_HUNDRED">יותר מ-500</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!--save-->
                                                    <div class="row text-left">
                                                        <div class="col-12">
                                                            <button type="submit" class="btn btn-info btn-round btn-lg"
                                                                    id="submitBudget">
                                                                שמור
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--<div class="justify-content-around row rtl text-center">
        <div class="col-md-4">
            <button type="button" class="btn btn-info" id="showS" onclick="collapsing('ShowSettings','editSettings')">
                <span class="ico-hover et-gears" style="margin-left:10px"></span>
                צפו בפרטים שלכם
            </button>
        </div>
        <div class="col-md-4">
            <button type="button" class="btn btn-info" id="editS" onclick="collapsing('editSettings','ShowSettings')">
                <span class="ico-hover et-tools-2" style="margin-left:10px"></span>
                ערכו את הפרטים שלכם
            </button>
        </div>
    </div>-->
        </div>
    </section>
    <!-- /My Account -->

    <!-- MyOffers -->
    <section id="MyOffers" class="bgImage sectionOpacity">
        <h1 class="pinkText text-center">ההצעות שלכם</h1>
        <div class="container">
            <div class="col-sm-12 text-center">
                <div class="table-responsive">
                    <table class="table">
                        <%List<Supplier> linkedSuppliers = (List<Supplier>) request.getAttribute("linkedSuppliers"); %>

                        <thead class="thead-light pinkText">
                        <tr>
                            <th scope="col">שם האולם</th>
                            <th scope="col">איזור</th>
                            <th scope="col">איש קשר</th>
                            <th scope="col">טלפון</th>
                            <th scope="col">אתר אינטרנט</th>

                        </tr>
                        </thead>
                        <tbody>
                        <%
                            if (linkedSuppliers != null) {
                                for (int i = 0; i < linkedSuppliers.size(); ++i) {
                                    String clickTpWeb = "לאתר";
                                    if (linkedSuppliers.get(i).getWebsite() == "")
                                        clickTpWeb = "";
                        %>
                        <tr>
                            <td><%= linkedSuppliers.get(i).getVenueName() %>
                            </td>
                            <td><%= linkedSuppliers.get(i).getAreaName(linkedSuppliers.get(i).getArea()) %>
                            </td>
                            <td><%= linkedSuppliers.get(i).getName() %>
                            </td>
                            <td><%= linkedSuppliers.get(i).getPhone() %>
                            </td>
                            <td>
                                <a href="<%= linkedSuppliers.get(i).getWebsite() %>" target="_blank">
                                    <div style="height:100%;width:100%;text-decoration: underline;">
                                        <%=clickTpWeb%>
                                    </div>
                                </a>
                            </td>

                        </tr>
                        <%
                                }
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
    <!-- /MyOffers -->

    <!-- Recommendation -->
    <section id="Recommendation">
        <h1 class="pinkText text-center">המומלצים שלנו</h1>

        <div class=" revolution_slider">
            <div class="slider fullwidthbanner-container roundedcorners mb-60">

                <div class="fullwidthbanner" data-height="500" data-navigationStyle="preview2">
                    <ul class="hide">
                        <!-- SLIDE  -->
                        <li data-transition="fade" data-slotamount="1" data-masterspeed="1000"
                            data-saveperformance="off" data-title="">
                            <div class="">
                                <img src="../client/html/GanVradim02.jpg" class="img-fluid hidden-md-up" alt="Nature"
                                     style="max-width: 100% !important;">
                                <img src="../client/html/GanVradim02.jpg" class="img-fluid hidden-sm-down" alt="Nature">
                                <div class="carousel-caption">
                                    <h3>גן הורדים</h3>
                                    <h4 class="visible-xs-block hidden-xs">ראשון לציון</h4>
                                    <p class="visible-xs-block hidden-xs">
                                        גן יפייפה בלב הכרך הסואן המשלב בין הטבע הפראי לעיצוב האורבני. בגן ישנו גם אולם
                                        מעוצב להפליא ומאובזר בטכנולוגיות המובילות
                                        ביותר בשביל האירוע המוצלח שלכם.
                                    </p>
                                </div>
                            </div>
                        </li>

                        <li data-transition="fade" data-slotamount="1" data-masterspeed="1000"
                            data-saveperformance="off" data-title="">
                            <div class="">
                                <img src="../client/html/alenby.jpeg" class="img-fluid hidden-md-up" alt="Nature"
                                     style="max-width: 100% !important;">
                                <img src="../client/html/alenby.jpeg" class="img-fluid hidden-sm-down" alt="Nature">
                                <div class="carousel-caption">
                                    <h3>חוות אלנבי</h3>
                                    <h4 class="visible-xs-block hidden-xs">נצר סירני</h4>
                                    <p class="visible-xs-block hidden-xs">
                                        חפשים את המקום המושלם לחגוג חתונות קטנות במרכז? אולם אירועים בשפלה חוות אלנבי,
                                        מתמחה בהפקת אירועים עד 300 איש, כנסו להתרשמות
                                        ויצירת קשר לאירועים באווירה כפרית.
                                    </p>
                                </div>
                            </div>
                        </li>
                    </ul>
                    <div class="tp-bannertimer">
                        <!-- progress bar -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- /Recommendation -->

    <script>
        function disableStart() {
            document.getElementById("start").style.display = "none";
        }
    </script>
    <!-- SCROLL TO TOP -->
    <a href="#" id="toTop"></a>

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