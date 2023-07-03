<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<!-- OPENKM INTEGRATION STYLES START -->
  <base href="http://www.openkm.com/en/cloud-full-service.html" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta name="keywords" content="OpenKM Cloud,Document Management Cloud
" />
  <meta name="author" content="Super User" />
  <meta name="description" content="The OpenKM Document Management Cloud allows you to customize your OpenKM experience. For example, you can use the OpenKM Cloud to choose which options to include in your OpenKM service.
" />
  <meta name="generator" content="Joomla! - Open Source Content Management" />
  <title>OpenKM Document Management System | Open Source DMS - OpenKM Cloud | Document Management Cloud</title>
  <link href="http://www.openkm.com/en/cloud-full-service.html" rel="canonical" />
  <link href="/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
  <link rel="stylesheet" href="/modules/mod_nice_social_bookmark/css/nsb.css" type="text/css" />
  <link rel="stylesheet" href="/modules/mod_ariextmenu/mod_ariextmenu/js/css/menu.min.css" type="text/css" />
  <link rel="stylesheet" href="/modules/mod_ariextmenu/mod_ariextmenu/js/css/menu.fix.css" type="text/css" />
  <link rel="stylesheet" href="/modules/mod_rokajaxsearch/css/rokajaxsearch.css" type="text/css" />
  <link rel="stylesheet" href="/modules/mod_rokajaxsearch/themes/blue/rokajaxsearch-theme.css" type="text/css" />
  <link rel="stylesheet" href="/media/mod_languages/css/template.css" type="text/css" />
  <style type="text/css">
.nsb_container a{
	padding:px; float:none; display:inline-block;
}#plusone{padding:px !important;}
UL#ariext88 LI A{font-size:13px;font-weight:bold;text-transform:none;text-align:left;}UL#ariext88 LI A{background:#260d54 none;}UL#ariext88 LI A{color:#ffffff;}UL#ariext88 LI A:hover,UL#ariext88 LI A:focus,UL#ariext88 LI A.ux-menu-link-hover{color:#00ffff;}UL#ariext88 LI A.current{color:#05e0e9;}
  </style>
  <script src="/media/jui/js/jquery.min.js" type="text/javascript"></script>
  <script src="/media/jui/js/jquery-noconflict.js" type="text/javascript"></script>
  <script src="/media/jui/js/jquery-migrate.min.js" type="text/javascript"></script>
  <script src="/media/system/js/caption.js" type="text/javascript"></script>
  <script src="/media/jui/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="/modules/mod_ariextmenu/mod_ariextmenu/js/ext-core.js" type="text/javascript"></script>
  <script src="/modules/mod_ariextmenu/mod_ariextmenu/js/menu.min.js" type="text/javascript"></script>
  <script src="/media/system/js/mootools-core.js" type="text/javascript"></script>
  <script src="/media/system/js/core.js" type="text/javascript"></script>
  <script src="/media/system/js/mootools-more.js" type="text/javascript"></script>
  <script src="/modules/mod_rokajaxsearch/js/rokajaxsearch.js" type="text/javascript"></script>
  <script type="text/javascript">
jQuery(window).on('load',  function() {
				new JCaption('img.caption');
			});
jQuery(document).ready(function(){
	jQuery('.hasTooltip').tooltip({"html": true,"container": "body"});
});
Ext.onReady(function() { new Ext.ux.Menu("ariext88", {"delay":0.1,"transitionDuration":0.1}); Ext.get("ariext88").select(".ux-menu-sub").removeClass("ux-menu-init-hidden"); });
window.addEvent((window.webkit) ? 'load' : 'domready', function() {
				window.rokajaxsearch = new RokAjaxSearch({
					'results': 'Results',
					'close': '',
					'websearch': 1,
					'blogsearch': 0,
					'imagesearch': 0,
					'videosearch': 0,
					'imagesize': 'MEDIUM',
					'safesearch': 'MODERATE',
					'search': 'Search...',
					'readmore': 'Read more...',
					'noresults': 'No results',
					'advsearch': 'Advanced search',
					'page': 'Page',
					'page_of': 'of',
					'searchlink': 'http://www.openkm.com/index.php?option=com_search&amp;view=search&amp;tmpl=component',
					'advsearchlink': 'http://www.openkm.com/index.php?option=com_search&amp;view=search',
					'uribase': 'http://www.openkm.com/',
					'limit': '10',
					'perpage': '3',
					'ordering': 'newest',
					'phrase': 'any',
					'hidedivs': '',
					'includelink': 0,
					'viewall': 'View all results',
					'estimated': 'estimated',
					'showestimated': 1,
					'showpagination': 1,
					'showcategory': 1,
					'showreadmore': 1,
					'showdescription': 1
				});
			});
  </script>
  <!--[if IE]><link rel="stylesheet" type="text/css" href="/modules/mod_ariextmenu/mod_ariextmenu/js/css/menu.ie.min.css" /><![endif]-->
  <!--[if lt IE 8]><script type="text/javascript" src="/modules/mod_ariextmenu/mod_ariextmenu/js/fix.js"></script><![endif]-->

