# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn com.igexin.**
-keep class com.igexin.** { *; }
-keep class org.json.** { *; }

#1.基本指令区
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
-ignorewarning
-printmapping proguardMapping.txt
-optimizations !code/simplification/cast,!field/*,!class/merging/*
-keepattributes *Annotation*,InnerClasses
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable

#2.默认保留区
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
-keep class android.support.** {*;}

-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}

# 枚举类
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#自定义view
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Parcelable
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# 资源文件
-keep class **.R$* {
 *;
}
-keepclassmembers class * {
    void *(**On*Event);
}

#3.webview
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}
-dontwarn android.net.http.SslError
-dontwarn Android.webkit.WebViewClient

#1.实体类
-dontwarn com.dpad.crmsalesapp.android.entity.**
-keep class com.dpad.crmsalesapp.android.entity.** { *; }




#自定义view
-dontwarn com.dpad.crmsalesapp.android.weiget.**
-keep class com.dpad.crmsalesapp.android.weiget.** { *; }

#工具类
-dontwarn com.dpad.crmsalesapp.android.utils.**
-keep class com.dpad.crmsalesapp.android.utils.** { *; }

#2.第三方包

# retrofit2 rxjava2 rxAndroid
-dontwarn retrofit2.adapter.rxjava2.**
-keep class retrofit2.adapter.rxjava2.** { *; }

-dontwarn retrofit2.converter.gson.**
-keep class retrofit2.converter.gson.** { *; }

-dontwarn retrofit2.converter.**
-keep class retrofit2.converter.** { *; }

-dontwarn io.reactivex.android.**
-keep class io.reactivex.android.** { *; }

-dontwarn io.reactivex.**
-keep class io.reactivex.** { *; }

-dontwarn org.hamcrest.**
-keep class org.hamcrest.** { *; }

-dontwarn org.reactivestreams.**
-keep class org.reactivestreams.** { *; }

-dontwarn org.codehaus.mojo.**
-keep class org.codehaus.mojo.** { *; }

# Rxlifecycle
-dontwarn com.trello.rxlifecycle2.**
-keep class com.trello.rxlifecycle2.** { *; }

# Rxpermission
-dontwarn com.tbruyelle.**
-keep class com.tbruyelle.** { *; }

# pickerview
-dontwarn com.bigkoo.pickerview.**
-keep class com.bigkoo.pickerview.** { *; }

# xrecyclerview
-dontwarn cn.droidlover.xrecyclerview.**
-keep class cn.droidlover.xrecyclerview.** { *; }

# banner
-dontwarn com.youth.banner.**
-keep class com.youth.banner.** { *; }

# Android_picker
-dontwarn cn.addapp.pickers.**
-keep class cn.addapp.pickers.** { *; }

# BaseRecyclerViewAdapterHelper
-dontwarn com.chad.library.**
-keep class com.chad.library.** { *; }

# ButterKnife 8.4.0
-dontwarn butterknife.**
-keep class butterknife.** { *; }

# EasySwipeMenuLayout
-dontwarn com.guanaj.easyswipemenulibrary.**
-keep class com.guanaj.easyswipemenulibrary.** { *; }



# nineoldandroids
-dontwarn com.nineoldandroids.**
-keep class com.nineoldandroids.** { *; }

# apache.http
-dontwarn org.apache.http.legacy.**
-keep class org.apache.http.legacy.** { *; }

# Glide
-dontwarn com.bumptech.glide.**
-keep class com.bumptech.glide.** { *; }

# Gson
-dontwarn com.google.gson.**
-keep class com.google.gson.** { *; }

# okhttp
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}

# okio
-dontwarn okio.**
-keep class okio.**{*;}

# photoview
-dontwarn com.github.chrisbanes.photoview.**
-keep class com.github.chrisbanes.photoview.**{*;}


#BlockCanary
-dontwarn com.github.moduth.blockcanary.**
-keep class com.github.moduth.blockcanary.**{*;}

#LeakCanary
-dontwarn com.squareup.leakcanary.**
-keep class com.squareup.leakcanary.**{*;}

-keepnames class * implements android.os.Parcelable {
public static final ** CREATOR;
}

-keep class com.linkedin.** { *; }
-keepattributes Signature


-dontwarn com.google.**
-keep class com.google.gson.** {*;}
-keep class com.google.protobuf.** {*;}


# gradle-retrolambda
-dontwarn java.lang.invoke.*
-dontwarn **$$Lambda$*


##解决java.lang.InternalError
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#个推混淆
-dontwarn com.igexin.**
-keep class com.igexin.** { *; }
-keep class org.json.** { *; }


-keep class com.jph.takephoto.** { *; }
-dontwarn com.jph.takephoto.**

-keep class com.darsh.multipleimageselect.** { *; }
-dontwarn com.darsh.multipleimageselect.**

-keep class com.soundcloud.android.crop.** { *; }
-dontwarn com.soundcloud.android.crop.**


