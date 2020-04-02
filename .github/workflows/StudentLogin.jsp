<%-- 
    Document   : StudentLogin
    Created on : Feb 25, 2020, 6:59:19 PM
    Author     : TEGA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="David Tega">
        <meta name="description" content="Cbt Training Platform">
        <link rel="stylesheet" type="text/css" href="css/w3.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/responsiveness.css">
        <meta name="copyright" content="copyright 2005-2020 Tech Giants"/>
        <meta name="robots" content="noindex,nofollow,noarchive"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Brainfield School Platform</title>
    </head>
    <body id="login" style="background-image: url('images/headway-5QgIuuBxKwM-unsplash.jpg'); background-size: cover;" >
        <div class="w3-padding-large w3-white">
            <div class="w3-container">
                <p class="w3-wide w3-text-brown w3-large">Login...</p>
                <p class="w3-text-red w3-small">${loginErrorMessage}</p>
            </div>
            <form action="StudentLogin" method="POST">
                    <div class="w3-row-padding">
                        <div class="w3-half container">
                            <select class="w3-select w3-border" name="class_name" required="required">
                                <option disabled selected>Class</option>
                                <jsp:include page="Classnames" flush="true" ></jsp:include>
                            </select>
                        </div>
                        <div class="w3-half container">
                            <input class="w3-input w3-border" name="student_rollno" type="text" placeholder="(XXX)" maxlength="3" required="required">
                        </div>
                        <button class="w3-button w3-col w3-margin-top w3-gray w3-border w3-padding-small w3-text-white">Submit</button>
                    </div>
                </form>  
        </div>
    </body>
</html>