<link rel="stylesheet" href="/templates/system/css/system.css" type="text/css" />
<link rel="stylesheet" href="/templates/system/css/general.css" type="text/css" />
<link rel="stylesheet" href="/templates/openkm/css/layout_en-gb.css" type="text/css" />
<link rel="stylesheet" href="/templates/openkm/css/typography.css" type="text/css" />
<!-- Start Alexa Certify Javascript -->
<script type="text/javascript">
_atrk_opts = { atrk_acct:"CGIIi1a4ZP00gp", domain:"openkm.com",dynamic: true};
(function() { var as = document.createElement('script'); as.type = 'text/javascript'; as.async = true; as.src = "https://d31qbv1cthcecs.cloudfront.net/atrk.js"; var s = document.getElementsByTagName('script')[0];s.parentNode.insertBefore(as, s); })();
</script>
<!-- End Alexa Certify Javascript -->
<!-- OPENKM INTEGRATION STYLES ENDS -->
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<noscript><img src="https://d5nxst8fruw4z.cloudfront.net/atrk.gif?account=CGIIi1a4ZP00gp" style="display:none" height="1" width="1" alt="" /></noscript>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-3373814-1");
pageTracker._trackPageview();
} catch(err) {}</script>
</head>  
  <body>
<!-- OPENKM INTEGRATION BODY START -->
<div class="container">
  <div id="header">
    <h1>
      <a href="/"><img src="/templates/openkm/images/logo.png" alt="OpenKM Document Management System | Open Source DMS" /></a>
    </h1>
    <div class="language">
      		<div class="moduletablelanguage-selector">
					<div class="mod-languageslanguage-selector">

	<ul class="lang-block">
						<li class="lang-active" dir="ltr">
			<a href="/en/">
							<img src="/media/mod_languages/images/en.gif" alt="English" title="English" />						</a>
			</li>
								<li class="" dir="ltr">
			<a href="/es/cloud.html">
							<img src="/media/mod_languages/images/es.gif" alt="Español" title="Español" />						</a>
			</li>
				</ul>

</div>
		</div>
	
    </div>
    <div class="search">
       		<div class="moduletable">
					<form name="rokajaxsearch" id="rokajaxsearch" class="blue" action="http://www.openkm.com/" method="get">
<div class="rokajaxsearch ">
	<div class="roksearch-wrapper">
		<input id="roksearch_search_str" name="searchword" type="text" class="inputbox roksearch_search_str" />
	</div>
	<input type="hidden" name="searchphrase" value="any"/>
	<input type="hidden" name="limit" value="20" />
	<input type="hidden" name="ordering" value="newest" />
	<input type="hidden" name="view" value="search" />
	<input type="hidden" name="option" value="com_search" />

	
	<div id="roksearch_results"></div>
</div>
<div id="rokajaxsearch_tmp" style="visibility:hidden;display:none;"></div>
</form>
		</div>
	
    </div>	
    <div class="pretty_links">
      		<div class="moduletable">
					<ul class="nav menu">
<li class="item-116"><a class="try" href="http://demo.openkm.com/" target="_blank" >Online demo</a></li><li class="item-117"><a class="download" href="/en/download-english.html" >Download</a></li></ul>
		</div>
	
    </div>
  </div>
  <div class="barra">
    		<div class="moduletable">
					
