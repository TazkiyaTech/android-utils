# Android Utils Library

This library contains a mixture of small helper classes, functions and views useful for Android projects.

## Collections

* [ArrayExtensions](library/src/main/java/com/tazkiyatech/utils/collections/ArrayExtensions.kt) – Provides a
  Kotlin extension function for checking whether an `Array` contains any of the elements of another array.
* [CollectionExtensions](library/src/main/java/com/tazkiyatech/utils/collections/CollectionExtensions.kt) –
  Provides a Kotlin extension function for checking whether a `Collection` contains any of the elements of
  another collection.
* [ImmutableList](library/src/main/java/com/tazkiyatech/utils/collections/ImmutableList.java) – Provides a
  helper method for creating immutable copies of `java.util.List` instances
* [ImmutableMap](library/src/main/java/com/tazkiyatech/utils/collections/ImmutableMap.java) – Provides a
  helper method for creating immutable copies of `java.util.Map` instances.
* [ImmutableSet](library/src/main/java/com/tazkiyatech/utils/collections/ImmutableSet.java) – Provides a
  helper method for creating immutable copies of `java.util.Set` instances.
* [ListExtensions](library/src/main/java/com/tazkiyatech/utils/collections/ListExtensions.kt) – Provides a
  Kotlin extension function for joining a `List` of `String` objects into a single `String` object.

## Display

* [Colors](library/src/main/java/com/tazkiyatech/utils/display/Colors.kt) – Provides a number of Kotlin
  extension functions for converting between different colour representations.
* [DialogFragmentExtensions](library/src/main/java/com/tazkiyatech/utils/display/DialogFragmentExtensions.kt)
  – Provides a Kotlin extension function which allows a `DialogFragment` to be shown even after the activity's
  state has been saved.
* [Dimensions](library/src/main/java/com/tazkiyatech/utils/display/Dimensions.kt) – Provides a number of
  Kotlin extension functions for converting between different dimension units.
* [SpannableExtensions](library/src/main/java/com/tazkiyatech/utils/display/SpannableExtensions.kt) – Provides
  a number of Kotlin extension functions for adding spans to an `android.text.Spannable` instance.
* [SpannableStringBuilderExtensions](library/src/main/java/com/tazkiyatech/utils/display/SpannableStringBuilderExtensions.kt)
  – Provides a number of Kotlin extension functions for adding spans to
  an `android.text.SpannableStringBuilder` instance.
* [Themes](library/src/main/java/com/tazkiyatech/utils/display/Themes.kt) – Provides a number of Kotlin
  extension functions for getting colours such as the primary text colour out of the theme.

## Lang

* [CharSequenceExtensions](library/src/main/java/com/tazkiyatech/utils/lang/CharSequenceExtensions.kt) –
  Provides a number of Kotlin extension functions for the `CharSequence` class.

## Network

* [NetworkInspector](library/src/main/java/com/tazkiyatech/utils/network/NetworkInspector.java) – Provides
  helper methods for checking the state of the network.

## Streams

* [StreamCopier](library/src/main/java/com/tazkiyatech/utils/streams/StreamCopier.java) – Provides an easy
  method for copying the contents of an input stream to an output stream.
* [StringInputStream](library/src/main/java/com/tazkiyatech/utils/streams/StringInputStream.java) – Provides
  an easy method for reading in the contents of an input stream and converting it to a `String` instance.
* [StringOutputStream](library/src/main/java/com/tazkiyatech/utils/streams/StringOutputStream.java) – Provides
  an easy method for writing a `String` instance to an output stream.

## Views

* [RecyclerViewExtensions](library/src/main/java/com/tazkiyatech/utils/views/RecyclerViewExtensions.kt) –
  Provides Kotlin extension functions for drawing a colored divider or a vertical gap between items in
  a `RecyclerView`.
* [SimpleTouchListener](library/src/main/java/com/tazkiyatech/utils/views/SimpleTouchListener.java) – An
  implementation of the `android.view.View.OnTouchListener` interface that simply reports when
  a `android.view.View` is touched down and when the touch is subsequently released or canceled.
* [SpinnerLookalikeView](library/src/main/java/com/tazkiyatech/utils/views/SpinnerLookalikeView.java) – An
  extension of the `android.widget.FrameLayout` class that looks like an `android.widget.Spinner` view.

## Setup

To use the above utilities within your app simply add the following repository and dependency declaration in
the `build.gradle` file of your Android project:

```gradle
repositories {
    mavenCentral()
}
dependencies {
    implementation 'com.tazkiyatech:android-utils:0.2.3'
}
```