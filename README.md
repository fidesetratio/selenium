wget https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip
unzip chromedriver_linux64.zip
wget http://www.java2s.com/Code/JarDownload/testng/testng-6.8.7.jar.zip
unzip testng-6.8.7.jar.zip
wget https://selenium-release.storage.googleapis.com/3.13/selenium-server-standalone-3.13.0.jar
xvfb-run java -Dwebdriver.chrome.driver=/usr/bin/chromedriver -jar selenium-server-standalone.jar