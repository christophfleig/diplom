{namespace Frameset}


{**
	By now, this template is active on all GRIN-Brands. It is linked via <BRAND>TEMPLINK.gtpl to the other branddirectories.
	Plz mind that every change applies to all GRIN-Brands!
**}

{template .Meta}
	{meta override=true}
	{*Grin specific global meta tags*}
	<link rel="apple-touch-icon" href="{OPTION('base-href-images')}commons/{GrinEnv.brand}-ios-icon.png"/>
{/template}

{template .Css}
	{meta override=true}
	{load_css_group('whitelabel.css')}
	{load_brand_css('diplomica.css','grin-frameset.css')}
	

{/template}

{*
*
* .Top Template
*
*}
{template .Top}
	{meta override=true}
	{if (GrinEnv.i_am_hausarbeiten || GrinEnv.i_am_diplomarbeiten24) && !GrinEnv.i_am_ie6 && ! (GrinEnv.handler == 'document' && GrinEnv.i_am_diplomarbeiten24)}
		<div style="height: 90px; width: 0px; clear: both; float: none; display: block;"></div>
	{/if}
	

	<div class="header">
<!-- BEGIN ADITIONTAG Website-Tag -->
<script type="text/javascript" src="http://imagesrv.adition.com/js/adition.js"></script>
<script type="text/javascript" src="http://ad1.adfarm1.adition.com/js?wp_id=11851"></script>
<!-- END ADITIONTAG-->
		<div class="identity">
			<a href="{OPTION('base-href-main')}">
				{brand_img('logo.gif',null,null)}
			</a>
		</div>
		{call Widget.UserInfo.Container}
	</div>
	{* Menu *}
	<div class="nav">
		<div class="main-menu">
			<ul>
				{if RegExp("^\/[a-z]{2}\/$").test(GrinEnv.request_full_path)}
                <li class="nav_left_on"
        		{else}
                <li class="nav_left"
        		{/if}>
				<a href="{OPTION('base-href-main')}">{NLS('Page::Menu::Home')}</a> 
				{if RegExp("^\/[a-z]{2}\/$").test(GrinEnv.request_full_path)}
                <div class="arrow-bottom-on"
        		{else}
                <div class="arrow-bottom"
        		{/if}>
				</div>
				</li>
					
					{if RegExp("^\/[a-z]{2}\/catalog\/$").test(GrinEnv.request_full_path)}
                	<li class="nav_main_on"
        			{else}
                	<li class="nav_main"
        			{/if}>
					<a href="search?searchstring=&publication_type=ebook&source_type=document%2Cexternal_book%2Cexternal_document">{NLS('Page::Menu::Catalogue')}</a>
					{if RegExp("^\/[a-z]{2}\/catalog\/$").test(GrinEnv.request_full_path)}
                	<div class="arrow-bottom-on"
        			{else}
                	<div class="arrow-bottom"
        			{/if}> 
					</div>
				</li>
{if RegExp("^\/[a-z]{2}\/upload$").test(GrinEnv.request_full_path)}
                	<li class="nav_main_on"
        			{else}
                	<li class="nav_main"
        			{/if}>
					<a href="upload">Autor werden</a>
					{if RegExp("^\/[a-z]{2}\/upload$").test(GrinEnv.request_full_path)}
                	<div class="arrow-bottom-on"
        			{else}
                	<div class="arrow-bottom"
        			{/if}>
					</div>
				</li> 
				{if GrinEnv.i_am_hausarbeiten}

				{else}
					{* Network 
					<li class="nav_main">
						<a href="{OPTION('base-href-network')}">{NLS('Page::Menu::People')}</a>
						<div class="arrow-bottom"></div>
					</li>
					*}
						{if RegExp("\/[a-z]{2}\/help").test(GrinEnv.request_full_path)}
	                	<li class="nav_main_on"
	        			{else}
	                	<li class="nav_main"
	        			{/if}>
						<a href="help-dummy.html">{NLS('Page::Menu::Help')}</a>
						{if RegExp("\/[a-z]{2}\/help").test(GrinEnv.request_full_path)}
                		<div class="arrow-bottom-on"
        				{else}
                		<div class="arrow-bottom"
        				{/if}></div>
					</li>
				{/if}
			</ul>
		</div>
		<div class="nav_bg">
			<div class="search">
				{Call Structure.SearchForm.Main}
					{if GrinEnv.i_am_hausarbeiten}
						{param placeholdertext=NLS('Page::Search::AllAndFreeTexts', 
							{alltexts: format_number(_ctx.brand_statistics.document_count), 
							freetexts: format_number(_ctx.brand_statistics.free_document_count)}
						)}
					{else}
						{param placeholdertext=NLS('Page::Search::AllTexts', 
							{alltexts: format_number(_ctx.brand_statistics.document_count)})}
					{/if}
				{/Call}
			</div>
			<div class="header-items">
				<a href="{OPTION('base-href-blog')}">{NLS('Page::Menu::Blog')}</a>
			</div>
			<div class="header-items">
				{link_to(brand_img('grin_twitter.png',null,'grin-twitter-fb'),'http://twitter.com/DiplomicaVerlag',null,{target:'_blank'})}
			</div>
			<div class="header-items-images">
				{link_to(brand_img('grin_fb.png',null,'grin-twitter-fb'),'http://www.facebook.com/DiplomicaVerlag',null,{target: '_blank'})}
			</div>
		</div>
		<div class="nav_right">
		</div>
		{*    Upload - button disabled
		<div class="color-white upload-area-position upload-area">
			<a href="{OPTION('base-href-upload',{lang:GrinEnv.lang})}" class="upload-area-caption cursor-pointer">{NLS('Page::Upload::WebartsLongMessage')}</a>
		</div>  *}
	</div>
{/template}

