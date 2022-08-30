# Peppythings
Peppythings web site test automation suite
PeppyThings project is a web application automation project. It is not automated the web-site entirely. It focuses on utilizing different techniques and creating optimized & easy to maintain framework.
Executed test cases based on testng.xml files are as follows;

1. Test folder name: Food Page Test
   -Navigate to main page, click on Food tab.
   -In the Food Page, click on "Kampanyalar" button which is placed under "Kategoriler" title.
   -Click filter box and select "prices from down to up". Verify that listed items are ordered correctly.
   -Numbers are written next to "Gıda", "Güçlü kadınların ürünleri", "Kampanyalar", "Sofra&Mutfak"	buttons. 
   -Click on "Gıda", "Güçlü kadınların ürünleri", "Kampanyalar", "Sofra&Mutfak"	buttons present under category title respectively.
   -Verify number of items listed and numbers written next to buttons are same.
   -Bug: On the Food Page number written next to Gıda button is 28 but 32 items are listed. It is a bug of web-site itself.
   
2. Test folder name: Login Test
   -Navigate to main page, open new window and navigate to LoginPage in the new window
   -Enter login credentials
   -Verify number of items listed on dashboard is 6.
   -Verify that texts written on the boxes are Pano, Siparişler, Adres, Hesap Detayları, Vendors, Favorilerim 
   
3. Test folder name: Main Page Test
   -Navigate to main page.
   -Verify logo is present on the page.
   -Verify URL is correct.
   -Verify footer links on the page is not broken. 
   
4. Test folder name: Textile Page Test
   -Navigate to main page.
   -Open Textile Page in the new tab.
   -Check URL is correct
   -Check numbers present under category page is matching with number of listed products.
   -Click on lokalyumak button, verify that all listed products description contains "Lif".

This project utilizes TestNG Listeners, Log4j & ExtentReport frameworks. 