<div id="ariext88_container" class="ux-menu-container ux-menu-clearfix">

	<ul id="ariext88" class="ux-menu ux-menu-horizontal">
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item101 ux-menu-item-parent-pos0">
				<a href="/en/" class=" ux-menu-link-level-0 ux-menu-link-first">
					Home									</a>
						</li>
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item-parent ux-menu-item125 ux-menu-item-parent-pos1">
				<a href="javascript:void(0);" class=" ux-menu-link-level-0 ux-menu-link-parent">
					Product										<span class="ux-menu-arrow"></span>
									</a>
			
	<ul class="ux-menu-sub ux-menu-init-hidden">
					<li class=" ux-menu-item-level-1 ux-menu-item127">
				<a href="/en/product/technology.html" class=" ux-menu-link-level-1">
					Technology									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item129">
				<a href="/en/product/hardware-requirements.html" class=" ux-menu-link-level-1">
					Hardware requirements									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item128">
				<a href="/en/product/architecture.html" class=" ux-menu-link-level-1">
					Architecture									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item140">
				<a href="/en/product/features.html" class=" ux-menu-link-level-1">
					Features									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item345">
				<a href="/en/product/comparison-of-versions.html" class=" ux-menu-link-level-1">
					Comparison of versions									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item-parent ux-menu-item518">
				<a href="javascript:void(0);" class=" ux-menu-link-level-1 ux-menu-link-parent">
					Versions										<span class="ux-menu-arrow"></span>
									</a>
			
	<ul class="ux-menu-sub ux-menu-init-hidden">
					<li class=" ux-menu-item-level-2 ux-menu-item519">
				<a href="/en/product/versions/professional.html" class=" ux-menu-link-level-2">
					Professional									</a>
						</li>
					<li class=" ux-menu-item-level-2 ux-menu-item520">
				<a href="/en/product/versions/cloud.html" class=" ux-menu-link-level-2">
					Cloud									</a>
						</li>
					<li class=" ux-menu-item-level-2 ux-menu-item521">
				<a href="/en/product/versions/community.html" class=" ux-menu-link-level-2 ux-menu-link-last">
					Community									</a>
						</li>
			</ul>
			</li>
					<li class=" ux-menu-item-level-1 ux-menu-item522">
				<a href="/en/product/university-training.html" class=" ux-menu-link-level-1">
					University and training									</a>
						</li>
			</ul>
			</li>
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item-parent ux-menu-item472 ux-menu-item-parent-pos2">
				<a href="javascript:void(0)" class=" ux-menu-link-level-0 ux-menu-link-parent">
					Modules										<span class="ux-menu-arrow"></span>
									</a>
			
	<ul class="ux-menu-sub ux-menu-init-hidden">
					<li class=" ux-menu-item-level-1 ux-menu-item503">
				<a href="/en/modules-eng/apps.html" class=" ux-menu-link-level-1">
					Apps									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item494">
				<a href="/en/modules-eng/barcode.html" class=" ux-menu-link-level-1">
					Barcode									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item489">
				<a href="/en/modules-eng/cmis-content-management-interoperability-services.html" class=" ux-menu-link-level-1">
					CMIS									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item497">
				<a href="/en/modules-eng/electronic-invoicing.html" class=" ux-menu-link-level-1">
					Electronic invoicing									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item492">
				<a href="/en/modules-eng/mail-archiver.html" class=" ux-menu-link-level-1">
					Mail Archiver 									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item473">
				<a href="/en/modules-eng/multitenant.html" class=" ux-menu-link-level-1">
					Multitenant									</a>
						</li>
			</ul>
			</li>
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item514 ux-menu-item-parent-pos3">
				<a href="/en/screenshot.html" class=" ux-menu-link-level-0">
					Screenshots									</a>
						</li>
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item515 ux-menu-item-parent-pos4">
				<a href="/en/videos.html" class=" ux-menu-link-level-0">
					Videos									</a>
						</li>
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item-parent ux-menu-item475 ux-menu-item-parent-pos5">
				<a href="javascript:void(0)" class=" ux-menu-link-level-0 ux-menu-link-parent">
					Partners										<span class="ux-menu-arrow"></span>
									</a>
			
	<ul class="ux-menu-sub ux-menu-init-hidden">
					<li class=" ux-menu-item-level-1 ux-menu-item141">
				<a href="/en/extranet/become-a-partner.html" class=" ux-menu-link-level-1">
					Become a partner									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item255">
				<a href="/en/extranet/partners-extranet.html" class=" ux-menu-link-level-1">
					Partners extranet									</a>
						</li>
			</ul>
			</li>
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item-parent ux-menu-item118 ux-menu-item-parent-pos6">
				<a href="javascript:void(0);" class=" ux-menu-link-level-0 ux-menu-link-parent">
					Resources										<span class="ux-menu-arrow"></span>
									</a>
			
	<ul class="ux-menu-sub ux-menu-init-hidden">
					<li class=" ux-menu-item-level-1 ux-menu-item476">
				<a href="/en/resources/documents.html" class=" ux-menu-link-level-1">
					Documents									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item120">
				<a href="/en/resources/manuals.html" class=" ux-menu-link-level-1">
					Manuals									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item486">
				<a href="/en/resources/workflow-course.html" class=" ux-menu-link-level-1">
					Workflow Course									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item121">
				<a href="http://forum.openkm.com" class=" ux-menu-link-level-1">
					Forum									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item499">
				<a href="http://blog.openkm.com/en" class=" ux-menu-link-level-1">
					Blog									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item131">
				<a href="/en/resources/faq.html" class=" ux-menu-link-level-1">
					FAQ									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item202">
				<a href="/en/resources/newsletter.html" class=" ux-menu-link-level-1">
					Newsletter									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item122">
				<a href="http://issues.openkm.com" target="_blank" class=" ux-menu-link-level-1">
					Bug tracker									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item132">
				<a href="http://wiki.openkm.com/index.php/Changelog" target="_blank" class=" ux-menu-link-level-1">
					Changelog									</a>
						</li>
			</ul>
			</li>
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item-parent ux-menu-item134 ux-menu-item-parent-pos7">
				<a href="javascript:void(0);" class=" ux-menu-link-level-0 ux-menu-link-parent">
					Information										<span class="ux-menu-arrow"></span>
									</a>
			
	<ul class="ux-menu-sub ux-menu-init-hidden">
					<li class=" ux-menu-item-level-1 ux-menu-item135">
				<a href="/en/information/price-request.html" class=" ux-menu-link-level-1">
					Price request									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item350">
				<a href="/en/information/cloud-request.html" class=" ux-menu-link-level-1">
					Cloud request									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item175">
				<a href="/en/information/demo-request.html" class=" ux-menu-link-level-1">
					Demo request									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item137">
				<a href="/en/information/training-course-request.html" class=" ux-menu-link-level-1">
					Training course request									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item130">
				<a href="/en/information/acknowledgements.html" class=" ux-menu-link-level-1">
					Acknowledgements									</a>
						</li>
					<li class=" ux-menu-item-level-1 ux-menu-item501">
				<a href="/en/information/about-us.html" class=" ux-menu-link-level-1">
					About us									</a>
						</li>
			</ul>
			</li>
					<li class="ux-menu-item-main ux-menu-item-level-0 ux-menu-item139 ux-menu-item-parent-pos8">
				<a href="/en/contact.html" class=" ux-menu-link-level-0 ux-menu-link-last">
					Contact									</a>
						</li>
			</ul>
