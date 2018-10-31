package rutul.com.ecampus.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

import rutul.com.ecampus.R;

public class FragmentUtil {

    public static Stack<Fragment> fragmentStack = new Stack<Fragment>();
//    private int containerId;
//    private Fragment fragment;
//    private String currentFragmentTag;
//    private String fragmentTag;
//    private FragmentActivity activity;
//    private Bundle bundle;

    public void replaceFragment(FragmentActivity activity, int containerId, Fragment fragment, String fragmentTag, ANIMATION_TYPE animationType, @Nullable Bundle bundle) {
        if (getCurrentFragment(activity) != null) {
            if (getCurrentFragment(activity).getTag().equalsIgnoreCase(fragmentTag)) {
                return;
            }
        }
//        this.containerId = containerId;
//        this.fragment = fragment;
//        this.fragmentTag = fragmentTag;
//        this.activity = activity;
//        this.bundle = bundle;

//        Fragment frag = activity.getSupportFragmentManager().findFragmentById(containerId);
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        fragmentStack.clear();
        if (fragment != null) {
//            if (!frag.getTag().equals("fragmentTag")) {
            switch (animationType) {
                case SLIDE_UP_TO_DOWN:
//                    fragmentStack.clear();
                    ft.setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom);
//                    ft.replace(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom).replace(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
                case SLIDE_DOWN_TO_UP:
//                    fragmentStack.clear();
                    ft.setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top);
//                    ft.replace(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top).replace(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
                case SLIDE_LEFT_TO_RIGHT:
//                    fragmentStack.clear();
                    ft.setCustomAnimations(R.anim.enter_left, R.anim.exit_right);
//                    ft.replace(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left, R.anim.exit_right).replace(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
                case SLIDE_RIGHT_TO_LEFT:
//                    fragmentStack.clear();
                    ft.setCustomAnimations(R.anim.enter_right, R.anim.exit_left);
//                    ft.replace(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).replace(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
//                default:
//                    fragmentStack.clear();
//                    ft.replace(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
                //this.activity.getSupportFragmentManager().beginTransaction().replace(this.containerId, this.fragment, this.fragmentTag).commit();
//                    break;
            }
//            }
        } else {
//            fragmentStack.clear();
            ft.setCustomAnimations(R.anim.enter_right, R.anim.exit_left);
//            ft.replace(containerId, fragment, fragmentTag);
//            fragmentStack.push(fragment);
//            ft.commit();
//            //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).replace(this.containerId, this.fragment, this.fragmentTag).commit();
        }
        ft.replace(containerId, fragment, fragmentTag);
        fragmentStack.push(fragment);
        ft.commit();
    }

    public void addFragment(FragmentActivity activity, int containerId, Fragment fragment, String fragmentTag, ANIMATION_TYPE animationType, @Nullable Bundle bundle) {
        if (getCurrentFragment(activity) != null) {
            if (getCurrentFragment(activity).getTag().equalsIgnoreCase(fragmentTag)) {
                return;
            }
        }
//        this.containerId = containerId;
//        this.fragment = fragment;
//        this.fragmentTag = fragmentTag;
//        this.activity = activity;
//        this.bundle = bundle;

        //Fragment frag = activity.getSupportFragmentManager().findFragmentById(containerId);
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        if (fragment != null) {
            switch (animationType) {
                case SLIDE_UP_TO_DOWN:
                    ft.setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom);
//                    ft.add(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom).add(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
                case SLIDE_DOWN_TO_UP:
                    ft.setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top);
//                    ft.add(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top).add(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
                case SLIDE_LEFT_TO_RIGHT:
                    ft.setCustomAnimations(R.anim.enter_left, R.anim.exit_right);
//                    ft.add(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left, R.anim.exit_right).add(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
                case SLIDE_RIGHT_TO_LEFT:
                    ft.setCustomAnimations(R.anim.enter_right, R.anim.exit_left);
//                    ft.add(containerId, fragment, fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).add(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
                default:
                    fragmentStack.clear();
//                    ft.add(containerId, fragment, fragmentTag);
//                    ft.addToBackStack(fragmentTag);
//                    fragmentStack.push(fragment);
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().add(this.containerId, this.fragment, this.fragmentTag).commit();
                    break;
            }
        } else {
            ft.setCustomAnimations(R.anim.enter_right, R.anim.exit_left);
//            ft.add(containerId, fragment, fragmentTag);
//            ft.addToBackStack(fragmentTag);
//            fragmentStack.push(fragment);
//            ft.commit();
//            //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).add(this.containerId, this.fragment, this.fragmentTag).commit();
        }
        ft.add(containerId, fragment, fragmentTag);
        ft.addToBackStack(fragmentTag);
        fragmentStack.push(fragment);
        ft.commit();
    }

    public void removeFragment(FragmentActivity activity, int containerId, Fragment fragment, ANIMATION_TYPE animationType) {
//        this.fragment = fragment;
//        this.activity = activity;
//        this.containerId = containerId;

//        Fragment frag = activity.getSupportFragmentManager().findFragmentById(containerId);
//        Log.i("frag", "" + frag);
        if (fragmentStack.size() == 1) {
            return;
        }
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
//            if (!frag.getTag().equals("fragmentTag")) {
            switch (animationType) {
                case SLIDE_UP_TO_DOWN:
                    ft.setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom);
//                    ft.remove(fragmentStack.pop());
//                    fragmentStack.lastElement().onResume();
//                    ft.show(fragmentStack.lastElement());
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_top, R.anim.exit_bottom).remove(this.fragment).commit();
                    break;
                case SLIDE_DOWN_TO_UP:
                    ft.setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top);
