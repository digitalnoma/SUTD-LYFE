// Generated by view binder compiler. Do not edit!
package com.example.hamburgermenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hamburgermenu.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTweetBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button backTweet;

  @NonNull
  public final Button btnUpload;

  @NonNull
  public final ConstraintLayout frameLayout7;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final EditText listingInformation;

  @NonNull
  public final EditText listingTitle;

  @NonNull
  public final Button postTweet;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  private FragmentTweetBinding(@NonNull ConstraintLayout rootView, @NonNull Button backTweet,
      @NonNull Button btnUpload, @NonNull ConstraintLayout frameLayout7,
      @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3,
      @NonNull EditText listingInformation, @NonNull EditText listingTitle,
      @NonNull Button postTweet, @NonNull TextView textView, @NonNull TextView textView2,
      @NonNull TextView textView3) {
    this.rootView = rootView;
    this.backTweet = backTweet;
    this.btnUpload = btnUpload;
    this.frameLayout7 = frameLayout7;
    this.imageView = imageView;
    this.linearLayout3 = linearLayout3;
    this.listingInformation = listingInformation;
    this.listingTitle = listingTitle;
    this.postTweet = postTweet;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTweetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTweetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_tweet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTweetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backTweet;
      Button backTweet = ViewBindings.findChildViewById(rootView, id);
      if (backTweet == null) {
        break missingId;
      }

      id = R.id.btn_upload;
      Button btnUpload = ViewBindings.findChildViewById(rootView, id);
      if (btnUpload == null) {
        break missingId;
      }

      ConstraintLayout frameLayout7 = (ConstraintLayout) rootView;

      id = R.id.image_view;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.listing_information;
      EditText listingInformation = ViewBindings.findChildViewById(rootView, id);
      if (listingInformation == null) {
        break missingId;
      }

      id = R.id.listing_title;
      EditText listingTitle = ViewBindings.findChildViewById(rootView, id);
      if (listingTitle == null) {
        break missingId;
      }

      id = R.id.postTweet;
      Button postTweet = ViewBindings.findChildViewById(rootView, id);
      if (postTweet == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      return new FragmentTweetBinding((ConstraintLayout) rootView, backTweet, btnUpload,
          frameLayout7, imageView, linearLayout3, listingInformation, listingTitle, postTweet,
          textView, textView2, textView3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