</div>		</div>
	
  </div>
  <!-- OPENKM INTEGRATION BODY ENDS -->
    <div id="content" class="clearfix">
    <div id="maincolumn" class="col primera ">
      		<div class="moduletable">
					
<ul class="breadcrumb">
	<li class="active"><span class="divider icon-location"></span></li><li><a href="/en/" class="pathway">Home</a><span class="divider"><img src="/media/system/images/arrow.png" alt="" /></span></li><li class="active"><span>Cloud full service</span></li></ul>
		</div>
	
      <div class="item-page" itemscope itemtype="http://schema.org/Article">
				<div class="page-header">
												<a href="/en/cloud-full-service.html" itemprop="url"> Cloud</a>
							</div>
				
<div class="icons">
	
		
	</div>
	
	
	
		
								<div itemprop="articleBody">
		<p style="text-align: justify;"><strong>OpenKM Cloud</strong> increases the managing and sharing of information in your organization without investing in hardware and IT personnel.</p>
<table border="0" cellpadding="2">
<tbody>
<tr>
<td style="width: 100px;" align="center" valign="top"><img src="/images/cloud/icon_try.png" alt="" width="80" height="80" border="0" /></td>
<td>
<p><strong><span style="color: #000080; font-size: medium;">Price</span></strong></p>
<p>The service includes:</p>
<p><strong>Implementation</strong></p>
<ol style="list-style-type: upper-alpha;">
<li>Installation.</li>
<li>Configuration</li>
<ul>
<li>DB (MySQL by default)</li>
<li>Apache proxy OpenKM.</li>
<li>OpenKM configured as a service.</li>
<li>System backups.</li>
<li>OpenKM mail service</li>
<li>OpenKM mail notification and subscription</li>
<li>Preview documents..</li>
<li>OCR (cuneiform ocr tesseract or engines).</li>
<li>SSL (secure extranet).</li>
<li>clamscan antivirus.</li>
</ul>
<li>Customization of the application with your logo</li>
</ol>
<div> </div>
<div><strong>Hosting</strong></div>
<blockquote>
<div>
<ul>
<li>440 Gbit Bandwidth</li>
<li>Redundant Network</li>
<li>Juniper Routing-Technology</li>
<li>100 % switched network; no collision domains</li>
<li>High Speed Access to all Internet-Uplinks</li>
<li>24/7 Monitoring</li>
<li>Network Availability min. 99%</li>
</ul>
</div>
</blockquote>
</td>
</tr>
<tr>
<td style="width: 100px;" align="center" valign="top"><img src="/images/cloud/icon_managed.png" alt="" width="80" height="80" border="0" /></td>
<td>
<p><span style="color: #000080; font-size: medium;"><strong>Automated Management Services</strong></span></p>
<p>Automated application monitoring and backups, version upgrades, resource scaling,</p>
<p><span style="color: #000080; font-size: medium;"><strong>Broad network access </strong></span></p>
OpenKM Cloud services are accessible from multiple devices (including PCs, smartphones and tablets) and any location with Internet access</td>
</tr>
<tr>
<td style="width: 100px;" align="center" valign="top"> </td>
<td> </td>
</tr>
<tr>
<td align="center" valign="top"><img src="/images/cloud/icon_cost.png" alt="" width="80" height="80" border="0" /></td>
<td>
<p><span style="font-size: medium; color: #000080;"><strong>Cost certainty</strong></span></p>
<p>You only pay for the cloud services and resources you actually use (including the cost of system upgrades), makes it easier to predict IT costs.</p>
</td>
</tr>
<tr>
<td align="center" valign="top"> </td>
<td> </td>
</tr>
<tr>
<td align="center" valign="top"><img src="/images/cloud/icon_flexibility.png" alt="" width="80" height="80" border="0" /></td>
<td>
<p><span style="font-size: medium; color: #000080;"><strong>Rapid implementation</strong></span></p>
<p>OpenKM Cloud delivers a faster return on IT investments, thanks to accelerated implementation and reduced infrastructure costs. Less time is required to get up and running on cloud-based systems.</p>
</td>
</tr>
<tr>
<td align="center" valign="top"> </td>
<td> </td>
</tr>
<tr>
<td align="center" valign="top"><img src="/images/cloud/icon_monitoring.png" alt="" width="80" height="80" border="0" /></td>
<td>
<p><span style="color: #000080; font-size: medium;"><strong>Scalability</strong></span></p>
<p>The platform is built to scale the application as needed.Companies can quickly develop and deploy new IT capabilities and business processes to stay ahead of the competition and keep pace with changes in the marketplace</p>
</td>
</tr>
<tr>
<td align="center" valign="top"> </td>
<td> </td>
</tr>
<tr>
<td align="center" valign="top"><img src="/images/cloud/icon_reliability.png" alt="" width="80" height="80" border="0" /></td>
<td>
<p><span style="color: #000080; font-size: medium;"><strong>Rapid elasticity</strong></span></p>
<p>OpenKM Cloud can be quickly scaled up or down in response to an organizations changing needs</p>
</td>
</tr>
<tr>
<td align="center" valign="top"> </td>
<td> </td>
</tr>
</tbody>
</table>
<p style="text-align: justify;">If you want a price estimate of document management in the cloud, please, submit the contact form and will receive personalized attention.</p>
<p style="text-align: center;"><a class="button readon" style="font-size: 13px; margin-left: 15px; margin-top: 10px; float: center; width: 190px; background-color: #0090cb; border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25); border-radius: 5px 5px 5px 5px; box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px rgba(0, 0, 0, 0.05); color: #ffffff; cursor: pointer; display: inline-block; margin-bottom: 0; padding: 5px 20px; text-align: center; text-shadow: 0 1px 1px rgba(0, 0, 0, 0.75); vertical-align: middle; text-decoration: none !important;" title="Contact Form" href="/en/information/cloud-request.html" target="_blank"><strong>Contact Form</strong></a></p> 	</div>

	
						 </div>

    </div>
        <div id="sidebar-2" class="col segunda">
        <div class="small clearfix">
    <div class="fast">
      		<div class="moduletable">
					<ul class="nav menu">
