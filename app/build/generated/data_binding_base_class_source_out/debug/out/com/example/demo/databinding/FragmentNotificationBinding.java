// Generated by view binder compiler. Do not edit!
package com.example.demo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.demo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentNotificationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView invisibleText;

  @NonNull
  public final LinearLayout notificationContainer;

  @NonNull
  public final ImageView notificationIcon;

  private FragmentNotificationBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView invisibleText, @NonNull LinearLayout notificationContainer,
      @NonNull ImageView notificationIcon) {
    this.rootView = rootView;
    this.invisibleText = invisibleText;
    this.notificationContainer = notificationContainer;
    this.notificationIcon = notificationIcon;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_notification, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentNotificationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.invisible_text;
      TextView invisibleText = ViewBindings.findChildViewById(rootView, id);
      if (invisibleText == null) {
        break missingId;
      }

      id = R.id.notification_container;
      LinearLayout notificationContainer = ViewBindings.findChildViewById(rootView, id);
      if (notificationContainer == null) {
        break missingId;
      }

      id = R.id.notification_icon;
      ImageView notificationIcon = ViewBindings.findChildViewById(rootView, id);
      if (notificationIcon == null) {
        break missingId;
      }

      return new FragmentNotificationBinding((ConstraintLayout) rootView, invisibleText,
          notificationContainer, notificationIcon);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}