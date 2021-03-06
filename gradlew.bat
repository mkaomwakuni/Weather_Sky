<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/cv_movie"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="4dp"
    android:focusable="true"
    app:cardCornerRadius="8dp"
    app:cardElevation="@dimen/size_small">

    <FrameLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@drawable/shape_background"
        android:elevation="@dimen/size_large"
        android:padding="2dp">

        <TextView
            android:id="@+id/tv_rating_cardlabel"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:textAlignment="center"
            android:textColor="@color/colorWhite"
            android:textSize="15sp"
            android:textStyle="bold"
            tools:text="7.4" />
    </FrameLayout>

    <RelativeLayout
        android:id="@+id/rl_parent"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@drawable/movie_selector">

        <smoovie.apps.com.kayatech.smoovie.util.SmooviePosterImageView
            android:id="@+id/iv_poster_image"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_alignParentStart="true"
            android:layout_alignParentTop="true"
            android:contentDescription="@string/label_content_description_poster"
            android:scaleType="fitXY"
            android:transitionName="poster" />

    </RelativeLayout>


</android.support.v7.widget.CardView>

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  