<li class="item-112"><a class="community" href="/en/community.html" >Community</a></li><li class="item-113"><a class="professional" href="/en/professional-support.html" >Professional Support</a></li><li class="item-114 current active"><a class="cloud" href="/en/cloud-full-service.html" >Cloud full service</a></li><li class="item-115"><a class="university" href="/en/university-a-training.html" >University &amp; training</a></li></ul>
		</div>
	
    </div>
    </div>
        
            <div class="contenido_derecha_medio">
        		<div class="moduletablevideos">
					<h3>Videos</h3>
					<ul class="nav menu">
<li class="item-380"><a href="/en/openkm-multitenant.html" >OpenKM - Multitenant</a></li><li class="item-360"><a href="/en/openkm-mobile.html" >OpenKM - Mobile</a></li><li class="item-484"><a href="/en/openkm-zone-ocr.html" >OpenKM - Zone OCR</a></li><li class="item-480"><a href="/en/openkm-ms-office-addin-en.html" >OpenKM - MS Office addin</a></li><li class="item-352"><a href="/en/openkm-google-docs-a-zoho.html" >OpenKM - Google Docs &amp; Zoho</a></li><li class="item-483"><a href="/en/dropbox.html" >OpenKM - Dropbox</a></li><li class="item-123"><a href="/en/openkm-abby-flexicapture-ocr.html" >OpenKM - Abby Flexicapture</a></li><li class="item-479"><a href="http://www.openkm.com/en/videos.html" >More videos ...</a></li></ul>
		</div>
	
      </div>
            		<div class="moduletable">
					<div class="nsb_container"><a id="l1" target="_blank" rel="nofollow" href="http://www.facebook.com/sharer.php?u=http://www.openkm.com/en/cloud-full-service.html&amp;title=OpenKM+Document+Management+System+%7C+Open+Source+DMS+-+OpenKM+Cloud+%7C+Document+Management+Cloud"><img title="Facebook" src="/modules/mod_nice_social_bookmark/icons/facebook_aqu_32.png" alt="Facebook" /></a><a id="l3" target="_blank" rel="nofollow" href="http://twitter.com/home?status=http://www.openkm.com/en/cloud-full-service.html&amp;title=OpenKM+Document+Management+System+%7C+Open+Source+DMS+-+OpenKM+Cloud+%7C+Document+Management+Cloud"><img title="Twitter" src="/modules/mod_nice_social_bookmark/icons/twitter_aqu_32.png" alt="Twitter" /></a><a id="l4" target="_blank" rel="nofollow" href="http://digg.com/submit?phase=2&amp;url=http://www.openkm.com/en/cloud-full-service.html&amp;title=OpenKM+Document+Management+System+%7C+Open+Source+DMS+-+OpenKM+Cloud+%7C+Document+Management+Cloud"><img title="Digg" src="/modules/mod_nice_social_bookmark/icons/digg_aqu_32.png" alt="Digg" /></a><a id="l5" target="_blank" rel="nofollow" href="http://del.icio.us/post?url=http://www.openkm.com/en/cloud-full-service.html&amp;title=OpenKM+Document+Management+System+%7C+Open+Source+DMS+-+OpenKM+Cloud+%7C+Document+Management+Cloud"><img title="Delicious" src="/modules/mod_nice_social_bookmark/icons/delicious_aqu_32.png" alt="Delicious" /></a><a id="l6" target="_blank" rel="nofollow" href="http://www.stumbleupon.com/submit?url=http://www.openkm.com/en/cloud-full-service.html&amp;title=OpenKM+Document+Management+System+%7C+Open+Source+DMS+-+OpenKM+Cloud+%7C+Document+Management+Cloud"><img title="Stumbleupon" src="/modules/mod_nice_social_bookmark/icons/stumbleupon_aqu_32.png" alt="Stumbleupon" /></a><a id="l7" target="_blank" rel="nofollow" href="http://www.google.com/bookmarks/mark?op=edit&amp;bkmk=http://www.openkm.com/en/cloud-full-service.html&amp;title=OpenKM+Document+Management+System+%7C+Open+Source+DMS+-+OpenKM+Cloud+%7C+Document+Management+Cloud"><img title="Google Bookmarks" src="/modules/mod_nice_social_bookmark/icons/google_aqu_32.png" alt="Google Bookmarks" /></a><a id="l8" target="_blank" rel="nofollow" href="http://reddit.com/submit?url=http://www.openkm.com/en/cloud-full-service.html&amp;title=OpenKM+Document+Management+System+%7C+Open+Source+DMS+-+OpenKM+Cloud+%7C+Document+Management+Cloud"><img title="reddit" src="/modules/mod_nice_social_bookmark/icons/reddit_aqu_32.png" alt="Reddit" /></a><a id="l10" target="_blank" rel="nofollow" href="http://technorati.com/faves?add=http://www.openkm.com/en/cloud-full-service.html&amp;title=OpenKM+Document+Management+System+%7C+Open+Source+DMS+-+OpenKM+Cloud+%7C+Document+Management+Cloud"><img title="technorati" src="/modules/mod_nice_social_bookmark/icons/technorati_aqu_32.png" alt="Technorati" /></a><a id="l11" target="_blank" rel="nofollow" href="http://www.linkedin.com/shareArticle?mini=true&amp;url=http://www.openkm.com/en/cloud-full-service.html&amp;summary=%5B..%5D&amp;source="><img title="linkedin" src="/modules/mod_nice_social_bookmark/icons/linkedin_aqu_32.png" alt="Linkedin" /></a></div><div style="clear:both;"></div>		</div>
	
    </div>
      </div>
