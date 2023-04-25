// Generated by view binder compiler. Do not edit!
package com.example.hamburgermenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hamburgermenu.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMarketplaceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button backbutton;

  @NonNull
  public final Button createlistingbutton;

  @NonNull
  public final RecyclerView dataList;

  @NonNull
  public final ConstraintLayout frameLayout4;

  private FragmentMarketplaceBinding(@NonNull ConstraintLayout rootView, @NonNull Button backbutton,
      @NonNull Button createlistingbutton, @NonNull RecyclerView dataList,
      @NonNull ConstraintLayout frameLayout4) {
    this.rootView = rootView;
    this.backbutton = backbutton;
    this.createlistingbutton = createlistingbutton;
    this.dataList = dataList;
    this.frameLayout4 = frameLayout4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMarketplaceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMarketplaceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_marketplace, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMarketplaceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backbutton;
      Button backbutton = ViewBindings.findChildViewById(rootView, id);
      if (backbutton == null) {
        break missingId;
      }

      id = R.id.createlistingbutton;
      Button createlistingbutton = ViewBindings.findChildViewById(rootView, id);
      if (createlistingbutton == null) {
        break missingId;
      }

      id = R.id.dataList;
      RecyclerView dataList = ViewBindings.findChildViewById(rootView, id);
      if (dataList == null) {
        break missingId;
      }

      ConstraintLayout frameLayout4 = (ConstraintLayout) rootView;

      return new FragmentMarketplaceBinding((ConstraintLayout) rootView, backbutton,
          createlistingbutton, dataList, frameLayout4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