{*
*
* SIDEBAR
*
*}
{template .Sidebar}
	{meta override=true}	
	{* No static sidebar *}
{/template}

{*
*
* FOOTER
*
*}
{template.Footer}
{meta override=true}	
	<div class="footer">
<a href="impressum.html">Impressum</a> | <a href="AGB.html">AGB</a> | <a href="about.html">Über den Verlag</a> | <a href="partner.html">Partner</a>

		<div class="column">
			<div class="footer-1st-element">{NLS('Page::Menu::General')}</div>
			<ul>
				<li>{link_to_static(NLS('Page::Menu::Home'),'../index.html',null)}</li>
				<li>{link_to_static(NLS('Page::Commons::BecomeAnAuthor'),'../upload',null)}</li>
				<li>{link_to_static(NLS('Page::Menu::Catalogue'),'../search',null)}</li>
			</ul>
			<ul>
				<li><a href="{OPTION('base-href-blog')}">{NLS('Page::Menu::Blog')}</a></li>
			</ul>
			<ul>
				<li>{link_to_static(NLS('Page::Menu::About'),'../about.html',null)}</li>
				<li>{link_to_static(NLS('Page::Menu::About::Press'),'../press.html',null)}</li>
				<li>{link_to_static('Partner','../partner.html',null)}</li>
				<li>{link_to_static(NLS('Page::Imprint::Privacy'),'../help-dummy.html#Datenschutz',null)}</li>
				<li>{link_to_static(NLS('Page::Imprint'),'../impressum.html',null)}</li>
			</ul>
		</div>
		<div class="column">
			<div class="footer-1st-element">{NLS('Page::Menu::Authors')}</div>
			<ul>
				<li>{link_to_static('Autoreninfo','../help-dummy.html#Info',null)}</li>
				<li>{link_to_static('Autorenhonorar','../help-dummy.html#Honorar',null)}</li>
				<li>{link_to_static('Autorenvertrag','../help-dummy.html#Vertrag',null)}</li>
				<li>{link_to_static('Autorenprofil','../help-dummy.html#Profil',null)}</li>
				<li>{link_to_static('Arbeit hochladen','../help-dummy.html#AHoch',null)}</li>
			</ul>
			<ul>
				<li>{link_to_static('Schreibtipps','../help-dummy.html#Schreiben',null)}</li>
				<li>{link_to_static('Marketingtipps','../help-dummy.html#Marketing',null)}</li>
			</ul>
			<ul>
				<li>{link_to_static('Dissertationen','../help-dummy.html#Dissertationen',null)}</li>
				<li>{link_to_static('Fachbücher und Studien','../help-dummy.html#Fachbuecher',null)}</li>
				<li>{link_to_static('Belletristik','../help-dummy.html#Belletristik',null)}</li>
			</ul>
		</div>
		<div class="column">
			<div class="footer-1st-element">{NLS('Page::Commons::Readers')}&#160;&&#160;{NLS('Page::BuyerInformation')}</div>
			<ul>
				<li>{link_to_static('Unser Angebot','../help-dummy.html#Angebot',null)}</li>
				<li>{link_to_static('Bestellvorgang','../help-dummy.html#Bestellvorgang',null)}</li>
				<li>{link_to_static('Bestellformular','../help-dummy.html#Bestellformular',null)}</li>
				<li>{link_to_static('Versandkosten','../help-dummy.html#Versandkosten',null)}</li>
				<li>{link_to_static('Zahlungsarten','../help-dummy.html#Zahlungsarten',null)}</li>
				<li>{link_to_static('Lieferung','../help-dummy.html#Lieferung',null)}</li>
				<li>{link_to_static('Rückgabe','../help-dummy.html#Rueckgabe',null)}</li>
				<li>{link_to_static('AGB','../help-dummy.html#AGB',null)}</li>
			</ul>
		</div>
		<div class="column">
			<div class="footer-1st-element"></div>
			<ul>
				<li>Copyright</li>
				<li>&#169; Diplomica Verlag GmbH</li>
				<li>1996 - 2013</li>
			</ul>
			<div class="footer-1st-element"></div>
			<ul>
				<li>Alle Inhalte urheberrechtlich geschützt. Kopieren und verbreiten untersagt.</li>
			</ul>
			<ul>
				<li><a href="mailto:info@diplom.de">info@diplom.de</a></li>
				<li><a href="http://www.diplomica.de/">Diplomica Verlagsgruppe</a></li>
			</ul>
		</div>
		<div class="column-big">
		<div class="footer-1st-element"></div>
		<ul>
			Diplom.de steht seit 1996 für die professionelle und 
			hochwertige Veröffentlichung akademischer 
			Abschlussarbeiten im Original als eBook und Buch.
		</ul>
		<ul>
			Bachelorarbeiten, Masterarbeiten, Diplomarbeiten, 
			Magisterarbeiten, Dissertationen und andere 
			Abschlussarbeiten aus allen Fachbereichen 
			und Hochschulen können Sie bei uns als eBook
			sofort per Download beziehen oder sich als Buch
			zusenden lassen.
		</ul>
		<ul>
			<li>{link_to_static('Nutzen Sie unsere kostenfreie Buchveröffentlichung!','../upload',null)}</li> 
		</ul>
		</div>
		<div class="clear-all"></div>
	</div>
{/template}