</div>
<div id="footer" class="clearfix">
  <div class="container clearfix">
    <div class="col primera">
      
    </div>
    <div class="col segunda">
      		<div class="moduletable">
					<ul class="nav menu">
<li class="item-108"><a class="pantalla" href="http://www.openkm.com/en/information/demo-request.html" >Sign-up for Trial</a></li><li class="item-107"><a class="telefono" href="javascript:void(0)" >+34 605 074 544</a></li><li class="item-111"><a class="youtube" href="http://www.youtube.com/user/openkm" >Youtube</a></li></ul>
		</div>
			<div class="moduletable">
					<ul class="nav menu">
<li class="item-103"><a class="facebook" href="http://www.facebook.com/pages/OpenKM/176685359016721" target="_blank" >Facebook</a></li><li class="item-104"><a class="twitter" href="http://twitter.com/#!/openkm" target="_blank" >Twitter</a></li><li class="item-105"><a class="skype" href="skype:biel.openkm?chat " target="_blank" >Skype</a></li></ul>
		</div>
	
    </div>
  </div>
</div>
<div id="privacy">
  <div class="privacy container clearfix">
    <div class="col primera">
  		<div class="moduletable">
					<h3>© 2011-2014 OpenKM. All Rights Reserved.</h3>
					<ul class="nav menu">