//                    ft.remove(fragmentStack.pop());
//                    fragmentStack.lastElement().onResume();
//                    ft.show(fragmentStack.lastElement());
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_bottom, R.anim.exit_top).remove(this.fragment).commit();
                    break;
                case SLIDE_LEFT_TO_RIGHT:
                    ft.setCustomAnimations(R.anim.enter_left, R.anim.exit_right);
//                    ft.remove(fragmentStack.pop());
//                    fragmentStack.lastElement().onResume();
//                    ft.show(fragmentStack.lastElement());
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_left, R.anim.exit_right).remove(this.fragment).commit();
                    break;
                case SLIDE_RIGHT_TO_LEFT:
                    ft.setCustomAnimations(R.anim.enter_right, R.anim.exit_left);
//                    ft.remove(fragmentStack.pop());
//                    fragmentStack.lastElement().onResume();
//                    ft.show(fragmentStack.lastElement());
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).remove(this.fragment).commit();
                    break;
                default:
//                    ft.remove(fragmentStack.pop());
//                    fragmentStack.lastElement().onResume();
//                    ft.show(fragmentStack.lastElement());
//                    ft.commit();
//                    //this.activity.getSupportFragmentManager().beginTransaction().remove(this.fragment).commit();
                    break;
            }
//            }
        } else {
            ft.setCustomAnimations(R.anim.enter_right, R.anim.exit_left);
//            ft.remove(fragmentStack.pop());
//            fragmentStack.lastElement().onResume();
//            ft.show(fragmentStack.lastElement());
//            ft.commit();
//            //this.activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_right, R.anim.exit_left).remove(this.fragment).commit();
        }
        ft.remove(fragmentStack.pop());
        fragmentStack.lastElement().onResume();
        ft.show(fragmentStack.lastElement());
        ft.commit();
    }


    public Fragment getCurrentFragment(FragmentActivity activity) {
        Fragment currentFrag = null;
        //Fragment currentFrag = activity.getSupportFragmentManager().findFragmentById(R.id.main_container);
        if (currentFrag == null) {
            return null;
        }
        return currentFrag;

    }

    public enum ANIMATION_TYPE {
        SLIDE_UP_TO_DOWN, SLIDE_DOWN_TO_UP, SLIDE_LEFT_TO_RIGHT, SLIDE_RIGHT_TO_LEFT, NONE
    }
}