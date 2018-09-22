<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="he" dir="rtl">

<head>
    <meta charset="utf-8" />
    <title>מארגנת החתונות</title>
    <meta name="description" content="" />
    <meta name="Author" content="" />

    <!-- mobile settings -->
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0" />
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->
    <!-- WEB FONTS : use %7C instead of | (pipe) -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"
          rel="stylesheet" type="text/css" />

    <!-- CORE CSS -->
    <link href="../client/html/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

    <!-- THEME CSS -->
    <link href="../client/html/assets/css/layout.css" rel="stylesheet" type="text/css" />

    <!-- PAGE LEVEL SCRIPTS -->
    <link href="../client/html/assets/css/header-1.css" rel="stylesheet" type="text/css" />
    <link href="../client/html/assets/css/color_scheme/green.css" rel="stylesheet" type="text/css" id="color_scheme" />
    <link href="../client/html/assets/css/essentials.css" rel="stylesheet" type="text/css" />
    <link href="../client/html/assets/css/MyStyle.css" rel="stylesheet" />
    <link href="../client/html/assets/css/layout-RTL.css" rel="stylesheet" />


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
                                <a href="#slider" class="pinkText">
                                    ראשי
                                </a>
                            </li>
                            <li>
                                <a href="#login" class="pinkText">
                                    התחברות
                                </a>
                            </li>
                            <li>
                                <a href="#about" class="pinkText">
                                    מי אנחנו
                                </a>
                            </li>
                        </ul>

                    </nav>
                </div>

            </div>
        </header>
        <!-- /Top Nav -->

    </div>


    <!-- SLIDER -->
    <section id="slider" class="fullheight transparent">
        <div class="overlay dark-2"></div>

        <!-- Video Background - replace videoURL with your youtube video URL -->
        <a id="YTPlayer" class="player" data-property="{videoURL:'https://youtu.be/6t6QbWyrP7I',containment:'body',autoPlay:true, mute:true, startAt:4, opacity:1}">youtube</a>
        <!--/Video Background -->

        <div class="display-table">
            <div class="display-table-cell vertical-align-middle">
                <div class="container">

                    <div class="slider-featured-text text-center">
                        <h1 class="text-white wow fadeInUp" data-wow-delay="0.4s">
                            סירי
                        </h1>
                        <h1 class="text-white wow fadeInUp" data-wow-delay="0.4s">
                            מארגנת החתונות
                        </h1>
                        <h2 class="fw-300 text-white wow fadeInUp" data-wow-delay="0.8s">העוזרת הדיגיטלית שתלווה אתכם עד החופה
                        </h2>


                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-6">
                            <a href="#login" class="btn btn-featured btn-round btn-pink">
                                <span style="font-size:24px;" id="coupleSignUp" onClick="clickCB('couples')">מתחתנים</span>
                                <i class="et-heart btn-round"></i>
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-6">
                            <a href="#login" class="btn btn-featured btn-round btn-aqua">
                                <span style="font-size:24px;" id="supplierSignUp" onClick="clickCB('suppliers')">ספקים</span>
                                <i class="et-wine btn-round"></i>

                            </a>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </section>
    <!-- /SLIDER -->
    <!-- CONTACT -->
    <section id="login" class="bgImage sectionOpacity">
        <div class="container">
            <header class="text-center mb-60">
                <h2 class="pinkText">התחברות</h2>
                <hr/>
            </header>

            <div class="container">
                <div class="row">

                    <!-- LOGIN -->
                    <div class="col-md-4 col-sm-5">
                        <div class="box-static box-border-top p-30 box-white">
                            <div class="box-title mb-30">
                                <h2 class="fs-20">משתמש קיים</h2>
                            </div>

                            <form class="sky-form" method="post" action="/user" autocomplete="off" >
                                <input name="action_signin" hidden>
                                <div class="clearfix">

                                    <!-- Email -->
                                    <label>דוא"ל</label>
                                    <label class="input mb-10">
                                        <i class="ico-append et-envelope"></i>
                                        <input required="" type="email" name="email">
                                        <b class="tooltip tooltip-bottom-right">כתובת דוא"ל להתחברות</b>
                                    </label>

                                    <!-- Password -->
                                    <label>סיסמה</label>
                                    <label class="input mb-10">
                                        <i class="ico-append et-key"></i>
                                        <input required="" type="password" name="password">
                                        <b class="tooltip tooltip-bottom-right">הסיסמה הסודית שלכם</b>
                                    </label>

                                    <p name="CorrectLogin" text=" ">
                                        <b>
                                            <%String isCorrectLogin = (String) request.getAttribute("isCorrectLogin"); %>
                                            <h4 style="color: red"><%=isCorrectLogin%>
                                            </h4>
                                        </b>
                                    </p>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 col-sm-6 col-6">
                                        <!-- Inform Tip -->
                                        <div class="form-tip pt-20">
                                            <a class="btn btn-outline-link" href="#"></a>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-6 text-left" style="float:left;">
                                        <button type="submit" class="btn btn-pink btn-round btn-lg left">כניסה</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                    <!-- /LOGIN -->
                    <!-- REGISTER -->
                    <div class="col-md-8 col-sm-7">

                        <div class="box-static box-bordered box-white p-30">

                            <div class="box-title mb-30">
                                <h2 class="fs-20">לא רשומים? הרשמו עכשיו</h2>
                            </div>
                            <form class="m-0 sky-form" action="/user" method="post"  dir="rtl">
                                <fieldset>
                                    <div class="row">

                                        <div class="col-md-6 col-sm-6">
                                            <label>שם פרטי *</label>
                                            <label class="input mb-10">
                                                <i class="ico-append et-profile-male"></i>
                                                <input name="firstName" required="" type="text">
                                                <b class="tooltip tooltip-bottom-right">הקלד/י את השם הפרטי שלך</b>
                                            </label>
                                        </div>

                                        <div class="col-md-6 col-sm-6">
                                            <label>שם משפחה *</label>
                                            <label class="input mb-10">
                                                <i class="ico-append et-profile-male"></i>
                                                <input name="lastName" required="" type="text">
                                                <b class="tooltip tooltip-bottom-right">הקלד/י את השם המשפחה שלך</b>
                                            </label>
                                        </div>

                                    </div>

                                    <div class="row">

                                        <div class="col-md-6 col-sm-6">
                                            <label>דוא"ל" *</label>
                                            <label class="input mb-10">
                                                <i class="ico-append et-envelope"></i>
                                                <input name="userEmail" required="" type="email">
                                                <b class="tooltip tooltip-bottom-right">כתובת הדואר האלקטורני שלך</b>
                                            </label>
                                        </div>

                                        <div class="col-md-6 col-sm-6">
                                            <label>סיסמה*</label>
                                            <label class="input mb-10">
                                                <i class="ico-append et-pencil"></i>
                                                <input name="userPass" required="" type="text">
                                                <b class="tooltip tooltip-bottom-right">בחר/י סיסמה חזקה
                                                </b>
                                            </label>
                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6">
                                            <label class="radio-btn">
                                                <input type="radio" name="isSupplier" value="false" id="couples" required>
                                                <i></i> מתחתנים *
                                            </label>
                                        </div>
                                        <div class="col-md-6 col-sm-6">
                                            <label class="radio-btn">
                                                <input type="radio" name="isSupplier" value="true" id="suppliers" required>
                                                <i></i> ספקים *
                                            </label>
                                        </div>

                                    </div>
                                </fieldset>
                                <input name="action_signup" hidden>
                                <div class="row">
                                    <div class="col-md-12" style="float:left">
                                        <button type="submit" class="btn btn-pink btn-round">
                                            <i class="fa fa-check"></i> הרשמה
                                        </button>
                                    </div>
                                </div>

                            </form>

                        </div>

                    </div>
                    <!-- /REGISTER -->


                </div>

            </div>

        </div>
    </section>
    <!-- /CONTACT -->
    <section id="about" class="sectionOpacity aboutSectionDesktop">
        <div class="container">
            <header class="text-center mb-60">
                <h2 class="pinkText">מי אנחנו?</h2>
                <hr/>
            </header>
            <div class="container">
                <div class="row text-center">
                    <div class="col-md-6 col-sm-5">
                        <div>
                            <i class="et-heart ico-rounded ico-hover-dark ico-lg"></i>
                            <label>
                                לורם איפסום דולור סיט אמט, קונסקטורר אדיפיסינג אלית קולהע צופעט למרקוח איבן איף, ברומץ כלרשט מיחוצים. קלאצי קולהע צופעט למרקוח
                                איבן איף, ברומץ כלרשט מיחוצים. קלאצי סחטיר בלובק. תצטנפל בלינדו למרקל אס לכימפו, דול,
                                צוט ומעיוט - לפתיעם ברשג - ולתיעם גדדיש. קוויז דומור ליאמום בלינך רוגצה. לפמעט
                            </label>
                        </div>
                    </div>

                    <div class="col-md-6 col-sm-5">
                        <div style="width:95%">
                            <i class="et-wine ico-rounded ico-hover-dark ico-lg"></i>
                            <label>
                                לורם איפסום דולור סיט אמט, קונסקטורר אדיפיסינג אלית קולהע צופעט למרקוח איבן איף, ברומץ כלרשט מיחוצים. קלאצי קולהע צופעט למרקוח
                                איבן איף, ברומץ כלרשט מיחוצים. קלאצי סחטיר בלובק. תצטנפל בלינדו למרקל אס לכימפו, דול,
                                צוט ומעיוט - לפתיעם ברשג - ולתיעם גדדיש. קוויז דומור ליאמום בלינך רוגצה. לפמעט
                            </label>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
    <!-- SCROLL TO TOP -->
    <a href="#" id="toTop"></a>
    <!-- PRELOADER -->
    <div id="preloader">
        <div class="inner">
            <span class="loader"></span>
        </div>
    </div>
</div>

<!-- /PRELOADER -->

<!-- JAVASCRIPT FILES -->
<script>var plugin_path = '../client/html/assets/plugins/';</script>
<script src="../client/html/assets/plugins/jquery/jquery-3.3.1.min.js"></script>

<script src="../client/html/assets/js/scripts.js"></script>

<!-- PAGELEVEL SCRIPTS -->
<script src="../client/html/assets/js/contact.js"></script>
<script type="text/javascript">
    function clickCB(id) {
        document.getElementById(id).click();
    }

    // function getToSignInPage() {
    //     if (document.getElementById('suppliers').checked)
    //     window.location.href = "../html/onboarding-suppliers-toDelete.html";
    //
    //     else if(!document.getElementById('suppliers').checked)
    //         window.location.href = "../html/onboarding-couples.html";
    //     return false;
    // }

</script>
</body>

</html>
