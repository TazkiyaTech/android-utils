# Android Utils Library

This library contains an assortment of small helper classes, functions and views useful for Android projects.

## Collections

|                           |                                                                                                                              |
|---------------------------|------------------------------------------------------------------------------------------------------------------------------|
| [ArrayExtensions][1]      | Provides a Kotlin extension function for checking whether an `Array` contains any of the elements of another array.          |
| [CollectionExtensions][2] | Provides a Kotlin extension function for checking whether a `Collection` contains any of the elements of another collection. |
| [ImmutableList][3]        | Provides a helper method for creating immutable copies of `java.util.List` instances.                                        |
| [ImmutableMap][4]         | Provides a helper method for creating immutable copies of `java.util.Map` instances.                                         |
| [ImmutableSet][5]         | Provides a helper method for creating immutable copies of `java.util.Set` instances.                                         |
| [ListExtensions][6]       | Provides a Kotlin extension function for joining a `List` of `String` objects into a single `String` object.                 |

## Display

|                 |                                                                                                                       |
|-----------------|-----------------------------------------------------------------------------------------------------------------------|
| [Colors][7]     | Provides a number of Kotlin extension functions for converting between different colour representations.              |
| [Dimensions][8] | Provides a number of Kotlin extension functions for converting between different dimension units.                     |
| [Themes][9]     | Provides a number of Kotlin extension functions for getting colours such as the primary text colour out of the theme. |

## Fragments

|                                |                                                                                                                                  |
|--------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| [DialogFragmentExtensions][10] | Provides a Kotlin extension function which allows a `DialogFragment` to be shown even after the activity's state has been saved. |

## Network

|                        |                                                                |
|------------------------|----------------------------------------------------------------|
| [NetworkInspector][11] | Provides helper methods for checking the state of the network. |

## Streams

|                          |                                                                                                                  |
|--------------------------|------------------------------------------------------------------------------------------------------------------|
| [StreamCopier][12]       | Provides an easy method for copying the contents of an input stream to an output stream.                         |
| [StringInputStream][13]  | Provides an easy method for reading in the contents of an input stream and converting it to a `String` instance. |
| [StringOutputStream][14] | Provides an easy method for writing a `String` instance to an output stream.                                     |

## Text

|                                        |                                                                                                                        |
|----------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| [CharSequenceExtensions][15]           | Provides a number of Kotlin extension functions for the `CharSequence` class.                                          |
| [SpannableExtensions][16]              | Provides a number of Kotlin extension functions for adding spans to an `android.text.Spannable` instance.              |
| [SpannableStringBuilderExtensions][17] | Provides a number of Kotlin extension functions for adding spans to an `android.text.SpannableStringBuilder` instance. |

## Views

|                              |                                                                                                                                                                                                |
|------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [RecyclerViewExtensions][18] | Provides Kotlin extension functions for drawing a colored divider or a vertical gap between items in a `RecyclerView`.                                                                         |
| [SimpleTouchListener][19]    | An implementation of the `android.view.View.OnTouchListener` interface that simply reports when a `android.view.View` is touched down and when the touch is subsequently released or canceled. |
| [SpinnerLookalikeView][20]   | An extension of the `android.widget.FrameLayout` class that looks like an `android.widget.Spinner` view.                                                                                       |

## Setup

To use the above utilities within your app simply add the following repository and dependency declaration in
the `build.gradle` file of your Android project:

```groovy
repositories {
    mavenCentral()
}
dependencies {
    implementation("com.tazkiyatech:android-utils:2.0.0")
}
```

[1]: library/src/main/java/com/tazkiyatech/utils/collections/ArrayExtensions.kt
[2]: library/src/main/java/com/tazkiyatech/utils/collections/CollectionExtensions.kt
[3]: library/src/main/java/com/tazkiyatech/utils/collections/ImmutableList.java
[4]: library/src/main/java/com/tazkiyatech/utils/collections/ImmutableMap.java
[5]: library/src/main/java/com/tazkiyatech/utils/collections/ImmutableSet.java
[6]: library/src/main/java/com/tazkiyatech/utils/collections/ListExtensions.kt
[7]: library/src/main/java/com/tazkiyatech/utils/display/Colors.kt
[8]: library/src/main/java/com/tazkiyatech/utils/display/Dimensions.kt
[9]: library/src/main/java/com/tazkiyatech/utils/display/Themes.kt
[10]: library/src/main/java/com/tazkiyatech/utils/display/DialogFragmentExtensions.kt
[11]: library/src/main/java/com/tazkiyatech/utils/network/NetworkInspector.java
[12]: library/src/main/java/com/tazkiyatech/utils/streams/StreamCopier.java
[13]: library/src/main/java/com/tazkiyatech/utils/streams/StringInputStream.java
[14]: library/src/main/java/com/tazkiyatech/utils/streams/StringOutputStream.java
[15]: library/src/main/java/com/tazkiyatech/utils/lang/CharSequenceExtensions.kt
[16]: library/src/main/java/com/tazkiyatech/utils/display/SpannableExtensions.kt
[17]: library/src/main/java/com/tazkiyatech/utils/display/SpannableStringBuilderExtensions.kt
[18]: library/src/main/java/com/tazkiyatech/utils/views/RecyclerViewExtensions.kt
[19]: library/src/main/java/com/tazkiyatech/utils/views/SimpleTouchListener.java
[20]: library/src/main/java/com/tazkiyatech/utils/views/SpinnerLookalikeView.java
