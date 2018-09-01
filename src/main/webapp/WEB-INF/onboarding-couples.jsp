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
    <div id="header" class="navbar-toggleable-md sticky transparent header-md clearfix">
        <header id="topNav">
            <div class="container">

                <!-- Mobile Menu Button -->
                <button class="btn btn-mobile" data-toggle="collapse" data-target=".nav-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Logo -->
                <!--<a class="logo float-left scrollTo" href="#top">
                    <img src="../client/html/assets/images/_smarty/logo_light.png" alt="" />
                    <img src="../client/html/assets/images/_smarty/logo_dark.png" alt="" />
                </a>-->

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
                        </ul>

                    </nav>
                </div>
            </div>
        </header>
        <!-- /Top Nav -->

    </div>

    <!-- My Account -->
    <section id="MyAccount" class="">
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
                <h2 class="pinkText">החשבון שלנו</h2>
                <hr/>
            </header>

            <div class="container" style="margin-bottom: 15%">
                <div class="row">

                    <!-- tabs -->
                    <div class="col-md-3 col-sm-3">
                        <ul class="nav nav-tabs nav-stacked flex-column text-right">
                            <li class="nav-item">
                                <a class="nav-link" href="#When" data-toggle="tab" onclick="disableStart()">
                                    מתי נתחתן?
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#Where" data-toggle="tab" onclick="disableStart()">
                                    איפה נתחתן?
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#OurStyle" data-toggle="tab" onclick="disableStart()">
                                    מה הסטייל שלנו?
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#Budget" data-toggle="tab" onclick="disableStart()">
                                    על כמה נשלם?
                                </a>
                            </li>
                        </ul>
                    </div>

                    <!-- tabs content -->
                    <div class="col-md-9 col-sm-9">
                        <div id="start" Sclass="col-md-12">
                            <div class="box-icon box-icon-center box-icon-content text-right" style=" margin-top: 0px">
                                <img style='vertical-align:middle;' src='../client/html/arrow.png'>
                                <h2 style="float:left; margin-left: 34%; margin-top:3%;">
                                    איך תרצו להתחתן?</h2>
                            </div>

                        </div>
                        <div class="tab-content tab-stacked nav-alternate text-right">
                            <section id="When" class="tab-pane">
                                <form id="formWhen" action="/couple" method="post">
                                    <input name="action_When" hidden>
                                    <div class="row"></div>
                                    <div class="checkbox col-12">

                                        <!--spontaneous-->
                                        <label class="checkbox">
                                            <input type="radio" id="spontaneousCB" value="spontaneous" name="whenRadio"
                                                   onclick="WhenToggle('spontaneousCB')">
                                            <i></i> ספונטנים
                                        </label>
                                        <div class="divider"></div>

                                        <!--season-->
                                        <label class="checkbox">
                                            <input type="radio" value="season" id="seasonCB" name="whenRadio"
                                                   onclick="WhenToggle('seasonCB')">
                                            <i></i> תמיד חלמתי להתחתן ב...
                                        </label>
                                        <div id="chooseSeason" class="collapse">
                                            <!--season-->
                                            <div class="row">
                                                <!-- summer -->
                                                <div class="col-3">
                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content">
                                                        <div class="box-icon-title">
                                                            <i class="handle-small fa fa-sun-o"></i>
                                                            <h2 class="pinkText">קיץ</h2>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="june" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> יוני
                                                            </label>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="july" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> יולי
                                                            </label>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="august" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> אוגוסט
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- fall -->
                                                <div class="col-3">
                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content">
                                                        <div class="box-icon-title">
                                                            <i class="handle-small fa fa-leaf"></i>
                                                            <h2 class="pinkText">סתיו</h2>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="september" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> ספטמבר
                                                            </label>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="october" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> אוקטובר
                                                            </label>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="november" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> נובמבר
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- winter -->
                                                <div class="col-3">
                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content">
                                                        <div class="box-icon-title">
                                                            <i class="handle-small fa fa-umbrella"></i>
                                                            <h2 class="pinkText">חורף</h2>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="december" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> דצמבר
                                                            </label>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="january" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> ינואר
                                                            </label>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="february" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> פברואר
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- spring -->
                                                <div class="col-3">
                                                    <div class="box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content">
                                                        <div class="box-icon-title">
                                                            <i class="handle-small fa fa-tree"></i>
                                                            <h2 class="pinkText">אביב</h2>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="march" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> מרץ
                                                            </label>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="april" class="chooseSeasonCB" name="chooseSeasonCB">
                                                                <i></i> אפריל
                                                            </label>
                                                        </div>
                                                        <div class="col-12">
                                                            <label class="checkbox">
                                                                <input type="checkbox" value="may" class="chooseSeasonCB" name="chooseSeasonCB">
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
                                                            <input type="checkbox" value="sunday" class="chooseSeasonCB" name="chooseDaysCB">
                                                            <i></i> ראשון
                                                        </label>
                                                        <label class="checkbox">
                                                            <input type="checkbox" value="monday" class="chooseSeasonCB" name="chooseDaysCB">
                                                            <i></i> שני
                                                        </label>
                                                        <label class="checkbox">
                                                            <input type="checkbox" value="tuesday" class="chooseSeasonCB" name="chooseDaysCB">
                                                            <i></i> שלישי
                                                        </label>
                                                        <label class="checkbox">
                                                            <input type="checkbox" value="wednesday" class="chooseSeasonCB" name="chooseDaysCB">
                                                            <i></i> רביעי
                                                        </label>
                                                        <label class="checkbox">
                                                            <input type="checkbox" value="thursday" class="chooseSeasonCB" name="chooseDaysCB">
                                                            <i></i> חמישי
                                                        </label>
                                                        <label class="checkbox">
                                                            <input type="checkbox" value="friday" class="chooseSeasonCB" name="chooseDaysCB">
                                                            <i></i> שישי
                                                        </label>
                                                        <label class="checkbox">
                                                            <input type="checkbox" value="saturday" class="chooseSeasonCB" name="chooseDaysCB">
                                                            <i></i> שבת
                                                        </label>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="divider"></div>

                                        <!--specific-->
                                        <label class="checkbox">
                                            <input type="radio" value="specific" id="specificCB" name="whenRadio"
                                                   onclick="WhenToggle('specificCB')">
                                            <i></i> חייבים להתחתן ביום הולדת!
                                        </label>
                                        <div id="chooseSpecific" style="display: none">
                                            <div class="row text-center">
                                                <label class="pinkText">בחרו את התאריך שלכם:</label>
                                                <input type="text" class="datepicker pinkText chooseSpecificDate" name="specificDate"
                                                       data-format="dd/mm/yyyy"
                                                       style="display: inline; margin-top: 1px !important; position: unset; ">
                                            </div>
                                        </div>

                                        <!--save-->
                                        <div class="row">
                                        </div>
                                        <div class="row text-left">
                                            <div class="col-12">
                                                <button type="submit" class="btn btn-info btn-round btn-lg">שמור
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <script>
                                        function WhenToggle(id) {
                                            switch (id) {
                                                case 'spontaneousCB':
                                                    document.getElementById('chooseSeason').style.display = "none";
                                                    document.getElementById('chooseSpecific').style.display = "none";
                                                    var cbarray = document.getElementsByClassName('chooseSeasonCB');
                                                    for (var i = 0; i < cbarray.length; i++) {
                                                        cbarray[i].checked = false;
                                                    }
                                                    $('.chooseSpecificDate').val('').datepicker('update');
                                                    break;
                                                case 'seasonCB':
                                                    document.getElementById('chooseSeason').style.display = "block";
                                                    document.getElementById('chooseSpecific').style.display = "none";
                                                    $('.chooseSpecificDate').val('').datepicker('update');
                                                    break;
                                                default: //specific
                                                    document.getElementById('chooseSeason').style.display = "none";
                                                    document.getElementById('chooseSpecific').style.display = "block";
                                                    var cbarray = document.getElementsByClassName('chooseSeasonCB');
                                                    for (var i = 0; i < cbarray.length; i++) {
                                                        cbarray[i].checked = false;
                                                    }
                                            }
                                        }
                                    </script>
                                </form>
                            </section>

                            <section id="Where" class="tab-pane">
                                <form id="formWhere" action="/couple" method="post">
                                    <input name="action_Where" hidden>
                                    <div class="row">
                                        <div class="col-4">
                                            <label class="checkbox">
                                                <input type="checkbox" value="GushDan" name="AreaCB">
                                                <i></i> מרכז
                                            </label>
                                        </div>
                                        <div class="col-4">
                                            <label class="checkbox">
                                                <input type="checkbox" value="North" name="AreaCB">
                                                <i class="btn-pink"></i> צפון
                                            </label>
                                        </div>
                                        <div class="col-4">
                                            <label class="checkbox">
                                                <input type="checkbox" value="Shfela" name="AreaCB">
                                                <i></i> שפלה
                                            </label>
                                        </div>
                                        <div class="col-4">
                                            <label class="checkbox">
                                                <input type="checkbox" value="Jerusalem" name="AreaCB">
                                                <i></i> ירושליים
                                            </label>
                                        </div>
                                        <div class="col-4">
                                            <label class="checkbox">
                                                <input type="checkbox" value="Sharon" name="AreaCB">
                                                <i></i> שרון
                                            </label>
                                        </div>
                                        <div class="col-4">
                                            <label class="checkbox">
                                                <input type="checkbox" value="South" name="AreaCB">
                                                <i></i> דרום
                                            </label>
                                        </div>
                                        <!--save-->
                                        <div class="row text-left">
                                            <div class="col-12">
                                                <button type="submit" class="btn btn-info btn-round btn-lg">שמור</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </section>

                            <section id="OurStyle" class="tab-pane">
                                <form id="formStyle" action="/couple" method="post">
                                    <input name="action_Style" hidden>
                                    <div class="row">
                                        <div class="col-4">
                                            <div class="row">
                                                <img src="../client/html/chandelier.png" onclick="toggleCheck('classic')"
                                                     class="my-img-hover">
                                            </div>
                                            <label class="checkbox text-center">
                                                <input type="checkbox" value="Classic" id="classic" name="styleCB">
                                                <i></i> קלאסי
                                            </label>
                                        </div>
                                        <div class="col-4">
                                            <div class="row">
                                                <img src="../client/html/graffiti.png" onclick="toggleCheck('urban')" class="my-img-hover">
                                            </div>
                                            <label class="checkbox text-center">
                                                <input type="checkbox" value="Urban" id="urban" name="styleCB">
                                                <i></i> אורבני
                                            </label>
                                        </div>
                                        <div class="col-4">
                                            <div class="row">
                                                <img src="../client/html/house.png" onclick="toggleCheck('rural')" class="my-img-hover">
                                            </div>
                                            <label class="checkbox text-center">
                                                <input type="checkbox" value="Rural" id="rural" name="styleCB">
                                                <i></i> כפרי
                                            </label>
                                        </div>
                                    </div>

                                    <!--save-->
                                    <div class="row text-left">
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-info btn-round btn-lg">שמור</button>
                                        </div>
                                    </div>
                                </form>
                                <script>
                                    function toggleCheck(idToToggle) {
                                        document.getElementById(idToToggle).checked = !document.getElementById(idToToggle).checked;
                                    }
                                </script>
                            </section>

                            <section id="Budget" class="tab-pane">
                                <form id="formBudget" action="/couple" method="post">
                                    <input name="action_Budget" hidden>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="budgetHeight box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content text-center">
                                                <div class="box-icon-title">
                                                    <i class="fa fa-users"></i>
                                                    <h2>כמה אנשים אתם תהיו?</h2>
                                                </div>
                                                <input type="number" min=80 placeholder="מינימום 80" name="howManyPeople">
                                            </div>

                                        </div>

                                        <div class="col-md-6">
                                            <div class="budgetHeight box-icon box-icon-center box-icon-round box-icon-transparent box-icon-large box-icon-content text-center">
                                                <div class="box-icon-title">
                                                    <i class="fa fa-dollar"></i>
                                                    <h2>
                                                        מה התקציב לכל למנה?
                                                    </h2>
                                                </div>
                                                <select class="selectpicker show-tick" name="price">
                                                    <option value="OneFifty">150-200</option>
                                                    <option value="Two">200-250</option>
                                                    <option value="TwoFifty">250-300</option>
                                                    <option value="Three">300-350</option>
                                                    <option value="ThreeFifty">350-400</option>
                                                    <option value="Four">400-450</option>
                                                    <option value="Five">יותר מ500</option>
                                                    <option value="NoRange">עוד לא גיבשנו תקציב</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <!--save-->
                                    <div class="row text-left">
                                        <div class="col-12">
                                            <button type="button" class="btn btn-info btn-round btn-lg">שמור</button>
                                        </div>
                                    </div>
                                </form>
                            </section>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- /My Account -->

    <!-- MyOffers -->
    <section id="MyOffers" class="bgImage sectionOpacity">
        <h1 class="pinkText text-center">ההצעות שלכם</h1>
        <div class="container">
            <div class="col-sm-12 text-center">
                <div class="table-responsive-sm">
                    <table class="table">
                        <thead class="thead-light pinkText">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">שם האולם</th>
                            <th scope="col">כתובת</th>
                            <th scope="col">טלפון</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>חוות אלנבי</td>
                            <td>נצר סירני, 7039500</td>
                            <td>077-12356</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>גן הורדים</td>
                            <td>הרצל 150, ראשון לציון</td>
                            <td>077-12356</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>הקיו</td>
                            <td>גליל ים</td>
                            <td>077-12356</td>
                        </tr>
                        <tr>
                            <th scope="row">1</th>
                            <td>חוות אלנבי</td>
                            <td>נצר סירני, 7039500</td>
                            <td>077-12356</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>גן הורדים</td>
                            <td>הרצל 150, ראשון לציון</td>
                            <td>077-12356</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>הקיו</td>
                            <td>גליל ים</td>
                            <td>077-12356</td>
                        </tr>
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
                            <div class="my-container">
                                <div class="row">
                                    <img src="../client/html/GanVradim02.jpg" class="responsive" alt="Nature">
                                    <div class="my-text-block text-center">
                                        <h3>גן הורדים</h3>
                                        <h4>ראשון לציון</h4>
                                        <p>
                                            גן יפייפה בלב הכרך הסואן המשלב בין הטבע הפראי לעיצוב האורבני. בגן ישנו גם
                                            אולם מעוצב להפליא ומאובזר בטכנולוגיות המובילות
                                            ביותר בשביל האירוע המוצלח שלכם.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>

                        <li data-transition="fade" data-slotamount="1" data-masterspeed="1000"
                            data-saveperformance="off" data-title="">
                            <div class="my-container">
                                <img src="../client/html/alenby.jpeg" class="responsive" alt="Nature">
                                <div class="my-text-block text-center">
                                    <h3>חוות אלנבי</h3>
                                    <h4>נצר סירני</h4>
                                    <p>
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