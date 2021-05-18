module be.webtechie.test {
    requires com.pi4j;
    requires com.pi4j.plugin.pigpio;
    requires org.slf4j;
    requires org.slf4j.simple;
    requires javafx.graphics;
    requires javafx.controls;

    uses com.pi4j.extension.Extension;
    uses com.pi4j.provider.Provider;

    opens be.webtechie.test to com.pi4j;
    exports be.webtechie.test to javafx.graphics;
}
