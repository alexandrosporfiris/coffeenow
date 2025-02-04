<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cache" uri="/WEB-INF/coffeenowcustomtags.tld"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<c:set var="realPath"><%= getServletContext().getRealPath("/") %></c:set>

<!DOCTYPE html>
<html lang="en">

	<head>
		<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>${SEO_pageTitle}</title>
		<meta property="og:url" content='${SEO_ogUrl}' />
		<meta property="og:type" content="website" />
		<meta property="og:image" content='${SEO_ogImage}' />
		<meta property="og:image:width" content='${SEO_ogImageWidth}' />
		<meta property="og:image:height" content='${SEO_ogImageHeight}' />
		<meta property="og:image:type" content="image/jpeg" />
		<meta name="description" content='${SEO_pageDescription}'>
		
		<link href="img/common/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon">
		
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="webjars/font-awesome/css/all.css">
		
            <c:set var="styles"><tiles:getAsString name="styles" /></c:set>
			<c:forTokens items="${styles}" delims="," var="style">
				${cache:bust(style, "css", realPath)}
			</c:forTokens>
		
		<link rel="apple-touch-icon" sizes="57x57" href="img/common/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="img/common/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="img/common/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="img/common/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="img/common/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="img/common/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="img/common/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="img/common/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="img/common/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="img/common/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="img/common/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="img/common/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="img/common/favicon-16x16.png">
		<link rel="manifest" href="img/common/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="img/common/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
	</head>
	
	<tiles:insertAttribute name="content" />
	
	<script src="webjars/jquery/jquery.min.js"></script>
	<script src="webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="webjars/jquery-easing/jquery.easing.min.js"></script>
	
        <c:set var="scripts"><tiles:getAsString name="scripts" /></c:set>
		<c:forTokens items="${scripts}" delims="," var="script">
			${cache:bust(script, "js", realPath)}
		</c:forTokens>
	
</html>