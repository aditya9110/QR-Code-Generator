# QR-Code-Generator
Program to generate a QR Code (Quick Response Code) using Applets in Java.

Implementation: A basic applet is created with labels, textfields and buttons. When a string, especially a link, is being entered in the textfield, it is stored into a variable. The variables is been passed to the QR code library. It is then converted from string to Image type like .jpg, .png, etc. Its then passed to ByteArrayOutputStream in order to store in a file. The image is converted to byte array to store as FileOutputStream cannot pass byte data. A location has declared, here desktop, where the image file is been stored. On scanning the image using a QR Scanner App, the link is been displayed on the mobile. 
JAR Files: Java Archive File.
This .jar files has been imported into program which generates the QR Code. 
