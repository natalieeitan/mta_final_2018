<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="he" dir="rtl">

<head>
    <meta charset="utf-8"/>
    <title>Perfect Match</title>
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
</head>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function () {
        if ($(window).width() >= 768){
        $('html, body').animate({
            scrollTop: $('#passInputLogin').offset().top
        }, 'slow');
        }
        else {
            $('html, body').animate({
                scrollTop: $('#emailInputLogin').offset().top
            }, 'slow');
        }
    });
</script>

<body class="smoothcircle enable-animation has-video-bg"
      data-background="../client/html/assets/images/_smarty/backgrounds/default.jpg"
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
                            <li>
                                <a href="#testimonial" class="pinkText">
                                    זוגות מספרים
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
        <a id="YTPlayer" class="player"
           data-property="{videoURL:'https://youtu.be/6t6QbWyrP7I',containment:'body',autoPlay:true, mute:true, startAt:4, opacity:1}">youtube</a>
        <!--/Video Background -->

        <div class="display-table">
            <div class="display-table-cell vertical-align-middle">
                <div class="container">

                    <div class="slider-featured-text text-center">
                        <h1 class="text-white wow fadeInUp" data-wow-delay="0.4s">
                            Perfect Match
                        </h1>
                        <!--<h1 class="text-white wow fadeInUp" data-wow-delay="0.4s">-->
                        <!--מתאימים לכם חתונה-->
                        <!--</h1>-->
                        <h2 class="fw-300 text-white wow fadeInUp" data-wow-delay="0.8s"
                            style="font-size: 35px; margin-top: 30px">
                            שידוך מושלם בין מתחתנים לספקים
                        </h2>


                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-6">
                            <a href="#login" class="btn btn-featured btn-round btn-pink">
                                <span style="font-size:24px;" id="coupleSignUp"
                                      onClick="clickCB('couples')">מתחתנים</span>
                                <i class="et-heart btn-round"></i>
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-6">
                            <a href="#login" class="btn btn-featured btn-round btn-aqua">
                                <span style="font-size:24px;" id="supplierSignUp"
                                      onClick="clickCB('suppliers')">ספקים</span>
                                <i class="et-wine btn-round"></i>

                            </a>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </section>
    <!-- /SLIDER -->

    <!-- LOGIN -->
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

                            <form class="sky-form" method="post" action="/user" autocomplete="off">
                                <input name="action_signin" hidden>
                                <div class="clearfix">

                                    <!-- Email -->
                                    <label>דוא"ל</label>
                                    <label class="input mb-10">
                                        <i class="ico-append et-envelope"></i>
                                        <input required="" type="email" name="email" id="emailInputLogin">
                                        <b class="tooltip tooltip-bottom-right">כתובת דוא"ל להתחברות</b>
                                    </label>

                                    <!-- Password -->
                                    <label>סיסמה</label>
                                    <label class="input mb-10">
                                        <i class="ico-append et-key"></i>
                                        <input required="" type="password" name="password" id="passInputLogin">
                                        <b class="tooltip tooltip-bottom-right">הסיסמה הסודית שלכם</b>
                                    </label>

                                    <div name="CorrectLogin" text=" ">
                                        <%String isCorrectLogin = (String) request.getAttribute("isCorrectLogin"); %>
                                        <p style="color: red;font-weight: bold;"><%=isCorrectLogin%>
                                        </p>
                                    </div>
                                </div>

                                <div class="row text-left">
                                    <div class="col-md-12" style="float:left;">
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
                            <form class="m-0 sky-form" action="/user" method="post" dir="rtl">
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
                                            <label>דוא"ל *</label>
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
                                    <div>
                                        <p name="duplicateMail" text=" ">
                                            <b>
                                                <%String isDuplicateMail = (String) request.getAttribute("isDuplicateMail"); %>
                                                <h4 style="color: red"><%=isDuplicateMail%>
                                                </h4>
                                            </b>
                                        </p>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6">
                                            <label class="radio-btn">
                                                <input type="radio" name="isSupplier" value="false" id="couples"
                                                       required>
                                                <i></i> מתחתנים *
                                            </label>
                                        </div>
                                        <div class="col-md-6 col-sm-6">
                                            <label class="radio-btn">
                                                <input type="radio" name="isSupplier" value="true" id="suppliers"
                                                       required>
                                                <i></i> ספקים *
                                            </label>
                                        </div>

                                    </div>
                                </fieldset>
                                <input name="action_signup" hidden>
                                <div class="row text-left">
                                    <div class="col-md-12" style="float:left">
                                        <button type="submit" class="btn btn-pink btn-round btn-lg">
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
    <!-- /LOGIN -->

    <!-- ABOUT -->
    <section id="about" class="sectionOpacity aboutSectionDesktop">
        <div class="container">
            <header class="text-center mb-60">
                <h2 class="pinkText">מי אנחנו?</h2>
                <hr/>
            </header>
            <div class="container">
                <div class="justify-content-around row text-center">
                    <div class="col-md-5 col-sm-5">
                        <div>
                            <i class="et-heart ico-rounded ico-hover-dark ico-lg"></i>
                            <h2 class="wow fadeInUp" data-wow-delay="0.1s">מתחתנים?</h2>
                            <label class="wow fadeInUp" data-wow-delay="0.3s" style="font-size: 18px">קודם כל מזל טוב!
                                <br>
                                אם התחלתם בתהליך תכנון החתונה בוודאי כבר גיליתם שעולם החתונות מכיל בתוכו אינסוף אפשרויות
                                וקל מאוד ללכת בו לאיבוד.
                                <br>בשביל זה אנחנו כאן.
                                <br>
                                אנחנו ב- Perfect Match נמצא עבורכם את המקום המושלם לחתונה והכל בהתאמה אישית.
                                חשוב להדגיש, לא מדובר באתר חיפוש, Perfect Match פונה לאולמות אירועים בשבילכם ומציעה לכם
                                רק הצעות רלוונטיות ואישיות בהתאם לדרישות שלכם כדי לחסוך זמן בדרך לחתונה המושלמת.
                            </label>
                        </div>
                    </div>

                    <div class="col-md-5 col-sm-5">
                        <div style="width:95%">
                            <i class="et-wine ico-rounded ico-hover-dark ico-lg"></i>
                            <h2 class="wow fadeInUp" data-wow-delay="0.1s">ספקים?</h2>
                            <label class="wow fadeInUp" data-wow-delay="0.3s" style="font-size: 18px">
                                רוב הזוגות הולכים לבדוק ומקבלים הצעות מכ-8 מקומות לפני שהם סוגרים מקום לחתונה,
                                כך שגם אם אתם בעלי אולם אירועים איכותי ומרשים הרבה זוגות עלולים לפספס אתכם בזמן החיפוש.
                                <br>בשביל זה אנחנו כאן.
                                <br>אנחנו ב- Perfect Match פותחים עבורכם ערוץ נוסף למציאת זוגות לחתונה ומפנים אליכם
                                זוגות רלוונטים שאתם עומדים בדרישות שלהם בהתאם לנתונים שהם הזינו.
                                כלומר אתם מקבלים הזדמנות להציע שירות ללקוחות שמחפשים בדיוק את מה שאתם מציעים מבלי לבזבז
                                זמן יקר.
                            </label>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
    <!-- /ABOUT -->

    <!--testimonial-->
    <section id="testimonial" class="bgImage aboutSectionDesktop">
        <div class="container">
            <header class="text-center mb-60">
                <h2 class="pinkText">זוגות מספרים</h2>
                <hr/>
            </header>
            <div class="row">
                <div class="owl-carousel text-center owl-mini-testimonial m-0"
                     data-plugin-options='{"singleItem": true, "autoPlay": 4000, "navigation": false, "pagination": true, "transitionStyle":"fade"}'>

                    <div class="testimonial">
                        <div class="justify-content-around row">
                            <div class="col-md-10" >
                                <div class="card bg-light">
                                    <div class="card-header">
                                        <i class="ico-transparent ico-md et-quote"></i>
                                        <label class="bold" style="font-size: 20px;">קובי וירדן
                                        </label>
                                        <label dir="rtl">התחתנו ב21/7/2016
                                            <br>
                                            אחרי הרבה פגישות מיותרות,<br>
                                            הגענו לאתר ממש במקרה ובזכותם קיבלנו הצעה מנצחת.
                                            <br>
                                            תודה!
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="testimonial">
                        <div class="justify-content-around row">
                            <div class="col-md-10" >
                                <div class="card bg-light">
                                    <div class="card-header">
                                        <i class="ico-transparent ico-md et-quote"></i>
                                        <label class="bold" style="font-size: 20px;">נטלי ובר
                                        </label>
                                        <label dir="rtl">התחתנו ב26/8/2018
                                            <br>
                                            תודה לPerfect Match!
                                            <br>
                                            בזכותכם חסכנו המון זמן בבחירת המקום המושלם להתחתן בו!
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="testimonial">
                        <div class="justify-content-around row">
                            <div class="col-md-10" >
                                <div class="card bg-light">
                                    <div class="card-header">
                                        <i class="ico-transparent ico-md et-quote"></i>
                                        <label class="bold" style="font-size: 20px;" >לירון ודליה
                                        </label>
                                        <label dir="rtl">
                                            אנחנו במהלך הכנות לחתונה,
                                            <br>
                                            גילינו שהתהליך ארוך ומייגע,
                                            <br>
                                            למזלנו גילינו את Perfect Match שקיצרו לנו תהליכים
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
    <!--/testimonial-->

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
</script>
</body>

</html>
