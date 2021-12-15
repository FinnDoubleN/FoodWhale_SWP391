<%-- 
    Document   : RecipeListDetail
    Created on : Dec 11, 2021, 3:10:27 PM
    Author     : ADMIN
--%>

<%@page import="model.Category"%>
<%@page import="model.Ingredient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Recipe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Recipe Lists</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="favicon.ico">
        <script defer src="../plugins/fontawesome/js/all.min.js"></script>
        <link id="theme-style" rel="stylesheet" href="../css/portal.css">
        <%
            ArrayList<Category> ingrecate = (ArrayList<Category>) request.getAttribute("ingrecate");
            ArrayList<Category> reccate = (ArrayList<Category>) request.getAttribute("reccate");
            Recipe r = (Recipe) request.getAttribute("recipelistdetail");
            ArrayList<Ingredient> ingredient = (ArrayList<Ingredient>) request.getAttribute("ingredient");
            ArrayList<Ingredient> ingreByrec = (ArrayList<Ingredient>) request.getAttribute("ingreByrec");
            Cookie cookie = null;
            Cookie[] cookies = request.getCookies();
            String ROLE = "";
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equalsIgnoreCase("ROLE")) {
                    ROLE = cookie.getValue().toString();
                }
            }
        %>
    </head>
    <body class="app">
        <header class="app-header fixed-top">
            <div class="app-header-inner">
                <div class="container-fluid py-2">
                    <div class="app-header-content">
                        <div class="row justify-content-between align-items-center">
                            <div class="col-auto">
                                <a id="sidepanel-toggler" class="sidepanel-toggler d-inline-block d-xl-none" href="#">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30" role="img"><title>Menu</title><path stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="2" d="M4 7h22M4 15h22M4 23h22"></path></svg>
                                </a>
                            </div>
                            <div class="search-mobile-trigger d-sm-none col">
                                <i class="search-mobile-trigger-icon fas fa-search"></i>
                            </div>
                            <div class="app-utilities col-auto">
                                <div class="app-utility-item app-user-dropdown dropdown">
                                    <a class="dropdown-toggle" id="user-dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false"><img src="../img/avatar.png" alt="user profile"></a>
                                    <ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
                                        <%
                                            if (ROLE.equalsIgnoreCase("") || ROLE.equalsIgnoreCase("user") || ROLE.equalsIgnoreCase("staff")) {
                                        %>
                                        <li><a class="dropdown-item" href="account.html">Account</a></li>
                                        <li><a class="dropdown-item" href="settings.html">Settings</a></li>
                                            <%
                                                } else if (ROLE.equalsIgnoreCase("admin")) {
                                                }
                                            %>
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">Log Out</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="app-sidepanel" class="app-sidepanel">
                <div id="sidepanel-drop" class="sidepanel-drop"></div>
                <div class="sidepanel-inner d-flex flex-column">
                    <a href="#" id="sidepanel-close" class="sidepanel-close d-xl-none">&times;</a>
                    <div class="app-branding">
                        <a class="app-logo" href="${pageContext.request.contextPath}"><span class="logo-text">FOODWHALE</span></a>
                    </div>
                    <nav id="app-nav-main" class="app-nav app-nav-main flex-grow-1">
                        <ul class="app-menu list-unstyled accordion" id="menu-accordion">
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Dashboard">
                                    <span class="nav-icon">
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-door" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z"/>
                                        <path fill-rule="evenodd" d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                                        </svg>
                                    </span>
                                    <span class="nav-link-text">Dashboard</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Dashboard/OrderList">
                                    <span class="nav-icon">
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-card-list" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                        <path fill-rule="evenodd" d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5z"/>
                                        <circle cx="3.5" cy="5.5" r=".5"/>
                                        <circle cx="3.5" cy="8" r=".5"/>
                                        <circle cx="3.5" cy="10.5" r=".5"/>
                                        </svg>
                                    </span>
                                    <span class="nav-link-text">Orders</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Dashboard/AccountList">
                                    <span class="nav-icon">
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-folder" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z"/>
                                        <path fill-rule="evenodd" d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z"/>
                                        </svg>
                                    </span>
                                    <span class="nav-link-text">Accounts</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="${pageContext.request.contextPath}/Dashboard/RecipeList">
                                    <span class="nav-icon">
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-card-list" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                        <path fill-rule="evenodd" d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5z"/>
                                        <circle cx="3.5" cy="5.5" r=".5"/>
                                        <circle cx="3.5" cy="8" r=".5"/>
                                        <circle cx="3.5" cy="10.5" r=".5"/>
                                        </svg>
                                    </span>
                                    <span class="nav-link-text">Recipes</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Dashboard/IngredientList">
                                    <span class="nav-icon">
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-files" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z"/>
                                        <path d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z"/>
                                        </svg>
                                    </span>
                                    <span class="nav-link-text">Ingredients</span>
                                </a>
                            </li>
                            <li class="nav-item has-submenu">
                                <a class="nav-link submenu-toggle" href="#">
                                    <span class="nav-icon">
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-columns-gap" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M6 1H1v3h5V1zM1 0a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm14 12h-5v3h5v-3zm-5-1a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1v-3a1 1 0 0 0-1-1h-5zM6 8H1v7h5V8zM1 7a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V8a1 1 0 0 0-1-1H1zm14-6h-5v7h5V1zm-5-1a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1h-5z"/>
                                        </svg>
                                    </span>
                                    <span class="nav-link-text">Categories</span>
                                    <span class="submenu-arrow">
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"></path>
                                        </svg>
                                    </span>
                                </a>
                                <div id="submenu-1" class="submenu submenu-1" data-bs-parent="#menu-arcordion" style>
                                    <ul class="submenu-list list-unstyled">
                                        <form id="form1" action="${pageContext.request.contextPath}/Dashboard/CategoryList" method="post">
                                            <li class="submenu-item">
                                                <a class="submenu-link" href="javascript:;" onclick="document.getElementById('form1').submit();">Recipe Category</a>
                                            </li>
                                            <input type="hidden" name="Recipe">
                                        </form>
                                        <form id="form2" action="${pageContext.request.contextPath}/Dashboard/CategoryList" method="post">
                                            <li class="submenu-item">
                                                <a class="submenu-link" href="javascript:;" onclick="document.getElementById('form2').submit();">Ingredient Category</a>
                                            </li>
                                            <input type="hidden" name="Ingredient">
                                        </form>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <div class="app-wrapper">
            <div class="app-content pt-3 p-md-3 p-lg-4">
                <div class="container-xl">
                    <h1 class="app-page-title">Recipe Detail</h1>
                    <div class="row-new gy-4">
                        <div class="col-12 col-lg-12">
                            <div class="app-card-header p-3 border-bottom-0">
                                <div class="row gx-3 placecontent-center ">
                                </div>
                            </div>
                            <form class="app-card app-card-account d-flex flex-column" action="RecipeListDetail" method="post">
                                <div class="app-card-body px-4 col-12 col-lg-6">
                                    <input type="hidden" class="item-data" value="<%= r.getrID()%>" name="rID" readonly>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between align-items-center">
                                            <div class="col-auto">
                                                <div class="item-label"><strong>Name</strong></div>
                                                <input type="text" class="item-data" value="<%= r.getrName()%>" maxlength="24" name="rName">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between align-items-center">
                                            <div class="col-auto">
                                                <div class="item-label mb-2"><strong>Category Name</strong></div>
                                                <select name="cID"> 
                                                    <%
                                                        for (Category cateingre : ingrecate) {
                                                    %>
                                                    <option value="<%=cateingre.getCategoryID()%>"><%=cateingre.getCname()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                                <%
                                                    for (Category cateingre : ingrecate) {
                                                        if (cateingre.getCategoryID() == r.getcID()) {
                                                %>
                                                &emsp;Current: <strong><%=cateingre.getCname()%></strong>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between align-items-center">
                                            <div class="col-auto">
                                                <div class="item-label"><strong>Difficulty</strong></div>
                                                <input type="text" class="item-data" value="<%= r.getDifficulty()%>" maxlength="24" name="Difficulty">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between align-items-center">
                                            <div class="col-auto">
                                                <div class="item-label"><strong>Time</strong></div>
                                                <input type="text" class="item-data" value="<%= r.getTime()%>" maxlength="24" name="Time">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between align-items-center">
                                            <div class="col-auto">
                                                <div class="item-label"><strong>Username</strong></div>
                                                <select name="uID"> 
                                                    <%
                                                        for (Category caterec : reccate) {
                                                    %>
                                                    <option value="<%=caterec.getCategoryID()%>"><%=caterec.getCname()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                                <%
                                                    for (Category caterec : reccate) {
                                                        if (caterec.getCategoryID() == r.getrID()) {
                                                %>
                                                &emsp;Current: <strong><%=caterec.getCname()%></strong>
                                                <%
                                                        }
                                                    }
                                                %>                                            </div>
                                        </div>
                                    </div>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between align-items-center">
                                            <div class="col-auto">
                                                <div class="item-label"><strong>Description</strong></div>
                                                <textarea class="item-data" name="Description" cols="80"><%= r.getrDescription()%></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="app-card-body px-4 col-12 col-lg-6 align-self-end position-absolute">
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between align-items-center">
                                            <div class="col-auto">
                                                <div class="item-label mb-2"><strong>Image</strong></div>
                                                <div class="item-data"><img class="profile-image" src="<%= r.getImage()%>" alt="">
                                                    <textarea class="item-data" name="image" style="width: 300px;"><%= r.getImage()%></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between">
                                            <div class="col-auto">
                                                <div class="item-label"><strong>Guideline</strong></div>
                                                <textarea class="item-data" name="Guideline" rows="4" cols="80"><%= r.getGuideline()%></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between">
                                            <div class="col-auto">
                                                <div class="item-label"><strong>Status</strong></div>
                                                <% if (r.getStatus()
                                                            .equalsIgnoreCase("Active")) {%>
                                                <input type="radio" id="Active" name="Status" value="Active" checked>
                                                <label for="Active">Active</label>
                                                <input type="radio" id="Delete" name="Status" value="Delete">
                                                <label for="Delete">Delete</label>
                                                <%} else if (r.getStatus()
                                                        .equalsIgnoreCase("Delete")) {%>
                                                <input type="radio" id="Active" name="Status" value="Active" >
                                                <label for="Active">Active</label>
                                                <input type="radio" id="Delete" name="Status" value="Delete" checked>
                                                <label for="Delete">Delete</label>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item border-bottom py-3">
                                        <div class="row justify-content-between">
                                            <div class="item-label"><strong>Ingredient</strong></div>
                                            <div class="col-auto" style="display: flex; flex-wrap: wrap;
                                                 justify-content: space-between;">
                                                <div class="multiselect">
                                                    <div class="selectBox" onclick="showCheckboxes(1)">
                                                        <select>
                                                            <option>Select Seasoning</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="multiselect">
                                                    <div class="selectBox" onclick="showCheckboxes(2)">
                                                        <select>
                                                            <option>Select Vegetable</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="multiselect">
                                                    <div class="selectBox" onclick="showCheckboxes(3)">
                                                        <select>
                                                            <option>Select Cheese</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="multiselect">
                                                    <div class="selectBox" onclick="showCheckboxes(4)">
                                                        <select>
                                                            <option>Select Sea Food</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="multiselect">
                                                    <div class="selectBox" onclick="showCheckboxes(5)">
                                                        <select>
                                                            <option>Select Meat</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="multiselect">
                                                    <div class="selectBox" onclick="showCheckboxes(6)">
                                                        <select>
                                                            <option>Select Oil</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                </div>
                                                <hr>
                                                <div class="multiselect">
                                                    <div class="selectBox" onclick="showCheckboxes(7)">
                                                        <select>
                                                            <option>Select Dough</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                </div>
                                                <hr>
                                            </div>
                                            <div id="checkbox1">
                                                <lable for="one">
                                                    <%
                                                        int s = 1;
                                                        for (Ingredient in : ingredient) {
                                                            if (in.getCategoryID() == 1) {
                                                    %>
                                                    <input type="checkbox" id="<%=s%>" name="inID" value="<%=in.getInID()%>"
                                                           <%
                                                               for (Ingredient byRec : ingreByrec) {
                                                                   if (in.getInID() == byRec.getInID()) {
                                                           %>
                                                           checked
                                                           <%
                                                                   }
                                                               }
                                                           %>
                                                           /><%=in.getInName()%>
                                                    <%
                                                            }
                                                            s++;
                                                        }
                                                    %>
                                                </lable>
                                            </div>
                                            <div id="checkbox2">
                                                <lable for="two">
                                                    <%
                                                        int v = 1;
                                                        for (Ingredient in : ingredient) {
                                                            if (in.getCategoryID() == 2) {
                                                    %>
                                                    <input type="checkbox" id="<%=v%>" name="inID" value="<%=in.getInID()%>"
                                                           <%
                                                               for (Ingredient byRec : ingreByrec) {
                                                                   if (in.getInID() == byRec.getInID()) {
                                                           %>
                                                           checked
                                                           <%
                                                                   }
                                                               }
                                                           %>
                                                           /><%=in.getInName()%>
                                                    <%
                                                            }
                                                            v++;
                                                        }
                                                    %>
                                                </lable>
                                            </div>
                                            <div id="checkbox3">
                                                <lable for="three">
                                                    <%
                                                        int c = 1;
                                                        for (Ingredient in : ingredient) {
                                                            if (in.getCategoryID() == 3) {
                                                    %>
                                                    <input type="checkbox" id="<%=c%>" name="inID" value="<%=in.getInID()%>"
                                                           <%
                                                               for (Ingredient byRec : ingreByrec) {
                                                                   if (in.getInID() == byRec.getInID()) {
                                                           %>
                                                           checked
                                                           <%
                                                                   }
                                                               }
                                                           %>
                                                           /><%=in.getInName()%>
                                                    <%
                                                            }
                                                            c++;
                                                        }
                                                    %>
                                                </lable>
                                            </div>
                                            <div id="checkbox4">
                                                <lable for="four">
                                                    <%
                                                        int f = 1;
                                                        for (Ingredient in : ingredient) {
                                                            if (in.getCategoryID() == 4) {
                                                    %>
                                                    <input type="checkbox" id="<%=f%>" name="inID" value="<%=in.getInID()%>"
                                                           <%
                                                               for (Ingredient byRec : ingreByrec) {
                                                                   if (in.getInID() == byRec.getInID()) {
                                                           %>
                                                           checked
                                                           <%
                                                                   }
                                                               }
                                                           %>
                                                           /><%=in.getInName()%>
                                                    <%
                                                            }
                                                            f++;
                                                        }
                                                    %>
                                                </lable>
                                            </div>
                                            <div id="checkbox5">
                                                <lable for="five">
                                                    <%
                                                        int m = 1;
                                                        for (Ingredient in : ingredient) {
                                                            if (in.getCategoryID() == 5) {
                                                    %>
                                                    <input type="checkbox" id="<%=m%>" name="inID" value="<%=in.getInID()%>"
                                                           <%
                                                               for (Ingredient byRec : ingreByrec) {
                                                                   if (in.getInID() == byRec.getInID()) {
                                                           %>
                                                           checked
                                                           <%
                                                                   }
                                                               }
                                                           %>
                                                           /><%=in.getInName()%>
                                                    <%
                                                            }
                                                            m++;
                                                        }
                                                    %>
                                                </lable>
                                            </div>
                                            <div id="checkbox6">
                                                <lable for="six">
                                                    <%
                                                        int o = 1;
                                                        for (Ingredient in : ingredient) {
                                                            if (in.getCategoryID() == 6) {
                                                    %>
                                                    <input type="checkbox" id="<%=o%>" name="inID" value="<%=in.getInID()%>"
                                                           <%
                                                               for (Ingredient byRec : ingreByrec) {
                                                                   if (in.getInID() == byRec.getInID()) {
                                                           %>
                                                           checked
                                                           <%
                                                                   }
                                                               }
                                                           %>
                                                           /><%=in.getInName()%>
                                                    <%
                                                            }
                                                            o++;
                                                        }
                                                    %>
                                                </lable>
                                            </div>
                                            <div id="checkbox7">
                                                <lable for="seven">
                                                    <%
                                                        int d = 1;
                                                        for (Ingredient in : ingredient) {
                                                            if (in.getCategoryID() == 7) {
                                                    %>
                                                    <input type="checkbox" id="<%=d%>" name="inID" value="<%=in.getInID()%>"
                                                           <%
                                                               for (Ingredient byRec : ingreByrec) {
                                                                   if (in.getInID() == byRec.getInID()) {
                                                           %>
                                                           checked
                                                           <%
                                                                   }
                                                               }
                                                           %>
                                                           /><%=in.getInName()%>
                                                    <%
                                                            }
                                                            d++;
                                                        }
                                                    %>
                                                </lable>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="app-card-footer p-4 mt-auto">
                                    <input class="btn app-btn-secondary" name="submit" type="submit" value="Update">
                                    <input class="btn app-btn-secondary" name="submit" type="submit" value="Delete">
                                    <a class="btn app-btn-secondary" href="${pageContext.request.contextPath}/Dashboard/RecipeList">Cancel</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="app-footer">
                <div class="container text-center py-3">
                    <small class="copyright">Designed by <a class="app-link" href="${pageContext.request.contextPath}/Homepage" target="_blank">FoodWhale</a></small>
                </div>
            </footer>

        </div>
        <!-- Javascript -->
        <script src="../plugins/popper.min.js"></script>
        <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="../js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <!-- Charts JS -->
        <script src="../plugins/chart.js/chart.min.js"></script>
        <script src="../js/index-charts.js"></script>

        <!-- Page Specific JS -->
        <script src="../js/app.js"></script>

    </body>
</html>