<li class="item-138"><a class="first" href="/en/legal.html" >Legal</a></li><li class="item-143"><a href="/en/privacy.html" >Privacy</a></li></ul>
		</div>
	
    </div>
    <div class="col segunda">
      <a href="http://www.ideatiza.com" title="Ideatiza Design Studio">
        <img src="/templates/openkm/images/rec.png" alt="Rec produccions" />
      </a>
    </div>
  </div>
</div>

<!-- Piwik -->
<script type="text/javascript">
  var _paq = _paq || [];
  _paq.push(["trackPageView"]);
  _paq.push(["enableLinkTracking"]);

  (function() {
    var u=(("https:" == document.location.protocol) ? "https" : "http") + "://stats.openkm.com/";
    _paq.push(["setTrackerUrl", u+"piwik.php"]);
    _paq.push(["setSiteId", "1"]);
    var d=document, g=d.createElement("script"), s=d.getElementsByTagName("script")[0]; g.type="text/javascript";
    g.defer=true; g.async=true; g.src=u+"piwik.js"; s.parentNode.insertBefore(g,s);
  })();
</script>
<!-- End Piwik Code -->
  
<!-- google add start -->
<script type="text/javascript">
/* <![CDATA[ */
var google_conversion_id = 991218216;
var google_custom_params = window.google_tag_params;
var google_remarketing_only = true;
/* ]]> */
</script>
<script type="text/javascript" src="//www.googleadservices.com/pagead/conversion.js">
</script>
<noscript>
<div style="display:inline;">
<img height="1" width="1" style="border-style:none;" alt="" src="//googleads.g.doubleclick.net/pagead/viewthroughconversion/991218216/?value=0&amp;guid=ON&amp;script=0"/>
</div>
</noscript>
<!-- google add ends -->
</body>
</html>
