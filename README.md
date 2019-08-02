# Android Utils Library

This library contains a mixture of small helper classes and views useful for Android projects.

## Classes

The classes contained within the library are as follows:

* [com.tazkiyatech.utils.collections.ImmutableList](library/src/main/java/com/tazkiyatech/utils/collections/ImmutableList.java) – Provides a helper method for creating immutable copies of `java.util.List` instances
* [com.tazkiyatech.utils.collections.ImmutableMap](library/src/main/java/com/tazkiyatech/utils/collections/ImmutableMap.java) – Provides a helper method for creating immutable copies of `java.util.Map` instances.
* [com.tazkiyatech.utils.collections.ImmutableSet](library/src/main/java/com/tazkiyatech/utils/collections/ImmutableSet.java) – Provides a helper method for creating immutable copies of `java.util.Set` instances.
* [com.tazkiyatech.utils.collections.ListExtensions](library/src/main/java/com/tazkiyatech/utils/collections/ListExtensions.kt) – Provides a helper method for joining a `java.util.List` of `java.lang.String` objects into a single `java.lang.String` object.
* [com.tazkiyatech.utils.database.QueryPlanExplainer](library/src/main/java/com/tazkiyatech/utils/database/QueryPlanExplainer.java) – Provides helper methods for explaining the strategy or plan that SQLite uses to implement specific SQL queries.
* [com.tazkiyatech.utils.display.Colors](library/src/main/java/com/tazkiyatech/utils/display/Colors.kt) – Provides helper methods for converting between different colour representations.
* [com.tazkiyatech.utils.display.Dimensions](library/src/main/java/com/tazkiyatech/utils/display/Dimensions.kt) – Provides helper methods for converting between different dimension units.
* [com.tazkiyatech.utils.display.SpannableExtensions](library/src/main/java/com/tazkiyatech/utils/display/SpannableExtensions.kt) – Provides helper methods for adding spans to `android.text.Spannable` instances.
* [com.tazkiyatech.utils.display.SpannableStringBuilderExtensions](library/src/main/java/com/tazkiyatech/utils/display/SpannableStringBuilderExtensions.kt) – Provides helper methods for adding spans to `android.text.SpannableStringBuilder` instances.
* [com.tazkiyatech.utils.display.Themes](library/src/main/java/com/tazkiyatech/utils/display/Themes.kt) – Provides helper methods for getting colours such as the primary text colour out of the theme.
* [com.tazkiyatech.utils.network.NetworkInspector](library/src/main/java/com/tazkiyatech/utils/network/NetworkInspector.java) – Provides helper methods for checking the state of the network.
* [com.tazkiyatech.utils.streams.StreamCopier](library/src/main/java/com/tazkiyatech/utils/streams/StreamCopier.java) – Provides an easy method for copying the contents of an input stream to an output stream.
* [com.tazkiyatech.utils.streams.StringInputStream](library/src/main/java/com/tazkiyatech/utils/streams/StringInputStream.java) – Provides an easy method for reading in the contents of an input stream and converting it to a String.
* [com.tazkiyatech.utils.streams.StringOutputStream](library/src/main/java/com/tazkiyatech/utils/streams/StringOutputStream.java) – Provides an easy method for writing a String to an output stream.
* [com.tazkiyatech.utils.views.HorizontalDividerRecyclerViewItemDecoration](library/src/main/java/com/tazkiyatech/utils/views/HorizontalDividerRecyclerViewItemDecoration.java) – An extension of the `android.support.v7.widget.RecyclerView.ItemDecoration` class that draws a horizontal divider at the bottom of each item in the `RecyclerView`.
* [com.tazkiyatech.utils.views.HorizontalFlowLayout](library/src/main/java/com/tazkiyatech/utils/views/HorizontalFlowLayout.java) – An extension of the `android.widget.RelativeLayout` class that places its children horizontally and flows over to a new line whenever it runs out of width.
* [com.tazkiyatech.utils.views.SimpleTouchListener](library/src/main/java/com/tazkiyatech/utils/views/SimpleTouchListener.java) – An implementation of the `android.view.View.OnTouchListener` interface that simply reports when a `android.views.View` is touched down and when the touch is subsequently released or canceled.
* [com.tazkiyatech.utils.views.SpinnerLookalikeView](library/src/main/java/com/tazkiyatech/utils/views/SpinnerLookalikeView.java) – An extension of the `android.widget.FrameLayout` class that looks like an `android.widget.Spinner` view.

## Setup

To use the above classes within your app you'll need to first declare the repository from which you'll get the library. You can do this by copying the following `jcenter` repository declaration into the `build.gradle` file of your app:

    repositories {
        jcenter()
    }

Secondly and finally, you need to declare the library as a dependency in your app. You can do this by copying the following dependency declaration into the `build.gradle` file of your app:

    dependencies {
        implementation 'com.tazkiyatech:android-utils:0.0.8'
    }
