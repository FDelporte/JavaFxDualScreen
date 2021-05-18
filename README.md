# JavaFX Dual screen test application for Raspberry Pi

This is a proof-of-concept application demonstrating dual screen support on Raspberry Pi with JavaFX 17.

## Get JavaFX 17-ea+9

```
wget https://download2.gluonhq.com/openjfx/17/openjfx-17-ea+9_linux-arm32_bin-sdk.zip
sudo unzip openjfx-17-ea+9_linux-arm32_bin-sdk.zip -d /opt
```

64bit: https://download2.gluonhq.com/openjfx/17/openjfx-17-ea+9_monocle-linux-aarch64_bin-sdk.zip

## Get drm1.1.4 lib

```
cd /opt/javafx-sdk-17/lib/
sudo wget http://download2.gluonhq.com/drm/lib-1.1.4/arm32/libgluon_drm.so
sudo chmod +x libgluon_drm.so 
ls -l

total 15896
-rw-r--r-- 1 root root  745769 Apr 30 20:26 javafx.base.jar
-rw-r--r-- 1 root root 2535774 Apr 30 20:26 javafx.controls.jar
-rw-r--r-- 1 root root  129375 Apr 30 20:26 javafx.fxml.jar
-rw-r--r-- 1 root root 4538555 Apr 30 20:26 javafx.graphics.jar
-rw-r--r-- 1 root root  268328 Apr 30 20:26 javafx.media.jar
-rw-r--r-- 1 root root    1039 Apr 30 20:26 javafx.platform.properties
-rw-r--r-- 1 root root     105 Apr 30 20:26 javafx.properties
-rw-r--r-- 1 root root  712205 Apr 30 20:26 javafx.web.jar
-rwxr-xr-x 1 root root   61200 Apr 30 20:26 libdecora_sse.so
-rwxr-xr-x 1 root root   29580 Apr 30 20:26 libglass_monocle.so
-rwxr-xr-x 1 root root   15966 Apr 30 20:26 libglass_monocle_x11.so
-rwxr-xr-x 1 root root  197940 Apr 30 20:26 libglass.so
-rwxr-xr-x 1 root root   25748 Apr 30 20:26 libgluon_drm-1.1.3.so
-rwxr-xr-x 1 root root   24738 May  6 11:03 libgluon_drm.so
-rwxr-xr-x 1 root root   22082 Apr 30 20:26 libjavafx_font_freetype.so
-rwxr-xr-x 1 root root   20616 Apr 30 20:26 libjavafx_font_pango.so
-rwxr-xr-x 1 root root   15326 Apr 30 20:26 libjavafx_font.so
-rwxr-xr-x 1 root root  232386 Apr 30 20:26 libjavafx_iio.so
-rwxr-xr-x 1 root root    5823 Apr 30 20:26 libprism_common.so
-rwxr-xr-x 1 root root   54487 Apr 30 20:26 libprism_es2_monocle.so
-rwxr-xr-x 1 root root   56467 Apr 30 20:26 libprism_sw.so
-rw-r--r-- 1 root root 6532597 Apr 30 20:26 src.zip
```

64bit: wget http://download2.gluonhq.com/drm/lib-1.1.4/aarch64/libgluon_drm.so

## Build and run

```
mvn package
cd target/distribution
sudo bash run-kiosk.sh
```