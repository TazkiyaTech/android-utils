This Android library (SDK) contains helper classes and views that we have found to be useful in our Android applications and which we'd like to share with the wider world!

The classes contained within the library are as follows:

* `com.thinkincode.utils.views.AutoResizeTextView` – An extension of the `android.widget.TextView` class which resizes (scales down) its text to fit within its available width and height.
* `com.thinkincode.utils.views.HorizontalFlowLayout` – An extension of the `android.widget.RelativeLayout` class which places its children horizontally and flows over to a new line whenever it runs out of width.
* `com.thinkincode.utils.network.NetworkInspector` – Contains helper methods for checking the state of the network.

To use the above classes within your app you'll need to first declare the repository from which you'll get the library. You can do this by copying the following declaration into the `build.gradle` file of your app:

    repositories {
        jcenter()
    }

Secondly and finally, you need to declare the library as a dependency in your app. You can do this by copying the following declaration into the `build.gradle` file of your app:

    dependencies {
        compile 'com.thinkincode.utils:Android:0.0.3'
    }