{*
*
* BOTTOM
*
*}
{* .Bottom is called directly before </body></html> *}
{template .Bottom}
	{meta override=true}

	{if !GrinEnv.i_am_grin && !GrinEnv.i_am_unterweisungen && !(GrinEnv.handler == 'document' && GrinEnv.i_am_diplomarbeiten24)}
		{call .Advertisement}
	{/if}

	{call .VGWORT}
{/template}

{template .VGWORT}

	{if GrinEnv.handler == 'document'}
		{if _ctx.maindata.identifiers && _ctx.maindata.identifiers.vgwort && _ctx.maindata.identifiers.vgwort.publicidentificationid}
			<img width="1" height="1" alt="" src="http://vg00.met.vgwort.de/na/{_ctx.maindata.identifiers.vgwort.publicidentificationid}"></img>
		{/if}
	{/if}

{/template}

{template .Advertisement}
	
{/template}


{*
*
* Container Template called on OrderFinished page
*
*}
{template .OrderFinished.InfoBox}
	{param account=_ctx.maindata}
	{if (GrinEnv.i_am_grin || GrinEnv.i_am_hausarbeiten) && GrinEnv.lang == 'de'}
		{param shop_id=GrinEnv.i_am_grin ? 'X1098E55B93A58BF003CB4E90E5AF4E73' : 'X3E9B44D7C191BAEC3BC114194FEC381F'}

		<div class="sub-section top-line">
			<!-- trusted shops form -->
			{literal}
				<style>
					table.tform { border: none;  }
					table.tform td { border: none; }
					table.tform tr:hover { background: none; }
				</style>
			{/literal}
			<table border="0" cellspacing="0" cellpadding="4" class="tform">
				<tr>
					<td width="90">
						<form name="formSiegel" method="post" action="https://www.trustedshops.com/shop/certificate.php" target="_blank">
							<input type="image" border="0" src="/images/trustedshops_m.gif" title="Trusted Shops Gütesiegel - Bitte hier Gültigkeit prüfen!" style="width: 63px; height: 60px; border: none; box-shadow: none;"/>
							<input name="shop_id" type="hidden" value="{_p.shop_id}" />
						</form>
					</td>
					<td align="justify">
						<form id="formTShops" name="formTShops" method="post" action="https://www.trustedshops.com/shop/protection.php" target="_blank">
							<input name="_charset_" type="hidden" value="" />
							<input name="shop_id" type="hidden" value="{_p.shop_id}" />
							<input name="email" type="hidden" value="{_p.account.shopping_cart.email}" />
							<input name="amount" type="hidden" value="{_p.account.sum_gross[0].value / 100}" />
							<input name="curr" type="hidden" value="{_p.account.sum_gross[0].currency}" />
							<input name="paymentType" type="hidden" value="{_p.account.shopping_cart.payment_type}" />
							<input name="KDNR" type="hidden" value="a{_p.account.user_id}" />
							<input name="ORDERNR" type="hidden" value="{_p.account.invoice.transaction_id}" />
							Als zusätzlichen Service bieten wir Ihnen den Trusted Shops Käuferschutz an. Wir übernehmen alle Kosten dieser Garantie, Sie müssen sich lediglich anmelden.
							<br />
							<br />
							<button type="submit" id="btnProtect" name="btnProtect" class="m-5px-left">
								<span><span>Anmeldung zum Trusted Shops Käuferschutz</span></span>
							</button>
						</form>
					</td>
				</tr>
			</table> 
		</div>
	{/if}

	<!-- Google Code for Purchase/Sale Conversion Page ACCOUNT 1 -->
	<script type="text/javascript">
		<!-- /* <![CDATA[ */ -->
		var google_conversion_id = 1072502168;
		var google_conversion_language = "en";
		var google_conversion_format = "1";
		var google_conversion_color = "666666";
		var google_conversion_label = "purchase";
		var google_conversion_value = {_p.account.sum[0].value};
		<!-- /* ]]> */ -->
	</script>
	<script type="text/javascript" src="https://www.googleadservices.com/pagead/conversion.js">
	</script>
	<noscript>
		<div style="display:inline;">
			<img height="1" width="1" style="border-style:none;" alt="" src="https://www.googleadservices.com/pagead/conversion/1072502168/?label=purchase&amp;guid=ON&amp;script=0"/>
		</div>
	</noscript>

	<!-- Google Code for Purchase/Sale Conversion Page ACCOUNT 2-->
	<script type="text/javascript">
		<!-- /* <![CDATA[ */ -->
		var google_conversion_id = 979605176;
		var google_conversion_language = "de";
		var google_conversion_format = "2";
		var google_conversion_color = "ffffff";
		var google_conversion_label = "BMbLCKj9wQIQuK2O0wM";
		var google_conversion_value = {_p.account.sum[0].value};
		<!-- /* ]]> */ -->
	</script>
	<script type="text/javascript" src="https://www.googleadservices.com/pagead/conversion.js">
	</script>
	<noscript>
		<div style="display:inline;">
			<img height="1" width="1" style="border-style:none;" alt="" src="https://www.googleadservices.com/pagead/conversion/979605176/?label=BMbLCKj9wQIQuK2O0wM&amp;guid=ON&amp;script=0"/>
		</div>
	</noscript>

<!-- BEGIN ADITIONTAG Website-Tag -->
<script type="text/javascript" src="http://imagesrv.adition.com/js/adition.js"></script>
<script type="text/javascript" src="http://ad1.adfarm1.adition.com/js?wp_id=11852"></script>
<!-- END ADITIONTAG-->
{/template}

