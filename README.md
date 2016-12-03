This Android library (SDK) contains helper classes and views that we have found to be useful in our Android applications and which we'd like to share with the wider world!

The classes contained within the library are as follows:

* `com.thinkincode.utils.database.QueryPlanExplainer` – Provides helper methods for explaining the strategy or plan that SQLite uses to implement specific SQL queries.
* `com.thinkincode.utils.network.NetworkInspector` – Provides helper methods for checking the state of the network.
* `com.thinkincode.utils.streams.StreamCopier` – Provides an easy method for copying the contents of an input stream to an output stream.
* `com.thinkincode.utils.streams.StringInputStream` – Provides an easy method for reading in the contents of an input stream and converting it to a String.
* `com.thinkincode.utils.streams.StringOutputStream` – Provides an easy method for writing a String to an output stream.
* `com.thinkincode.utils.views.AutoResizeTextView` – An extension of the `android.widget.TextView` class which resizes (scales down) its text to fit within its available width and height.
* `com.thinkincode.utils.views.HorizontalDividerRecyclerViewItemDecoration` – An extension of the `android.support.v7.widget.RecyclerView.ItemDecoration` class that draws a horizontal divider at the bottom of each item in the `RecyclerView`.
* `com.thinkincode.utils.views.HorizontalFlowLayout` – An extension of the `android.widget.RelativeLayout` class that places its children horizontally and flows over to a new line whenever it runs out of width.
* `com.thinkincode.utils.views.SpinnerLookalikeView` – An extension of the `android.widget.FrameLayout` class that looks like an `android.widget.Spinner` view.

To use the above classes within your app you'll need to first declare the repository from which you'll get the library. You can do this by copying the following declaration into the `build.gradle` file of your app:

    repositories {
        jcenter()
    }

Secondly and finally, you need to declare the library as a dependency in your app. You can do this by copying the following declaration into the `build.gradle` file of your app:

    dependencies {
        compile 'com.thinkincode.utils:Android:0.1.8'
    }
