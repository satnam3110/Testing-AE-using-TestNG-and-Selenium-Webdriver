# Testing-AE-using-TestNG-and-Selenium-Webdriver
Testing AE using TestNG and Selenium Webdriver
This Project is built using git,Maven, TestNG & Selinum webdriver.
the will test the follwing Test cases on www.ae.com
1. SearchProduct
2. AddProductToCart
3. CheckoutCart
4. PlaceOrder
5. TestPaymentType


To run run downlod the Maven project source code in sts/eclipse tool.
1. download the project and import it in sts/esclipse as Maven project.
2. download geckodriver from https://github.com/mozilla/geckodriver/releases/tag/v0.26.0
3. set the -Dwebdriver.gecko.driver="/change /this to your path of /geckodriver" run configuration-->VM Argument
4. right click on TestAEusingTestNG file and the clink on ----- run As------->TestNG test.
5. ensure firefox browser is installed in your system and is recommended to close firefox browser prior to run the application (As I have seen timeout,memory consumption issue )



